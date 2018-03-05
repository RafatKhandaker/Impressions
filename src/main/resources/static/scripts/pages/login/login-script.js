var modal = $('#id01');
var close = $('.close');
var cancelBtn = $('.cancelbtn');
var loginBtn = $('#loginBtn');

function closeLoginForm(){
	this.modal.css('display', 'none');
}

function openLoginForm(){
	this.modal.css('display', 'block')
}

window.onclick = function(e) {
		
	if(e.target.className == this.close.attr('class')){
		closeLoginForm();
	}
		
	if(e.target.className == this.cancelBtn.attr('class')){
		closeLoginForm();
	}
	
	if(e.target.id == this.loginBtn.attr('id')){
		openLoginForm();
	}
}


		
