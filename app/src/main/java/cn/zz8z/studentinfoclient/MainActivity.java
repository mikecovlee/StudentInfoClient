package cn.zz8z.studentinfoclient;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;

/**
 * Created by Mike Lee on 2016/10/15.
 */

class background_task extends AsyncTask<Void,Void,Void>
{
    MainActivity mThis;
    background_task(MainActivity ma)
    {
        mThis=ma;
    }
    @Override
    protected Void doInBackground(Void...params) {
        try
        {
            Thread.sleep(2000);
        }catch (InterruptedException e)
        {
        }
        Intent intent=new Intent(mThis,LoginActivity.class);
        mThis.startActivity(intent);
        mThis.finish();
        return null;
    }
}

public class MainActivity extends Activity {
    public static DatabaseConnector OnlineDatabase;
    public static SQLiteDatabase LocalDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化在线数据库
        // OnlineDatabase.connect(this.getResources().getString(R.string.DataBaseUrl));
        LocalDatabase=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/studentinfo.db3",null);
        background_task task=new background_task(this);
        task.execute();
    }
}