package com.silvertech.javaprojects.equalandhashcodecontract;

import java.util.Objects;

public class EmployeeKey {
  private int empCode;
  private int dob;
  public EmployeeKey(int empCode, int dob){
    this.empCode = empCode;
    this.dob = dob;
  }

  @Override
  public String toString() {
    return "EmployeeKey{" +
        "empCode=" + empCode +
        ", dob=" + dob +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EmployeeKey)) {
      return false;
    }
    EmployeeKey that = (EmployeeKey) o;
    return empCode == that.empCode &&
        dob == that.dob;
  }

  //To see the magic comment the hashCode() function
//  @Override
//  public int hashCode() {
//    return Objects.hash(empCode, dob);
//  }
}