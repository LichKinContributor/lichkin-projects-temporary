package com.lichkin.application.apis.GetTourGuidePage;

import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysTourGuideR;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysTourGuideEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetPageService<I, O, SysTourGuideEntity> {

	@Override
	protected void initSQL(I cin, ApiKeyValues<I> params, QuerySQL sql) {
		// 主表
		sql.select(SysTourGuideR.id);
		sql.select(SysTourGuideR.photo);
		sql.select(SysTourGuideR.userName);
		sql.select(SysTourGuideR.cellphone);
		sql.select(SysTourGuideR.totalTourCount);
		sql.select(SysTourGuideR.todayTourCount);
		sql.select(SysTourGuideR.level);

		// 字典表
		int i = 0;
		LKDictUtils.gender(sql, SysTourGuideR.gender, i++);

		// 筛选条件（必填项）
		// 公司ID
		sql.eq(SysTourGuideR.compId, params.getCompId());
		// 在用状态
		sql.eq(SysTourGuideR.usingStatus, LKUsingStatusEnum.USING);

		// 排序条件
		sql.addOrders(new Order(SysTourGuideR.level, false), new Order(SysTourGuideR.id));
	}

}
