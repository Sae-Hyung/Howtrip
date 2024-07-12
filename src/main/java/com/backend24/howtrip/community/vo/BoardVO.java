package com.backend24.howtrip.community.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class BoardVO {
   private int boardId;
   private String userId;
   private String title;
   private String boardContent;
   private int views;
   private int likeCnt;
   private Timestamp createdTime;
   private Timestamp updateTime;
   
 

   //기본생성자
   public BoardVO() {
        
   }
     
   //전체 필드를 가진 생성자
   public BoardVO(int boardId, String title, String boardContent, int views, int likeCnt, Date createdTime, Date updateTime, String userId) {
      this.boardId = boardId;
      this.userId = userId;
      this.title = title;
      this.boardContent = boardContent;
      this.views = views;
      this.likeCnt = likeCnt;
       
   }
  
   public int getBoardId() {
      return boardId;
   }

   public void setBoardId(int boardId) {
      this.boardId = boardId;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getBoardContent() {
      return boardContent;
   }

   public void setBoardContent(String boardContent) {
      this.boardContent = boardContent;
   }

   public int getViews() {
      return views;
   }

   public void setViews(int views) {
      this.views = views;
   }

   public int getLikeCnt() {
      return likeCnt;
   }

   public void setLikeCnt(int likeCnt) {
      this.likeCnt = likeCnt;
   }

   public Timestamp getCreatedTime() {
	   return createdTime;
   }

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserId() {
		return userId;
   }

   public void setUserId(String userId) {
	   this.userId = userId;
   }
     
}