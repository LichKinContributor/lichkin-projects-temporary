package com.lichkin.application.apis.GetLocationEquipmentList;

import com.lichkin.framework.beans.impl.LKRequestPageBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestPageBean {

	/** 位置编码 */
	private String locationCode;

}
