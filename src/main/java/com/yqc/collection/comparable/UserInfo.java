package com.yqc.collection.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>title: Comparable是内部比较器，自己实现compaeTo方法，Collections.sort方法内部调用的是
 * Arrays.sort方法,Arrays.sort采用的是传统归并排序以及Timsort排序</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2018-04-05
 * @modified By yangqc
 */
public class UserInfo implements Comparable<UserInfo> {

  private int userId;
  private int age;
  private String name;

  public UserInfo(int userId, int age, String name) {
    this.userId = userId;
    this.age = age;
    this.name = name;
  }

  @Override
  public int compareTo(UserInfo o) {
    if (this.age - o.age == 0) {
      return this.userId = o.userId;
    }
    return this.age - o.age;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
        "userId=" + userId +
        ", age=" + age +
        ", name='" + name + '\'' +
        '}';
  }
}

class Test {

  public static void main(String[] args) {
    List<UserInfo> list = new ArrayList<>();
    list.add(new UserInfo(1, 21, "name1"));
    list.add(new UserInfo(2, 27, "name1"));
    list.add(new UserInfo(3, 15, "name1"));
    list.add(new UserInfo(5, 14, "name1"));
    list.add(new UserInfo(4, 24, "name1"));
    Collections.sort(list);
    for (UserInfo userInfo : list) {
      System.out.println(userInfo);
    }
  }
}