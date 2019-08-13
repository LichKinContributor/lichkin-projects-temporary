package com.lichkin.application.apis.GetParkGateList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class O {

	/** 主键 */
	private String id;

	/** 位置编码（字典） */
	private String locationCodeDictCode;

	/** 位置名称 */
	private String locationCode;

	/** 图片（BASE64） */
	private String photo;

}
