function doSubmit(){
	if(!frm.name.value || !isNaN(frm.name.value)){
		alert("이름을 입력하세요.");
		frm.name.value = "";
		frm.name.focus();
		return false;
	}
	
	if(!frm.id.value){
		alert("아이디를 입력하세요.");
		frm.id.focus();
		return false;
	}
	
	if(frm.check.value == 'false'){
		alert("아이디 중복체크를 해주세요.");
		frm.id.focus();
		return false;
	}
	
	if(!frm.pwd.value){
		alert("비밀번호를 입력하세요.");
		frm.pwd.focus();
		return false;
	}
	
	if(!frm.pwd_chk.value){
		alert("비밀번호를 다시 입력하세요.")
		frm.pwd_chk.focus();
		return false;
	}
	
	if(frm.pwd.value != frm.pwd_chk.value){
		alert("비밀번호가 일치하지 않습니다.")
		frm.pwd_chk.value = "";
		frm.pwd_chk.focus();
		return false;
	}
	return true;
}

function login(){
	if(!login_frm.id.value){
		alert("아이디를 입력하세요.");
		login_frm.id.focus();
		return false;
	}
	
	if(!login_frm.pwd.value){
		alert("비밀번호를 입력하세요.");
		login_frm.pwd.focus();
		return false;
	}
	
	login_frm.submit();
}

function checkId(){
	var sId = frm.id.value;
	
	if(!sId){
		alert("먼저 아이디를 입력하세요.");
		frm.id.focus();
	} else {
		window.open("../member/checkId.jsp?id=" + sId, "", "width=400 height=150 left=500 top=200");
	}
	return false;
}

function modify(){
	if(!modify_frm.pwd.value){
		alert("비밀번호를 입력하세요.");
		modify_frm.pwd.focus();
		return false;
	}
	
	if(!modify_frm.pwd_chk.value){
		alert("비밀번호를 다시 입력하세요.")
		modify_frm.pwd_chk.focus();
		return false;
	}
	
	if(modify_frm.pwd.value != modify_frm.pwd_chk.value){
		alert("비밀번호가 일치하지 않습니다.")
		modify_frm.pwd_chk.value = "";
		modify_frm.pwd_chk.focus();
		return false;
	}
	
	return true;
}