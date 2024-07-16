/**
 * 
 */

// 로그인 확인 기능 수행
function loginCheck() {
 	if (document.formLogin.userId.value == "" || document.formLogin.userId.value == null) {
		alert("아이디를 입력하여 주십시오.");
		document.formLogin.userId.focus();
		return;  // 함수가 종료가 되어야 focus()가 실행된다.	
	}
	
	if (document.formLogin.userPw.value == "" || document.formLogin.userPw.value == null) {
		alert("비밀번호를 입력하여 주십시오.");
		document.formLogin.userPw.focus();
		return;  // 함수가 종료가 되어야 focus()가 실행된다.	
	}
	
	document.formLogin.submit();
	
}


// 다음 버튼 클릭 시 실행
function join() {
	var result = false; // false일 경우 유효성 검사를 정상적으로 통과한 것이다.
	
	var formJoin = document.formJoin;
	
	
	if (formJoin.userId.value == "" || formJoin.userId.value == null) {
		alert("아이디를 입력해 주세요.");
		return;
	} else if(formJoin.reId.value == "N") {
		alert("아이디 중복확인을 진행해 주세요."); 
		return;
	}
	
	
	if(formJoin.userPw.value == "" || formJoin.userPw.value == null){
		alert("비밀번호를 입력해 주세요.");
		formJoin.userPw.focus(); 
		return;
	} else { // 만약 alert이 발생할 경우 result를 true로 변경해 주어야 한다.
		result = !password(elInputPassword.value);
		if(result) {
			alert("비밀번호는 8 ~ 20자 길이의 영어, 숫자, 특수문자(@$!%*#?&)의 조합으로 작성해주세요");
			formJoin.userPw.focus();
			return;
		}
	}
	
	
	if(formJoin.userPwCheck.value == "" || formJoin.userPwCheck.value == null){
		alert("비밀번호 확인을 입력해 주세요.");
		formJoin.userPwCheck.focus(); 
		return;
	} else {
		result = !isMatch(elInputPassword.value, elInputPasswordRetype.value);
		if(result){
			alert("비밀번호가 일치하지 않습니다.");
			formJoin.userPwCheck.focus();
			return;
		}
	}
	
	if (formJoin.name.value == "" || formJoin.name.value == null){
		alert("이름을 입력해 주세요.");
		formJoin.name.focus();
		return;
	} else {// 한글 이름의 유효성 검사
		result = !/^[가-힇]{2,5}$/.test(formJoin.name.value);
		if(result){
			alert("2~5자 길이의 한글 이름을 입력해 주세요.");
			formJoin.name.focus();
			return;
		}  	
	}
	
	
	if(formJoin.birth.value == "" || formJoin.birth.value == null) {
		alert("생년월일을 입력해 주세요.");
		formJoin.birth.focus();
		return;
	}
	
	if(formJoin.gender.value == "" || formJoin.gender.value == null) {
		alert("성별을 입력해 주세요.");
		formJoin.gender.focus();
		return;
	} 
	
	if(formJoin.email.value == "" || formJoin.email.value == null) {
		alert("이메일을 입력해 주세요.");
		formJoin.email.focus();
		return;
	} /*else {
		result = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i.test(formJoin.email.value);
		if(result){
			alert("유효하지 않은 이메일 형식입니다.");
			formJoin.email.focus();
			return;
		}
	}*/
	
	/*if(!/^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/.test(formJoin.tel.value)){
		result = !/^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/.test(formJoin.tel.value);
		alert("유효한 휴대전화 번호 형식이 아닙니다.");
		formJoin.tel.focus();
		return;
	}*/
	

	if(result == false) {
		formJoin.submit();
	}
}


// 회원가입 취소 버튼 클릭 시 메인 페이지로 이동
function joinCancle() {
	location.href = "/howtrip";
}

// 1. 아이디 입력창 정보 가져오기
let elInputUserId = document.querySelector("#userId"); // input#userId

// 2. 성공 메시지 정보 가져오기
let elSuccessMessage = document.querySelector(".success-message"); // div.success-message.hide

// 3. 실패 메시지 정보 가져오기 (글자수 제한 6~20글자)
let elFailureMessage = document.querySelector(".failure-message"); // div.failure-message.hide

// 4. 실패 메시지2 정보 가져오기 (영어 또는 숫자)
let elFailureMessageTwo = document.querySelector(".failure-message2"); // div.failure-message2.hide

// 아이디 : 글자수 제한(6글자 이상 20자 이하)
function idLength(value) {
  return value.length >= 6 && value.length <= 20;
}

// 아이디 : 영어 또는 숫자만 가능 
function onlyNumberAndEnglish(str) {
  return /^[A-Za-z0-9][A-Za-z0-9]*$/.test(str);  // 자바 스크립트 정규 표현식 사용
}


// 아이디 이벤트
function idEvent() { // 키보트로부터 값이 입력될 때 실행
  // 값을 입력한 경우
  if (elInputUserId.value.length !== 0) {
    // 영어 또는 숫자 외의 값을 입력했을 경우
    if(onlyNumberAndEnglish(elInputUserId.value) === false) {
      elSuccessMessage.classList.add("hide");
      elFailureMessage.classList.add("hide");
      elFailureMessageTwo.classList.remove("hide"); // 영어 또는 숫자만 가능합니다
    }
    // 글자 수가 6~20글자가 아닐 경우
    else if(idLength(elInputUserId.value) === false) {
      elSuccessMessage.classList.add("hide"); // 성공 메시지가 가려져야 함
      elFailureMessage.classList.remove("hide"); // 아이디는 4~12글자이어야 합니다
      elFailureMessageTwo.classList.add("hide"); // 실패 메시지2가 가려져야 함
    }
    // 조건을 모두 만족할 경우
    else if(idLength(elInputUserId.value) && onlyNumberAndEnglish(elInputUserId.value)) {
      elSuccessMessage.classList.remove("hide"); // 사용할 수 있는 아이디입니다
      elFailureMessage.classList.add("hide"); // 실패 메시지가 가려져야 함
      elFailureMessageTwo.classList.add("hide"); // 실패 메시지2가 가려져야 함
    }
  }
  // 값을 입력하지 않은 경우 (지웠을 때)
  // 모든 메시지를 가린다.
  else {
    elSuccessMessage.classList.add("hide");
    elFailureMessage.classList.add("hide");
    elFailureMessageTwo.classList.add("hide");
  }
}



// ----------------------------------------------------------------------



// 1. 비밀번호 입력창 정보 가져오기
let elInputPassword = document.querySelector("#userPw"); // input#userPw

// 2. 비밀번호 확인 입력창 정보 가져오기
let elInputPasswordRetype = document.querySelector("#userPwCheck"); // input#userPwCheck

// 3. 실패 메시지 정보 가져오기 (비밀번호 불일치)
let elMismatchMessage = document.querySelector(".mismatch-message"); // div.mismatch-message.hide

// 4. 실패 메시지 정보 가져오기 (8글자 이상, 영문, 숫자, 특수문자 미사용)
let elPasswordMessage = document.querySelector(".password-message"); // div.Password-message.hide
 


// 비밀번호 : 영어, 숫자, 특수문자 사용 가능
function password (str) {
  return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/.test(str);  // 자바 스크립트 정규 표현식 사용
}

// 비밀번호 확인 : 비밀번호와 비밀번호 확인 일치
function isMatch (password1, password2) {
  return password1 === password2;
}

// 비밀번호 이벤트
function passwordEvent() { // 키보트로부터 값이 입력될 때 실행
  // console.log(elInputPassword.value);
  // 값을 입력한 경우
  if (elInputPassword.value.length !== 0) {
    if(password(elInputPassword.value)) {
      elPasswordMessage.classList.add("hide"); // 실패 메시지가 가려져야 함
    }
    else {
      elPasswordMessage.classList.remove("hide"); // 실패 메시지가 보여야 함
    }
  }
  // 값을 입력하지 않은 경우 (지웠을 때)
  // 모든 메시지를 가린다.
  else {
    elPasswordMessage.classList.add("hide");
  }
};


// 비밀번호 확인 이벤트
function passwordReEvent() {
  // console.log(elInputPasswordRetype.value);
  if (elInputPasswordRetype.value.length !== 0) {
    if(isMatch(elInputPassword.value, elInputPasswordRetype.value)) {
      elMismatchMessage.classList.add("hide"); // 실패 메시지가 가려져야 함
    }
    else {
      elMismatchMessage.classList.remove("hide"); // 실패 메시지가 보여야 함
    }
  }
  else {
    elMismatchMessage.classList.add("hide"); // 실패 메시지가 가려져야 함
  }
};


 
function idFind() {
 	alert("아이디 찾기 버튼 클릭");
}
 
function pwdFind() {
 	alert("비밀번호 찾기 버튼 클릭");	
}