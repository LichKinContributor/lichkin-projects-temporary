package com.lichkin.application.controllers.pages.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.springframework.controllers.LKPagesController;
import com.lichkin.springframework.web.LKSession;
import com.lichkin.springframework.web.beans.LKPage;

@Controller
@RequestMapping("/admin")
public class AdminTemporaryPagesController extends LKPagesController {

	@GetMapping("/temporary/{module}/index" + MAPPING)
	public LKPage linkTo(@PathVariable String module) {
		if (!LKSession.checkMenuAuth(request, "/index")) {
			throw new LKRuntimeException(LKErrorCodesEnum.NOT_FOUND);
		}
		switch (module) {
			default:
				return new LKPage(LKPage.BLANK);
		}
	}


	@PostMapping("/temporary/{module}/index" + MAPPING)
	public LKPage jumpTo(@PathVariable String module) {
		return linkTo(module);
	}

}
