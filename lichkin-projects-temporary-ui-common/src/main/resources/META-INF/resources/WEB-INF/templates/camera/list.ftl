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
	<#if section="javascript-contents-after-links">
var $content = $('#content');
LK.initTitle(serverDatas.moduleName, {}, true);

LK.ajax({
  url : '/GetCameraList',
  success : function(responseDatas) {
    $(responseDatas).each(function() {
      this.linkUrlPrefix = '/camera';
      this.linkUrl = '/view';
      this.imgUrl = this.photo != null ? this.photo : serverDatas.sourceImg;
      this.param = {
        moduleName : serverDatas.moduleName,
        locationCode : this.locationCodeDictCode,
        locationName : this.locationCode,
        onlineUrl : this.onlineUrl
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
