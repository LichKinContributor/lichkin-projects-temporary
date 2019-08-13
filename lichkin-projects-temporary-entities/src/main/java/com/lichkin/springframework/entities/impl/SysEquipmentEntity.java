package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.BaseCompEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 设备表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysEquipmentEntity extends BaseCompEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 74000L;

	/** 厂商ID（SysManufacturerEntity.id） */
	@Column(length = 64, nullable = false)
	private String manufacturerId;

	/** 型号ID（SysModelEntity.id） */
	@Column(length = 64, nullable = false)
	private String modelId;

	/** 设备SID */
	@Column(length = 128, nullable = false)
	private String sid;

	/** 设备类型（字典） */
	@Column(length = 64, nullable = false)
	private String equipmentType;

}
