package com.example.xeby.myke.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.xeby.myke.database.DbHelper;
import com.example.xeby.myke.entity.Classs;
import com.example.xeby.myke.entity.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2016/9/26.
 * 算作工具类，所以应该使用单例模式
 */
public class StuCourseDao {
    private SQLiteDatabase mDataBase;
    private static StuCourseDao sStuCourseDao;

    private StuCourseDao(Context context){
        mDataBase = new DbHelper(context).getWritableDatabase();
    }

    public static StuCourseDao getInstance (Context context){
        synchronized (StuCourseDao.class){
            if (sStuCourseDao == null){
                sStuCourseDao = new StuCourseDao(context);
            }
        }
        return sStuCourseDao;
    }

    public void saveStuCls(Classs course){
        ContentValues values = new ContentValues();
        values.put(DbHelper.STUCLS_NAME_COL, course.getClassName());
        values.put(DbHelper.STUCLS_DAY_COL, course.getDay());
        values.put(DbHelper.STUCLS_NUM_COL, course.getStart());
        values.put(DbHelper.STUCLS_COUNT_COL, course.getCount());
        values.put(DbHelper.TEACHER_NAME_COL, course.getTeacherName());
        values.put(DbHelper.LOCATION_COL, course.getLocation());
        values.put(DbHelper.START_WEEK_COL, course.getStartWeek());
        values.put(DbHelper.END_WEEK_COL, course.getEndWeek());
        values.put(DbHelper.TYPE, course.getType());
        values.put(DbHelper.TEST_WEEK, course.getTestWeek());
        values.put(DbHelper.TEST_DAY, course.getTestDay());
        values.put(DbHelper.TEST_LOCATION, course.getTestLocation());
        values.put(DbHelper.TEST_CLASS_START, course.getTestStartClass());
        values.put(DbHelper.TEST_CLASS_COUNT,course.getTestClassCount());
        //当相同的时候替换。
        mDataBase.insertWithOnConflict(DbHelper.TABLE_STUCLS,null,values,SQLiteDatabase.CONFLICT_REPLACE);
    }

    public void saveStuClsList(List<Classs> courses){
        for (Classs course : courses){
            saveStuCls(course);
        }
    }

    public List<Classs> getStuClsList(){
        List<Classs> courses = new ArrayList<>();
        Cursor cursor = mDataBase.rawQuery("select * from "+DbHelper.TABLE_STUCLS,null);
        while (cursor.moveToNext()){
            Classs  course = new Classs();
            course.setClassName(cursor.getString(
                    cursor.getColumnIndex(DbHelper.STUCLS_NAME_COL))
            );
            course.setStart(cursor.getInt(
                    cursor.getColumnIndex(DbHelper.STUCLS_NUM_COL)
            ));
            course.setDay(cursor.getInt(
                    cursor.getColumnIndex(DbHelper.STUCLS_DAY_COL)
            ));
            course.setCount(cursor.getInt(
                    cursor.getColumnIndex(DbHelper.STUCLS_COUNT_COL)
            ));
            course.setTeacherName(cursor.getString(
                    cursor.getColumnIndex(DbHelper.TEACHER_NAME_COL)
            ));
            course.setLocation(cursor.getString(
                    cursor.getColumnIndex(DbHelper.LOCATION_COL)
            ));
            course.setStartWeek(cursor.getInt(
                    cursor.getColumnIndex(DbHelper.START_WEEK_COL)
            ));
            course.setEndWeek(cursor.getInt(
                    cursor.getColumnIndex(DbHelper.END_WEEK_COL)
            ));
            course.setTestWeek(cursor.getInt(
                    cursor.getColumnIndex(DbHelper.TEST_WEEK)
            ));
            course.setTestDay(cursor.getInt(
                    cursor.getColumnIndex(DbHelper.TEST_DAY)
            ));
            course.setTestStartClass(cursor.getInt(
                    cursor.getColumnIndex(DbHelper.TEST_CLASS_START)
            ));
            course.setTestClassCount(cursor.getInt(
                    cursor.getColumnIndex(DbHelper.TEST_CLASS_COUNT)
            ));
            course.setType(cursor.getInt(
                    cursor.getColumnIndex(DbHelper.TYPE)
            ));
            course.setTestLocation(cursor.getString(
                    cursor.getColumnIndex(DbHelper.TEST_LOCATION)
            ));

            courses.add(course);
        }
        cursor.close();
        return courses;
    }

    public void removeAll(){
        //删除全部记录
        mDataBase.delete(DbHelper.TABLE_STUCLS,null,null);
    }
}
