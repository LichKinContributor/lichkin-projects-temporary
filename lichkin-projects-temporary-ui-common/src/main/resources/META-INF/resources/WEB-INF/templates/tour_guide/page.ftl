<#include "/macro/html-lichkin-simple.ftl"/>

<@html js=false i18nJs=true;section>
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

LK.scrollDatas(null, '/GetTourGuidePage', {}, function(data) {
  var $item = $('<div class="gird-item"></div>').appendTo($content);
  $item.append('<div style="width:100%;text-align:center;"><img style="width:150px;height:150px;border-radius:150px;margin-bottom:10px;" src="data:image/jpeg;base64,' + data.photo + '" /></div><div style="clear:both;"></div>');
  $item.append('<div class="gird-item-key">' + $.LKGetI18N('userName:') + '</div><div class="gird-item-value">' + data.userName + '</div><div style="clear:both;"></div>');
  $item.append('<div class="gird-item-key">' + $.LKGetI18N('gender:') + '</div><div class="gird-item-value">' + data.gender + '</div><div style="clear:both;"></div>');
  $item.append('<div class="gird-item-key">' + $.LKGetI18N('cellphone:') + '</div><div class="gird-item-value"><a href="tel:' + data.cellphone + '">' + data.cellphone + '</a></div><div style="clear:both;"></div>');
  $item.append('<div class="gird-item-key">' + $.LKGetI18N('totalTourCount:') + '</div><div class="gird-item-value">' + data.totalTourCount + '</div><div style="clear:both;"></div>');
  $item.append('<div class="gird-item-key">' + $.LKGetI18N('todayTourCount:') + '</div><div class="gird-item-value">' + data.todayTourCount + '</div><div style="clear:both;"></div>');
  $item.append('<div class="gird-item-key">' + $.LKGetI18N('level:') + '</div><div class="gird-item-value">' + data.level + '</div><div style="clear:both;"></div>');
});
	</#if>
</@html>
