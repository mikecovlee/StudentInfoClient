package cn.zz8z.studentinfoclient;

/**
 * Created by Mike Lee on 2016/10/16.
 */

public class StudentInfo {
    public enum Grades
    {
        Grade_One,Grade_Two,Grade_Three
    }
    public enum Terms
    {
        First,Second
    }
    public enum Tests
    {
        First,Second,Middle,End
    }
    public enum Objects
    {
        Chinese,Math,English,Physics,Chemistry,Biology,Politics,History,Geography,Summary
    }
    public Grades myGrade;
    public Terms myTerm;
    public Tests myTest;
    public Objects myObject;
    public Float myScore=new Float(0);
    public Boolean havePlaceOfClass=new Boolean(false);
    public Integer myPlaceOfClass=new Integer(0);
    public Integer myPlaceOfGrade=new Integer(0);
}
