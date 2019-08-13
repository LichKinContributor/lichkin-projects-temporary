package com.lichkin.application.apis.toilet.arsg.UploadRoomStatus;

import org.springframework.stereotype.Service;

import com.lichkin.framework.defines.exceptions.LKException;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysToiletRoomStatusEntity;
import com.lichkin.springframework.services.LKApiServiceImpl;
import com.lichkin.springframework.services.LKApiVoidService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiServiceImpl<I, Void> implements LKApiVoidService<I> {

	@Override
	public void handle(I cin, ApiKeyValues<I> params) throws LKException {
		SysToiletRoomStatusEntity entity = new SysToiletRoomStatusEntity();
		entity.setFlag(cin.getFlag());
		dao.persistOne(entity);
	}

}
