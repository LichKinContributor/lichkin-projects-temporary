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
LK.initTitle([serverDatas.moduleName, ' -> ', serverDatas.locationName], {}, true);

$('<iframe></iframe>').css({
  'width' : '100%',
  'height' : $body.height(),
  'border' : 'none'
}).attr('src', serverDatas.onlineUrl).appendTo($content);
	</#if>
</@html>
