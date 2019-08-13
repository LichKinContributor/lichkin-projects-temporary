package com.lichkin.application.apis.GetEquipmentValue;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.exceptions.LKException;
import com.lichkin.framework.web.annotations.LKApiType;
import com.lichkin.framework.web.enums.ApiType;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.controllers.LKApiY0Controller;

@RestController(Statics.CONTROLLER_NAME)
@RequestMapping(value = LKFrameworkStatics.WEB_MAPPING_API + Statics.SUB_URL)
@LKApiType(apiType = ApiType.OPEN)
public class C extends LKApiY0Controller<I, O> {

	@Resource(name = Statics.SERVICE_NAME)
	private M mapper;


	@Override
	protected O doInvoke(I cin, ApiKeyValues<I> params) throws LKException {
		return mapper.getValue(cin);
	}

}
