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
  url : '/GetDictList',
  data : {
    categoryCode : 'ENVIRONMENT_LOCATIONS',
    allowEmptyResult : false
  },
  success : function(responseDatas) {
    $(responseDatas).each(function() {
      this.imgUrl = this.imgUrl != null ? this.imgUrl : serverDatas.sourceImg;
      switch (this.dictCode) {
        case 'TOILET': {
          this.linkUrlPrefix = '/toilet';
          this.linkUrl = '/list';
          this.param = {
            moduleName : serverDatas.moduleName + ' -> ' + this.dictName,
            sourceImg : this.imgUrl,
            directGo : 'environment'
          };
        }
        break;
        default: {
          this.linkUrlPrefix = '';
          this.linkUrl = '/environment/view';
          this.param = {
            moduleName : serverDatas.moduleName,
            locationCode : this.dictCode,
            locationName : this.dictName
          };
        }
        break;
      }
    });

    LK.createItems($content, responseDatas, true, {
      title : 'dictName'
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
