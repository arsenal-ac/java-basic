package com.yqc.io.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ��׼������
 * @author yangqc
 * 2016/6/1
 */
public class Echo {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=stdin.readLine())!=null && s.length()!=0){
			System.out.println(s);
		}
	}
}
