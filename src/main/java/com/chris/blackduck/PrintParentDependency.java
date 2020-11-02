package com.chris.blackduck;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintParentDependency {

  private static final String DEP_TREE_FILE = "C:\\Users\\qichri\\titanium\\codegen\\cg.out";
  private static final String USED_UNDECLARED_DEP_FILE = "C:\\Users\\qichri\\titanium\\codegen\\cg_an.out";

  private static final String DEPENDENCY = "commons-pool";

  private static final Recommendation recommendation = new Recommendation();

  public static void main(String[] args) throws IOException {
    DependencyTree tree = readDependencyFile();
    List<String> usedUndeclaredDependencies = readUsedUndeclaredFile();
    while (true) {
      System.out.println("Depenency > ");
      Scanner in = new Scanner(System.in);
      String dependency = in.nextLine();
      printTree(tree.root, dependency, usedUndeclaredDependencies);
      recommendation.printRecommendation();
    }
  }

  private static List<String> readUsedUndeclaredFile() throws IOException {
    List<String> dependencies = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(USED_UNDECLARED_DEP_FILE)));
    String line;
    while((line = reader.readLine()) != null) {
      dependencies.add(line);
    }
    return dependencies;
  }

  private static void printTree(DependencyTree.Node node, String dependency, List<String> usedUndeclaredDependencies) {
    if(node.dependency.contains(dependency) ) {
      System.out.println("-----------------------------");
      printNodeHierarchy(node, "");
      boolean isUsed = usedUndeclaredDependencies.contains(node.dependency.replaceFirst("\\[INFO\\].* ", "")) || node.parent.parent.parent == null;
      System.out.println("IS TRANSITIVE DEPENDENCY: " + node.isTransitive());
      System.out.println("IS UPF TRANSITIVE DEPENDENCY: " + node.isUpfTransitive());
      System.out.println("IS USED UNDECLARED: " + isUsed);
      System.out.println("-----------------------------");

      recommendation.pushTransitiveResult(node.isTransitive());
      recommendation.pushUpfTransitiveResult(node.isUpfTransitive());
      recommendation.pushIsUsedResult(isUsed);

      return;
    }
    node.children.forEach(child -> printTree(child, dependency, usedUndeclaredDependencies));
  }

  private static void printNodeHierarchy(DependencyTree.Node node, String text) {
    text = node.dependency + "\n" + text;
    //node.dependency.contains("com.aciworldwide.aps.adf") && node.dependency.contains("4.1.0.0")
    if(node.parent == null) {
      System.out.println(text);
    }
    else {
      printNodeHierarchy(node.parent, text);
    }
  }

  private static boolean isDependencyStr(String text) {
    return text.contains("[INFO]") && StringUtils.countMatches(text, ":" ) >= 3;
  }

  private static DependencyTree readDependencyFile() throws IOException {
    FileReader reader = new FileReader();
    DependencyTree tree = new DependencyTree();
    updateDependencyNode(tree.root, reader, tree.root.level);
    return tree;
  }

  private static void updateDependencyNode(DependencyTree.Node prevNode, FileReader reader, int prevDependencyLevel)
      throws IOException {
    String dependency = getNextDependency(reader);
    if(dependency == null) {
      return;
    }
    int dependencyLevel = getDependencyLevel(dependency);
    DependencyTree.Node node;
    if(dependencyLevel == prevDependencyLevel) {
      node = prevNode.parent.addChild(dependency);
    }
    else if(dependencyLevel > prevDependencyLevel) {
      node = prevNode.addChild(dependency);
    }
    else {
      node = prevNode.addChild(dependency, dependencyLevel);
    }

    updateDependencyNode(node, reader, dependencyLevel);
  }

  private static String getNextDependency(FileReader reader) throws IOException {
    String line;
    while((line = reader.getNextLine() ) != null) {
      if(isDependencyStr(line)) {
        return line;
      }
    }
    return null;
  }

  private static int getDependencyLevel(String dependency) {
    //return StringUtils.countMatches(dependency, "+-" ) + StringUtils.countMatches(dependency, "|" ) + StringUtils.countMatches(dependency, "\\-" );
    return dependency.length() - dependency.replaceFirst("\\[INFO\\].* ", "").length();
  }

  private static class DependencyTree {

    private Node root;

    public DependencyTree() {
      root = new Node();
      root.dependency = "ROOT";
      root.level = -1;
      root.children = new ArrayList<>();
    }

    private static class Node {
      private String dependency;
      private Node parent;
      private List<Node> children;
      private int level;

      Node addChild(String dependency) {
        Node child = new Node();
        child.parent = this;
        child.dependency = dependency;
        child.level = getDependencyLevel(dependency);
        child.children = new ArrayList<>();
        children.add(child);
        return child;
      }

      Node addChild(String dependency, int level) {
        if(this.level < level) {
          return addChild(dependency);
        }
        else if(parent != null) {
          return parent.addChild(dependency, level);
        }
        else {
          return null;
        }
      }

      boolean isUpfTransitive() {
        boolean isUpf = dependency.contains("com.aciworldwide.aps.adf") && (dependency.contains("4.1.0.0") || dependency.contains("4.1.0.0") );
        return isUpf || (parent != null && parent.isUpfTransitive());
      }

      boolean isTransitive() {
        return parent != null && parent.parent != null && parent.parent.parent != null;
      }
    }
  }
  private static class FileReader {
    BufferedReader reader;
    FileReader() throws FileNotFoundException {
      reader = new BufferedReader(new InputStreamReader(new FileInputStream(DEP_TREE_FILE)));
    }

    String getNextLine() throws IOException {
      return reader.readLine();
    }
  }

  private static final class Recommendation {
    List<Boolean> isTransitive = new ArrayList<>();
    List<Boolean> isUpfTransitive = new ArrayList<>();
    List<Boolean> isUsed = new ArrayList<>();

    public void pushTransitiveResult(boolean transitive) {
      isTransitive.add(transitive);
    }

    public void pushUpfTransitiveResult(boolean upfTransitive) {
      isUpfTransitive.add(upfTransitive);
    }

    public void pushIsUsedResult(boolean used) {
      isUsed.add(used);
    }

    public void printRecommendation() {
      System.out.println("-------- FINAL RECOMMENDATION --------");
      if(isTransitive.size() < 1) {
        System.out.println("NOT FOUND");
        return;
      }
      boolean canIgnore = isUsed.stream().noneMatch(Boolean::booleanValue);
      System.out.println("IGNORE: " + canIgnore);
      if(canIgnore) {
        boolean upfTransitive = isUpfTransitive.stream().allMatch(Boolean::booleanValue);
        System.out.println("UPF TRANSITIVE: " + upfTransitive );
        if(upfTransitive) {
          System.out.println("UPF transitive dependency");
        }
      }
    }
  }
}
