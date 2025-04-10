package net.ca1yps.community.service;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ca1yps.community.dto.FileDTO;
import net.ca1yps.community.mapper.FileMapper;

@Service
public class FileService {
	
	@Autowired
	FileMapper fileMapper;
	
	public int insertFile(FileDTO fileDTO) {
		return fileMapper.insertFile(fileDTO);
	}
	
	public int updateFile(long bid, long tempId) {
		return fileMapper.updateFileByBid(bid, tempId);
	}
	
	public int deleteFile(long id) {
		return fileMapper.deleteFile(id);
	}
	
	public void trashFile(String filePath) {
		File baseDir = new File(filePath);
		if(!baseDir.exists()) return;
		
		long todayZero = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		
		File[] files = baseDir.listFiles();			//폴더를 열어서 파일 이름을 가져옴(배열)
		if(files == null) return;
		//1. db가 없고 파일만 있는 경우 삭제
		for(File file: files) {						//파일 이름을 하나씩 점검하면서 db가 없으면 isTrash가 true, db가 오늘 00시 이전이면 isTrash가 true, 그 이외에는 isTrash는 false
			String fname = file.getName();
			FileDTO dto = fileMapper.fileByFileName(fname);
			boolean isTrash = false;
			if(dto == null) {
				isTrash = true;						//파일 삭제(dto가 있으면 db도 삭제)
			}else {
				long bid = dto.getBid();
				if(String.valueOf(bid).matches("\\d{12,14}") && bid < todayZero) {
					isTrash = true;
				}
			}
			
			if(isTrash) {
				boolean del = file.delete();
				System.out.println(del?"[삭제됨]":"[삭제실패]"+ ", " + fname );
				if(dto != null) {
					fileMapper.deleteFile(dto.getId());
				}
			}
		}
	}
	
	public List<FileDTO> selectFileList(long bid){
		return fileMapper.selectFileByBid(bid);
	}
	
	public FileDTO selectFileById(long id) {
		return fileMapper.fileById(id);
	}
	
	public FileDTO selectFileByFileName(String filename) {
		return fileMapper.fileByFileName(filename);
	}
}
