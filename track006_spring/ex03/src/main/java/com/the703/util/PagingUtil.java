package com.the703.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagingUtil {
	   private  int  listtotal;     //#1) 전체글 320
	   private  int  onepagelist;   //#2) 한페이지에 보여줄 게시물의 수 10
	   private  int  pagetotal;     //#3) 총페이지 수 320/10 = 32 , ex 123/10 = 13
	   private  int  bottomlist;    //#4) 하단의 페이지 나누기 - 이전 11 12 13 ... 
	   private  int  pstartno;      //#5) 페이지 시작번호 - 스타트 번호
	   
	   private  int current;		//#6) 현재페이지 번호 15      
	   private  int start;        	//#7) 시작 11
	   private  int end;			//#8) 마지막 20
	   
	   private int prev; // 이전 블록 첫번째 페이지
	   private int next; // 이전 블록 다음 페이지
	   
	   
	   public PagingUtil(int listtotal, int pstartno) { //전체페이지 수,시작하는 번호 이전 11 12 13 ...
		super();
		this.listtotal = listtotal; // 전체페이지 수
		this.onepagelist = 10;	    //한페이지에 보여줄 게시물의 수 10
		this.pagetotal = listtotal <= 0? 1: (int)Math.ceil(listtotal/(double)onepagelist); // 320/10 = 32
		this.bottomlist =10;
		this.pstartno = (pstartno-1)*onepagelist;	// (1) 1 0번째부터,10개 (2) 2 10번째부터,10개 (3) 3 20번째부터, 10개
		this.current = pstartno; // <이전 11 12 13 14 15(현재) 16 ... 19 20 다음>
		this.start = ((this.current-1)/this.bottomlist)*this.bottomlist+1;// 15라면 11로 만들기 20라면 11
				// 15 → 11 앞자리를 1로 ((15-1)/10)*10 + 1 = 11
				// 15 → 11 앞자리를 1로 ((20-1)/10)*10 + 1 = 11
		this.end = this.start+this.bottomlist-1; // 15에서 20으로 , 20에서 20으로
				// 15 → 20 11+10-1 = 20
				// 20 → 20 11+10-1 = 20
		if(this.end>this.pagetotal) {this.end= this.pagetotal;}	// 전체페이지 갯수가 256 → 마지막은 30이 아니라 26
		
		// 이전 블록
		this.prev = this.start - this.bottomlist;

		// 다음 블록
		this.next = this.start + this.bottomlist;
		
		
			
	}     
	   
}
