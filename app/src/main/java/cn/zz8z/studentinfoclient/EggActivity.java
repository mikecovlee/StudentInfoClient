package cn.zz8z.studentinfoclient;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.ImageView;
import android.graphics.*;

/**
 * Created by Mike Lee on 2016/10/15.
 */

public class EggActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg);
        paint p=(paint)findViewById(R.id.paint);
        p.setActivity(this);
    }
}