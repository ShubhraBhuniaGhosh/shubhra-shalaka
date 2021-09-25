package com.hsbc.meets.factory;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.service.MeetingService;
import com.hsbc.meets.service.impl.MeetingServiceImpl;

public abstract class MeetingServiceFactory {
	public static MeetingService getMeetingServiceObject(User manager) {
		return new MeetingServiceImpl(manager);
	}
}
