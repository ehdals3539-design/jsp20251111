package com.saeyan.ato;

public class NotceVO {
	
	/*
	 * 번호,게시물 고유 번호,Integer
제목,게시물 제목,String
작성일,작성 날짜,Date
조회수,조회된 횟수,Integer
내용,게시물의 상세 내용,Text

	 */
	
	private int num;
	private String title;
	private String date;
	private int	view;
	private String text;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "NotceVO [num=" + num + ", title=" + title + ", date=" + date + ", view=" + view + ", text=" + text
				+ "]";
	}

	
	
}
