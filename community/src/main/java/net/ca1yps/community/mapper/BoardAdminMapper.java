package net.ca1yps.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.ca1yps.community.dto.BoardAdminDTO;
import net.ca1yps.community.dto.BoardCategory;

@Mapper
public interface BoardAdminMapper {
	
	int setBoardAdmin(String btitle);
	int updateBoardAdmin(BoardAdminDTO dto);
	int deleteBoardAdmin(int id);
	BoardAdminDTO getBoardAdmin(int id);
	List<BoardAdminDTO> allList();
	List<BoardCategory> allCategoryByBoardId(int id);
	int updateBoardFileAdmin(BoardAdminDTO dto);

}
