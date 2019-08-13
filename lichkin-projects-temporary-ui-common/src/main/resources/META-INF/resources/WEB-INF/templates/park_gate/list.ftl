<#include "/macro/html-lichkin-simple.ftl"/>

<@html js=false;section>
	<#if section="body-content">
    	<div class="title-back"><img src="${ctx}/res/img/back.png" /></div>
		<div class="title">
			<div class="title-text"></div>
		</div>
        <div class="content" id="content">
        </div>
	</#if>
	<#if section="javascript-contents-before-self-link">
var $content = $('#content');
LK.initTitle(serverDatas.moduleName, {}, true);

LK.ajax({
  url : '/GetParkGateList',
  success : function(responseDatas) {
    $(responseDatas).each(function() {
      this.linkUrlPrefix = serverDatas.module;
      this.linkUrl = '/index';
      this.imgUrl = this.photo != null ? this.photo : serverDatas.sourceImg;
      this.param = {
        moduleName : serverDatas.moduleName,
        id : this.id,
        locationCode : this.locationCodeDictCode,
        locationName : this.locationCode
      };
    });

    LK.createItems($content, responseDatas, true, {
      title : 'locationCode'
    });

	<#if fromBack!="true">
    if (responseDatas.length == 1) {
      $('.list-item').trigger('click');
    }
	</#if>
  }
});
	</#if>
</@html>
