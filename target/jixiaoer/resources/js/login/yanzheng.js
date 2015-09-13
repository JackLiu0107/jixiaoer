$.extend({
	"param":{
		message:function(msg){return $("body > div:nth-child(1) > ul > li").html(msg);},
		num:0,
		phone:function(){return $("body > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > input").val()},
		pwd:function(){return $("body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > input").val()},
		v_pwd:function(){return $("body > div:nth-child(2) > ul:nth-child(3) > li:nth-child(2) > input").val()},
		kaptcha:function(){return $("#kaptcha").val()},
		code:function(){return $("#code").val()}
	},
	"validate":{
		phone : function(){
			if($.param.phone().length>0){
			   var myreg = /^1[3|4|5|8][0-9]\d{4,8}$/; 
		       if(myreg.test($.param.phone())){ 
		    	   $.param.message("");
		           return true; 
		       }else{
		    	   $.param.message("手机号码格式错误！");
		    	   return false;
		       } 
			}else{
				$.param.message("手机号不能为空！");
				return false;
			}
		},
		pwd : function(){
			if($.param.pwd().length>0){
			   var reg = $.param.pwd().length<6 || $.param.pwd().length>=20 ? false : true;
		       if(reg){ 
		    	   $.param.message("");
		           return true; 
		       }else{
		    	   $.param.message("密码长度在6~20位之间！");
		    	   return false;
		       } 
			}else{
				$.param.message("密码不能为空！");
				return false;
			}
		},
		v_pwd:function(){
			if($.param.v_pwd().length>0){
			   var reg = $.param.v_pwd()==$.param.pwd() ? true:false;
		       if(reg){ 
		    	   $.param.message("");
		           return true; 
		       }else{
		    	   $.param.message("确定密码错误！");
		    	   return false;
		       } 
			}else{
				$.param.message("确定密码不能为空！");
				return false;
			}
		},
		kaptcha:function(){
			if($.param.kaptcha().length>0){
				var code = false;
				$.ajax({  
					async:false,
				    url:'photo/code',// 跳转到 action    
				    data:"",    
				    type:'post',    
				    cache:false,    
				    dataType:'json',    
				    success:function(data) {   
				        if($.param.kaptcha()!=data){
				        	$.param.message("验证码错误！");
				        }else{
				        	code = true;
				        }
				     }  
				});
				return code;
			}else{
				$.param.message("验证码不能为空！");
				return false;
			}
		}
	}
});