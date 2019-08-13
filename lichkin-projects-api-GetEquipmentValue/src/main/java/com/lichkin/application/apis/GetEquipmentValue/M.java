package com.lichkin.application.apis.GetEquipmentValue;

import javax.annotation.ManagedBean;

import org.apache.ibatis.annotations.Mapper;

@Mapper
@ManagedBean(Statics.SERVICE_NAME)
public interface M {

	O getValue(I in);

}
