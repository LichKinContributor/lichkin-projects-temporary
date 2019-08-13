package com.lichkin.application.apis.GetCameraList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils4Temporary;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysCameraR;
import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.framework.utils.LKListUtils;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysCameraEntity;
import com.lichkin.springframework.services.LKApiBusGetListService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetListService<I, O, SysCameraEntity> {

	@Getter
	@RequiredArgsConstructor
	enum ErrorCodes implements LKCodeEnum {

		/** 暂未接入设备 */
		no_device_has_been_connected_yet(990002),

		/** 该厂商摄像头暂不支持在线地址解析 */
		camera_can_not_analysis_online_url_by_manufacturer(990003),

		/** 该型号摄像头暂不支持在线地址解析 */
		camera_can_not_analysis_online_url_by_module(990004),

		;

		private final Integer code;

	}


	@Override
	protected void initSQL(I cin, ApiKeyValues<I> params, QuerySQL sql) {
		sql.select(SysCameraR.id);
		sql.select(SysCameraR.photo);
		sql.select(SysCameraR.manufacturerId);
		sql.select(SysCameraR.modelId);
		sql.select(SysCameraR.sid);

		int i = 0;
		LKDictUtils4Temporary.locationCode(sql, params.getCompId(), SysCameraR.locationCode, i++);

		sql.eq(SysCameraR.compId, params.getCompId());
	}


	@Override
	protected List<O> afterQuery(I cin, ApiKeyValues<I> params, List<O> list) {
		if (list.isEmpty()) {
			throw new LKRuntimeException(ErrorCodes.no_device_has_been_connected_yet);
		}

		return LKListUtils.convert(list, source -> {
			// TODO 实际接入时，需按照厂商规则设置在线地址
			switch (source.getManufacturerId()) {
				case "test": {
					switch (source.getModelId()) {
						case "test-A": {
							source.setOnlineUrl("http://files.yoorenle.cn/videos/test.mp4");
						}
						break;
						default:
							throw new LKRuntimeException(ErrorCodes.camera_can_not_analysis_online_url_by_module).withParam("#module", source.getModelId());
					}
				}
				break;
				default:
					throw new LKRuntimeException(ErrorCodes.camera_can_not_analysis_online_url_by_manufacturer).withParam("#manufacturer", source.getManufacturerId());
			}
			return source;
		});
	}

}
