package com.silvertech.javaprojects.mapexample.ConHMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

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
public class ConcurrentHashMapExample {
//  static Map<String,Long> orders = new ConcurrentHashMap<>(); //Not thread safe
  static Map<String, AtomicLong> orders = new ConcurrentHashMap<>(); //thread safe
  public static void main(String[] args) throws InterruptedException {
    orders.put("Mumbai",new AtomicLong());
    orders.put("Bangalore",new AtomicLong());
    orders.put("Delhi",new AtomicLong());
    ExecutorService service = Executors.newFixedThreadPool(2);
    service.submit(ConcurrentHashMapExample::processOrder);
    service.submit(ConcurrentHashMapExample::processOrder);
    service.awaitTermination(1, TimeUnit.SECONDS);
    service.shutdown();
    System.out.println(orders);
  }

  private static void processOrder() {
    for(String city : orders.keySet()){
      for (int i = 0; i < 50; i++) {
//        Long oldOrder = orders.get(city); //if using normal Long class uncomment this line
//        orders.put(city,oldOrder+1); //if using normal Long class uncomment this line
        orders.get(city).getAndIncrement(); //if not using AtomicLong class uncomment this line
      }
    }
  }
}
