package com.lichkin.springframework.entities.impl;

import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.BaseEqptDataEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 风速数据表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class SysEqptDataWindSpeedEntity extends BaseEqptDataEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 76008L;


	public SysEqptDataWindSpeedEntity(String equipmentSid, String dataValue, String dataUnit) {
		super(equipmentSid, dataValue, dataUnit);
	}

}
