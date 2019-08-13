package com.lichkin.application.controllers.pages.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lichkin.springframework.controllers.LKPagesController;
import com.lichkin.springframework.web.beans.LKPage;

@Controller
@RequestMapping("/")
public class TemporaryPagesController extends LKPagesController {

	@GetMapping("/{module}/index" + MAPPING)
	public LKPage linkToModuleMain(@PathVariable String module, String moduleName, String sourceId, String sourceImg, String locationCode, String sourceName) {
		LKPage mv = new LKPage("/module/index").setRealViewName(true);

		mv.putServerData("module", module);

		mv.putServerData("firstLink", (moduleName == null) && (sourceId == null) && (sourceImg == null) && (locationCode == null) && (sourceName == null));

		mv.putServerData("moduleName", moduleName);
		mv.putServerData("sourceId", sourceId);
		mv.putServerData("sourceImg", sourceImg);
		mv.putServerData("locationCode", locationCode);
		mv.putServerData("sourceName", sourceName);

		return mv;
	}


	@GetMapping(value = { "/{module}/list" + MAPPING, "/{module}/page" + MAPPING })
	public LKPage linkToModuleIndex(@PathVariable String module, String moduleName, String sourceImg, String directGo) {
		LKPage mv = new LKPage();

		mv.putServerData("module", module);
		mv.putServerData("moduleName", moduleName);
		mv.putServerData("sourceImg", sourceImg);

		mv.putServerData("directGo", StringUtils.trimToEmpty(directGo));

		return mv;
	}


	@GetMapping("/camera/view" + MAPPING)
	public LKPage linkToCameraMain(String moduleName, String locationName, String onlineUrl) {
		LKPage mv = new LKPage();

		mv.putServerData("moduleName", moduleName);
		mv.putServerData("locationName", locationName);
		mv.putServerData("onlineUrl", onlineUrl);

		return mv;
	}


	@GetMapping("/environment/view" + MAPPING)
	public LKPage linkToEnvironmentView(String moduleName, String locationCode, String locationName) {
		LKPage mv = new LKPage();

		mv.putServerData("moduleName", moduleName);
		mv.putServerData("locationCode", locationCode);
		mv.putServerData("locationName", locationName);

		return mv;
	}

}
