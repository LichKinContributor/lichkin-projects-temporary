package com.lichkin.application.apis.toilet.arsg.UploadSmogStatus;

import com.lichkin.application.apis.toilet.arsg.ToiletArsgIn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends ToiletArsgIn {

	/** 烟雾状态。true：开；false：关； */
	private Boolean flag;

}
