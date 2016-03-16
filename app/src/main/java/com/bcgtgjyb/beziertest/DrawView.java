package com.bcgtgjyb.beziertest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bigwen on 2016/3/16.
 */
public class DrawView extends View {

    private Context mContext;
    private Paint paintRed;
    private Paint paintBlack;

    public DrawView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        paintRed = new Paint();
        paintBlack = new Paint();
        paintRed.setColor(Color.WHITE);
        paintBlack.setColor(Color.BLACK);
        paintBlack.setStrokeWidth(40);
        paintRed.setStrokeWidth(42);
        paintBlack.setStyle(Paint.Style.STROKE);
        paintRed.setStyle(Paint.Style.STROKE);
        paintRed.setAntiAlias(true);
        paintBlack.setAntiAlias(true);

        Xfermode xFermode = new PorterDuffXfermode(PorterDuff.Mode.DARKEN);
        paintRed.setXfermode(xFermode);
        paintBlack.setXfermode(xFermode);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF f = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
//        canvas.drawArc(f, 0, 360, false, paintBlack);
//        canvas.drawArc(f, 0, 120, false, paintRed);
//        canvas.drawArc(f, 120, 90, false, paintRed);
//
//        canvas.drawLine(0, 0, 50, 50, paintBlack);
//        canvas.drawLine(50, 50, 100, 100, paintBlack);
        PointF pointF = new PointF();
        pointF.set(getWidth()/2,getHeight()/2);
        ArcUtils.drawArc(canvas, pointF, getWidth() / 2 - getPaddingLeft(), 0, 360, paintBlack);
        ArcUtils.drawArc(canvas,pointF,getWidth()/2-getPaddingLeft(),0,120,paintRed);
//        Path p = new Path();
//        float[] a = drawPath90(getWidth()/2,getHeight()/2,getWidth(),0,50);
//        p.moveTo(a[0],a[1]);
//        p.cubicTo(a[2], a[3], a[4], a[5], a[6], a[7]);
//        canvas.drawPath(p, paintBlack);
//        canvas.drawPath(p,paintRed);
    }

    private float[] drawPath90(float xc, float yc, float r, float startAngle, float endAngle) {
        float a = (endAngle - startAngle) / 3;
        float x1 = xc + (float) Math.cos(startAngle) * r;
        float y1 = yc + (float) Math.sin(startAngle) * r;
        float x2 = (float) Math.cos(startAngle + a) * r + xc;
        float y2 = (float) Math.sin(startAngle + a) * r + yc;
        float x3 = (float) Math.cos(endAngle - a) * r + xc;
        float y3 = (float) Math.sin(endAngle - a) * r + yc;
        float x4 = xc + (float) Math.cos(endAngle) * r;
        float y4 = yc + (float) Math.sin(endAngle) * r;
        return new float[]{x1, y1, x2, y2, x3, y3, x4, y4};
    }
}
