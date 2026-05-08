package com.the703.basic016;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class JavaIO004_img {
	public static void main(String[] args) throws IOException {
		//#1. 경로
		String origin = "src/com/the703/basic016/KakaoTalk_20260508_164306316.jpg/";
		String target1 = "src/com/the703/basic016/KakaoTalk_20260508_164306317.jpg/";
		String target2 = "src/com/the703/basic016/KakaoTalk_20260508_164306318.jpg/";
		
		//#2. byte 이미지파일 원본 읽어들여서 쓰기
		// InputStream  >  [프로그램]  > OutputStream
		InputStream bis = new FileInputStream(origin);  //원본 읽어들여서 (read)
		OutputStream bos = new FileOutputStream(target1); //KakaoTalk_20260508_164306317.jpg 쓰기 (write)
		
		int cnt1=0;
		while((cnt1 = bis.read())!=-1) { //원본 읽어들여서 (read)
			bos.write((byte)cnt1); //.jpg 쓰기 (write)
		}
		bos.close(); bis.close();
		System.out.println(">>byte 이미지 복사완료!");
		
		//#3. char 이미지 파일 원본 읽어들여서 쓰기
		// Reader  >  [프로그램]  >  Writer
		Reader cr = new FileReader(origin);
		Writer cw = new FileWriter(target2);

		int cnt2=0;
		while((cnt2 = cr.read())!=-1) { //원본 읽어들여서
			cw.write((char)cnt2); //.jpg 쓰기 (write) // char 안됨
		}
		cr.close(); cw.close();
	}
}
