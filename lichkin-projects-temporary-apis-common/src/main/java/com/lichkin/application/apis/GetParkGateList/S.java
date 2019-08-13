package com.lichkin.application.apis.GetParkGateList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils4Temporary;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysParkGateR;
import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysParkGateEntity;
import com.lichkin.springframework.services.LKApiBusGetListService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetListService<I, O, SysParkGateEntity> {

	@Getter
	@RequiredArgsConstructor
	enum ErrorCodes implements LKCodeEnum {

		/** 暂未接入场所 */
		no_place_has_been_connected_yet(990001),

		;

		private final Integer code;

	}


	@Override
	protected void initSQL(I cin, ApiKeyValues<I> params, QuerySQL sql) {
		sql.select(SysParkGateR.id);
		sql.select(SysParkGateR.photo);

		int i = 0;
		LKDictUtils4Temporary.locationCode(sql, params.getCompId(), SysParkGateR.locationCode, i++);

		sql.eq(SysParkGateR.compId, params.getCompId());
	}


	@Override
	protected List<O> afterQuery(I cin, ApiKeyValues<I> params, List<O> list) {
		if (list.isEmpty()) {
			throw new LKRuntimeException(ErrorCodes.no_place_has_been_connected_yet);
		}
		return list;
	}

}
