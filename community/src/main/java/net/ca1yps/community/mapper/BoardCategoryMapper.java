package net.ca1yps.community.mapper;

import org.apache.ibatis.annotations.Mapper;

import net.ca1yps.community.dto.BoardCategory;

@Mapper
public interface BoardCategoryMapper {
	
	int saveCategory(BoardCategory category);
	int deleteCategory(int id);
	int upadateCategory(BoardCategory category);
	BoardCategory selectBoardCategoryById(int id);

}
