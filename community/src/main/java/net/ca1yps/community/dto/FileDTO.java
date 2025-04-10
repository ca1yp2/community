package net.ca1yps.community.dto;

import lombok.Data;

@Data
public class FileDTO {
	private long id;			
	private long bid;			//게시판 번호
	private String ofilename;	//올릴 때 파일 이름
	private String nfilename;	//변경한 이름
	private String ext;			//파일 확장자
	private long filesize;	//파일 크기
	private long addFileSize;
}
