$(function(){
	$("body > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > img").bind("click",function(){
		$("body > div:nth-child(2) > ul > li:nth-child(2) > input").val("");
	});
	
	// 重新发送
	$("#resive").bind("click", function(){
		$.ajax({  
		    url:'client/resive',// 跳转到 action    
		    data:"phone="+$("#phone").html()+"&kaptcha="+$("#kaptcha").val(),    
		    type:'post',    
		    cache:false,    
		    dataType:'json',    
		    success:function(data) {   
		    	$("#code").val(data);
		    }  
		});
	});
	// 按钮跳转
	$("body > div:nth-child(4) > ul > li > input").bind("click",function(){
		
		var code = $.param.code();
		var i_code = $("#i_code").val();
		if(code==i_code){
			window.location.href="client/message?phone="+$("#phone").val();
		}else{
			$("#vil").html("验证码输入错误！");
			return false;
		}
	});
});