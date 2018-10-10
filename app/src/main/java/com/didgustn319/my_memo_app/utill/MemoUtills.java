package com.didgustn319.my_memo_app.utill;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoUtills {

    public static String getCurrentDate() {
        // 현재날짜 구하기
        // level 26(Nogut)이상에서는 LocalDataTime 이라는 클래스를
        // 사용할 수 있다.
        // 현재 level 23(Mash)에서는 사용 불가

        // 1. 현재 시스템의 시간(UNIX Time)을 가져온다.
        // System.currentTimeMillis()
        long now = System.currentTimeMillis();

        Log.d("CURDATE",":" + now);
        // 2. Date 객체 생성
        Date date = new Date(now);

        // 3. 날짜형 문자열로 변환환
        //  가. 문자열 포멧을 설정
        SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
        String getDate = sDate.format(date);

        //  나. 시간의 문자열 포멧을 설정
        SimpleDateFormat sTime = new SimpleDateFormat("HH:mm:SS");
        String getTime = sTime.format(date);

        return getDate + " " + getTime;
    }
}
