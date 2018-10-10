package com.didgustn319.my_memo_app.database;

import android.os.SystemClock;
import android.util.Log;

import com.didgustn319.my_memo_app.utill.MemoUtills;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoVO {

    private String memoKey;
    private String memoCat;
    private String memoTitle;
    private String memoInDate;
    private String memoYeDate;
    private String memoFinishDate;
    private String memoText;

    public MemoVO() {
    }

    // memoText만으로 객체를 생성해서
    // 제목, 입력일자를 자동으로 생성하기


    public MemoVO(String memoText) {

        String curDateTime = MemoUtills.getCurrentDate();

        this.memoInDate = curDateTime;
        this.memoTitle = curDateTime + "에 만든 메모";
        this.memoText = memoText;

    }

    public String getMemoKey() {
        return memoKey;
    }

    public void setMemoKey(String memoKey) {
        this.memoKey = memoKey;
    }

    public String getMemoCat() {
        return memoCat;
    }

    public void setMemoCat(String memoCat) {
        this.memoCat = memoCat;
    }

    public String getMemoTitle() {
        return memoTitle;
    }

    public void setMemoTitle(String memoTitle) {
        this.memoTitle = memoTitle;
    }

    public String getMemoInDate() {
        return memoInDate;
    }

    public void setMemoInDate(String memoInDate) {
        this.memoInDate = memoInDate;
    }

    public String getMemoYeDate() {
        return memoYeDate;
    }

    public void setMemoYeDate(String memoYeDate) {
        this.memoYeDate = memoYeDate;
    }

    public String getMemoFinishDate() {
        return memoFinishDate;
    }

    public void setMemoFinishDate(String memoFinishDate) {
        this.memoFinishDate = memoFinishDate;
    }

    public String getMemoText() {
        return memoText;
    }

    public void setMemoText(String memoText) {
        this.memoText = memoText;
    }

    @Override
    public String toString() {
        return "MemoVO{" +
                "memoTitle='" + memoTitle + '\'' +
                ", memoInDate='" + memoInDate + '\'' +
                ", memoYeDate='" + memoYeDate + '\'' +
                ", memoFinishDate='" + memoFinishDate + '\'' +
                ", memoText='" + memoText + '\'' +
                '}';
    }
}
