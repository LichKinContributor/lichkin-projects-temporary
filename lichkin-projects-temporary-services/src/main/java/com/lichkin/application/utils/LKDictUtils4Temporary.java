package com.lichkin.application.utils;

import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.defines.LKFrameworkStatics;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 字典工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LKDictUtils4Temporary extends LKDictUtils {

	/**
	 * 连接字典表（设备类型）
	 * @param sql SQL语句对象
	 * @param columnResId 列资源ID
	 * @param tableIdx 字典表序号（从0开始）
	 */
	public static void equipmentType(QuerySQL sql, int columnResId, int tableIdx) {
		leftJoinDictionary(sql, "equipmentType", LKFrameworkStatics.LichKin, "EQUIPMENT_TYPE", columnResId, tableIdx);
	}


	/**
	 * 连接字典表（位置编码）
	 * @param sql SQL语句对象
	 * @param compId 公司ID
	 * @param columnResId 列资源ID
	 * @param tableIdx 字典表序号（从0开始）
	 */
	public static void locationCode(QuerySQL sql, String compId, int columnResId, int tableIdx) {
		leftJoinDictionary(sql, "locationCode", compId, "LOCATION_CODE", columnResId, tableIdx);
	}

}
