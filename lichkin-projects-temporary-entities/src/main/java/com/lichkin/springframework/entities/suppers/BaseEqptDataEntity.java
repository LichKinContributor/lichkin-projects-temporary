package com.lichkin.springframework.entities.suppers;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 设备数据表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@RequiredArgsConstructor
public abstract class BaseEqptDataEntity extends IDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 设备SID（SysEquipmentEntity.sid） */
	@NonNull
	@Column(length = 128, nullable = false)
	private String equipmentSid;

	/** 数据值 */
	@NonNull
	@Column(length = 32, nullable = false)
	private String dataValue;

	/** 数据单位 */
	@NonNull
	@Column(length = 16, nullable = false)
	private String dataUnit;

	/** 备注 */
	@Column(length = 128)
	private String remarks;

}
