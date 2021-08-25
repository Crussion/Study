function doSubmit(){
	if(!frm.book_num.value){
		alert("도서 코드를 입력하세요");
		frm.book_num.focus();
		return false;
	}
	
	if(!frm.book_subject.value){
		alert("도서명을 입력하세요");
		frm.book_subject.focus();
		return false;
	}
	
	if(!frm.book_writer.value){
		alert("저자를 입력하세요");
		frm.book_writer.focus();
		return false;
	}
	
	var date2 = frm.book_date2.value;
	var date3 = frm.book_date3.value;
	if(date2 || date3){
		if(date2 > 12 || date2 < 1){
			alert("올바른 월을 입력하세요");
			frm.book_date2.focus();
			return false;
		}
		if(date3 < 1 || date3 > 31){
			alert("올바른 일을 입력하세요");
			frm.book_date3.focus();
			return false;
		}
	}
	
	return true;
}