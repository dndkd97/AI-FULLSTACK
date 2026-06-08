package com.the703.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.MvcboardMapper;
import com.the703.dto.MvcboardDto;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired MvcboardMapper dao; //db관련

	@Override public List<MvcboardDto> selectAll() {  return dao.selectAll(); }

	@Override public int insert(MvcboardDto dto,MultipartFile file) {  
		String fileName="the703.png";
		if(!file.isEmpty()) {
			fileName= file.getOriginalFilename();
			String uploadPath = "C:/file/";
			File demp = new File(uploadPath + fileName);
			
			try { file.transferTo(demp); }//파일 옮기기
		   catch (IOException e) {  e.printStackTrace(); }
		}
		
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress());}
		catch (UnknownHostException e) {  e.printStackTrace(); }
		return dao.insert(dto); }

	@Override public MvcboardDto detail(int bno) {  
		//조회수 올리기 ##
		dao.updateHit(bno);
		return dao.select(bno); }

	@Override public MvcboardDto editView(int bno) {  return dao.select(bno); }

	@Override public int edit(MvcboardDto dto,MultipartFile file) {  
		String fileName="the703.png";
		if(!file.isEmpty()) {
			fileName= file.getOriginalFilename();
			String uploadPath = "C:/file/";
			File demp = new File(uploadPath + fileName);
			
			try { file.transferTo(demp); }//파일 옮기기
		   catch (IOException e) {  e.printStackTrace(); }
		}
		
		//비번 맞으면 수정
//		int result = -1; //비번 안맞음
//		MvcboardDto find = dao.select(dto.getBno());
//		if(find.getBpass().equals(dto.getBpass())) {result=dao.update(dto);} return result;
		return dao.update(dto); }

	@Override public int delete(MvcboardDto dto) {  
		//비번 맞으면 삭제
//		int result = -1; //비번 안맞음
//		MvcboardDto find = dao.select(dto.getBno());
//		if(find.getBpass().equals(dto.getBpass())) {result=dao.update(dto.getBno);}
		return dao.delete(dto); }
	
}
