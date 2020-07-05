package com.chris.bianchengzhimei;

public class BuyBook {
  /**
   * Each book is 8 euro and there are 5 books
   * 2 &gt; 5%
   * 3 &gt; 10%
   * 4 &gt; 20%
   * 5 &gt; 25%
   * <p>
   * I have an input a,b,c,d,e numbers of books, I wanted to find out how to buy these books
   * so return
   *
   */
  public static final int BOOK_COST = 8;

  public static void main(String[] args) {

    buyBooks(0, 1, 0, 4, 5);
  }

  /**
   * @param a Harry Potter book 1
   * @param b Harry Potter book 2
   * @param c Harry Potter book 3
   * @param d Harry Potter book 4
   * @param e Harry Potter book 5
   */
  public static void buyBooks(int a, int b, int c, int d, int e) {

    int totalNum = a + b + c + d + e;
    double totalCost = 0;
    int diffKindOfBooks = howManyDifferentBooks(a, b, c, d, e);

    System.out.println("There are " + diffKindOfBooks + " kind of books");

    while (diffKindOfBooks > 0) {
      totalCost = calculateCost(diffKindOfBooks, totalCost);
      a--;
      b--;
      c--;
      d--;
      e--;
      System.out.println(diffKindOfBooks);

      diffKindOfBooks = howManyDifferentBooks(a, b, c, d, e);
    }
    System.out.println(totalCost);
  }

  private static double calculateCost(int diffKindOfBooks, double cost) {
    switch (diffKindOfBooks) {
      case 2:
        cost = cost + 2 * 0.95 * BOOK_COST;
        break;
      case 3:
        cost = cost + 3 * 0.90 * BOOK_COST;
        break;
      case 4:
        cost = cost + 4 * 0.80 * BOOK_COST;
        break;
      case 5:
        cost = cost + 5 * 0.75 * BOOK_COST;
        break;
      default:
        cost = cost + BOOK_COST;
    }
    return cost;
  }

  private static int howManyDifferentBooks(int a, int b, int c, int d, int e) {
    return absVal(a) + absVal(b) + absVal(c) + absVal(d) + absVal(e);
  }

  //Check if this book exists or not
  private static int absVal(int x) {
    return x > 0 ? 1 : 0;
  }
}
