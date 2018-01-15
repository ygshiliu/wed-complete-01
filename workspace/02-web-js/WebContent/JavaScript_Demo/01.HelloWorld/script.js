	//给window对象定义一个onload事件
	window.onload = function(){
		//获取button对象
		//在js中一切皆对象
		//注意：语句后面要加;
		var btn = document.getElementById("btnId");
		//为button对象定义单击事件
		btn.onclick = function(){
			alert("我们的第一个js Demo实例！！***");
		}
	}