package com.lichkin.application.apis.GetEquipmentValue;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface M {

	O getValue(I in);

}
