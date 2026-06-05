package com.the703.service;

import java.util.List;
import com.the703.dto.MvcboardDto;

public interface BoardService {
	//■1.전체 리스트
	public List<MvcboardDto> selectAll();
	//■2.글쓰기 기능
	public int insert(MvcboardDto dto);
	//■3.글 상세보기   - 조회수올리기 / 해당글
	public MvcboardDto detail(int bno);
	//■4.글수정폼 경로  - 해당글
	public MvcboardDto editView(int bno);
	//■4.글수정 기능   - 비밀번호가 맞는지 확인 후 글수정
	public int edit(MvcboardDto dto);
	//■5.글삭제폼 경로  - 비밀번호가 맞는지 확인 후 글삭제
	public int delete(MvcboardDto dto);
}
