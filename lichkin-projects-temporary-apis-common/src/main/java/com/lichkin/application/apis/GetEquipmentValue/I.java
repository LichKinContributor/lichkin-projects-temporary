package com.lichkin.application.apis.GetEquipmentValue;

import com.lichkin.framework.beans.impl.LKRequestBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestBean {

	/** 设备类型（字典） */
	private String equipmentType;

	/** 设备ID */
	private String equipmentSid;

}
