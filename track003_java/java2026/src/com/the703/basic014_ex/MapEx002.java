package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class BookDto{
	private String title;  private String author;
	public BookDto() { super();  }
	public BookDto(String title, String author) { super(); this.title = title; this.author = author; }
	public String getTitle() { return title; }  public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }  public void setAuthor(String author) { this.author = author; }	
}

public class MapEx002 {
	public static void main(String[] args) {
		Map <String, BookDto> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		map.put("978-11111",new BookDto("자바의 완성","가길동"));
		map.put("978-22222",new BookDto("파이썬 기초" , "홍길동"));
		map.put("978-33333",new BookDto("자료구조와 알고리즘" , "이순신"));

		System.out.println("==============================");
		System.out.println("ISBN        TITLE      AUTHOR");
		System.out.println("==============================");
		for(Entry<String, BookDto> book :map.entrySet()) {
			System.out.println(book.getKey()+" | "+book.getValue().getTitle()+" | "+book.getValue().getAuthor());
			System.out.println("------------------------------");}
		System.out.println("도서 정보를 제공중입니다");
		System.out.print("ISBN을 입력하세요>");String isbn = sc.next();
		
		if(map.containsKey(isbn)) {
			BookDto book = map.get(isbn);
			System.out.println("📖 선택한 도서 정보:"+book.getTitle()+"/ 저자:"+book.getAuthor());}
	}
}
