$("#categoryLevel1").change(function(){      //当用于 select 元素时，change 事件会在选择某个选项时发生。
	var categoryLevel1 = $("#categoryLevel1").val();
	if(categoryLevel1 != '' && categoryLevel1 != null){
		$.ajax({
			type:"GET",//请求类型
			url:"../appCategory/getAppCategoryByParentId.json",//请求的url
			data:{parentId:categoryLevel1},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				$("#categoryLevel2").html("");
				var options = "<option value=\"\">--请选择--</option>";
				for(var i = 0; i < data.length; i++){
					options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
				}
				$("#categoryLevel2").html(options);
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("加载二级分类失败！");
			}
		});
	}else{
		$("#categoryLevel2").html("");
		var options = "<option value=\"\">--请选择--</option>";
		$("#categoryLevel2").html(options);
	}
	$("#categoryLevel3").html("");
	var options = "<option value=\"\">--请选择--</option>";
	$("#categoryLevel3").html(options);
});

$("#categoryLevel2").change(function(){
	var categoryLevel2 = $("#categoryLevel2").val();
	if(categoryLevel2 != '' && categoryLevel2 != null){
		$.ajax({
			type:"GET",//请求类型
			url:"../appCategory/getAppCategoryByParentId.json",//请求的url
			data:{parentId:categoryLevel2},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				$("#categoryLevel3").html("");
				var options = "<option value=\"\">--请选择--</option>";
				for(var i = 0; i < data.length; i++){
					//alert(data[i].id);
					//alert(data[i].categoryName);
					options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
				}
				$("#categoryLevel3").html(options);
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("加载三级分类失败！");
			}
		});
	}else{
		$("#categoryLevel3").html("");
		var options = "<option value=\"\">--请选择--</option>";
		$("#categoryLevel3").html(options);
	}
});

$(".checkApp").on("click",function(){
	var obj = $(this);
	var status = obj.attr("status");
	var vid = obj.attr("versionid");
	if(status == "1" && vid != "" && vid != null){//待审核状态下才可以进行审核操作
		window.location.href="check.html?aid="+ obj.attr("appinfoid") + "&vid="+ obj.attr("versionid");
	}else if(vid != "" || vid != null){
		alert("该APP应用没有上传最新版本,不能进行审核操作！");
	}else if(status != "1"){
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能进行审核操作！");
	}
});



	
