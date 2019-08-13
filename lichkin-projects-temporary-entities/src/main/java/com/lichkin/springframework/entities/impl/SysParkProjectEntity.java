package com.lichkin.springframework.entities.impl;

import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.BaseLocationEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 公园项目表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysParkProjectEntity extends BaseLocationEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 75002L;

}
