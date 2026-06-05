package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dao.MvcboardMapper;
import com.the703.dto.MvcboardDto;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired MvcboardMapper dao; //db관련

	@Override public List<MvcboardDto> selectAll() {  return dao.selectAll(); }

	@Override public int insert(MvcboardDto dto) {  
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress());}
		catch (UnknownHostException e) {  e.printStackTrace(); }
		return dao.insert(dto); }

	@Override public MvcboardDto detail(int bno) {  
		//조회수 올리기 ##
		dao.updateHit(bno);
		return dao.select(bno); }

	@Override public MvcboardDto editView(int bno) {  return dao.select(bno); }

	@Override public int edit(MvcboardDto dto) {  
		//비번 맞으면 수정
		return dao.update(dto); }

	@Override public int delete(MvcboardDto dto) {  
		//비번 맞으면 삭제
		return dao.delete(dto); }
	
}
