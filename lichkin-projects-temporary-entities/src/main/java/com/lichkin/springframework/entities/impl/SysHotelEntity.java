package com.lichkin.springframework.entities.impl;

import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.BaseLocationEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 酒店表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysHotelEntity extends BaseLocationEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 75003L;

}
