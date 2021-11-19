function categoryChange(e) {
	  var seoul = ["강남구", "강동구", "강북구", "강서구", "광진구"]
	  var gyeonggi = ["광명시", "수원시", "평택시", "안양시", "하남시"];
	  var busan = ["강서구", "금정구", "해운대구", "동구", "북구"];
	  var target = document.getElementById("gugun");
	 
	  if(e.value == "서울특별시 ") var d = seoul;
	  else if(e.value == "경기도 ") var d = gyeonggi;
	  else if(e.value == "부산광역시 ") var d = busan;
	 
	  target.options.length = 0;
	 
	  for (x in d) {
	    var opt = document.createElement("option");
	    opt.value = d[x];
	    opt.innerHTML = d[x];
	    target.appendChild(opt);
	  }
}

function locaSelect() {
	window.open("loca_Select.do?pg=1",'newWindow' ,"width=1000 height=500 left=500 top=500");
}

function locaChoice(num, name, addr, phone) {
	window.opener.document.getElementById("loca_num").value = num;
	window.opener.document.getElementById("loca_name").value = name;
	window.opener.document.getElementById("loca_addr").value = addr;
	window.opener.document.getElementById("loca_phone").value = phone;
	window.close();
}

 