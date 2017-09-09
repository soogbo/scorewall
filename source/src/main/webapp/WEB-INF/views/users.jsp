<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理系统</title>
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/js/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
</head>
<body>
	<div>
    <table class="easyui-datagrid" id="userList" title="用户列表" 
	       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/users',method:'get',pageSize:5,toolbar:toolbar,pageList:[10,20,30]">
	    <thead>
	        <tr>
	        	<th data-options="field:'ck',checkbox:true"></th>
	        	<th data-options="field:'id'">ID</th>
	            <th data-options="field:'parentId'">邀请人id</th>
	            <th data-options="field:'username'">用户名</th>
	            <th data-options="field:'password'">password</th>
	            <th data-options="field:'telephone'">telephone</th>
	            <th data-options="field:'imei'">imei</th>
	            <th data-options="field:'useMac'">useMac</th>
	            <th data-options="field:'scoreTotal'">总积分</th>
	            <th data-options="field:'scoreUse'">可用积分</th>
	            <th data-options="field:'status'">可用</th>
	            <th data-options="field:'scoreFlag'">scoreFlag</th>
	            <th data-options="field:'createAt',align:'center',formatter:formatDate">创建日期</th>
	            <th data-options="field:'updateAt',align:'center',formatter:formatDate">更新日期</th>
	        </tr>
	    </thead>
	</table>
	</div>
<div id="userAdd" class="easyui-window" title="新增" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/user-add'" style="width:500px;height:309px;padding:10px;">
        The window content.
</div>
<div id="userEdit" class="easyui-window" title="修改" data-options="modal:true,closed:true,iconCls:'icon-edit',href:'/page/user-add',onLoad:loadData,cache:false" style="width:500px;height:309px;padding:10px;">
        The window content.
</div>


<script type="text/javascript">

/*  function loadData(){
	var row=$("#userList").datagrid("getSelections");
 	var data = row[0];
 	//获取数据对生日字段进行格式化，div的onLoad属性表示页面加载完毕后才进行回显；
 	var birthday = data.birthday
 	data.birthday = new Date(birthday).format("yyyy-MM-dd");
 	$('#content').form('load',row[0]);
 } */
 
function formatDate(val,row){
	var now = new Date(val);
	return now.format("yyyy-MM-dd hh:mm:ss");
}
function formatBirthday(val,row){
	var now = new Date(val);
	return now.format("yyyy-MM-dd");
}
function formatSet(val,row){
	if(val == 1){
		return "男";
	}else if(val == 2){
		return "女";
	}else{
		return "未知";
	}
}
function getSelectionsIds(){
	var userList = $("#userList");
	var sels = userList.datagrid("getSelections");
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}
var toolbar = [{
    text:'新增',
    iconCls:'icon-add',
    handler:function(){
    	$('#userAdd').window('open');
    }
},{
    text:'编辑',
    iconCls:'icon-edit',
    handler:function(){
    	// 获取选中的用户
    	var userList = $("#userList");
    	var sels = userList.datagrid("getSelections");
    	if(sels.length != 1){
    		$.messager.alert("提示","请只选择一行数据进行编辑","info");
    		//清除所有选择
			$("#userList").datagrid("clearSelections");
    		return ;
    	}
    	// 打开窗口
    	$('#userEdit').window('open');
    }
},{
    text:'删除',
    iconCls:'icon-cancel',
    handler:function(){
    	var ids = getSelectionsIds();
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中用户!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的会员吗？',function(r){
    	    if (r){
    	    	/*
            	$.post("/user/delete",{'ids':ids}, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除会员成功!',undefined,function(){
        					$("#userList").datagrid("reload");
        				});
        			}
        		});
            	*/
    	    	$.ajax({
    				   type: "POST",
    				   url: "/user/user",
    				   data: {"ids":ids,"_method":"delete"},
    				   statusCode:{
    					  
    					   204:function(){
    						  alert("删除用户成功"); 
    						  $("#userList").datagrid("reload");
    					   },
    					   500:function(){
    						  alert("删除用户失败"); 
    					   }
    				   },
    				});
            	
            	
    	    }
    	});
    }
}/* ,'-',{
    text:'导出Excel',
    iconCls:'icon-remove',
    handler:function(){
    	var optins = $("#userList").datagrid("getPager").data("pagination").options;
    	var page = optins.pageNumber;
    	var rows = optins.pageSize;
    	$("<form>").attr({
    		"action":"/user/user/export/excel",
    		"method":"GET"
    	}).append("<input type='text' name='page' value='"+page+"'/>")
    	.append("<input type='text' name='rows' value='"+rows+"'/>").submit();
    }
},'-',{
    text:'导出Pdf',
    iconCls:'icon-remove',
    handler:function(){
    	var optins = $("#userList").datagrid("getPager").data("pagination").options;
    	var page = optins.pageNumber;
    	var rows = optins.pageSize;
    	$("<form>").attr({
    		"action":"/user/user/export/pdf",
    		"method":"GET"
    	}).append("<input type='text' name='page' value='"+page+"'/>")
    	.append("<input type='text' name='rows' value='"+rows+"'/>").submit();
    } 
}*/];
</script>
</body>
</html>