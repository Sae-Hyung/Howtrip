package com.backend24.howtrip.community.vo;

public class BoardTagVO {
	private int tagId;
	private String tagName;
	private int boardId;
	
	public BoardTagVO() {
		
	}
	public BoardTagVO(int tagId, String tagName, int boardId) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.boardId = boardId;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
    
}
