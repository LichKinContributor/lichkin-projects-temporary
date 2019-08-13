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
  url : '/GetToiletList',
  success : function(responseDatas) {
    $(responseDatas).each(function() {
      this.imgUrl = this.photo != null ? this.photo : serverDatas.sourceImg;
      switch (serverDatas.directGo) {
        case 'environment': {
          this.linkUrlPrefix = '/environment';
          this.linkUrl = '/view';
          this.param = {
            moduleName : serverDatas.moduleName,
            locationCode : this.locationCodeDictCode,
            locationName : this.locationCode
          };
        }
        break;
        default: {
          this.linkUrlPrefix = serverDatas.module;
          this.linkUrl = '/index';
          this.param = {
            moduleName : serverDatas.moduleName,
            sourceId : this.id,
            sourceImg : serverDatas.sourceImg,
            locationCode : this.locationCodeDictCode,
            sourceName : this.locationCode
          };
        }
        break;
      }
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
