function mediumtype(){
	var div = document.getElementById("type");
	if(div.value == 1){
		document.getElementById('type1').style.display = 'block';
		document.getElementById('type2').style.display = 'none';
		document.getElementById('type3').style.display = 'none';
		document.getElementById('type4').style.display = 'none';
	}else if(div.value == 2){
		document.getElementById('type1').style.display = 'none';
		document.getElementById('type2').style.display = 'block';
		document.getElementById('type3').style.display = 'none';
		document.getElementById('type4').style.display = 'none';
	}else if(div.value == 3){
		document.getElementById('type1').style.display = 'none';
		document.getElementById('type2').style.display = 'none';
		document.getElementById('type3').style.display = 'block';
		document.getElementById('type4').style.display = 'none';
	}else if(div.value == 4){
		document.getElementById('type1').style.display = 'none';
		document.getElementById('type2').style.display = 'none';
		document.getElementById('type3').style.display = 'none';
		document.getElementById('type4').style.display = 'block';
	}
	
}


function analogFMtype(){
	var div = document.getElementById("type");
	var type0=document.getElementById('type0');
	var type1=document.getElementById('type1');
	var type2=document.getElementById('type2');
	var type3=document.getElementById('type3');
	var type4=document.getElementById('type4');
	var type5=document.getElementById('type5');
	var type6=document.getElementById('type6');
	var type7=document.getElementById('type7');
	var type8=document.getElementById('type8');
	var type11=document.getElementById('type11');
	var type12=document.getElementById('type12');
	var type13=document.getElementById('type13');
	var type14=document.getElementById('type14');
	var type15=document.getElementById('type15');
	var type21=document.getElementById('type21');
	var type22=document.getElementById('type22');
	var type23=document.getElementById('type23');
	var type24=document.getElementById('type24');
	
	var arr =[type0,type1,type2,type3,type4,type5,type6,type7,type8,type11,type12,type13,type14,type15,type21,type22,type23,type24];
	for(var i=0;i<arr.length;i++){
		arr[i].style.display = 'none';
//		arr[i].style.display = 'block';
	}
	document.getElementById("type"+div.value).style.display = 'block';
}
function numbers(){
	var div = document.getElementById("areas");
	var code = document.getElementById("code");
	
	var text = "";
	for(var i=0;i<div.value;i++){
		text += '<div>目标区域编码'+(i+1)+'：<input type="text" class="a"  name="code" /><br/><br/></div>';
	}
	code.innerHTML=text;
}
function NumberOfParameter(){
	var div =document.getElementById("NumberOfParameters");
	var ParameterIdentification = document.getElementById("ParameterIdentification");
	
	var text = "";
	for(var i=0;i<div.value;i++){
		text += '参数标识'+(i+1)+'：'
    		+'<select name="ParameterIdentification" class="a">'
				+'<option value="1">终端音量</option>'
				+'<option value="2">本地地址</option>'
				+'<option value="3">回传地址</option>'
				+'<option value="4">终端资源编码</option>'
				+'<option value="5">物理地址编码</option>'
				+'<option value="6">工作状态</option>'
				+'<option value="7">故障代码</option>'
				+'<option value="8">设备类型</option>'
				+'<option value="9">硬件版本号</option>'
				+'<option value="10">软件版本号</option>'
				+'</select><br/><br/>';
	}
	ParameterIdentification.innerHTML=text;
}


//cable.jsp

function details(){
	var details_channel_indicate=document.getElementById("details_channel_indicate");
	if(details_channel_indicate.value == 1){
		document.getElementById("details_channel").style.display = "block";
	}else{
		document.getElementById("details_channel").style.display = "none";
	}
}
function MPEG(){
	var MPEG_1_only_flag = document.getElementById("MPEG_1_only_flag");
	if(MPEG_1_only_flag.value == 0){
		document.getElementById("MPEG_1").style.display = "block";
	}else{
		document.getElementById("MPEG_1").style.display = "none";
	}
}
function transferred(){
	var Transferred = document.getElementById("Transferred");
	if(Transferred.value == 0){
		document.getElementById("Transferred0").style.display="block";
		document.getElementById("Transferred1").style.display="none";
	}else{
		document.getElementById("Transferred1").style.display="block";
		document.getElementById("Transferred0").style.display="none";
	}
}
function alignmenttype(){
	var alignment_type = document.getElementById("alignment_type");
	if(alignment_type.value == 0){
		document.getElementById("alignment0").style.display="block";
		document.getElementById("alignment1").style.display="none";
	}else{
		document.getElementById("alignment1").style.display="block";
		document.getElementById("alignment0").style.display="none";
	}
}
function externalclock(){
	var bound_valid_flag=document.getElementById("bound_valid_flag");
	if(bound_valid_flag.value == 0){
		document.getElementById("external_clock_reference").style.display="none";
	}else{
		document.getElementById("external_clock_reference").style.display="block";
	}
}
function MPEG2(){
	var MPEG_1_only_flag2 = document.getElementById("MPEG_1_only_flag2");
	if(MPEG_1_only_flag2.value == 0){
		document.getElementById("MPEG_12").style.display = "block";
	}else{
		document.getElementById("MPEG_12").style.display = "none";
	}
}
function transferred2(){
	var Transferred2 = document.getElementById("Transferred2");
	if(Transferred2.value == 0){
		document.getElementById("Transferred02").style.display="block";
		document.getElementById("Transferred12").style.display="none";
	}else{
		document.getElementById("Transferred12").style.display="block";
		document.getElementById("Transferred02").style.display="none";
	}
}
function alignmenttype2(){
	var alignment_type2 = document.getElementById("alignment_type2");
	if(alignment_type2.value == 0){
		document.getElementById("alignment02").style.display="block";
		document.getElementById("alignment12").style.display="none";
	}else{
		document.getElementById("alignment12").style.display="block";
		document.getElementById("alignment02").style.display="none";
	}
}
function externalclock2(){
	var bound_valid_flag2=document.getElementById("bound_valid_flag2");
	if(bound_valid_flag2.value == 0){
		document.getElementById("external_clock_reference2").style.display="none";
	}else{
		document.getElementById("external_clock_reference2").style.display="block";
	}
}

//cable254
function EBMFun(id){
	var EBM_id = document.getElementById('multilingual_content_number');
	var multilingual_content = document.getElementById('multilingual_content');  
  	var text = "";
  	for(var i=0;i<EBM_id.value;i++){
  		text += '语种代码：'
  			+'<input type="text" class="a"  name="language_code" /><br/><br/>'
  			+'编码字符集：'
  			+'<select  name="code_character_set" class="a">'
  			+'<option value="0">GB/T 2312-1980</option>'
  			+'<option value="1">GB/T 18030-2005</option>'
  			+'<option value="2">GB/T 13000-2010</option>'
  			+'<option value="3">GB/T 21669-2008</option>'
  			+'<option value="4">GB/T 16959-1997</option>'
  			+'</select><br/><br/>'
  			+'文本内容：'
  			+'<textarea rows="5" cols="40" name="message_text"></textarea><br/><br/>'
  			+'消息发布机构名称：'
  			+'<input type="text" class="a"  name="agency_name" /><br/><br/>'
  			
	    	
  			+'<div id="auxiliary">'
  			+'辅助数据数量：'
  			+'<input type="text" class="a"  name="auxiliary_data_number" id="auxiliary_data_number" oninput="auxiliaryFun(this)"/><br/><br/>'
  			+'辅助数据类型：'
  			+'<select name="auxiliary_data_type" class="a">'
  			+'	<option value="1">MPEG-1 LayerI/II 音频文件</option>'
  			+'	<option value="2">MPEG-1 LayerIII 音频文件</option>'
  			+'	<option value="3">DRA 音频文件</option>'
  			+'	<option value="4">DRA+音频文件</option>'
  			+'	<option value="41">PNG 图片文件</option>'
  			+'	<option value="42">JPEG 图片文件</option>'
  			+'	<option value="43">GIF 图片文件</option>'
  			+'	<option value="61">音视频流</option>'
  			+'</select><br/><br/>'
  			+'辅助数据：'
  			+'<input type="text" class="a"  name="auxiliary_data" /><br/><br/><br/><br/>'
  			+'</div>';
  	} 
  	multilingual_content.innerHTML=text;
  	multilingual_content.parentElement;
}
function auxiliaryFun(id){
	var text='辅助数据数量：'
	+'<input type="text" class="a"  value="'+id.value+'" name="auxiliary_data_number" id="auxiliary_data_number" oninput="auxiliaryFun(this)"/><br/><br/>';
	for(var i=0;i<id.value;i++){
		text += '辅助数据类型：'
			+'<select name="auxiliary_data_type" class="a">'
			+'	<option value="1">MPEG-1 LayerI/II 音频文件</option>'
			+'	<option value="2">MPEG-1 LayerIII 音频文件</option>'
			+'	<option value="3">DRA 音频文件</option>'
			+'	<option value="4">DRA+音频文件</option>'
			+'	<option value="41">PNG 图片文件</option>'
			+'	<option value="42">JPEG 图片文件</option>'
			+'	<option value="43">GIF 图片文件</option>'
			+'	<option value="61">音视频流</option>'
			+'</select><br/><br/>'
			+'辅助数据：'
			+'<input type="text" class="a"  name="auxiliary_data" /><br/><br/><br/><br/>';
		
	}
	id.parentElement.innerHTML=text;
}
//cable252.jsp
function CertAuthFun(id){
	var text = '';
	for(var i=0;i<id.value;i++){
		text += '证书授权列表数据：'
			+'<textarea rows="5" cols="40" name="CertAuth_data"></textarea><br/><br/>';
	}
	document.getElementById("CertAuth").innerHTML=text;
}
function certFun(id){
	var text = '';
	for(var i=0;i<id.value;i++){
		text += '证书数据：'
			+'<textarea rows="5" cols="40" name="cert_data"></textarea><br/><br/>';
	}
	document.getElementById("cert").innerHTML=text;
}