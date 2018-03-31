package com.yqc.io.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

  public static void main(String[] args) throws IOException {
    DataInputStream in = new DataInputStream(
        new BufferedInputStream((new FileInputStream("src/com/yqc/ioTest/TestEOF.java"))));
    // ��Ϊ '\n'Ҳ��һ���ַ�������ֻ����available�ж��Ƿ�����յ�,��ʾû������������¶�ȡ���ֽ���
    while (in.available() != 0) {
      System.out.println((char) in.readByte());
    }
  }
}
