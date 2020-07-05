package com.chris.equalandhashcode;
import java.util.HashMap;
import java.util.Map;

/**
 * Before we implement equals and hashcode,
 * When we run above program, it will print null. It’s because Object hashCode() method is used to
 * find the bucket to look for the key. Since we don’t have access to the HashMap keys and
 * we are creating the key again to retrieve the data,
 * you will notice that hash code values of both the objects are different and hence value is not found.
 *
 * After we implement equals and hashcode,
 * we can get the correct value from the hashMap search
 */
public class HashingTest {
  public static void main(String[] args) {
    Map<DataKey, Integer> hm = getAllData();

    DataKey dk = new DataKey();
    dk.setId(1);
    dk.setName("Pankaj");
    System.out.println(dk.hashCode());

    Integer value = hm.get(dk);

    System.out.println(value);

  }

  private static Map<DataKey, Integer> getAllData() {
    Map<DataKey, Integer> hm = new HashMap<>();

    DataKey dk = new DataKey();
    dk.setId(1);
    dk.setName("Pankaj");
    System.out.println(dk.hashCode());

    hm.put(dk, 10);

    return hm;
  }
}
