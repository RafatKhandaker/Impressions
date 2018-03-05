var modal = $('#id01');
var close = $('.close');

window.onclick = function(e) {
		if(e.target.className == this.close.attr('class')){
			this.modal.css('display', 'none');
		}
}


		
