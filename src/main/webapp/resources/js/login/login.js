$(function(){
	// 清空文本框
	$("body > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > img").bind("click",function(){
		$("body > div:nth-child(2) > ul > li:nth-child(2) > input").val("");
	});
	// 显示隐藏密码
	$("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > img").bind("click",function(){
		if($.param.num==0){
			$.param.num=1;
			$("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > img").attr("src","resources/images/pwdHide.png");
			$("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > input").attr("type","text");
		}else{
			$.param.num=0;
			$("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(3) > img").attr("src","resources/images/pwdLook.png");
			$("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > input").attr("type","password");
		}
	});

	// 登陆按钮跳转
	$("body > div:nth-child(3) > ul > li > input").bind("click",function(){
		if($.validate.phone()&& $.validate.pwd()){
			window.location.href="client/version";
		}
	});
});