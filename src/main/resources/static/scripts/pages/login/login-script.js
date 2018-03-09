(
	function() {
	  var darkGrey, emailVerify, orange, emerald, forget, lightGrey, login, passwordSecure, red, signup, submit, toForget, toLogin, pswSec,toSignup, yellow, form, validate;

	  form = $(".form-class");
	  login = $(".login");
	  signup = $(".sign-up");
	  forget = $(".forget");
	  submit = $('.button');
	  validate = $('.validator');
	  pswSec = $('.security');

	  emerald = "#19CC8B";
	  red = "#BC3E48";
	  yellow = "#B8B136";
	  lightGrey = "#515866";
	  darkGrey = "#2A2D33";
	  orange = "#FFA500";

	  
	  function toLogin() {
		pswSec.addClass("hide");
	    $(".retype").addClass("ani-hide");
	    
	    login.addClass("selected");
	    
	    hideValidMsg();

	    signup.removeClass("selected");
	    forget.show();
	    
	    return;
	  };
	  
	  
	  function toSignup() {
		  
		    $(".retype").removeClass("ani-hide");
		    
		    hideValidMsg();
		    
		    signup.addClass("selected");
		    login.removeClass("selected");
		    
		    forget.hide();
		     
		    login.html("Login");
		    
		    return signup.html("Sign Up");
		  };
	  
	  function submitForm(){
		  if(validate.hasClass("display") || ( $('#usr').is(':empty') || $('#psw1').is(':empty')) ){ 
			   showValidMsg("invalid email or password");
			   return;
			  }
		  else{ hideValidMsg(); }
		  
		  if(login.hasClass('selected')){ form.attr('action','/login/login'); }
		  if(signup.hasClass('selected')){ form.attr('action', '/login/register'); }
		  
		  return form.submit();
	  };
	  

	  function toForget() {
	    $(".full-name, .full-name div, .retype, .retype div, .password, .password div .forget").addClass("ani-hide");
	   
	    signup.removeClass("selected");
	    login.addClass("selected");
	    emailVerify();
	    forget.hide();
	    login.html("Reset Password");
	    
	    return signup.html("Back");
	  };

	  
	  function hideValidMsg(){
		  if( !validate.hasClass('hide') ){
			  validate.addClass("hide");
		  }
		  return;
	  };
	  
	  
	  function showValidMsg(message){
		  if( validate.hasClass('hide') ){
			  validate.removeClass("hide");
		  }
		  validate.text(message);
		  return;
	  };
	  
	  emailVerify = $('#usr').change(function() {
		  
	    var usr = $('#usr');
	    
	    if( !(usr.val().endsWith(".com") && usr.val().includes("@")) ){ showValidMsg('* email invalid *'); }
	    else if( !validate.hasClass('hide') ){ hideValidMsg(); }
	   
	    return;
	  });

	  
	  passwordSecure = $('#psw1').change(function() {	

	    			var backFill, color, pie1, pieColor, secureVal, input, value, specChar, numChar, alphaChar;
	    			
	    				input =$(".password .content");
	    				value = input.val();
	    				specChar = (/^[a-zA-Z0-9- ]*$/);
	    				numChar = (/\d/);
	    				alphaChar = (/[a-zA-Z]/);
	    				
		    			hideValidMsg();
		    			
		    			if ( !(value.length > 0) ) { pswSec.addClass("hide"); } else { pswSec.removeClass("hide"); }
	    				
	    			if (value.length > 0) { color = red; backFill = red;	}
	    			if ( value.length >= 5 && alphaChar.test(value) && !(alphaChar.test(value) && numChar.test(value)) && specChar.test(value) ) { color = orange; backFill = orange; } 
	    		    if ( value.length >= 6 && ((alphaChar.test(value) && numChar.test(value)) || !specChar.test(value)) ) { color = yellow; backFill = yellow; } 
	    		    if ( value.length >= 8 && alphaChar.test(value) && numChar.test(value) && !specChar.test(value) ) { color = emerald; backFill = emerald; }
	    			    			
	    			secureVal = value.length * 9;
	    			if (secureVal >= 100) { secureVal = 100; }
	    			
	    			if (value.length <= 5) {
	    				pie1 = (value.length * 36) + 90;
	    				pieColor = lightGrey;
	    				
	    			} else if (value.length >= 5 && value.length <= 9) {
	    				pieColor = color;
	    				pie1 = (value.length * 36) - 90;
	    				
	    			} else {
	    				secureVal = 90;
	    				pie1 = 270;
	    			}
	    				    			
	    			$(".secureValue").html(secureVal);
	    			$(".password .content, .password .security-type").css("color", `${color}`);
	    			$(".circle.background").css("background", `${backFill}`);
	    			$(".password .fill").css({
	    				background: `linear-gradient(${pie1}deg, transparent 50%, ${pieColor} 100%), linear-gradient(90deg, ${lightGrey} 50%, transparent 50%)`
	    			});
	    			
	    			login.click(function() {
	    				$(".password .content").css("color", "#fff");
	    				return;
	    			});
	    			
	    		return;
	  });
	  
	  
	  login.click(function() {
	    if (!login.hasClass("selected")) { return toLogin(); }
	    return;
	  });

	  
	  signup.click(function() {
		if($(".password").hasClass("ani-hide")) { return toLogin(); } 
	    if (!signup.hasClass("selected")) { return toSignup(); }
	    return;
	  });
	  

	  submit.click(function() {
		  var psw1 = $('#psw1');
		  var psw2 = $('#psw2');
		  
		  if(signup.hasClass('selected') && psw1.val() != psw2.val()){
			  psw1.val('');
			  psw2.val('');
			  
			  $(".se	curity").addClass("hide");
			  
			  showValidMsg('* password mismatch *');
			  pswSec.addClass("hide");
			  return;
			  
		  }else{ validate.removeClass('display');  validate.addClass('hide'); }
		  
	      $(".text-wrapper").removeClass("show");
	      $(".load-gif").addClass("show");
	      
	      return setTimeout((function() {
	        
	    	  	submitForm();
	        
	        $(".text-wrapper").addClass("show");
	        
	        return $(".load-gif").removeClass("show");
	        
	      }), 1500);
	      
	  });

	  forget.click(function() {
	    return toForget();
	  });
	 
	}

).call(this);

