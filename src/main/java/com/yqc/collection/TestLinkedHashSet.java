package com.yqc.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinedHashSet��˳��洢
 *
 * @author yangqc 2016��12��19��
 */
public class TestLinkedHashSet {

  public static void main(String[] args) {
    Set<Integer> set = new LinkedHashSet<>();
    for (int i = 0; i < 10; i++) {
      set.add(10 - i);
    }
    for (Integer i : set) {
      System.out.println(i);
    }
    System.out.println("������HashSet");
    Set<Integer> set2 = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      set2.add(10 - i);
    }
    for (Integer i : set2) {
      System.out.println(i);
    }
  }
}
