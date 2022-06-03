const addStudent = document.querySelector("#addStudent");
const insert_form = document.querySelector("#insert_form");

function addstu() {
  var form_value = insert_form.serialize();
  $.ajax({
    type: "post",
    url: "http://localhost:8000/api/sign-up", //수정해야함
    enctype: "application/json",
    data: form_value,
    processData: false,
    contentType: false,
    success: function (data) {
      if (data == 0) {
        alert("강좌 등록에 실패하였습니다.");
        location.href = "addStudent"; //나중에 수정
      } else {
        alert("강좌 등록이 완료되었습니다.");
        location.href = "studentList"; //나중에 수정
      }
    },
    error: function () {
      //alert("전송 실패");
    },
  });
}

addStudent.onclick = () => {
  const stu_num = document.querySelector("#stu_num");
  const stu_grade = document.querySelector("#stu_grade");
  const stu_department = document.querySelector("#stu_department");
  const stu_name = document.querySelector("#stu_name");

  if (stu_num.value.length == 0) {
    alert("학번을 입력해 주세요.");
  } else if (stu_grade.value.length == 0) {
    alert("학년을 입력해 주세요.");
  } else if (stu_department.value.length == 0) {
    alert("학과를 입력해 주세요.");
  } else if (stu_name.value.length == 0) {
    alert("이름을 입력해 주세요.");
  } else {
    addstu();
  }
};
