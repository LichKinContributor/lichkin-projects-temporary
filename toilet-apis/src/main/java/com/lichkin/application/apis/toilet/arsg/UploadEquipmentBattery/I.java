package com.lichkin.application.apis.toilet.arsg.UploadEquipmentBattery;

import com.lichkin.application.apis.toilet.arsg.ToiletArsgIn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends ToiletArsgIn {

	/** 百分比数值，两位小数。注：字符串表示 */
	private String battery;

}
