package net.ca1yps.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ca1yps.community.dto.BoardAdminDTO;
import net.ca1yps.community.dto.BoardCategory;
import net.ca1yps.community.mapper.BoardAdminMapper;
import net.ca1yps.community.mapper.BoardCategoryMapper;

@Service
public class BoardAdminService {
	
	@Autowired
	private BoardAdminMapper baMapper;
	
	@Autowired
	private BoardCategoryMapper bcMapper;
	
	public int insertBoardAdmin(String btitle) {
		return baMapper.setBoardAdmin(btitle);
	}
	
	public int editBoardAdmin(BoardAdminDTO dto) {
		return baMapper.updateBoardAdmin(dto);
	}
	
	public int delBoardAdmin(int id) {
		return baMapper.deleteBoardAdmin(id);
	}
	
	public BoardAdminDTO getSelectById(int id) {
		return baMapper.getBoardAdmin(id);
	}
	
	public List<BoardAdminDTO> getAllList(){
		List<BoardAdminDTO> list = baMapper.allList();
		for(BoardAdminDTO dto : list) {
			List<BoardCategory> categories = baMapper.allCategoryByBoardId(dto.getId());
			dto.setBoardCategory(categories);
		}
		return list;
	}
	
	public List<BoardCategory> getAllCategory(int id){
		return baMapper.allCategoryByBoardId(id);
	}
	
	public int boardCategoryDelete(int categoryId) {
		return bcMapper.deleteCategory(categoryId);
	}
	
	public int boardCategoryUpdate(BoardCategory category) {
		return bcMapper.upadateCategory(category);
	}
	
	public int BoardCategoryInsert(BoardCategory category) {
		return bcMapper.saveCategory(category);
	}
	
	public BoardCategory boardCategoryInsert(BoardCategory category) {
		bcMapper.saveCategory(category);
		return bcMapper.selectBoardCategoryById(category.getId());
	}

}
