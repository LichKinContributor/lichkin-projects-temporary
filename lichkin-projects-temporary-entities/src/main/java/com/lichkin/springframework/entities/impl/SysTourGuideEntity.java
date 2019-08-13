package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

import com.lichkin.framework.defines.annotations.DefaultByteValue;
import com.lichkin.framework.defines.annotations.DefaultShortValue;
import com.lichkin.framework.defines.enums.impl.LKGenderEnum;
import com.lichkin.springframework.entities.suppers.BaseCompEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 导游表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysTourGuideEntity extends BaseCompEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 75009L;

	/** 照片（Base64） */
	@Lob
	@Column(nullable = false)
	private String photo;

	/** 姓名 */
	@Column(length = 64, nullable = false)
	private String userName;

	/** 手机号码 */
	@Column(length = 11, nullable = false)
	private String cellphone;

	/** 性别（枚举） */
	@Enumerated(EnumType.STRING)
	@Column(length = 7, nullable = false)
	private LKGenderEnum gender;

	/** 总带团次数 */
	@DefaultShortValue(0)
	@Column(nullable = false)
	private Short totalTourCount;

	/** 今日带团次数 */
	@DefaultByteValue(0)
	@Column(nullable = false)
	private Byte todayTourCount;

	/** 评分 */
	@DefaultByteValue(1)
	@Column(nullable = false)
	private Byte level;

}
