package com.yqc.singletonObject


class SingletonObject private{

  var field = "field"

  def doSomething: Unit = {
    println("do something")
  }
}

object SingletonObject {
  val single = new SingletonObject
  val a = "a String"

  def printString: Unit = {
    println(a)
  }

  def main(args: Array[String]): Unit = {
    var a = SingletonObject.single
    var b = SingletonObject.single
    println("a eq b : " + (a eq b))
  }
}

/*object OtherObject{
  def main(args: Array[String]): Unit = {
    println(new SingletonObject)
  }
}*/
