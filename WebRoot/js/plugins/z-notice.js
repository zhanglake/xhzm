$.extend({
	z_notice: function(status, value) {
		var description = null;
		var title = '';
		if (value == null || value == undefined || value == "") {
			if (status === "success") {
				description = "操作成功";
				title = "成功";
			} else if (status === "warning") {
				description = "不符合规范";
				title = "警告";
			} else if (status === "danger") {
				description = "操作失败"
				title = "错误";
			}
		} else {
			description = value;
		}

		var html_ = '<div id="alert-notice" class="alert alert-' + status + ' fade in" style="position:fixed;right:10px;top:10px;width: 250px;line-height:24px;z-index:9999;">';
		html_ += '<button type="button" class="close" data-dismiss="alert" aria-label="Close">';
		html_ += '<span aria-hidden="true">&times;</span>';
		html_ += '</button>';
		html_ += '<strong>' + title + '</strong>';
		html_ += '<br>' + description;
		html_ += '</div>';

		$("body").prepend(html_);
		
		// 定时关闭
		setTimeout(function() {
			$("#alert-notice .close").click();
		}, 3000);
	}
});