window.onload=function(){
	//退出系统对话框
	var quit=document.querySelector(".quit");
	var exit=document.querySelector(".exit");
	var exitpic=document.querySelector(".exit .top i");
	var cancelbtn=document.querySelector(".content .buttons .cancel");
	var okbtn=document.querySelector(".content .buttons .ok");
	//显示对话框
	quit.addEventListener("click",function(){
		exit.style.display="block";
	});
	//隐藏对话框
	exitpic.addEventListener("click",function(){
		exit.style.display="none";
	});
	cancelbtn.addEventListener("click",function(){
		exit.style.display="none";
	});
	//注销
	okbtn.addEventListener("click",function(){
		window.location.href="../login.html";
	});

	//左侧菜单控制
	//子菜单初始化不显示
	var mdls = document.getElementsByTagName("dl");
	var flag=true;
	var mdds=document.getElementsByTagName("dd");
	for (var i = 0; i < mdds.length; i++) {
		mdds[i].style.display="none";
	}
	//点击其中一个父菜单时显示子菜单
	for (var i = 0; i < mdls.length; i++) {
		mdls[i].addEventListener("click",function(e){
			if(e.target.tagName!='DT')
				return;
			var mtdds = this.getElementsByTagName("dd");
			if(flag){
				for (var i = 0; i < mtdds.length; i++) {
					mtdds[i].style.display="block";
				}
				flag=false;
			}else{
				for (var i = 0; i < mtdds.length; i++) {
					mtdds[i].style.display="none";
				}
				flag=true;
			}
		});
	}

	//点击子菜单的响应
	var userman=document.querySelector("#userman");
	var leftFrame=document.querySelector("#leftFrame");
	userman.addEventListener("click",function(){
		leftFrame.src="userman.jsp";
	});

};