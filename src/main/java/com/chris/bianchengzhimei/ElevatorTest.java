package com.chris.bianchengzhimei;

/**
 * Elevator will stay at level i, and the whole building has N level
 * <p>
 * I have tot[i] passangers
 * <p>
 * I want to find out a x so that the sum will be minimum
 * Sum = Tot[i] * |i-x|
 */
public class ElevatorTest {
  public static void main(String[] args) {
    int[] person = {1, 1, 1, 1, 1}; // 5 floors
    int numFloor = person.length;
    int N1, N2, N3, i;
    int stopFloor = 0;
    int minFloors = 0;
    //Method 1
    //    int finalMinFloor = 0;
    //    for(int i=0;i<numFloor;i++) {
    //      int minFloors = 0;
    //      for (int j=0;j<numFloor;j++){
    //        minFloors = minFloors + Math.abs(j-i)*person[j];
    //      }
    //
    //      if (finalMinFloor ==0 || finalMinFloor >minFloors) {
    //        finalMinFloor = minFloors;
    //        stopFloor = i+1;
    //      }
    //    }
    //    System.out.println("The floor should stop is " + stopFloor);

    //Method 2
    for (N1 = 0, N2 = person[1], N3 = 0, i = 2; i < numFloor; i++) {
      N3 += person[i];
      minFloors += person[i] * (i - 1);
    }
    for (i = 2; i < numFloor; i++) {
      if (N1 + N2 < N3) {
        stopFloor = i;
        minFloors += (N1 + N2 - N3);
        N1 += N2;
        N2 = person[i];
        N3 -= person[i];
      } else
        break;
    }
    System.out.println("The floor should stop is " + stopFloor);
  }
}
