var MainController = {
	init : function() {
		$("#customer_img").click(function() {
			window.location.href = "manage.jsp";
		});
	}
}
$(document).ready(function() {
	MainController.init();
});