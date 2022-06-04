const addStudent = document.querySelector("#addStudent");
const insert_form = document.querySelector("#insert_form");

var studentInfo = {
  username:"",
  registrationNumber:"",
  password:"",
  department:"",
  grade:"",
}

function addstu() {

  $.ajax({
    type: "post",
    url: "/api/sign-up", //수정해야함
    dataType: "json",
    contentType : "application/json; charset=utf-8",
    data: JSON.stringify(studentInfo),
    success: function (data) {
      console.log(data);
      location.replace("/studentList")

    },
    error: function () {
    },
  });
}

$(document).on("click", "#addStudent", function (e) {
  console.log(e);
  const stu_num = document.querySelector("#stu_num").value;
  const stu_grade = document.querySelector("#stu_grade").value;
  const stu_department = document.querySelector("#stu_department").value;
  const stu_name = document.querySelector("#stu_name").value;
  const stu_password = document.querySelector("#password").value;

  if (stu_num.length == 0) {
    alert("학번을 입력해 주세요.");
  } else if (stu_grade.length == 0) {
    alert("학년을 입력해 주세요.");
  } else if (stu_department.length == 0) {
    alert("학과를 입력해 주세요.");
  } else if (stu_name.length == 0) {
    alert("이름을 입력해 주세요.");
  } else {
    studentInfo.username = stu_name;
    studentInfo.department = stu_department;
    studentInfo.grade = stu_grade;
    studentInfo.registrationNumber = stu_num;
    studentInfo.password = stu_password;
    addstu();
  }});
