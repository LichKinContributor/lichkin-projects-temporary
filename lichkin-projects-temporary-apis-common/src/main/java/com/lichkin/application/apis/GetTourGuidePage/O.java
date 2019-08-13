package com.lichkin.application.apis.GetTourGuidePage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class O {

	private String id;

	private String photo;

	private String userName;

	private String cellphone;

	private String gender;

	private String genderDictCode;// for gender

	private Short totalTourCount;

	private Byte todayTourCount;

	private Byte level;

}
