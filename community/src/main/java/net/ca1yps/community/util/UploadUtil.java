package net.ca1yps.community.util;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.ca1yps.community.dto.FileDTO;

public interface UploadUtil {
	List<FileDTO> uploadFiles(
			List<MultipartFile> files, 
			String uploadPath, 
			int fileTypeCondition,		//0:이미지, 1:파일
			long fileSizeLimit,			//파일 하나의 용량제한
			long totalFileSizeLimit,	//총 파일 용량 제한
			long addFileSize			//현재까지 업로드된 용량을 더해서 보냄
			) throws Exception;
}
