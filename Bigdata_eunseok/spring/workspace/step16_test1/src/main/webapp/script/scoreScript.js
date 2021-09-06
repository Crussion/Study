function doSubmit(){
	if(!frm.studNo.value){
		alert("학번을 입력해 주세요");
		frm.studNo.focus();
		return false;
	}
	
	if(!frm.name.value){
		alert("이름을 입력해 주세요");
		frm.name.focus();
		return false;
	}
	return true;
}