(
	function() {

	  var form = $(".form-class");
	  var login = $(".login");
	  var signup = $(".sign-up");
	  var forget = $(".forget");
	  var submit = $('.button');
	  var validate = $('.validator');
	  var pswSec = $('.security');
	  var reType = $('.retype');

	  var emerald = "#19CC8B", red = "#BC3E48", yellow = "#B8B136", lightGrey = "#515866", darkGrey = "#2A2D33", orange = "#FFA500";

	  
	  function toLogin() {
		hideValidMsg();
		pswSec.addClass("hide");
	    reType.addClass("ani-hide");	    
	    login.addClass("selected");
	    signup.removeClass("selected");
	    forget.removeClass('hide');	    
	    return;
	  };
	  
	  
	  function toSignup() {		  
		    reType.removeClass("ani-hide");		    
		    hideValidMsg();
		    signup.addClass("selected");
		    login.removeClass("selected");		    
		    forget.addClass('hide');		     
		    login.html("Login");
		    return signup.html("Sign Up");
		  };
	  
	  function submitForm(){
		  if( validate.hasClass("hide") || ( $('#usr').val().length < 6 || $('#psw1').val().length < 6) ){ 
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
		  validate.empty();
		  return;
	  };
	  
	  
	  function showValidMsg(message){
		  if( validate.hasClass('hide') ){
			  validate.removeClass("hide");
		  }
		  validate.text(message);
		  return;
	  };
	  
	  passComplexity = function(color, value){
			var specChar = (/^[a-zA-Z0-9- ]*$/);
			var numChar = (/\d/);
			var alphaChar = (/[a-zA-Z]/);
			
		switch(color){
			case "red":
				if( value.length > 0 ){ return true; }
				return false;
			case "orange":
			  if( value.length >= 5 && alphaChar.test(value) && (numChar.test(value) ) && specChar.test(value) ){ return true; }
				return false;
			
			case "yellow":
			  if( value.length >= 6 && ((alphaChar.test(value) && numChar.test(value)) || !specChar.test(value)) ){ return true; }
				return false; 
				
			case "green":
			  if( value.length >= 8 && alphaChar.test(value) && numChar.test(value) && !specChar.test(value) ){ return true; }
				return false; 	
			}  
	  };
	  
	  emailVerify = $('#usr').change(function() {
		  
	    var usr = $('#usr');
	    
	    if( !(usr.val().endsWith(".com") && usr.val().includes("@")) ){ showValidMsg('* email invalid *'); }
	    else if( !validate.hasClass('hide') ){ hideValidMsg(); }
	   
	    return;
	  });

	  
	  passwordSecure = $('#psw1').change(function() {	
		  var backFill, color, pie1, pieColor, secureVal, input, value;
	    		  input =$(".password .content");
	    		  value = input.val();
	    		  
	    		  
	      var secVal = $(".secureValue");
	    	  var passCont = $(".password .content, .password .security-type");
	    	  var circBak = $(".circle.background");
	    	  var passFill = $(".password .fill");
	    				
		    		if( !validate.text().includes('* email invalid *') ){ hideValidMsg(); } 			
		    	    if ( !(value.length > 0) ) { pswSec.addClass("hide"); } else { pswSec.removeClass("hide"); }
	    				
	    			if ( passComplexity("red", value) ) { color = red; backFill = red;	}
	    			if ( passComplexity("orange", value) ) { color = orange; backFill = orange; } 
	    		    if ( passComplexity("yellow", value) ) { color = yellow; backFill = yellow; } 
	    		    if ( passComplexity("green", value) ) { color = emerald; backFill = emerald; }
	    			    				    			
	    			if (value.length <= 5) {
		    		    secVal.html(value.length * 9);
	    				pie1 = (value.length * 36) + 90;
	    				pieColor = lightGrey;
	    				
	    			} else if (value.length >= 5 && value.length <= 9) {
		    		    secVal.html(value.length * 9);
	    				pieColor = color;
	    				pie1 = (value.length * 36) - 90;
	    				
	    			} else{
	    				if( passComplexity("green", value) ){ secVal.html(99); pie1 = 360; }else{
	    				secVal.html(90);
	    				pie1 = 270;
	    				}
	    			} 
	    			
	    			passCont.css("color","");
	    			circBak.css("color", "");
	    			
	    			passCont.css("color", `${color}`);
	    			circBak.css("background", `${backFill}`);
	    			passFill.css({
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
		  }
		  
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

