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
function tabletype(){
	var div = document.getElementById("type");
	if(div.value == 253){
		document.getElementById('type1').style.display = 'block';
		document.getElementById('type2').style.display = 'none';
		document.getElementById('type3').style.display = 'none';
		document.getElementById('type4').style.display = 'none';
	}else if(div.value == 254){
		document.getElementById('type1').style.display = 'none';
		document.getElementById('type2').style.display = 'block';
		document.getElementById('type3').style.display = 'none';
		document.getElementById('type4').style.display = 'none';
	}else if(div.value == 252){
		document.getElementById('type1').style.display = 'none';
		document.getElementById('type2').style.display = 'none';
		document.getElementById('type3').style.display = 'block';
		document.getElementById('type4').style.display = 'none';
	}else if(div.value == 251){
		document.getElementById('type1').style.display = 'none';
		document.getElementById('type2').style.display = 'none';
		document.getElementById('type3').style.display = 'none';
		document.getElementById('type4').style.display = 'block';
	}
	
}
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