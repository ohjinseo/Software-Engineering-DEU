package com.sw9.swe.domain.schedule;

import com.sw9.swe.domain.course.Course;
import com.sw9.swe.exception.ScheduleConflictException;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

// zero base index
// 월[1-3] -> [0-2]

@Data
public class Schedule {
    private Boolean[][] dates = new Boolean[5][10];

    public Schedule(List<Course> courses) {

        // false로 초기화
        for (Boolean[] a : dates) {
            Arrays.fill(a, false);
        }

        courses.forEach(c->{
            // 월[2-3],화[1-2]
            String[] timeInfo = c.getTimeInfo().split(",");

            for (String s : timeInfo) {

                char day = s.trim().charAt(0); // 요일을 꺼내옴

                // 월[2-3] 에서 첫 시간과 끝 시간 꺼내옴
                int firstPoint = Integer.parseInt(String.valueOf(s.trim().charAt(2)));
                int secondPoint = Integer.parseInt(String.valueOf(s.trim().charAt(4)));

                for (int k = firstPoint - 1; k < secondPoint; k++) {
                    // 요일에 해당하는 enum 상수 값
                    dates[Week.valueOf(String.valueOf(day)).ordinal()][k] = true;
                }
            }
        });
        System.out.println(Arrays.deepToString(dates));
    }

    // 강의가 추가될 때 굳이 시간표 갱신이 필요 없음 -> 중복되는지 확인만 해주면됨!!
    public void isConflictSchedule(Course course) { // 생성된 시간표, 추가할 강의 주입

        String[] timeInfo = course.getTimeInfo().split(",");

        for (String s : timeInfo) {

            char day = s.trim().charAt(0);

            int firstPoint = Integer.parseInt(String.valueOf(s.trim().charAt(2)));
            int secondPoint = Integer.parseInt(String.valueOf(s.trim().charAt(4)));

            for (int k = firstPoint - 1; k < secondPoint; k++) {
                if (dates[Week.valueOf(String.valueOf(day)).ordinal()][k]) {
                    throw new ScheduleConflictException(course.getCourseName() + " : " + day + "요일 [" + firstPoint + "-" + secondPoint +"]교시 시간표가 겹칩니다.");
                }
            }
        }
    }
}
