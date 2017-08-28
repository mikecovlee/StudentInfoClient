package cn.zz8z.studentinfoclient;

import android.app.*;
import android.database.*;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.content.*;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {
    public static int egg_count=0;
    public static StudentPassword password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void handle_help(View v)
    {
        AlertDialog.Builder b=new AlertDialog.Builder(this)
                .setTitle("帮助")
                .setMessage(R.string.help_alert)
                .setPositiveButton("好",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog,int which)
                    {
                    }
                });
                b.create()
                .show();
    }
    public void handle_login(View v)
    {
        EditText student_id=(EditText)findViewById(R.id.student_id);
        EditText id_number=(EditText)findViewById(R.id.id_number);
        EditText password=(EditText)findViewById(R.id.password);
        LoginActivity.password=new StudentPassword(new String[]{
                student_id.getText().toString(),id_number.getText().toString(),password.getText().toString()
        });
        if(!LoginActivity.password.isEmpty())
        {
            if(/*MainActivity.OnlineDatabase.verify(LoginActivity.password)*/true)
            {
                //Cursor result=MainActivity.LocalDatabase.rawQuery("select * from login_history",null);
            }
            Intent intent=new Intent(this,InfoActivity.class);
            startActivity(intent);
            finish();
        }else {
            AlertDialog.Builder b = new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setPositiveButton("好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            ++LoginActivity.egg_count;
            if (LoginActivity.egg_count > 5 && LoginActivity.egg_count < 8) {
                if (LoginActivity.egg_count > 6)
                    b.setMessage("真没彩蛋…");
                else
                    b.setMessage("别再点了，没有彩蛋！");
                b.setNegativeButton("行吧", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoginActivity.egg_count = 0;
                    }
                });
            }else{
                b.setMessage("请填写所有项目");
            }
            if (LoginActivity.egg_count > 7) {
                egg_count = 0;
                Intent intent = new Intent(this, EggActivity.class);
                startActivity(intent);
            } else {
                b.create()
                        .show();
            }
        }
    }
}