package com.chris.staff;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StaffTest {

  @Test
  public void createStaff() {
    Staff testStaff = new Staff("Chris", 40000);

    assertEquals("Chris", testStaff.getName());
  }
}
