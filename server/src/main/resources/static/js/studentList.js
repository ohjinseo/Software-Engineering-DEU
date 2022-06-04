$(document).ready(function () {
    getStudentList();
});

function getStudentList() {
    $.ajax({
        url: "/api/students", //수정
        type: "GET",
        dataType: "json",
        success: function (result) {
            result?.result?.data?.studentList?.forEach((s) => {
                var student =
                    "<ul class='stu_info_wrap'>" +
                    "<button class='list_edit blue_btn'>" +
                    "수정" +
                    "</button>" +
                    "<button class='list_delete red_btn'>" +
                    "삭제" +
                    "</button>" +
                    "<li class='stu_num'>" +
                    s.registrationNumber +
                    "</li>" +
                    +"<li class='stu_grade'>" +
                    s.grade +
                    "</li>" +
                    "<li class='stu_department'>" +
                    s.department +
                    "</li>" +
                    "<li class='stu_name'>" +
                    s.username +
                    "</li>" +
                    "</ul>";

                $(".list_info_main").append(student);
            });
        },
    });
}