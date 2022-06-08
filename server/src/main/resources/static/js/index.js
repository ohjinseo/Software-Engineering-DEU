//로딩시 실행 ajax수정필요
$(document).ready(function () {
  getSubject();
  basketList();
  successList();
  getSchedule();
  getStudentInfo();
});

let bsum = 0;
let csum = 0;

function getStudentInfo() {
  $.ajax({
    url: `/api/student`, //나중에 수정해야할것
    type: "get",
    success: function (data) {
      var name = data?.result?.data?.username

      $('#stu_name').append(name);
    },
    error: function (error) {
      alert(error.responseJSON.result.message);
    },
  });
}

function getSchedule(){
  $.ajax({
    url: `/api/schedule`, //나중에 수정해야할것
    type: "get",
    success: function (data) {

      console.log(data);
      $("#schedule_table").empty();

      var days = "<tr>" +
        "<th>" + "</th>" +
        "<th>" + "월" + "</th>" +
        "<th>" + "화" + "</th>" +
        "<th>" + "수" + "</th>" +
        "<th>" + "목" + "</th>" +
        "<th>" + "금" + "</th>" +
      "</tr>"
      $("#schedule_table").append(days)

      for(i = 0; i < 8; i++){

        var $tr = $("<tr>",{});

        if(data?.result?.data?.dates[0][i] === 0){
          var $td1 =  $("<td>");
        }else if(data?.result?.data?.dates[0][i] === 1){
          var $td1 =  $("<td>", {class:"red"});
        }else if(data?.result?.data?.dates[0][i] === 2){
          var $td1 =  $("<td>", {class:"blue"});
        }

        if(data?.result?.data?.dates[1][i] === 0){
          var $td2 =  $("<td>");
        }else if(data?.result?.data?.dates[1][i] === 1){
          var $td2 =  $("<td>", {class:"red"});
        }else if(data?.result?.data?.dates[1][i] === 2){
          var $td2 =  $("<td>", {class:"blue"});
        }

        if(data?.result?.data?.dates[2][i] === 0){
          var $td3 =  $("<td>");
        }else if(data?.result?.data?.dates[2][i] === 1){
          var $td3 =  $("<td>", {class:"red"});
        }else if(data?.result?.data?.dates[2][i] === 2){
          var $td3 =  $("<td>", {class:"blue"});
        }

        if(data?.result?.data?.dates[3][i] === 0){
          var $td4 =  $("<td>");
        }else if(data?.result?.data?.dates[3][i] === 1){
          var $td4 =  $("<td>", {class:"red"});
        }else if(data?.result?.data?.dates[3][i] === 2){
          var $td4 =  $("<td>", {class:"blue"});
        }

        if(data?.result?.data?.dates[4][i] === 0){
          var $td5 =  $("<td>");
        }else if(data?.result?.data?.dates[4][i] === 1){
          var $td5 =  $("<td>", {class:"red"});
        }else if(data?.result?.data?.dates[4][i] === 2){
          var $td5 =  $("<td>", {class:"blue"});
        }

        // 장바구니
        $(".red").css({
          "width":"50px",
          "height":"30px",
          "background-color":"red"
        })

        // 수강신청
        $(".blue").css({
          "width":"50px",
          "height":"30px",
          "background-color":"blue"
        })
        var th = "<th>" + (i + 1) + "교시" + "</th>";
        $tr.append(th);
        $tr.append($td1);
        $tr.append($td2);
        $tr.append($td3);
        $tr.append($td4);
        $tr.append($td5);

      $("#schedule_table").append($tr);
      }
    },
    error: function (error) {
      alert(error.responseJSON.result.message);
    },
  });
}

//강좌전부 불러오기
function getSubject() {
  $.ajax({
    url: "/api/courses",
    type: "GET",
    dataType: "json",
    success: function (result) {
      result?.result?.data?.courseList?.forEach((c) => {
        var subjects =
            "<tr class='subject_info'>" +
            "<td>" +
            "<button class='blue_btn basket_plus' id='plus_basket' >장바구니 추가</button>" +
            "</td>" +
            "<td>" +
            c.department +
            "</td>" +
            "<td>" +
            c.division +
            "</td>" +
            "<td class='courseId'>" +
            c.courseId +
            "</td>" +
            "<td>" +
            c.courseName +
            "</td>" +
            "<td>" +
            c.grade +
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
    radio_box: $("#remain:checked").val();
    sbj_name = $("#sbj_name").val();
    sbj_type = $("#sbj_type").val();
    division = $("#division").val();

    var param = `${
        sbj_name === ""
            ? ""
            : "courseName=" + encodeURIComponent($("#sbj_name").val())
    }&${
        sbj_type === "" ? "" : "type=" + encodeURIComponent($("#sbj_type").val())
    }&${
        division === ""
            ? ""
            : "division=" + encodeURIComponent($("#division").val())
    }`;

    console.log(param);
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
              "<td class='courseId'>" +
              c.courseId +
              "</td>" +
              "<td>" +
              c.courseName +
              "</td>" +
              "<td>" +
              c.grade +
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

// 강좌번호검색
function sbj_num_find() {
  $("#sbj_num_find_btn").click(function () {
    radio_box: $("#remain:checked").val();
    sbj_num = $("#sbj_num").val();
    sbj_type = $("#sbj_type").val();
    division = $("#division").val();


    var param = `${
        sbj_num === ""
            ? ""
            : "courseNumber=" + encodeURIComponent($("#sbj_num").val())
    }&${
        sbj_type === "" ? "" : "type=" + encodeURIComponent($("#sbj_type").val())
    }&${
        division === ""
            ? ""
            : "division=" + encodeURIComponent($("#division").val())
    }`;

    $.ajax({
      url: "http://localhost:8080/api/courses", //나중에 수정해야할것
      type: "GET",
      dataType: "json",
      data: param,
      contentType: "application/json;charset=UTF-8;",
      success: function (result) {
        console.log(result);
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
              "<td class='courseId'>" +
              c.courseId +
              "</td>" +
              "<td>" +
              c.courseName +
              "</td>" +
              "<td>" +
              c.grade +
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
    sbj_pro = $("#sbj_pro").val();
    radio_box = $("#remain:checked").val();
    sbj_type = $("#sbj_type").val();
    division = $("#division").val();

    var param = `${
        sbj_pro === ""
            ? ""
            : "professor=" + encodeURIComponent($("#sbj_pro").val())
    }&${
        sbj_type === "" ? "" : "type=" + encodeURIComponent($("#sbj_type").val())
    }&${
        division === ""
            ? ""
            : "division=" + encodeURIComponent($("#division").val())
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
              "<td class='courseId'>" +
              c.courseId +
              "</td>" +
              "<td>" +
              c.courseName +
              "</td>" +
              "<td>" +
              c.grade +
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
    url: "/api/signupCourse", //나중에 수정해야할것
    type: "GET",
    dataType: "json",
    success: function (data) {
      csum = 0;
      $(".success_sbj_wrap").empty();
      data?.result?.data?.courseList.forEach((c) => {
        csum += c.grade;
        var subjects =
            "<tr class='subject_info success_subject_info'>" +
            "<td>" +
            "<button class='red_btn success_delete_btn' id='success_delete'>삭제</button>" +
            "</td>" +
            "<td>" +
            c.department +
            "</td>" +
            "<td>" +
            c.division +
            "</td>" +
            "<td class='courseId'>" +
            c.courseId +
            "</td>" +
            "<td>" +
            c.courseName +
            "</td>" +
            "<td>" +
            c.grade +
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

        $(".success_sbj_wrap").append(subjects);})

      $('#bg3').empty();
      $('#bg3').append(csum);
      $('#bg1').empty();
      $('#bg1').append(21-bsum - csum);
      getSchedule();
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
    url: "/api/cart", //나중에 수정해야할것
    type: "GET",
    dataType: "json",
    success: function (data) {
      $(".basket_info_wrap").empty();
      bsum = 0;
      data?.result?.data?.courses.forEach((c) => {
        bsum += c.grade;
        var subjects =
            "<tr class='basket_info'>" +
            "<td>" +
            "<button class='blue_btn apply_btn' id='sign_up_btn'>수강신청</button>" +
            "</td>" +
            "<td>" +
            "<button class='red_btn basket_delete_btn' id='basket_delete'>장바구니 삭제</button>" +
            "</td>" +
            "<td>" +
            c.department +
            "</td>" +
            "<td>" +
            c.division +
            "</td>" +
            "<td class='courseId'>" +
            c.id +
            "</td>" +
            "<td>" +
            c.courseName +
            "</td>" +
            "<td>" +
            c.grade +
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
      });
      $('#bg2').empty();
      $('#bg2').append(bsum);
      $('#bg1').empty();
      $('#bg1').append(21-bsum - csum);
      getSchedule();
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
  $(document).on("click", ".subject_info", function (e) {
    if(e.target.outerText === "장바구니 추가"){

    let courseId = e.currentTarget.childNodes[3].innerText;
    $.ajax({
      url: `/api/cart/${courseId}`, //나중에 수정해야할것
      type: "post",
      success: function (data) {
        alert("장바구니에 추가되었습니다."); //테스트
        basketList();
      },
      error: function (error) {
        alert(error.responseJSON.result.message);
      },
    });
    }
  });

//수강신청 / 장바구니 삭제 버튼 클릭
  $(document).on("click", ".basket_info", function (e) {
    let courseId = e.currentTarget.childNodes[4].innerText;

    if(e.target.outerText === "수강신청"){
    console.log("수강신청")
    $.ajax({
      url: `/api/signupCourse/${courseId}`, //나중에 수정해야할것
      type: "post",
      success: function (data) {
        alert("수강신청에 성공했습니다."); //테스트
        basketList();
        successList();
      },
      error: function () {
        alert(error.responseJSON.result.message);
      },
    });
    }

    else if(e.target.outerText === "장바구니 삭제"){
      console.log("장바구니 삭제")
      if (!confirm("삭제하시겠습니까?")) {
        return;
      }
      $.ajax({
        url: `/api/cart/${courseId}`, //나중에 수정
        type: "delete",

        success: function (result) {
          alert("해당 과목이 삭제되었습니다."); //테스트
          basketList();
        },
      });
    }
  });


//모두신청 버튼
  $(document).on("click", "#all_apply", function (e) {
    $.ajax({
      url: "/api/signupCourse/all", //나중에 수정해야할것
      type: "post",
      success: function (data) {
        alert("수강신청을 모두 완료했습니다."); //테스트
        basketList();
        successList();
      },
      error: function () {
        alert(error.responseJSON.result.message);
      },
    });
  });


//수강확정 삭제버튼
  $(document).on("click", ".success_subject_info", function (e) {
    if(e.target.outerText === "삭제"){
    let courseId = e.currentTarget.childNodes[3].innerText;
    if (!confirm("삭제하시겠습니까?")) {
      return;
    }
    $.ajax({
      url: `/api/signupCourse/${courseId}`, //나중에 수정
      type: "delete",
      success: function (result) {
        alert("해당 강좌가 삭제되었습니다.");
        successList();
      },
    });
    }
  });
