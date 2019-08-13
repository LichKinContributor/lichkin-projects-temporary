package com.lichkin.application.apis.toilet.arsg.UploadCleanOver;

import com.lichkin.application.apis.toilet.arsg.ToiletArsgIn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends ToiletArsgIn {

	/** 员工卡号 */
	private String cardId;

	/** 电量 */
	private String battery;

}
