//로딩시 실행 ajax수정필요
$(document).ready(function () {
  getSubject();
  basketList();
  successList();
  test(data); //테스트
});
//테스트
data = [
  {
    division: "전공선택",
    sbj_num: "1234",
    sbj_name: "소프트웨어공학",
    sbj_credit: "3/3",
    sbj_limitStu: "30/50",
    sbj_pro: "장성진",
    sbj_lecture_room: "810",
  },
  {
    division: "전공",
    sbj_num: "1234",
    sbj_name: "소프트웨어공학",
    sbj_credit: "3/3",
    sbj_limitStu: "30/50",
    sbj_pro: "장성진",
    sbj_lecture_room: "810",
  },
];

//강좌목록 테스트 함수 나중에 삭제할것
function test() {
  {
    console.log(data);
    for (i = 0; i <= data.length; i++) {
      console.log(data[i].division);
      var subjects =
        "<tr class='subject_info'>" +
        "<td>" +
        "<button class='blue_btn basket_plus' id='plus_basket'>장바구니 추가</button>" +
        "</td>" +
        "<td>" +
        data[i].division +
        "</td>" +
        "<td>" +
        data[i].sbj_num +
        "</td>" +
        "<td>" +
        data[i].sbj_name +
        "</td>" +
        "<td>" +
        data[i].sbj_credit +
        "</td>" +
        "<td>" +
        data[i].sbj_limitStu +
        "</td>" +
        "<td>" +
        data[i].sbj_pro +
        "</td>" +
        "<td>" +
        data[i].sbj_lecture_room +
        "</td>" +
        "</tr>";
      $(".subject_info_wrap").append(subjects);
    }
  }
}

//강좌전부 불러오기
function getSubject() {
  $.ajax({
    url: "http://localhost:8080/api/courses",
    type: "GET",
    dataType: "json",
    success: function (data) {
      console.log(data);
      if (data.length >= 1) {
        for (i = 0; i <= data.length; i++) {
          var subjects =
            "<tr class='subject_info'>" +
            "<td>" +
            "<button class='blue_btn basket_plus' id='plus_basket'onclick='plusBasket()' >장바구니 추가</button>" +
            "</td>" +
            "<td>" +
            data[i].division +
            "</td>" +
            "<td>" +
            data[i].sbj_num +
            "</td>" +
            "<td>" +
            data[i].sbj_name +
            "</td>" +
            "<td>" +
            data[i].sbj_credit +
            "</td>" +
            "<td>" +
            data[i].sbj_limitStu +
            "</td>" +
            "<td>" +
            data[i].sbj_pro +
            "</td>" +
            "<td>" +
            data[i].sbj_lecture_room +
            "</td>" +
            "</tr>";

          $(".subject_info_wrap").append(subjects);
        }
      } else {
        
        //alert(data.Msg);
      }
    },
    error: function (e) {
      console.log("에러좀떠");
      //alert("강좌불러오기 에러 입니다.");
    },
  });
}

//과목명검색
function sbj_name_find() {
  $("#sbj_name_find_btn").click(function () {
    var send = {
      sbj_name: $("#sbj_name").val(),
      radio_box: $("#remain:checked").val(),
      sbj_type: $("#sbj_type").val(),
      division: $("#division").val(),
    };
    $.ajax({
      url: "/send/sendMsg", //나중에 수정해야할것
      type: "POST",
      dataType: "json",
      data: send,
      success: function (data) {
        //테이블 초기화
        $(".subject_info_wrap").empty();
        if (data.length > 1) {
          for (i = 0; i <= data.length; i++) {
            var subjects =
              "<tr class='subject_info'>" +
              "<td>" +
              "<button onclick='plusBasket()' class='blue_btn basket_plus' id='plus_basket'>장바구니 추가</button>" +
              "</td>" +
              "<td>" +
              data[i].division +
              "</td>" +
              "<td>" +
              data[i].sbj_num +
              "</td>" +
              "<td>" +
              data[i].sbj_name +
              "</td>" +
              "<td>" +
              data[i].sbj_credit +
              "</td>" +
              "<td>" +
              data[i].sbj_limitStu +
              "</td>" +
              "<td>" +
              data[i].sbj_pro +
              "</td>" +
              "<td>" +
              data[i].sbj_lecture_room +
              "</td>" +
              "</tr>";

            $(".subject_info_wrap").append(subjects);
          }
        } else if (result.length == 0) {
          //alert("해당하는 강좌가 없습니다.");
        }
      },
      error: function (error) {
        //alert("강좌명검색 에러 발생"); //테스트
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
      url: "/send/sendMsg", //나중에 수정해야할것
      type: "POST",
      dataType: "json",
      data: send,
      success: function (data) {
        //테이블 초기화
        $(".subject_info_wrap").empty();
        if (result.length > 1) {
          for (i = 0; i <= result.length; i++) {
            var subjects =
              "<tr class='subject_info'>" +
              "<td>" +
              "<button onclick='plusBasket()' class='blue_btn basket_plus' id='plus_basket'>장바구니 추가</button>" +
              "</td>" +
              "<td>" +
              data[i].division +
              "</td>" +
              "<td>" +
              data[i].sbj_num +
              "</td>" +
              "<td>" +
              data[i].sbj_name +
              "</td>" +
              "<td>" +
              data[i].sbj_credit +
              "</td>" +
              "<td>" +
              data[i].sbj_limitStu +
              "</td>" +
              "<td>" +
              data[i].sbj_pro +
              "</td>" +
              "<td>" +
              data[i].sbj_lecture_room +
              "</td>" +
              "</tr>";

            $(".subject_info_wrap").append(subjects);
          }
        } else if (result.length == 0) {
          //alert("해당하는 강좌가 없습니다.");
        }
      },
      error: function (error) {
       // alert("강좌번호 검색 오류발생"); //테스트
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
    $.ajax({
      url: "/send/sendMsg", //나중에 수정해야할것
      type: "POST",
      dataType: "json",
      data: send,
      success: function (result) {
        //테이블 초기화
        $(".subject_info_wrap").empty();
        if (result.length > 1) {
          for (i = 0; i <= result.length; i++) {
            var subjects =
              "<tr class='subject_info'>" +
              "<td>" +
              "<button onclick='plusBasket()' class='blue_btn basket_plus' id='plus_basket'>장바구니 추가</button>" +
              "</td>" +
              "<td>" +
              result[i].division +
              "</td>" +
              "<td>" +
              result[i].sbj_num +
              "</td>" +
              "<td>" +
              result[i].sbj_name +
              "</td>" +
              "<td>" +
              result[i].sbj_credit +
              "</td>" +
              "<td>" +
              result[i].sbj_limitStu +
              "</td>" +
              "<td>" +
              result[i].sbj_pro +
              "</td>" +
              "<td>" +
              result[i].sbj_lecture_room +
              "</td>" +
              "</tr>";
            $(".subject_info_wrap").append(subjects);
          }
        } else if (result.length == 0) {
          //alert("해당하는 강좌가 없습니다.");
        }
      },
      error: function (error) {
       // alert("교수 검색 에러발생"); //테스트
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
            data[i].division +
            "</td>" +
            "<td>" +
            data[i].sbj_num +
            "</td>" +
            "<td>" +
            data[i].sbj_name +
            "</td>" +
            "<td>" +
            data[i].sbj_credit +
            "</td>" +
            "<td>" +
            data[i].sbj_limitStu +
            "</td>" +
            "<td>" +
            data[i].sbj_pro +
            "</td>" +
            "<td>" +
            data[i].sbj_lecture_room +
            "</td>" +
            "</tr>";

          $(".success_sbj_wrap").append(subjects);
        }
      } else if (result.length == 0) {
       // alert("해당하는 강좌가 없습니다.");
      }
    },
    error: function (error) {
     // alert("수강확정 불러오기 오류 발생"); //테스트
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
            data[i].division +
            "</td>" +
            "<td>" +
            data[i].sbj_num +
            "</td>" +
            "<td>" +
            data[i].sbj_name +
            "</td>" +
            "<td>" +
            data[i].sbj_credit +
            "</td>" +
            "<td>" +
            data[i].sbj_limitStu +
            "</td>" +
            "<td>" +
            data[i].sbj_pro +
            "</td>" +
            "<td>" +
            data[i].sbj_lecture_room +
            "</td>" +
            "</tr>";

          $(".basket_info_wrap").append(subjects);
        }
      } else if (result.length == 0) {
      //  alert("해당하는 강좌가 없습니다.");
      }
    },
    error: function (error) {
     // alert("장바구니 조회 오류 발생"); //테스트
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
       // alert("메시지 전송 성공"); //테스트
        basketList();
      },
      error: function (error) {
       // alert("장바구니추가 전송 실패"); //테스트
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
        //alert("메시지 전송 성공"); //테스트
        successList();
      },
      error: function (error) {
      //  alert("수강신청 전송 실패"); //테스트
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
         // alert("삭제되었습니다.");
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
       // alert("메시지 전송 성공"); //테스트
        successList();
      },
      error: function (error) {
       // alert("수강신청 전송 실패"); //테스트
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
