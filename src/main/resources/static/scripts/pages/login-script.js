var modal = $('#id01');
var close = $('.close');

window.onclick = function(e) {
	
		if (e.target == this.modal) {
			this.modal.css('display: none');
		}
		
		if(e.target == this.close){
			this.modal.css('display: none');
		}
}

function pageLoad(this.modal){
	this.close.onclick = function(e){
		modal.css('display: none')
	}
}
		
