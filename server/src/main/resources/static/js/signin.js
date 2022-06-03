var user_id = document.querySelector("#user_id");
var user_password = document.querySelector("#user_password");
const login_btn = document.querySelector("#login_btn");

const signInData = {
  username : "",
  password : ""
};

//로그인 체크해서 이메일 없으면 이메일 입력 , 비밀번호없으면 비밀번호 입력 메세지 전달
function emptyCheck() {
  console.log(user_id.value)
  if (user_id.value.length === 0) {
    let msgText = "아이디를 입력해 주세요.";
    messageService(msgText, 0);
    return false;
  } else if (user_password.value.length === 0) {
    let msgText = "비밀번호를 입력해 주세요.";
    messageService(msgText, 1);
    return false;
  } else {
    return true;
  }
}

//오류메세지 없애는것
function clearMsgNode(msg) {
  while (msg.hasChildNodes()) {
    msg.removeChild(msg.firstChild);
  }
  msg.style.display = "none";
}

//로그인체크 메세지 html에 나타나게
function messageService(msgText, msgFlag) {
  const idErrorMsg = document.querySelector(".idErrorMsg");
  const passwordErrorMsg = document.querySelector(".passwordErrorMsg");

  clearMsgNode(idErrorMsg);
  clearMsgNode(passwordErrorMsg);

  let msgTextNode = document.createTextNode(msgText);

  //msgFlag == 0 이메일 오류, 1이면 password 오류
  if (msgFlag == 0) {
    idErrorMsg.appendChild(msgTextNode);
    idErrorMsg.style.display = "block";
  } else {
    passwordErrorMsg.appendChild(msgTextNode);
    passwordErrorMsg.style.display = "block";
  }
}

//데이터 넘기는 ajax
function signInSubmit() {
  console.log(signInData)
  $.ajax({
    type: "POST",
    url: "/login",
    data: signInData,
    contentType: 'application/x-www-form-urlencoded; charset=utf-8',
    dataType:"text",
    success: function (data) {
      location.replace("/");
      console.log("로그인 성공")
      //이메일이 존재 하지 않음
    },
    error: function (e) {
      console.log(e);
    },
  });
}

function signInService() {
  //ajax호출
  if (emptyCheck() === true) {
    signInData.username = user_id.value;
    signInData.password = user_password.value;
    signInSubmit();
  }


}
//로그인 버튼 누를시 signInService호출
function loginClick() {
  signInService();
}

login_btn.onclick = () => {
  signInService();
};

//비밀번호 변경누르면
function change_pwd() {
  alert(
    "학생경력관리포털(DAP시스템) -> 학생정보시스템 -> " +
      "[개인정보변경]에서 변경할 수 있습니다."
  );
}

//비밀번호 찾기누르면
function find_pwd() {
  window.open(
    "https://d4u.deu.ac.kr/urp4wn/web/com/compwschon.aspx",
    "_blank",
    "width=500, height=500"
  );
}
``;

//아이디 엔터누르면 비밀번호 입력창으로 이동
item_ip[0].onkeypress = () => {
  if (window.event.keyCode === 13) {
    window.event.preventDefault();
    item_ip[1].focus();
  }
};
//비밀번호 엔터누르면 로그인 버튼 눌러짐
item_ip[1].onkeypress = () => {
  if (window.event.keyCode == 13) {
    window.event.preventDefault();
    signInService();
  }
};
