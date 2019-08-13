package com.lichkin.application.apis.toilet.arsg.UploadRoomStatus;

import com.lichkin.application.apis.toilet.arsg.ToiletArsgIn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends ToiletArsgIn {

	/** 蹲位状态。true：有人；false：无人； */
	private Boolean flag;

	/** 电量 */
	private String battery;

}
