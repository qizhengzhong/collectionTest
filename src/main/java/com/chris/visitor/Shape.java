package com.chris.visitor;

/**
 * All shapes that implement this interface should override accept method
 */
public interface Shape {
  void move(int x, int y);

  void draw();

  String accept(Visitor visitor);
}
