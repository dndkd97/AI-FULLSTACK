package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.Sboard2Dao;
import com.the703.dao.TestDao;
import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;

@SpringBootTest
class Boot1ApplicationTests {
	@Autowired TestDao dao;
	@Autowired Sboard2Dao sboard2Dao;
	@Autowired Sboard2Service sboard2Service;
	
	  @Test  public void test010_delete() {   
	      Sboard2Dto  dto = new Sboard2Dto();
	      dto.setId(2); // 있는 id
	      assertEquals(1, sboard2Service.delete(dto));     
	   } 
	   // 41
	   @Disabled  @Test  public void test09_update() {   
	      Sboard2Dto  dto = new Sboard2Dto();
	      dto.setAppUserId(1);   dto.setBtitle("title-new");  dto.setBcontent("content-new");
	      dto.setBpass("1111");  dto.setId(41);
	   
	      MockMultipartFile file = new   MockMultipartFile("file" , "test.txt" , "text/plain" , "data".getBytes());
	      // import org.springframework.mock.web.MockMultipartFile;
	      int result = sboard2Service.update(file, dto); 
	      assertEquals(1, result);    
	   } 
	    
	   @Disabled  @Test  public void test08_detail() {   
	      Sboard2Dto  dto = new Sboard2Dto();
	      dto.setId(41);
	      assertEquals(41, sboard2Service.detail(dto).getId());     
	   } 
	   
	   
	
	@Disabled @Test public void test07_service_paging() {
		assertEquals(5,sboard2Service.list10(1).size());
		assertEquals(5,sboard2Service.selectCnt());
	}
	
	@Disabled @Test public void test06_service_insert() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setAppUserId(1); dto.setBtitle("title"); dto.setBcontent("content");
		dto.setBpass("1111"); 
		
		MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain","data".getBytes());
		
		int result = sboard2Service.insert(file,dto);
		assertEquals(1,result);
		
	}
	
	@Disabled @Test public void test05_delete() { //삭제
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(27);
		int result = sboard2Dao.delete(dto);
		assertEquals(1,result);
	}
	
	@Disabled @Test public void test04_update() { //수정
		Sboard2Dto dto = new Sboard2Dto();
		dto.setBtitle("title-new"); dto.setBcontent("content-new");
		dto.setBfile("1.png"); dto.setId(2);
		int result = sboard2Dao.update(dto);
		assertEquals(1,result);
	}
	
	 @Disabled @Test public void test03_byId() { //id,조회수 올리기
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(2);
		Sboard2Dto result = sboard2Dao.selectById(dto);
		assertEquals(2,result.getId());
	}
	
	
	 @Disabled @Test public void test02_paging() { //페이징,갯수
		HashMap<String,Object> para = new HashMap<>();
		para.put("start", 0);
		para.put("end", 10);
		List<Sboard2Dto>list10=sboard2Dao.selectPaging(para);
		
		assertEquals(1,list10.size());
		assertNotNull(list10);
		assertEquals(1,sboard2Dao.selectCnt()); //전체갯수 6개
	}
	
	@Disabled @Test public void test01_Insert() throws UnknownHostException {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setAppUserId(1); dto.setBtitle("title"); dto.setBcontent("content");
		dto.setBpass("1111"); dto.setBfile("1.png"); dto.setBip(InetAddress.getLocalHost().getHostAddress());
		
		int result = sboard2Dao.insert(dto);
		System.out.println("....1>" + sboard2Dao.insert(dto));
		assertEquals(1,result);
	}
	
	
	@Disabled @Test
	void contextLoads() {
		System.out.println("............");
		System.out.println("<"+dao.readTime()+">");
	}

}
