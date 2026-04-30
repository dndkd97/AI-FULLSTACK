package com.the703.basic014_ex;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoSetEx002 {
	public static void main(String[] args) {
		Set<Integer> lotto = new HashSet<>();
		Random rand = new Random();
	    Scanner sc = new Scanner(System.in);
	   
		while(lotto.size()<6) {
		int num = rand.nextInt(45) + 1; // 1~45
		lotto.add(num);}
		
		System.out.println("=====이번주 로또 번호=====");
		
		for(Integer n : lotto) { System.out.println(n);}
		System.out.println("확인할 번호 입력:> "); int num1= sc.nextInt();
		
		if(lotto.contains(num1)) {System.out.println("포함됨 → "+num1);}
		else {System.out.println("포함되지않음");}
	}

}
