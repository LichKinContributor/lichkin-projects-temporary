<#include "/macro/html-lichkin-simple.ftl"/>

<@html js=false css=true;section>
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

var loadData = function(data, $dataValue, $remarks) {
  LK.ajax({
    url : '/GetEquipmentValue',
    data : {
      equipmentType : data.equipmentTypeDictCode,
      equipmentSid : data.equipmentSid
    },
    showLoading : false,
    success : function(responseDatas) {
      $dataValue.html(responseDatas.dataValue);
      $remarks.html(responseDatas.remarks);
    }
  });
};

LK.ajax({
  url : '/GetLocationEquipmentList',
  data : {
    locationCode : serverDatas.locationCode
  },
  success : function(responseDatas) {
    $(responseDatas).each(function(idx, data) {
      var $item = $('<div class="item"></div>').appendTo($('#content'));
      $item.append('<div class="equipmentType">' + data.equipmentType + '</div>');
      var $dataValue = $('<div class="equipmentDataValue"></div>').appendTo($item);
      var $remarks = $('<div class="equipmentRemarks"></div>').appendTo($item);
      loadData(data, $dataValue, $remarks);
      setInterval(function() {
        loadData(data, $dataValue, $remarks);
      }, 5000);
    });
  }
});
	</#if>
</@html>
