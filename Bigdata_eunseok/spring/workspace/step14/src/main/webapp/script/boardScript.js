function checkBoardWrite() {
	if(!boardWriteForm.subject.value) {
		alert("제목을 입력하세요");
		boardWriteForm.subject.focus();
	} else if (!boardWriteForm.content.value) {
		alert("내용을 입력하세요");
		boardWriteForm.content.focus();
	} else {
		boardWriteForm.submit();
	}
}