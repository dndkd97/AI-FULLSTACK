package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class BookDTO{
    private String title; private String author;
	public BookDTO() { super();  }
	public BookDTO(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	@Override public String toString() { return "BookDTO [title=" + title + ", author=" + author + "]"; }
	public String getTitle() { return title; } public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; } public void setAuthor(String author) { this.author = author; } 
}

public class MapEx003 {
	public static void main(String[] args) {
	
		Map<String, Map<String, BookDTO>> library = new HashMap<>();
		Map<String, BookDTO> seoul = new HashMap<>();
		Map<String, BookDTO> busan = new LinkedHashMap<>();
		Scanner sc = new Scanner(System.in);
		String name,isbn;
		
		seoul.put("978-11111",new BookDTO("자바의 정석","남궁성"));
		seoul.put("978-22222",new BookDTO("파이썬 기초","홍길동"));
		busan.put("978-33333",new BookDTO("자료구조와 알고리즘","이순신"));
		busan.put("978-44444",new BookDTO("파이썬 심화","홍길동"));
		
		library.put("서울점", seoul);
		library.put("부산점", busan);
		
		System.out.println("=== 도서관 전체 목록 ===");
		for(Entry<String, Map<String, BookDTO>> m : library.entrySet()) {
		 System.out.println("📚"+m.getKey());
			for(Entry<String, BookDTO> book :m.getValue().entrySet()) {
				System.out.println(book.getKey()+"|"+book.getValue().getTitle()+"|"+book.getValue().getAuthor());
			   }System.out.println("---------------------");}
			
		System.out.print("지점 이름 입력>");name=sc.next();
		System.out.print("ISBN 입력>");isbn=sc.next();
		
	  if(library.containsKey(name) && library.get(name).containsKey(isbn)) {
		  BookDTO book = library.get(name).get(isbn);
		  System.out.println("📖 선택한 도서 정보: "+ book.getTitle() +"/ 저자:"+ book.getAuthor());}
	}
}
