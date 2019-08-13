package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.IDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 设备位置信息表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysEquipmentLocationEntity extends IDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 74001L;

	/** 设备SID（SysEquipmentEntity.sid） */
	@Column(length = 128, nullable = false)
	private String equipmentSid;

	/** 位置编码（字典） */
	@Column(length = 64, nullable = false)
	private String locationCode;

}
