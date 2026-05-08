package com.the703.basic015;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream003 {
	public static void main(String[] args) {
		Integer[]  ages = {17 , 21, 26 , 45, 18}; 
		
		Stream<Integer> arr = Arrays.stream(ages);
		
		//Ex1. 짝수만 출력
		arr.filter(t->t%2!=1)
		.sorted()
		.forEach(System.out::print);
		
		System.out.println();
		//Ex2. 평균값 처리
		//int java.util.function.ToIntFunction.applyAsInt( T value )
		arr = Arrays.stream(ages);
		double aver =arr
		.mapToInt(age->age) //IntStream로 변환
		.average()          //평균계산 , max(최대), min(최소), sum(합), count(개수)
		.orElse(0.0);       //값없으면 0.0
		System.out.println(aver);
		
		//Ex3. 제일 나이가 많은 사람
		arr = Arrays.stream(ages);
		int max =arr
		.mapToInt(age->age)		
		.max()
		.orElse(-1);
		System.out.println(max);
		
		//Ex4. 나이 정렬해서 리스트로
		//arr = Arrays.stream(ages);
		List<Integer> list =
		Arrays.stream(ages).sorted().collect(Collectors.toList());
		System.out.println(list);
		//
		//Ex5. 20살 이상만 필터링(filter)해서 리스트로 수집(collect)
		List<Integer> list1 = Arrays.stream(ages).filter(age -> age >= 20).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(list1);
		
//		arr = Arrays.stream(ages);
//		arr.filter(t->t>20)
//		.collect(Collectors.toList())
//		.forEach(System.out::print);
	}
}
