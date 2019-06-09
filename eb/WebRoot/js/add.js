/**
 * 
 */
function $(str){
	return (document.getElementById(str));
}

function check_submit(){
//	if($("EBIVersion").value ==""){
//		alert("请填写协议版本号!");
//		return false;
//	}
//	if($("InfoID").value == ""){
//		alert("请填写应急广播信息ID!");
//		return false;
//	}
	if($("EventType").value == ""){
		alert("请填写应急事件类型!");
		return false;
	}
	if($("EventLevel").value == ""){
		alert("请填写应急事件级别!");
		return false;
	}
	if($("InfoType").value == ""){
		alert("请填写应急广播信息类型!");
		return false;
	}
	if($("InfoStatus").value == ""){
		alert("请填写应急广播信息状态!");
		return false;
	}
	if($("IsMediaRes").value == ""){
		alert("请填写信息发布类型!");
		return false;
	}
//	if($("IsTTS").value == ""){
//		alert("请填写音频文件标志位!");
//		return false;
//	}
//	if($("Language").value == ""){
//		alert("请填写语言!");
//		return false;
//	}
//	if($("LanguageCode").value == ""){
//		alert("请填写语种代码!");
//		return false;
//	}
//	if($("CodeSet").value == ""){
//		alert("请填写编码字符集!");
//		return false;
//	}
	if($("Headline").value == ""){
		alert("请填写应急广播信息标题!");
		return false;
	}
	if($("EventDescription").value == ""){
		alert("请填写应急广播信息描述!");
		return false;
	}
	if($("PublishRegion").value == ""){
		alert("请填写发布范围!");
		return false;
	}
	if($("BroadcastDateTime").value == ""){
		alert("请填写播发开始时间!");
		return false;
	}
	if($("PublishMeans").value == ""){
		alert("请填写发布手段!");
		return false;
	}
	if($("Presentation").value == ""){
		alert("请填写呈现方式!");
		return false;
	}
	if($("PublishFrequency").value == ""){
		alert("请填写发布频次!");
		return false;
	}
	if($("RollFrequency").value == ""){
		alert("请填写频率内次数!");
		return false;
	}
	if($("attfile").value == ""){
		alert("请添加附件!");
		return false;
	}
	
}
function myFunction(){
	alert("111");
	
}

//添加资源附件
function addAtt(){
//	alert("addAtt");
	var div = document.getElementById("attDiv");
	var attstr='<div><div class="first">附件信息：</div><br/>1资源附件: <input type="file" name="attfile" class="a"><br/><br/>2 附件描述：<input type="text" class="a" name="AttDescription" /><br/><br/>3 附件类型：<select name="AttType" class="a"><option value="01">视频</option><option value="02">音频</option><option value="03">数字图像</option><option value="04">文档</option><option value="04">预留</option></select><br/><br/>4 附件摘要编码：<input type="text" class="a" name="Digest" /><br/><br/><input type="button" class="att button button-primary button-rounded button-small" value="删除附件" onclick="deleteAtt(this)"/><br/><br/><br/></div>'
	div.innerHTML +=attstr;
}
//删除资源附件
function deleteAtt(input){
	var div = document.getElementById("attDiv");
	div.removeChild(input.parentNode);
}

//添加地震类扩展信息
function addEarth(){
//	alert("addEarth");
	var div = document.getElementById("earthDiv");
	var earthstr='<div><input type="hidden" name="earth" value="1" /><div class="first"> 地震类扩展信息：</div><br/>1 震中所在行政区划编码：<input type="text" class="a" name="location_code" /><br/><br/>2 震中所在行政区划：<input type="text" class="a" name="place" /><br/><br/>3 地震发生时间：<input type="text" class="a" name="earthquake_time" /><br/><br/>4 地震震级：<input type="text" class="a" name="level" /><br/><br/>5 震源深度（公里）：<input type="text" class="a" name="depth" /><br/><br/>6 地震震中经度：<input type="text" class="a" name="longitude" /><br/><br/>7 地震震中纬度：<input type="text" class="a" name="latitude" /><br/><br/>8 地震类型：<select name="eq_type" class="a"><option value="自然地震">自然地震</option><option value="人工地震">人工地震</option></select><br/><br/>9 地震信息类型：<select name="expedited_reporting_type" class="a"><option value="自然速报">自然速报</option><option value="正式速报">正式速报</option><option value="其他">其他</option></select><br/><br/>10 距离震中最近的省会城市的信息：<input type="text" class="a" name="nearest_provincial_capital" /><br/><br/>11 省会列表：<input type="text" class="a" name="shenghui" /><br/><br/>12 距离震中最近的地级市的信息：<input type="text" class="a" name="nearest_prefecture" /><br/><br/>13 地级市列表：<input type="text" class="a" name="dijishi" /><br/><br/>14 距离震中最近的县级市的信息：<input type="text" class="a" name="nearest_county" /><br/><br/>15 县级市列表：<input type="text" class="a" name="xianjishi" /><br/><br/>16 震中附近的村庄：<input type="text" class="a" name="nearest_village" /><br/><br/>17 村庄列表：<input type="text" class="a" name="villages" /><br/><br/>18 震中附近的乡镇：<input type="text" class="a" name="nearest_town" /><br/><br/>19 乡镇列表：<input type="text" class="a" name="towns" /><br/><br/>20 距离：<input type="text" class="a" name="juli" /><br/><br/>21 震中方圆范围：<input type="text" class="a" name="range" /><br/><br/>22 地震信息综合描述：<input type="text" class="a" name="Seismic_information" /><br/><br/>23 天气：<input type="text" class="a" name="WEATHER" /><br/><br/>24 海拔（米）：<input type="text" class="a" name="altitude" /><br/><br/>25 人口（万人）：<input type="text" class="a" name="population" /><br/><br/>26 面积（平方公里）：<input type="text" class="a" name="area" /><br/><br/>27 人均GDP（万元）：<input type="text" class="a" name="gdp" /><br/><br/>28 最近五次地震信息：<input type="text" class="a" name="five_earthquake" /><br/><br/><input type="button" class="a button button-primary button-rounded button-small" value="删除地震类扩展信息" onclick="deleteEarth(this)"/><br/><br/><br/><br/></div>'
	div.innerHTML =earthstr;
}
//删除地震类扩展信息
function deleteEarth(input){
//	alert("deleteEarth");
	var div = document.getElementById("earthDiv");
	div.removeChild(input.parentNode);
	div.innerHTML = '<input type="hidden" name="earth" value="0" /><input type="button" class="a button button-primary button-rounded button-small" value="添加地震类扩展信息" onclick="addEarth()"/><br/><br/><br/>';
}

//添加民航机场类扩展信息
function addAir(){
//	alert("addAir");
	var div = document.getElementById("airDiv");
	var airstr= '<div><input type="hidden" name="air" value="1" /><div class="first"> 民航机场类扩展信息：</div><br/>1 民航机场名称：<input type="text" class="a" name="Airport" /><br/><br/>2 民航机场代码：<input type="text" class="a" name="Airportcode" /><br/><br/>3 入港航班架次：<input type="text" class="a" name="Inbound_flights" /><br/><br/>4 出港航班架次：<input type="text" class="a" name="Outbound_flights" /><br/><br/>5 入港旅客人数：<input type="text" class="a" name="Inbound_numberofpeople" /><br/><br/>6 出港旅客人数：<input type="text" class="a" name="Outbound_numberofpeople" /><br/><br/>7 入港延误航班架次：<input type="text" class="a" name="Inbound_Delayedflights" /><br/><br/>8 出港延误航班架次：<input type="text" class="a" name="Outbound_Delayedflights" /><br/><br/>9 民航机场状态：<select name="AirportStatus" class="a"><option value="1">流量正常</option><option value="2">大面积延误</option><option value="3">民航机场关闭</option><option value="4">民航机场（重新）开放</option></select><br/><br/>10 入港延误航班号：<input type="text" class="a" name="Inbound_flights_number" /><br/><br/>11 出港延误航班号：<input type="text" class="a" name="Outbound_flightsnumber" /><br/><br/>12 监测时间：<input type="text" class="a" name="Time" /><br/><br/><br/><br/><input type="button" class="a button button-primary button-rounded button-small" value="删除民航机场类扩展信息" onclick="deleteAir(this)"/><br/><br/><br/><br/></div>';
	div.innerHTML =airstr;
}
//删除民航机场类扩展信息
function deleteAir(input){
//	alert("deleteair");
	var div = document.getElementById("airDiv");
	div.removeChild(input.parentNode);
	div.innerHTML = '<input type="hidden" name="air" value="0" /><input type="button" class="a button button-primary button-rounded button-small" value="添加民航机场类扩展信息" onclick="addAir()"/><br/><br/><br/>';
}
function showebd(){
	document.getElementById('ebd').style.display = 'block';
	document.getElementById('ebdhref').innerHTML="收起应急广播业务数据";
	document.getElementById('ebdhref').href="javascript:hideebd()";
}
function hideebd(){
	document.getElementById('ebd').style.display = 'none';
	document.getElementById('ebdhref').innerHTML="展开应急广播业务数据";
	document.getElementById('ebdhref').href="javascript:showebd()";
}
function showebi(){
	document.getElementById('ebi').style.display = 'block';
	document.getElementById('ebihref').innerHTML="收起其他信息";
	document.getElementById('ebihref').href="javascript:hideebi()";
}
function hideebi(){
	document.getElementById('ebi').style.display = 'none';
	document.getElementById('ebihref').innerHTML="展开其他信息";
	document.getElementById('ebihref').href="javascript:showebi()";
}
