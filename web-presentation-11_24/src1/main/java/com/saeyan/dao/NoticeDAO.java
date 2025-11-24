package com.saeyan.dao;

public class NoticeDAO {
	
	private static NoticeDAO instance= new NoticeDAO();
	
	private NoticeDAO() {}
	
	public static NoticeDAO getinstance() {
		return instance;
	}
	
	
}
