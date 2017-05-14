package com.yqc.exception;

import java.io.*;
//(1)��ʹǰ��try�������쳣
//try catch finally���Բ�ͬʱ����

public class Exceptions {
	public static void main(String[] args) {
		// ����쳣1.���ļ�
		// �ٳ����쳣�ĵط�������ִֹ�д���
		// ����ж��catch��䣬�����ƥ���쳣��catch���
		FileReader fr = null;
		try {
			fr = new FileReader("d:\\aa.txt");
		} catch (Exception e) {
			// ���쳣��Ϣ����������ų��쳣
			System.out.println("message:" + e.getMessage());// �������һ��
			e.printStackTrace();
		} finally {
			System.out.println("����finally");
			// ������飬������û���쳣�� ����ִ��
			// һ��˵������Ҫ�رյ���Դ[�ļ������ӣ��ڴ档����]
			if (fr != null) {
				try {
					System.out.println("�ر�û�г��ִ���!");
					fr.close();
				} catch (Exception e) {
					System.out.println("�رճ��ִ���");
					e.printStackTrace();
				}
			}

		}
		// 2.����һ��192.168.12.12 ip�Ķ˿�
		System.out.println("Ok");
		// ���Էֲ�����
	}
	//�������finally�齫���ᱻִ��
	//(1)finally�췢���쳣
	//(2)���������߳�����
	//(3)��ǰ��Ĵ���������System.exit()���������˳�ϵͳ�Ĵ���
	//(4)�ر���CPU
	//��finally��һ����ִ��
}
