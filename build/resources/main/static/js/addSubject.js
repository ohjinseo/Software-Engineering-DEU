const addSubject = document.querySelector("#addSubject");
const insert_form = document.querySelector("#insert_form");

function addsbj() {
  var form_value = insert_form.serialize();
  $.ajax({
    type: "post",
    url: "add-subject", //수정해야함
    enctype: "multipart/form-data",
    data: form_value,
    processData: false,
    contentType: false,
    success: function (data) {
      if (data == 0) {
        alert("강좌 등록에 실패하였습니다.");
        location.href = "addSubject"; //나중에 수정
      } else {
        alert("강좌 등록이 완료되었습니다.");
        location.href = "subjectList"; //나중에 수정
      }
    },
    error: function () {
      alert("전송 실패");
    },
  });
}

addSubject.onclick = () => {
  const sbj_num = document.querySelector("#sbj_num");
  const sbj_name = document.querySelector("#sbj_name");
  const sbj_grade = document.querySelector("#sbj_grade");
  const sbj_department = document.querySelector("#sbj_department");
  const sbj_division = document.querySelector("#sbj_division");
  const sbj_lecture_room = document.querySelector("#sbj_lecture_room");
  const sbj_pro = document.querySelector("#sbj_pro");
  const sbj_limitStu = document.querySelector("#sbj_limitStu");
  const sbj_schedule = document.querySelector("#sbj_schedule");

  if (sbj_num.value.length == 0) {
    alert("강좌번호를 입력해 주세요.");
  } else if (sbj_name.value.length == 0) {
    alert("강좌명을 입력해 주세요.");
  } else if (sbj_grade.value.length == 0) {
    alert("학년을 입력해 주세요.");
  } else if (sbj_department.value.length == 0) {
    alert("이수구분을 입력해 주세요.");
  } else if (sbj_division.value.length == 0) {
    alert("학과를 입력해 주세요.");
  } else if (sbj_lecture_room.value.length == 0) {
    alert("강의실을 입력해 주세요.");
  } else if (sbj_pro.value.length == 0) {
    alert("교수를 입력해 주세요.");
  } else if (sbj_limitStu.value.length == 0) {
    alert("최대수강인원을 입력해 주세요.");
  } else if (sbj_schedule.value.length == 0) {
    alert("시간표를 입력해 주세요.");
  } else {
    addsbj();
  }
};
