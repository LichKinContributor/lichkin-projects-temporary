package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.IDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 资源消耗表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysToiletResourceConsumeEntity extends IDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 75010L;

	/** 厕所ID（SysToiletEntity.id） */
	@Column(length = 64, nullable = false)
	private String toiletId;

	/** 记录日期（yyyy-MM-dd） */
	@Column(length = 10, nullable = false)
	private String insertDate;

	/** 资源类型。W:水;E:电; */
	@Column(length = 1, nullable = false)
	private String resourceType;

	/** 资源消耗值。#0.00 */
	@Column(length = 11, nullable = false)
	private String consumeValue;

}
