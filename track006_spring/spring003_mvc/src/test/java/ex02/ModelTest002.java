package ex02;

import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.MvcboardMapper;
import com.the703.dao.TestMapper;
import com.the703.dto.MvcboardDto;
import com.the703.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/root-context.xml")
public class ModelTest002 {

	@Autowired ApplicationContext context;
	@Autowired DataSource datasource;
	@Autowired SqlSession sqlsession;
	@Autowired TestMapper test; 
	@Autowired MvcboardMapper mvcboard;
	@Autowired BoardService service;
	
	@Test public void test9() {
		HashMap<String , Integer> map = new HashMap<>();
		map.put("start",0);
		map.put("end",10);
		System.out.println(mvcboard.select10(map));
		System.out.println(mvcboard.selectCnt());
	}
	
	
	@Ignore @Test
	public void test8() {
		
		//삭제
		MvcboardDto dto = new MvcboardDto();
		dto.setBno(3);
		System.out.println(service.delete(dto));
		
		//수정
	//	MvcboardDto dto = new MvcboardDto();
	//	dto.setBname("frist"); dto.setBpass("1111");
	//	dto.setBtitle("NEW-service-첫번째 글쓰기"); dto.setBcontent("NEW-service-내용 ");
	//	dto.setBno(3);
	//	System.out.println(service.edit(dto));
		//검색
	//	System.out.println(service.detail(3));
		
		//삽입 -3
	//	MvcboardDto dto = new MvcboardDto();
	//	dto.setBname("frist"); dto.setBpass("1111");
	//	dto.setBtitle("service-첫번째 글쓰기"); dto.setBcontent("service-내용 ");
	//	System.out.println(service.insert(dto));
		//전체 리스트
		System.out.println(service.selectAll());
	}
	
	@Ignore @Test 
	public void test1(){ System.out.println(context); }
	
	@Ignore @Test
	public void test2() {System.out.println(sqlsession);}
	
	@Ignore @Test
	public void test3() {System.out.println(test.now());}

//  @Ignore @Test public void test5() { System.out.println(mvcboard.select(1)); } //select
//	@Ignore @Test
//	public void test6() { //insert
//		MvcboardDto dto = new MvcboardDto();
//		dto.setBname("최다영"); dto.setBpass("1234"); dto.setBtitle("다용"); dto.setBcontent("안녕"); dto.setBhit(1); dto.setBip("1");
//		System.out.println(mvcboard.insert(dto));
//	}
//	@Ignore @Test public void test7() { //update
//		 MvcboardDto dto = new MvcboardDto();
//			dto.setBname("최다영1"); dto.setBtitle("다용1"); dto.setBcontent("안녕1"); dto.setBno(2); //where
//		 System.out.println(mvcboard.update(dto));}
//	@Ignore @Test public void test8() { System.out.println(mvcboard.delete(2)); }//delete
	
//	@Test public void test4() { System.out.println(mvcboard.selectAll()); }//selectAll
}
