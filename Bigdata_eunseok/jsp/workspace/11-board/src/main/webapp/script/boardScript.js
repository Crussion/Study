/**
 * 
 */
function boardSubmit(){
	if(!board_frm.subject.value){
		alert("제목을 입력하세요");
		board_frm.subject.focus();
		return false;
	}
	
	if(!board_frm.content.value){
		alert("내용을 입력하세요");
		board_frm.content.focus();
		return false;
	}
	
	return true;
}

function boardModify(){
	if(!modify_frm.subject.value){
		alert("제목을 입력하세요");
		modify_frm.subject.focus();
		return false;
	}
	
	if(!modify_frm.content.value){
		alert("내용을 입력하세요");
		modify_frm.content.focus();
		return false;
	}
	
	return true;
}