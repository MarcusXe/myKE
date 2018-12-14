package com.example.xeby.myke.net;

import com.example.xeby.myke.entity.Classs;
import com.example.xeby.myke.entity.Course;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PC on 2016/9/26.
 * 解析HTML文档的类
 */
public class CourseParse {
    private static List<Classs> mClass=new ArrayList<>();
    private static final String TAG = "LoginParse";

    static boolean parseIsLoginSucceed(String data) {
        Document doc = Jsoup.parse(data);
        //查看登陆文档。
        Element element = doc.getElementById("xhxm");
        if (element != null) {
            return true;
        }
        return false;
    }

    /*解析个人课表*/
    static List<Classs> parsePersonal(String data) {
        Document doc = Jsoup.parse(data);
        //首先获取Table
        Element table = doc.getElementById("Table1");
        //然后获取table中的td节点
        Elements trs = table.select("tr");
        //移除不需要的参数，这里表示移除前两个数值。
        trs.remove(0);
        trs.remove(0);
        //遍历td节点
        for (int i = 0; i < trs.size(); ++i) {
            Element tr = trs.get(i);
            //获取tr下的td节点，要求
            Elements tds = tr.select("td[align]");
            //遍历td节点
            for (int j = 0; j < tds.size(); ++j) {
                Element td = tds.get(j);
                String str = td.text();
                //如果数值为空则不计算。
                if (str.length() > 1) {
                    mClass.addAll(parseCourseDetail(str,i,Integer.valueOf(td.attr("rowspan")),j));
                }
            }
        }
        return mClass;
    }

//    private static String parsePersonalCourse(String text) {
//        //正则表达式获取课名，和教室
//        //parsePersonalCourse(text);
//        return parseCourseDetail(text);
//     /*   parseCourseDetail(text);
//        Pattern courseNamePattern = Pattern.compile("^.+?(\\s{1})");
//        Matcher courseNameMatcher = courseNamePattern.matcher(text);
//        courseNameMatcher.find();
//        String str = courseNameMatcher.group(0);
//
//        Pattern courseLocPattern = Pattern.compile("\\s*[\\u4e00-\\u9fa5]+[A-Z]*\\d{1,3}");
//        Matcher courseLocMatcher = courseLocPattern.matcher(text);
//        courseLocMatcher.find();
//        String data = courseLocMatcher.group(0);
//
//        return str+"@"+data;*/
//    }

    //星期几
    private static int getDayOfWeek(String s) {
        int day = -1;
        switch (s) {
            case "周一":
                day = 0;
                break;
            case "周二":
                day = 1;
                break;
            case "周三":
                day = 2;
                break;
            case "周四":
                day = 3;
                break;
            case "周五":
                day = 4;
                break;
            case "周六":
                day = 5;
                break;
            case "周日":
                day = 6;
                break;
            default:
                break;
        }
        return day;
    }

    // 单双周
    private static int getType(String s) {
        int r = 0;
        if (s.contains("|")) {
            String t = s.split("\\|")[1].replace("}", "");
            switch (t) {
                case "双周":
                    r = 2;
                    break;
                case "单周":
                    r = 1;
            }
        }
        return r;
    }
    private static int getWeek(String s){
        int i;
        Pattern courseNamePattern = Pattern.compile("\\d+");
        Matcher courseNameMatcher = courseNamePattern.matcher(s);
        courseNameMatcher.find();
        i=Integer.valueOf(courseNameMatcher.group(0));
        return i;
    }

    private static List<Classs> parseCourseDetail(String text,int start,int cou,int day) {
//        Pattern courseLocPattern = Pattern.compile("\\s*[\\u4e00-\\u9fa5]+[A-Z]*\\d{1,3}");
        List<Classs> mClass = new ArrayList<>();
//        Classs m
        String[] items = text.split(" ");

        for (int i = 0, j = 0; i < items.length; i++) {
            if (items[i].contains("{")) {
                Classs mC = new Classs();
                mC.setClassName(items[i - 1]);
                mC.setTeacherName(items[i + 1]);
                mC.setLocation(items[i + 2]);
//                mC.setCount(items[i].split(",").length);
                mC.setCount(cou);
                mC.setDay(day);
                mC.setStartWeek(getWeek(items[i].split("-")[0].substring(items[i].split("-")[0].length()-3)));
                mC.setEndWeek( getWeek(items[i].split("-")[1].substring(0,3)));
                mC.setStart(start);
                mC.setType(getType(items[i]));
//                if (items[i+3].contains("(")){
//                    mC.setTestdDay();
//                }
                mClass.add(mC);
            }

        }
        return mClass;
    }
}
