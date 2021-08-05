function doSubmit(){
	if(!frm.id.value){
		alert("아이디를 입력해 주세요.");
		frm.id.focus();
		return false;
	}
	
	if(!frm.pwd.value){
		alert("비밀번호를 입력해 주세요.");
		frm.pwd.focus();
		return false;
	}
	
	if(confirm("입력하신 내용이 맞습니까?")){
		return true;
	}else{
		return false;
	}
}