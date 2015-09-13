$(function(){
	var num = 0;
	$("body > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > img").bind("click",function(){
		$("body > div:nth-child(2) > ul > li:nth-child(2) > input").val("");
	});
	$("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > img").bind("click",function(){
		if(num==0){
			num=1;
			$("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > img").attr("src","resources/images/pwdHide.png");
			$("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > input").attr("type","text");
		}else{
			num=0;
			$("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > img").attr("src","resources/images/pwdLook.png");
			$("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > input").attr("type","password");		
		}
	});
	
	// 按钮跳转
	$("body > div:nth-child(3) > ul > li > input").bind("click",function(){
		if($.validate.phone()&& $.validate.pwd() && $.validate.v_pwd()){
			var u = navigator.userAgent, app = navigator.appVersion;
			var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //android终端或者uc浏览器
			var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
			var clientType = "";
			if(isAndroid) clientType = "android";
			else if(isiOS) clientType = "ios";
			else clientType = "pc";
			
			// 手机是否注册
//			$.ajax({  
//				async:false,
//			    url:'photo/findIsPhone',// 跳转到 action    
//			    data:"phone="+$("#phone").val(),    
//			    type:'post',    
//			    cache:false,    
//			    dataType:'json',    
//			    success:function(data) {   
//			        if(data){
//			        	$.param.message("验证码错误！");
//			        }else{
//			        	code = true;
//			        }
//			     }  
//			});
			
			var name = $("#name").val();
			window.location.href="client/version?phone="+$("#phone").val()+"&name="+name+"&password="+$.param.v_pwd()+"&clientType="+clientType;
		}
	});
});