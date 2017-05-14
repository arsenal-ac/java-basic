package com.yqc.exception;

import java.io.*;
//(1)即使前面try发生了异常
//try catch finally可以不同时出现

public class Exceptions {
	public static void main(String[] args) {
		// 检查异常1.打开文件
		// 再出现异常的地方，就终止执行代码
		// 如果有多个catch语句，则进入匹配异常的catch语句
		FileReader fr = null;
		try {
			fr = new FileReader("d:\\aa.txt");
		} catch (Exception e) {
			// 把异常信息输出，便于排除异常
			System.out.println("message:" + e.getMessage());// 这个方法一般
			e.printStackTrace();
		} finally {
			System.out.println("进入finally");
			// 这个语句块，不管有没有异常， 都会执行
			// 一般说，把需要关闭的资源[文件，连接，内存。。。]
			if (fr != null) {
				try {
					System.out.println("关闭没有出现错误!");
					fr.close();
				} catch (Exception e) {
					System.out.println("关闭出现错误！");
					e.printStackTrace();
				}
			}

		}
		// 2.连接一个192.168.12.12 ip的端口
		System.out.println("Ok");
		// 可以分布捕获
	}
	//如下情况finally块将不会被执行
	//(1)finally快发现异常
	//(2)程序所在线程死亡
	//(3)在前面的代码中用了System.exit()；这里是退出系统的代码
	//(4)关闭了CPU
	//即finally不一定被执行
}
