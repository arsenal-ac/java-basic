package com.yqc.rtti;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2017-11-08
 * @modified By yangqc
 */
public class AsctractToy implements IToy {

  @Override
  public String playToy(String player) throws Exception {
    System.out.println(player + " plays abstract toy");
    return "";
  }
}
