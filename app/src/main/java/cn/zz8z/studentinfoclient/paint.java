package cn.zz8z.studentinfoclient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class paint extends View {
    private float mX=-1;
    private float mY=-1;
    private Paint p=new Paint();
    private Bitmap bitmap;
    public paint(Context context) {
        super(context);
    }
    public paint(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    void setActivity(EggActivity e)
    {
        bitmap=((BitmapDrawable)e.getResources().getDrawable(R.drawable.image)).getBitmap();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setAntiAlias(true);
        if(mX<0&&mY<0)
        {
            mX=(float)0.5*canvas.getWidth();
            mY=(float)0.5*canvas.getHeight();
        }
        mX-=(float)0.5*bitmap.getWidth();
        mY-=(float)0.5*bitmap.getHeight();
        canvas.drawBitmap(bitmap,mX,mY,p);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mX=event.getX();
        mY=event.getY();
        invalidate();
        return true;
    }
}
