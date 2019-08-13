package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.IDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 厕所房间状态表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysToiletRoomStatusEntity extends IDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 76011L;

	/** 蹲位状态。true：有人；false：无人； */
	@Column(nullable = false)
	private Boolean flag;

}
