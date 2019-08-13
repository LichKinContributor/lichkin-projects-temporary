package com.lichkin.application.apis.GetParkGateList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.web.annotations.LKApiType;
import com.lichkin.framework.web.enums.ApiType;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.controllers.LKApiBusGetListController;
import com.lichkin.springframework.entities.impl.SysParkGateEntity;
import com.lichkin.springframework.services.LKApiBusGetListService;

@RestController(Statics.CONTROLLER_NAME)
@RequestMapping(value = LKFrameworkStatics.WEB_MAPPING_API + Statics.SUB_URL)
@LKApiType(apiType = ApiType.COMPANY_QUERY)
public class C extends LKApiBusGetListController<I, O, SysParkGateEntity> {

	@Autowired
	private S service;


	@Override
	protected LKApiBusGetListService<I, O, SysParkGateEntity> getService(I cin, ApiKeyValues<I> params) {
		return service;
	}

}
