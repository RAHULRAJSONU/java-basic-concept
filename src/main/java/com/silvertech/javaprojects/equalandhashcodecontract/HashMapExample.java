package com.silvertech.javaprojects.equalandhashcodecontract;

import java.util.HashMap;
import java.util.Map;

/*
 * java-basic-concept
 * MIT License
 *
 * Copyright (c) 2020 Rahul Raj
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class HashMapExample {

  public static void main(String[] args) {
    EmployeeKey lookUpKey = new EmployeeKey(100, 10101993);;
    //To see the magic comment the hashCode() method of EmployeeKey
    System.out.println(loadCache().get(lookUpKey));
  }

  private static Map<EmployeeKey, String> loadCache(){
    EmployeeKey ek1 = new EmployeeKey(100, 10101993);
    EmployeeKey ek2 = new EmployeeKey(101, 11101994);
    EmployeeKey ek3 = new EmployeeKey(102, 12101995);
    EmployeeKey ek4 = new EmployeeKey(103, 13101996);
    Map<EmployeeKey,String> cache = new HashMap<>();
    cache.put(ek1,"Rob");
    cache.put(ek2,"Mention");
    cache.put(ek3,"Albert");
    cache.put(ek4,"Gen");
    return cache;
  }
}

