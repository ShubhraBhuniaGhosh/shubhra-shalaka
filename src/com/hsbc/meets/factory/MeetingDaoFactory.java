package com.hsbc.meets.factory;

import com.hsbc.meets.dao.MeetingDao;
import com.hsbc.meets.dao.impl.MeetingDbDaoImpl;

public abstract class MeetingDaoFactory {
	
	public static MeetingDao getMeetingDaoObject() {
		return new MeetingDbDaoImpl();
	}
}
