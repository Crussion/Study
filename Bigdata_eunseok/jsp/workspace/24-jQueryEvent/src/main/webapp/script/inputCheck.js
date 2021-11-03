$(function(){
	$("#join").submit(function(){
		var user_id = $("input[name='user_id']")
		if(!user_id.val()){
			alert("아이디를 입력하세요.")
			user_id.focus()
			return false
		}
		var user_pw = $("input[name='user_pw']")
		if(!user_pw.val()){
			alert("비밀번호를 입력하세요.")
			user_pw.focus()
			return false
		}
		var jumin_no = $("input[name='jumin_no']")
		if(!jumin_no.val()){
			alert("주민번호를 입력하세요.")
			jumin_no.focus()
			return false
		}
		var gender = $("input[name='gender']")
		if(!gender.is(":checked")){
			alert("성별을 선택하세요.")
			gender.focus()
			return false
		}
		var email = $("input[name='email']")
		if(!email.val()){
			alert("이메일을 입력하세요.")
			email.focus()
			return false
		}
		var url = $("input[name='url']")
		if(!url.val()){
			alert("URL을 입력하세요.")
			url.focus()
			return false
		}
		var hpno = $("input[name='hpno']")
		if(!hpno.val()){
			alert("핸드폰 번호를 입력하세요.")
			hpno.focus()
			return false
		}
		var hobby = $("input[name='hobby']")
		if(!hobby.is(":checked")){
			alert("취미를 선택하세요.")
			hobby.focus()
			return false
		}
		if($("select[name='job'] > option:selected").index() < 1){
			alert("직업을 선택하세요.")
			$("select[name='job']").focus()
			return false
		}
		
		gender = $("input[name='gender']:checked")
		hobby = $("input[name='hobby']:checked")
		var select_hobby = ""
		hobby.each(function(){
			select_hobby += $(this).val()
		})
		job = $("select[name='job'] > option:selected")
		
		var result = "<ul>"
		result += "<li>아이디: " + user_id.val() + "</li>"
		result += "<li>비밀번호: " + user_pw.val() + "</li>"
		result += "<li>주민번호: " + jumin_no.val() + "</li>"
		result += "<li>성별: " + gender.val() + "</li>"
		result += "<li>이메일: " + email.val() + "</li>"
		result += "<li>URL: " + url.val() + "</li>"
		result += "<li>전화번호: " + hpno.val() + "</li>"
		result += "<li>취미: " + select_hobby  + "</li>"
		result += "<li>직업: " + job.val() + "</li>"
		result += "</ul>"
		
		$("body").html(result)
		
		return false
	})
})