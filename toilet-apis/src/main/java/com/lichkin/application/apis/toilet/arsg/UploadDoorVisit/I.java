package com.lichkin.application.apis.toilet.arsg.UploadDoorVisit;

import com.lichkin.application.apis.toilet.arsg.ToiletArsgIn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends ToiletArsgIn {

	/** 进数 */
	private Integer in;

	/** 出数 */
	private Integer out;

	/** 剩余数 */
	private Integer stay;

	/** true:红外故障;false:无故障; */
	private Boolean ifros;

	/** 电量 */
	private String battery;

}
