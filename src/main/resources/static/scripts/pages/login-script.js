var modal = $('#id01');
var close = $('.close');
var cancelBtn = $('.cancelbtn');

function closeLoginForm(){
	this.modal.css('display', 'none');
}

window.onclick = function(e) {
		
	if(e.target.className == this.close.attr('class')){
		closeLoginForm();
	}
		
	if(e.target.className == this.cancelBtn.attr('class')){
		closeLoginForm();
	}
}


v

		
