package com.lichkin.application.apis.GetCameraList;

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

	/** 厂商ID（SysManufacturerEntity.id） */
	private String manufacturerId;

	/** 型号ID（SysModelEntity.id） */
	private String modelId;

	/** 设备ID */
	private String sid;

	/** 在线地址 */
	private String onlineUrl;

}
