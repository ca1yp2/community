package net.ca1yps.community.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import net.ca1yps.community.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	List<BoardDTO> allList(int bid);
	BoardDTO getBoardById(long id);
	BoardDTO getBoardByPassword(Map<String, Object> params);
	int setBoard(BoardDTO dto);
	int setUpdateBoard(BoardDTO dto);
	int setDeleteBoard(long id);
}
