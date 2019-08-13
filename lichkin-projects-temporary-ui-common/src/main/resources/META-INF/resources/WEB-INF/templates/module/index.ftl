<#include "/macro/html-lichkin-simple.ftl"/>

<@html js=false i18nJs=serverDatas.firstLink;section>
	<#if section="body-content">
		<#if serverDatas.firstLink>
    	<div class="title-close"><img src="${ctx}/res/img/close.png" /></div>
    	<#else>
    	<div class="title-back"><img src="${ctx}/res/img/back.png" /></div>
		</#if>
		<div class="title">
			<div class="title-text"></div>
		</div>
        <div class="content" id="content">
        </div>
	</#if>
	<#if section="javascript-contents-before-self-link">
var $content = $('#content');
<#if serverDatas.firstLink>
LK.initTitle(serverDatas.module);
<#else>
LK.initTitle([serverDatas.moduleName, ' -> ', serverDatas.sourceName], {}, true);
</#if>

LK.ajax({
  url : '/GetModuleList',
  data : {
    moduleType : serverDatas.module
  },
  success : function(responseDatas) {
    var $bar = null;
    $(responseDatas).each(function(idx) {
      if (idx % 3 == 0) {
        $bar = $('<div class="button-item-bar"></div>').appendTo($content);
      }
      this.icon = this.icon != null ? this.icon : (serverDatas.sourceImg != null ? serverDatas.sourceImg : 'b-blank.png');
      var $div = $('<div class="button-item"><div class="button-item-img"><img src="' + LK.resolveImgSrc(this.icon, _IMG + '/icons/') + '"></img></div><div class="button-item-text">' + this.moduleName + '</div></div>').appendTo($bar);
      (function(data) {
        $div.click(function() {
          LK.Go(data.url, {
            moduleName : data.moduleName,
            sourceImg : data.icon,
            locationCode : serverDatas.locationCode,
            locationName : serverDatas.sourceName + ' -> ' + data.moduleName
          });
        })
      })(this);
    });

	<#if fromBack!="true"&&!serverDatas.firstLink>
    if (responseDatas.length == 1) {
      $('.list-item').trigger('click');
    }
	</#if>
  }
});
	</#if>
</@html>
