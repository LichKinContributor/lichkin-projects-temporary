package com.lichkin.application.apis.toilet.arsg.UploadSquattingTimeout;

import com.lichkin.application.apis.toilet.arsg.ToiletArsgIn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends ToiletArsgIn {

	/** 超时分钟数 */
	private Integer timeoutMinutes;

}
