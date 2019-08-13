package com.lichkin.application.apis.toilet.arsg.UploadEnvironmentData;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lichkin.framework.defines.exceptions.LKException;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysEqptDataAmmoniaEntity;
import com.lichkin.springframework.entities.impl.SysEqptDataHumidityEntity;
import com.lichkin.springframework.entities.impl.SysEqptDataHydrothionEntity;
import com.lichkin.springframework.entities.impl.SysEqptDataPm25Entity;
import com.lichkin.springframework.entities.impl.SysEqptDataTemperatureEntity;
import com.lichkin.springframework.services.LKApiServiceImpl;
import com.lichkin.springframework.services.LKApiVoidService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiServiceImpl<I, Void> implements LKApiVoidService<I> {

	private static final String UNIT_TEMPERATURE = "℃";

	private static final String UNIT_HUMIDITY = "%";

	private static final String UNIT_PM25 = "μg/m³";

	private static final String UNIT_HYDROTHION = "ppm";

	private static final String UNIT_AMMONIA = "g/L";


	@Transactional
	@Override
	public void handle(I cin, ApiKeyValues<I> params) throws LKException {
		String toiletKey = cin.getToiletKey();
		if (StringUtils.isBlank(toiletKey)) {
			return;
		}

		String sid = cin.getSid();
		if (StringUtils.isBlank(sid)) {
			return;
		}

		String temperature = cin.getTemperature();
		if (StringUtils.isNotBlank(temperature)) {
			String dataValue = temperature.replace(UNIT_TEMPERATURE, "");
			SysEqptDataTemperatureEntity entity = new SysEqptDataTemperatureEntity(sid, dataValue, UNIT_TEMPERATURE);

			double value = Double.parseDouble(dataValue);
			if (value < -40) {
				entity.setRemarks("极寒");
			} else if (value < -35) {
				entity.setRemarks("奇寒");
			} else if (value < -30) {
				entity.setRemarks("酷寒");
			} else if (value < -20) {
				entity.setRemarks("严寒");
			} else if (value < -15) {
				entity.setRemarks("深寒");
			} else if (value < -10) {
				entity.setRemarks("大寒");
			} else if (value < -5) {
				entity.setRemarks("小寒");
			} else if (value < 0) {
				entity.setRemarks("轻寒");
			} else if (value < 5) {
				entity.setRemarks("微寒");
			} else if (value < 10) {
				entity.setRemarks("凉");
			} else if (value < 12) {
				entity.setRemarks("温凉");
			} else if (value < 14) {
				entity.setRemarks("微温凉");
			} else if (value < 16) {
				entity.setRemarks("温和");
			} else if (value < 18) {
				entity.setRemarks("微温和");
			} else if (value < 20) {
				entity.setRemarks("温暖");
			} else if (value < 22) {
				entity.setRemarks("暖");
			} else if (value < 25) {
				entity.setRemarks("热");
			} else if (value < 28) {
				entity.setRemarks("炎热");
			} else if (value < 30) {
				entity.setRemarks("暑热");
			} else if (value < 35) {
				entity.setRemarks("酷热");
			} else if (value < 40) {
				entity.setRemarks("奇热");
			} else {
				entity.setRemarks("极热");
			}

			dao.persistOne(entity);
		}

		String humidity = cin.getHumidity();
		if (StringUtils.isNotBlank(humidity)) {
			String dataValue = humidity.replace(UNIT_HUMIDITY, "");
			SysEqptDataHumidityEntity entity = new SysEqptDataHumidityEntity(sid, dataValue, UNIT_HUMIDITY);

			double value = Double.parseDouble(dataValue);
			if (value < 45) {
				entity.setRemarks("干燥");
			} else if (value < 60) {
				entity.setRemarks("适宜");
			} else {
				entity.setRemarks("潮湿");
			}

			dao.persistOne(entity);
		}

		String pm25 = cin.getPm25();
		if (StringUtils.isNotBlank(pm25)) {
			String dataValue = pm25.replace(UNIT_PM25, "");
			SysEqptDataPm25Entity entity = new SysEqptDataPm25Entity(sid, dataValue, UNIT_PM25);

			double value = Double.parseDouble(dataValue);
			if (value < 35) {
				entity.setRemarks("优");
			} else if (value < 75) {
				entity.setRemarks("良");
			} else if (value < 115) {
				entity.setRemarks("轻度污染");
			} else if (value < 150) {
				entity.setRemarks("中度污染");
			} else if (value < 250) {
				entity.setRemarks("重度污染");
			} else {
				entity.setRemarks("严重污染");
			}

			dao.persistOne(entity);
		}

		String hydrothion = cin.getHydrothion();
		if (StringUtils.isNotBlank(hydrothion)) {
			String dataValue = hydrothion.replace(UNIT_HYDROTHION, "");
			SysEqptDataHydrothionEntity entity = new SysEqptDataHydrothionEntity(sid, dataValue, UNIT_HYDROTHION);

			double value = Double.parseDouble(dataValue);
			if (value < 0.03) {
				entity.setRemarks("一级");
			} else if (value < 0.1) {
				entity.setRemarks("二级");
			} else if (value < 0.6) {
				entity.setRemarks("三级");
			} else {
				entity.setRemarks("严重超标");
			}

			dao.persistOne(entity);
		}

		String ammonia = cin.getAmmonia();
		if (StringUtils.isNotBlank(ammonia)) {
			String dataValue = ammonia.replace(UNIT_AMMONIA, "");
			SysEqptDataAmmoniaEntity entity = new SysEqptDataAmmoniaEntity(sid, dataValue, UNIT_AMMONIA);

			double value = Double.parseDouble(dataValue);
			if (value < 1) {
				entity.setRemarks("一级");
			} else if (value < 2) {
				entity.setRemarks("二级");
			} else if (value < 5) {
				entity.setRemarks("三级");
			} else {
				entity.setRemarks("严重污染");
			}

			dao.persistOne(entity);
		}
	}

}
