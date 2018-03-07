(function() {
	  var darkGrey, emailVerify, emerald, forget, lightGrey, login, passwordSecure, red, signup, submit, toForget, toLogin, toSignup, yellow, form, validate;

	  form = $(".form-class");
	  login = $(".login");
	  signup = $(".sign-up");
	  forget = $(".forget");
	  submit = $('.button');
	  validate = $('.validator');

	  emerald = "#19CC8B";
	  red = "#BC3E48";
	  yellow = "#B8B136";
	  lightGrey = "#515866";
	  darkGrey = "#2A2D33";

	  
	  toLogin = function() {
	    $(".security").addClass("hide");
	    $(".full-name, .retype").addClass("ani-hide");
	    $(".password, .password div").removeClass("ani-hide");
	    
	    login.addClass("selected");
	    
	    validate.removeClass("display");
	    validate.addClass("hide");

	    signup.removeClass("selected");
	    emailVerify();
	    forget.show();
	  };
	  
	  
	  submitForm = function(){
		  if(login.hasClass('selected')){
			  form.attr('action','/login/login');
		  }
		  if(signup.hasClass('selected')){
			  form.attr('action', '/login/register');
		  }
		  return form.submit();
	  };
	  
	  
	  toSignup = function() {
	    passwordSecure();
	    $(".full-name, .retype, .password").removeClass("ani-hide");
	    
	    validate.removeClass("display");
	    validate.addClass("hide");

	    signup.addClass("selected");
	    login.removeClass("selected");
	    emailVerify();
	    forget.hide();
	    login.html("Login");
	    return signup.html("Sign Up");
	  };
	  

	  toForget = function() {
	    $(".full-name, .full-name div, .retype, .retype div, .password, .password div .forget").addClass("ani-hide");
	    signup.removeClass("selected");
	    login.addClass("selected");
	    emailVerify();
	    forget.hide();
	    login.html("Reset Password");
	    return signup.html("Back");
	  };

	  
	  emailVerify = function() {
	    var checkInterval, myInterval;
	    
	    if ($(".login").hasClass("selected")) {
	      checkInterval = 0;
	     
	      return myInterval = setInterval((function() {
	        if ($(".email .content").val().length >= 18) {
	          
	         	$(".profile-img").addClass("profile-pic");
	         	$(".profile-add").hide();
	          
	         	clearInterval(myInterval);
	        }
	        if (checkInterval === 250) {
	        		clearInterval(myInterval);
	        }
	        return checkInterval++;
	      }), 250);
	    } else {
	      $(".profile-add").show();
	      return $(".profile-img").removeClass("profile-pic");
	    }
	  };

	  
	  passwordSecure = function() {
	    var checkInterval, myInterval;
	    checkInterval = 0;
	    
	    return myInterval = setInterval((
	    		function() { 	
	    			var backFill, color, pie1, pieColor, secureVal, value;
	    				value = $(".password .content").val();
	    			if (value.length > 0 && value.length < 4) {
	    				color = red;
	    				backFill = red;
	    			} else if (value.length >= 5 && value.length < 7) {
	    				color = yellow;
	    				backFill = yellow;
	    			} else if (value.length >= 8) {
	    				color = emerald;
	    				backFill = emerald;
	    			}
	    			
	    			if (value.length > 0) {
	    				$(".security").removeClass("hide");
	    			} else {
	    				$(".security").addClass("hide");
	    			}
	    			
	    			secureVal = value.length * 9;
	    			if (secureVal >= 100) {
	    				secureVal = 100;
	    			}
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
	    				background: `linear-gradient(${pie1}deg, transparent 50%, ${pieColor} 50%), linear-gradient(90deg, ${lightGrey} 50%, transparent 50%)`
	    			});
	    			
	    			if (checkInterval === 250) {
	    				clearInterval(myInterval);
	    			}
	    			login.click(function() {
	    				$(".password .content").css("color", "#fff");
	    				return clearInterval(myInterval);
	    			});
	    			return checkInterval++;
	    }), 250);
	  };

	  
	  login.click(function() {
	    if (!login.hasClass("selected")) {
	      return toLogin();
	    }
	  });

	  
	  signup.click(function() {
		if ($(".password").hasClass("ani-hide")) {
	      return toLogin();
	    } 
	    
	    if (!signup.hasClass("selected")) {
	      return toSignup();
	    }
	  });
	  

	  submit.click(function() {
		  var psw1 = $('#psw1');
		  var psw2 = $('#psw2');
		  
		  if(signup.hasClass('selected') && psw1.val() != psw2.val()){
			  psw1.val('');
			  psw2.val('');
			  
			  $(".se	curity").addClass("hide");
			  
			  validate.text('* password mismatch *');
			  validate.removeClass("hide");
			  validate.addClass("display");
			  return;
		  }
		  validate.addClass("hide");
		  validate.removeClass("display");
	      $(".text-wrapper").removeClass("show");
	      $(".load-gif").addClass("show");
	      
	      return setTimeout((function() {
	        toLogin();
	        submitForm();
	        $(".text-wrapper").addClass("show");
	        
	        return $(".load-gif").removeClass("show");
	        
	      }), 1500);
	      
	  });
	  

	  forget.click(function() {
	    return toForget();
	  });

	  
	  $(".password .content").click(function() {
	    if ($(".sign-up").hasClass("selected")) {
	      return passwordSecure();
	    }
	    return;
	  });
	  

	  $(".email .content").click(() => {
	    return emailVerify();
	  });
	}

).call(this);

