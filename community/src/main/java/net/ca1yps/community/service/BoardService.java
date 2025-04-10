package net.ca1yps.community.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ca1yps.community.dto.BoardDTO;
import net.ca1yps.community.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper bMapper;
	
	public List<BoardDTO> getAllList(int bbsid){
		return bMapper.allList(bbsid);
	}
	
	public BoardDTO getBoardById(long id) {
		return bMapper.getBoardById(id);
	}
	
	public BoardDTO getBoardByPass(int id, String password) {
		Map<String, Object> params = new HashMap<>();
		params.put("id",id);
		params.put("password", password);
		return bMapper.getBoardByPassword(params);
	}
	
	public int insertBoard(BoardDTO dto) {
		return bMapper.setBoard(dto);
	}
	
	public int updateBoard(BoardDTO dto) {
		return bMapper.setUpdateBoard(dto);
	}
	
	public int deleteBoard(long id) {
		return bMapper.setDeleteBoard(id);
	}
}
