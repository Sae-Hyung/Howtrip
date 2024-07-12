package com.backend24.howtrip.board.vo;

public class BoardFileVO {
    private int fileId;
    private String fileName;
    private String fileExtension;
    private String fileDirectory;
    private int fileSeq;
    private int boardId;
    
    public BoardFileVO() {
    	        this.fileId = 0;  // 기본값 설정 (0 또는 원하는 값으로 초기화)
    	        this.fileName = "";  // 기본값 설정 (빈 문자열 또는 원하는 값으로 초기화)
    	        this.fileExtension = "";  // 기본값 설정 (빈 문자열 또는 원하는 값으로 초기화)
    	        this.fileDirectory = "";  // 기본값 설정 (빈 문자열 또는 원하는 값으로 초기화)
    	        this.fileSeq = 0;  // 기본값 설정 (0 또는 원하는 값으로 초기화)
    	        this.boardId = 0;  // 기본값 설정 (0 또는 원하는 값으로 초기화)
    }
    	
    	
	public int getFileId() {
		return fileId;
	}
		
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public String getFileDirectory() {
		return fileDirectory;
	}
	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}
	public int getFileSeq() {
		return fileSeq;
	}
	public void setFileSeq(int fileSeq) {
		this.fileSeq = fileSeq;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

}
