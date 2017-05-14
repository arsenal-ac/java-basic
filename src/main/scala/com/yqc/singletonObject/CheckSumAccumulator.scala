package com.yqc.singletonObject

class CheckSumAccumulator {

  private var sum = 0

  def add(b: Byte): Unit = sum += b

  def checkSum(): Int = ~(sum & 0xff) + 1

  def subtraction(b: Byte) = {
    sum -= b
  }

}

object TestObject {

  def g() {
    "this String gets lost too!"
  }

  def h() = {
    "this String gets returned!"
  }

  def main(args: Array[String]): Unit = {
    println(g())
    println(h())
  }
}
