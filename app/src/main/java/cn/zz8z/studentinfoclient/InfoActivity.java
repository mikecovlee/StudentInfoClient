package cn.zz8z.studentinfoclient;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Mike Lee on 2016/10/15.
 */

public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        TextView welcome_text=(TextView)findViewById(R.id.welcome_text);
        TextView studentid_text=(TextView)findViewById(R.id.studentid_text);
        welcome_text.setText("欢迎，"+LoginActivity.password.getIdNumber());
        studentid_text.setText("您的学号为:"+LoginActivity.password.getStudentId());
    }
    public void handle_find(View v)
    {
        StudentInfo info=new StudentInfo();
        Spinner grade=(Spinner)findViewById(R.id.spinner_grade);
        Spinner term=(Spinner)findViewById(R.id.spinner_term);
        Spinner test=(Spinner)findViewById(R.id.spinner_type);
        Spinner object=(Spinner)findViewById(R.id.spinner_object);
        switch (grade.getSelectedItemPosition())
        {
            case 0:
                info.myGrade=StudentInfo.Grades.Grade_One;
                break;
            case 1:
                info.myGrade=StudentInfo.Grades.Grade_Two;
                break;
            case 2:
                info.myGrade=StudentInfo.Grades.Grade_Three;
                break;
        }
        switch (term.getSelectedItemPosition())
        {
            case 0:
                info.myTerm=StudentInfo.Terms.First;
                break;
            case 1:
                info.myTerm=StudentInfo.Terms.Second;
                break;
        }
        switch (test.getSelectedItemPosition())
        {
            case 0:
                info.myTest=StudentInfo.Tests.First;
                break;
            case 1:
                info.myTest=StudentInfo.Tests.Middle;
                break;
            case 2:
                info.myTest=StudentInfo.Tests.Second;
                break;
            case 3:
                info.myTest=StudentInfo.Tests.End;
                break;
        }
        switch (object.getSelectedItemPosition())
        {
            case 0:
                info.myObject=StudentInfo.Objects.Chinese;
                break;
            case 1:
                info.myObject=StudentInfo.Objects.Math;
                break;
            case 2:
                info.myObject=StudentInfo.Objects.English;
                break;
            case 3:
                info.myObject=StudentInfo.Objects.Physics;
                break;
            case 4:
                info.myObject=StudentInfo.Objects.Chemistry;
                break;
            case 5:
                info.myObject=StudentInfo.Objects.Biology;
                break;
            case 6:
                info.myObject=StudentInfo.Objects.Politics;
                break;
            case 7:
                info.myObject=StudentInfo.Objects.History;
                break;
            case 8:
                info.myObject=StudentInfo.Objects.Geography;
                break;
            case 9:
                info.myObject=StudentInfo.Objects.Summary;
                info.havePlaceOfClass=true;
                break;
        }
        //MainActivity.OnlineDatabase.getInfo(LoginActivity.password,info);
        AlertDialog.Builder b = new AlertDialog.Builder(this)
                .setTitle("查询结果");
        b.setPositiveButton("好", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        String[] items;
        if(info.havePlaceOfClass)
            items=new String[]{
                    "分数:"+info.myScore.toString(),"名次(年级):"+info.myPlaceOfGrade.toString(),"名次(班级):"+info.myPlaceOfClass.toString()
            };
        else
            items=new String[]{
                    "分数:"+info.myScore.toString(),"名次(年级):"+info.myPlaceOfGrade.toString()
            };
        b.setItems(items,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        b.create().show();
    }
}
