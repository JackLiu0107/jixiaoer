$(function(){
	$("body > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > img").bind("click",function(){
		$("body > div:nth-child(2) > ul > li:nth-child(2) > input").val("");
	});
	
	// 更换验证码
	$('#kaptchaImage').click(function (){
        $(this).hide().attr('src', 'photo/captcha-image?' + Math.floor(Math.random()*100)).fadeIn(); 
    })   
	
	// 按钮跳转
	$("body > div:nth-child(4) > ul > li > input").bind("click",function(){
		if($.validate.phone() && $.validate.kaptcha()){
			window.location.href="client/validate?phone="+$.param.phone()+"&kaptcha="+$.param.kaptcha();
		}
	});
	
});