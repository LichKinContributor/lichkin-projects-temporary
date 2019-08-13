package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.BaseLocationEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 摄像头表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysCameraEntity extends BaseLocationEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 75008L;

	/** 厂商ID（SysManufacturerEntity.id） */
	@Column(length = 64, nullable = false)
	private String manufacturerId;

	/** 型号ID（SysModelEntity.id） */
	@Column(length = 64, nullable = false)
	private String modelId;

	/** 设备ID */
	@Column(length = 64, nullable = false)
	private String sid;

}
