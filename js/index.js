//로딩시 실행 ajax수정필요
$(document).ready(function () {
  getSubject();
  //basketList();
  //successList();
});

//강좌전부 불러오기
function getSubject() {
  $.ajax({
    url: "http://localhost:8080/api/courses",
    type: "GET",
    dataType: "json",
    success: function (result) {
      console.log(result?.result?.data);
      result?.result?.data?.courseList?.forEach((c) => {
        var subjects =
          "<tr class='subject_info'>" +
          "<td>" +
          "<button class='blue_btn basket_plus' id='plus_basket'onclick='plusBasket()' >장바구니 추가</button>" +
          "</td>" +
          "<td>" +
          c.department +
          "</td>" +
          "<td>" +
          c.division +
          "</td>" +
          "<td>" +
          c.courseNum +
          "</td>" +
          "<td>" +
          c.courseName +
          "</td>" +
          "<td>" +
          c.credit +
          "</td>" +
          "<td>" +
          c.limitStudent +
          "</td>" +
          "<td>" +
          c.professor +
          "</td>" +
          "<td>" +
          c.lectureInfo +
          "&nbsp;&nbsp;" +
          c.timeInfo +
          "</td>" +
          "</tr>";

        $(".subject_info_wrap").append(subjects);
      });
    },
    error: function () {
      alert("강좌불러오기 에러 입니다.");
    },
  });
}

//강좌명검색
function sbj_name_find() {
  $("#sbj_name_find_btn").click(function () {
    radio_box: $("#remain:checked").val(), (sbj_type = $("#sbj_type").val());
    division = $("#division").val();

    var param = `${
      sbj_name == ""
        ? ""
        : "courseName=" + encodeURIComponent($("#sbj_name").val())
    }`;

    $.ajax({
      url: `http://localhost:8080/api/courses`, //나중에 수정해야할것
      type: "GET",
      data: param,
      dataType: "json",
      contentType: "application/json;charset=UTF-8;",
      success: function (result) {
        console.log(result?.result?.data?.courseList);
        //테이블 초기화
        $(".subject_info_wrap").empty();
        result?.result?.data?.courseList?.forEach((c) => {
          var subjects =
            "<tr class='subject_info'>" +
            "<td>" +
            "<button class='blue_btn basket_plus' id='plus_basket'onclick='plusBasket()' >장바구니 추가</button>" +
            "</td>" +
            "<td>" +
            c.department +
            "</td>" +
            "<td>" +
            c.division +
            "</td>" +
            "<td>" +
            c.courseNum +
            "</td>" +
            "<td>" +
            c.courseName +
            "</td>" +
            "<td>" +
            c.credit +
            "</td>" +
            "<td>" +
            c.limitStudent +
            "</td>" +
            "<td>" +
            c.professor +
            "</td>" +
            "<td>" +
            c.lectureInfo +
            "&nbsp;&nbsp;" +
            c.timeInfo +
            "</td>" +
            "</tr>";

          $(".subject_info_wrap").append(subjects);
        });
      },
      error: function () {
        alert("비동기 처리 오류");
      },
    });
  });
}

//강좌번호검색
function sbj_num_find() {
  $("#sbj_num_find_btn").click(function () {
    var send = {
      sbj_name: $("#sbj_num").val(),
      radio_box: $("#remain:checked").val(),
      sbj_type: $("#sbj_type").val(),
      division: $("#division").val(),
    };
    $.ajax({
      url: "http://localhost:8080/api/courses", //나중에 수정해야할것
      type: "GET",
      dataType: "json",
      data: send,
      contentType: "application/json;charset=UTF-8;",
      success: function (data) {
        //테이블 초기화
        $(".subject_info_wrap").empty();
        result?.result?.data?.courseList?.forEach((c) => {
          var subjects =
            "<tr class='subject_info'>" +
            "<td>" +
            "<button class='blue_btn basket_plus' id='plus_basket'onclick='plusBasket()' >장바구니 추가</button>" +
            "</td>" +
            "<td>" +
            c.department +
            "</td>" +
            "<td>" +
            c.division +
            "</td>" +
            "<td>" +
            c.courseNum +
            "</td>" +
            "<td>" +
            c.courseName +
            "</td>" +
            "<td>" +
            c.credit +
            "</td>" +
            "<td>" +
            c.limitStudent +
            "</td>" +
            "<td>" +
            c.professor +
            "</td>" +
            "<td>" +
            c.lectureInfo +
            "&nbsp;&nbsp;" +
            c.timeInfo +
            "</td>" +
            "</tr>";

          $(".subject_info_wrap").append(subjects);
        });
      },
      error: function (error) {
        alert("비동기 처리 오류");
        // alert(
        //   "code:" +
        //     request.status +
        //     "\n" +
        //     "message:" +
        //     request.responseText +
        //     "\n" +
        //     "error:" +
        //     error
        // );
      },
    });
  });
}

//교수검색
function sbj_pro_find() {
  $("#sbj_pro_find_btn").click(function () {
    var send = {
      sbj_pro: $("#sbj_pro").val(),
      radio_box: $("#remain:checked").val(),
      sbj_type: $("#sbj_type").val(),
      division: $("#division").val(),
    };
    var param = `${
      $("#sbj_pro").val() == ""
        ? ""
        : "professor=" + encodeURIComponent($("#sbj_pro").val())
    }`;
    $.ajax({
      url: "http://localhost:8080/api/courses", //나중에 수정해야할것
      type: "GET",
      dataType: "json",
      data: param,
      contentType: "application/json;charset=UTF-8;",
      success: function (result) {
        //테이블 초기화
        $(".subject_info_wrap").empty();
        result?.result?.data?.courseList?.forEach((c) => {
          var subjects =
            "<tr class='subject_info'>" +
            "<td>" +
            "<button class='blue_btn basket_plus' id='plus_basket'onclick='plusBasket()' >장바구니 추가</button>" +
            "</td>" +
            "<td>" +
            c.department +
            "</td>" +
            "<td>" +
            c.division +
            "</td>" +
            "<td>" +
            c.courseNum +
            "</td>" +
            "<td>" +
            c.courseName +
            "</td>" +
            "<td>" +
            c.credit +
            "</td>" +
            "<td>" +
            c.limitStudent +
            "</td>" +
            "<td>" +
            c.professor +
            "</td>" +
            "<td>" +
            c.lectureInfo +
            "&nbsp;&nbsp;" +
            c.timeInfo +
            "</td>" +
            "</tr>";

          $(".subject_info_wrap").append(subjects);
        });
      },
      error: function (error) {
        alert("비동기 처리 오류");
        // alert(
        //   "code:" +
        //     request.status +
        //     "\n" +
        //     "message:" +
        //     request.responseText +
        //     "\n" +
        //     "error:" +
        //     error
        // );
      },
    });
  });
}

//수강확정 조회
function successList() {
  $.ajax({
    url: "/send/sendMsg", //나중에 수정해야할것
    type: "GET",
    dataType: "json",
    success: function (data) {
      if (data.length > 1) {
        for (i = 0; i <= data.length; i++) {
          var subjects =
            "<tr class='subject_info success_subject_info'>" +
            "<td>" +
            "<button onclick='deleteSuccess()' class='red_btn success_delete_btn' id='success_delete'>삭제</button>" +
            "</td>" +
            "<td>" +
            c.department +
            "</td>" +
            "<td>" +
            c.division +
            "</td>" +
            "<td>" +
            c.courseNum +
            "</td>" +
            "<td>" +
            c.courseName +
            "</td>" +
            "<td>" +
            c.credit +
            "</td>" +
            "<td>" +
            c.limitStudent +
            "</td>" +
            "<td>" +
            c.professor +
            "</td>" +
            "<td>" +
            c.lectureInfo +
            "&nbsp;&nbsp;" +
            c.timeInfo +
            "</td>" +
            "</tr>";

          $(".success_sbj_wrap").append(subjects);
        }
      } else if (result.length == 0) {
        alert("해당하는 강좌가 없습니다.");
      }
    },
    error: function () {
      alert("비동기 처리 오류");
      // alert(
      //   "code:" +
      //     request.status +
      //     "\n" +
      //     "message:" +
      //     request.responseText +
      //     "\n" +
      //     "error:" +
      //     error
      // );
    },
  });
}
//장바구니 조회
function basketList() {
  $.ajax({
    url: "/send/sendMsg", //나중에 수정해야할것
    type: "GET",
    dataType: "json",
    success: function (data) {
      if (data.length > 1) {
        for (i = 0; i <= data.length; i++) {
          var subjects =
            "<tr class='basket_info'>" +
            "<td>" +
            "<button onclick='Success()' class='blue_btn apply_btn' id='sign_up_btn'>수강신청</button>" +
            "</td>" +
            "<td>" +
            "<button onclick='deleteBasket()' class='red_btn basket_delete_btn' id='basket_delete'>장바구니 추가</button>" +
            "</td>" +
            "<td>" +
            c.department +
            "</td>" +
            "<td>" +
            c.division +
            "</td>" +
            "<td>" +
            c.courseNum +
            "</td>" +
            "<td>" +
            c.courseName +
            "</td>" +
            "<td>" +
            c.credit +
            "</td>" +
            "<td>" +
            c.limitStudent +
            "</td>" +
            "<td>" +
            c.professor +
            "</td>" +
            "<td>" +
            c.lectureInfo +
            "&nbsp;&nbsp;" +
            c.timeInfo +
            "</td>" +
            "</tr>";

          $(".basket_info_wrap").append(subjects);
        }
      } else if (result.length == 0) {
        alert("해당하는 강좌가 없습니다.");
      }
    },
    error: function () {
      alert("비동기 처리 오류");
      // alert(
      //   "code:" +
      //     request.status +
      //     "\n" +
      //     "message:" +
      //     request.responseText +
      //     "\n" +
      //     "error:" +
      //     error
      // );
    },
  });
}

//장바구니 추가 버튼 클릭
function plusBasket() {
  const sbj_num = $("#sbj_num");
  $(document).on("click", "#plus_basket", function (sbj_num) {
    var send = {
      sbj_num: sbj_num,
      // sbj_pro: $("#sbj_pro").val(),
      // radio_box: $("#remain:checked").val(),
      // sbj_type: $("#sbj_type").val(),
      // division: $("#division").val(),
    };
    $.ajax({
      url: "/send/sendMsg", //나중에 수정해야할것
      type: "post",
      dataType: JSON.stringify(데이터),
      data: send,
      success: function (data) {
        alert("메시지 전송 성공"); //테스트
        basketList();
      },
      error: function (error) {
        alert("비동기 처리 오류");
        // alert(
        //   "code:" +
        //     request.status +
        //     "\n" +
        //     "message:" +
        //     request.responseText +
        //     "\n" +
        //     "error:" +
        //     error
        // );
      },
    });
  });
}
//수강신청 버튼 클릭
function Success() {
  $(document).on("click", "#sign_up_btn", function (sbj_num) {
    var send = {
      // sbj_pro: $("#sbj_pro").val(),
      // radio_box: $("#remain:checked").val(),
      // sbj_type: $("#sbj_type").val(),
      // division: $("#division").val(),
    };
    $.ajax({
      url: "/send/sendMsg", //나중에 수정해야할것
      type: "post",
      dataType: JSON.stringify(데이터),
      data: send,
      success: function (data) {
        alert("메시지 전송 성공"); //테스트
        successList();
      },
      error: function () {
        alert("비동기 처리 오류");
        // alert(
        //   "code:" +
        //     request.status +
        //     "\n" +
        //     "message:" +
        //     request.responseText +
        //     "\n" +
        //     "error:" +
        //     error
        // );
      },
    });
  });
}

//장바구니 삭제버튼
function deleteBasket() {
  $(document).on("click", "#basket_delete", function (sbj_num) {
    if (!confirm("삭제하시겠습니까?")) {
      return;
    }
    $.ajax({
      url: "", //나중에 수정
      type: "post",
      dataType: JSON.stringify(데이터),
      data: { sbj_num: sbj_num },
      success: function (result) {
        if (result == "OK") {
          $(sbj_num).remove();
          alert("삭제되었습니다.");
          basketList();
        }
      },
    });
  });
}

//모두신청 버튼
function allApply() {
  $(document).on("click", "#all_apply", function () {
    var send = {
      //넘길데이터
    };
    $.ajax({
      url: "/send/sendMsg", //나중에 수정해야할것
      type: "post",
      dataType: JSON.stringify(데이터),
      data: send,
      success: function (data) {
        alert("메시지 전송 성공"); //테스트
        successList();
      },
      error: function () {
        alert("비동기 처리 오류");
        // alert(
        //   "code:" +
        //     request.status +
        //     "\n" +
        //     "message:" +
        //     request.responseText +
        //     "\n" +
        //     "error:" +
        //     error
        // );
      },
    });
  });
}

//수강확정 삭제버튼
function deleteSuccess() {
  $(document).on("click", "#success_delete", function (sbj_num) {
    if (!confirm("삭제하시겠습니까?")) {
      return;
    }
    $.ajax({
      url: "", //나중에 수정
      type: "post",
      dataType: JSON.stringify(데이터),
      data: { sbj_num: sbj_num },
      success: function (result) {
        if (result == "OK") {
          $(sbj_num).remove();
          alert("삭제되었습니다.");
          successList();
        }
      },
    });
  });
}
