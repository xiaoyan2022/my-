/**
 * 通用方法：保存类form提交
 * @param selector form选择器，可以是id也可以是class
 */
function ajaxSaveForm(selector){
    var form = $(selector);
    var action = form.attr('action');
    $.post(action, form.serialize(), function(data){
        if('ok'==data.state){
			layer.msg(data.msg);
			$.pjax.reload('#rightMain');
		} else {
			layer.msg(data.msg);
		}
	});
}

/**
 * 通用方法：搜索类表单提交
 * @param selector form选择器，可以是id也可以是class
 * @param container	局部刷新的页面容器，可以是id也可以是class
 */
function ajaxSearchForm(selector, container){
	var form = $(selector);
	var action = form.attr('action');
	$.ajax({
		url: action,
		data: form.serialize(),
		type: "POST",
		beforeSend: function(xhr){
			//这里设置header，仿造pjax请求，刷新局部页面
			xhr.setRequestHeader('X-PJAX', 'true');
			NProgress.start();
		},
		success: function(html){
			$(container).html(html);
		},
		complete: function(XMLHttpRequest, textStatus) {
			NProgress.done();
		}
	});
}

/**
 * 通用方法：数据表格中的删除按钮
 * @param url	删除操作的完整url，包含地址和参数
 */
function ajaxDelete(url){
	layer.confirm('确认删除该元素么?', function(index){
		$.post(url, function(data){
			if('ok'==data.state){
				layer.msg(data.msg);
				$.pjax.reload('#rightMain');
			} else {
				layer.alert(data.msg);
			}
		});
		layer.close(index);
	}); 
}


