package com.the703.dao;

import java.util.List;

import com.the703.dto.MvcboardDto;

@Mapper
public interface MvcboardMapper {
    public int insert(MvcboardDto dto);
    public List<MvcboardDto> selectAll();
    public MvcboardDto select(int bno);
    public int update(MvcboardDto dto);
    public int delete(int bno);
	
}
