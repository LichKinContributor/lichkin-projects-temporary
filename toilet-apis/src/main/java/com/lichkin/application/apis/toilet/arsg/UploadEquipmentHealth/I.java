package com.lichkin.application.apis.toilet.arsg.UploadEquipmentHealth;

import com.lichkin.application.apis.toilet.arsg.ToiletArsgIn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends ToiletArsgIn {

	/** 设备健康状况。true：正常；false：异常； */
	private Boolean flag;

}
