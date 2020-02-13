package com.silvertech.javaprojects.mapexample.weekHMap;

import java.util.Map;
import java.util.WeakHashMap;

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
public class WeakHashMapExample {

  public static void main(String[] args) throws InterruptedException {
    Map<Order, Integer> orders = new WeakHashMap<>();
    orders.put(new Order(1,"awer"),100); // weak reference
    orders.put(new Order(2,"awer"),200); // weak reference
//    Strong reference
    Order o3 = new Order(3,"hjhjh");
    orders.put(o3,5000);
    System.out.println("Before GC:: "+orders.size());
    System.gc();
    Thread.sleep(10000);
    System.out.println("After GC:: "+orders.size());
  }
}
