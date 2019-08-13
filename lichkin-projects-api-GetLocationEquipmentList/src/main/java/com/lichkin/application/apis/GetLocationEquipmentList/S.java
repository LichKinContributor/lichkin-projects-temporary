package com.lichkin.application.apis.GetLocationEquipmentList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils4Temporary;
import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysEquipmentLocationR;
import com.lichkin.framework.db.beans.SysEquipmentR;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysEquipmentEntity;
import com.lichkin.springframework.entities.impl.SysEquipmentLocationEntity;
import com.lichkin.springframework.services.LKApiBusGetListService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetListService<I, O, SysEquipmentLocationEntity> {

	@Getter
	@RequiredArgsConstructor
	enum ErrorCodes implements LKCodeEnum {

		/** 暂未接入设备 */
		no_device_has_been_connected_yet(990002),

		;

		private final Integer code;

	}


	@Override
	protected void initSQL(I cin, ApiKeyValues<I> params, QuerySQL sql) {
		sql.select(SysEquipmentR.sid, "equipmentSid");

		sql.innerJoin(SysEquipmentEntity.class,

				new Condition(SysEquipmentR.sid, SysEquipmentLocationR.equipmentSid),

				new Condition(new eq(SysEquipmentR.compId, params.getCompId())),

				new Condition(new eq(SysEquipmentR.usingStatus, LKUsingStatusEnum.USING))

		);

		int i = 0;
		LKDictUtils4Temporary.equipmentType(sql, SysEquipmentR.equipmentType, i++);

		sql.eq(SysEquipmentLocationR.locationCode, cin.getLocationCode());

		sql.addOrders(new Order(SysEquipmentR.sid), new Order(SysEquipmentR.equipmentType));
	}


	@Override
	protected List<O> afterQuery(I cin, ApiKeyValues<I> params, List<O> list) {
		if (list.isEmpty()) {
			throw new LKRuntimeException(ErrorCodes.no_device_has_been_connected_yet);
		}
		return list;
	}

}
