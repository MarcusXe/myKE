package com.example.xeby.myke.entity;

/**
 * Created by PC on 2016/9/23.
 *
 */
public class Classs {
    ///;p'p
    private int day=-1;
    private int start=-1;
    private int count=-1;
    private String className=null;
    private String teacherName=null;
    private String location=null;
    private int startWeek=-1;
    private int endWeek=-1;
    private int testWeek=-1;
    private int testDay=-1;
    private String testLocation=null;
    private int testStartClass=-1;
    private  int testClassCount=-1;

    public Classs(int day, int start, int count, String className, String teacherName, String location, int startWeek, int endWeek) {
        this.day = day;
        this.start = start;
        this.count = count;
        this.className = className;
        this.teacherName = teacherName;
        this.location = location;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }
    public Classs(){};



    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }


    public String getTestLocation() {
        return testLocation;
    }

    public void setTestLocation(String testLocation) {
        this.testLocation = testLocation;
    }


    public int getTestDay() {
        return testDay;
    }

    public void setTestDay(int testDay) {
        this.testDay = testDay;
    }
    public int getTestWeek() {
        return testWeek;
    }

    public void setTestWeek(int testWeek) {
        this.testWeek = testWeek;
    }

    public int getTestStartClass() {
        return testStartClass;
    }

    public void setTestStartClass(int testStartClass) {
        this.testStartClass = testStartClass;
    }

    public int getTestClassCount() {
        return testClassCount;
    }

    public void setTestClassCount(int testClassCount) {
        this.testClassCount = testClassCount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type=0;

}


