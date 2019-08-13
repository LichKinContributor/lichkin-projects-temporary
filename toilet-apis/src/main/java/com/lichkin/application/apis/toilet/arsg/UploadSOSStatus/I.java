package com.lichkin.application.apis.toilet.arsg.UploadSOSStatus;

import com.lichkin.application.apis.toilet.arsg.ToiletArsgIn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends ToiletArsgIn {

	/** SOS状态。true：开；false：关； */
	private Boolean flag;

}
