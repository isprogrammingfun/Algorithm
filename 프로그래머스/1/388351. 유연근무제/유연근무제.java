import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int cnt = 0;
            for(int j = 0; j < 7; j++) {
            int currentDay = (startday + j - 1) % 7 + 1;
            if(currentDay == 6 || currentDay == 7)
                continue;
                
            int schedule = schedules[i];
            int timelog = timelogs[i][j];
                
            // 시간을 분 단위로 변환
            int scheduleMinutes = (schedule / 100) * 60 + (schedule % 100);
            int timelogMinutes = (timelog / 100) * 60 + (timelog % 100);

            // 10분 이내 차이 체크
            if(Math.abs(timelogMinutes - scheduleMinutes) <= 10)
                cnt++;
            // 일찍 온 경우
            else if(timelogMinutes < scheduleMinutes)
                cnt++;
            }
            if(cnt == 5)
                answer++;
        }
        return answer;
    }
}