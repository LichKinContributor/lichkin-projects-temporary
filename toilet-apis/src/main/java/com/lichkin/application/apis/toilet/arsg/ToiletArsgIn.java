package com.lichkin.application.apis.toilet.arsg;

import com.lichkin.framework.beans.impl.LKRequestBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToiletArsgIn extends LKRequestBean {

	/** 厕所唯一识别码 */
	private String toiletKey;

	/** 厕所类型：1：男；2：女；3：残疾人专用；4：第三；5：哺乳室。 */
	private Integer type;

	/** 设备类型。UploadEnvironmentData无此值 */
	private String equipmentType;

	/** 设备唯一识别码 */
	private String sid;

}
