package net.ca1yps.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.ca1yps.community.dto.FileDTO;

@Mapper
public interface FileMapper {
	int insertFile(FileDTO file);
	int updateFileByBid(@Param("bid") long bid, @Param("tempId") long tempId);	//임시로 등록된 bid를 게시판 bid로 업데이트
	int deleteFile(long id);
	List<FileDTO> selectFileByBid(long bid);
	FileDTO fileById(long id);
	FileDTO fileByFileName(String fname);
}
