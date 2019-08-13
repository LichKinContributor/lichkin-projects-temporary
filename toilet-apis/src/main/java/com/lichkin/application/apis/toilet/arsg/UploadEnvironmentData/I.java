package com.lichkin.application.apis.toilet.arsg.UploadEnvironmentData;

import com.lichkin.application.apis.toilet.arsg.ToiletArsgIn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends ToiletArsgIn {

	/** 温度 */
	private String temperature;

	/** 湿度 */
	private String humidity;

	/** PM2.5 */
	private String pm25;

	/** 硫化氢 */
	private String hydrothion;

	/** 氨气 */
	private String ammonia;

	/** 故障状态。转换成二进制，从左到右，分别对应前面5个状态，1:故障;0:无故障; */
	private String state;

}
