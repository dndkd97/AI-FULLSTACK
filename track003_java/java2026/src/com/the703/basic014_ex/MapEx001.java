package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String name = "";
		map.put("피구왕", " 통키 ");
		map.put("제빵왕"," 김탁구 ");
		map.put("요리왕"," 비룡 ");
		
		System.out.println("==============================");
		System.out.println("KING"+"\t"+"NAME");
		System.out.println("==============================");
		for( Entry<String, String> m: map.entrySet()) {
			System.out.println(m.getKey()+"\t"+m.getValue());
			System.out.println("----------------");}
		System.out.println("KING의 정보를 제공중입니다");
		System.out.print("이름을 입력하세요>"); name = sc.next();
		
		if(map.containsKey(name)) {System.out.println("\n□"+name+":"+map.get(name));}
		else {System.out.println("왕이없음");}
	}

}
