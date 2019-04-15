package org.danas.customprogress.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * 线性progress
 */
public class LinearProgress extends BaseProgress {
    private int bgCoclor = 0xff999999;//背景颜色
    private int progressCoclor = 0xffFFD700;//进度条颜色颜色
    private boolean isRound = false;//背景是否圆角

    public LinearProgress(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public LinearProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public LinearProgress setHeightPX(int height) {
        heightPX = height;
        return this;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    /**
     * 设置进度条背景颜色 默认0xff999999
     *
     * @param bgCoclor
     */
    public LinearProgress setBgCoclor(int bgCoclor) {
        this.bgCoclor = bgCoclor;
        return this;
    }


    /**
     * 是否圆角 圆角半径为高度的一办
     *
     * @param round
     */
    public LinearProgress setRound(boolean round) {
        isRound = round;
        return this;
    }

    /**
     * 进度色彩
     *
     * @param progressCoclor
     */
    public LinearProgress setProgressCoclor(int progressCoclor) {
        this.progressCoclor = progressCoclor;
        return this;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBg(canvas);
        drawProgress(canvas);
    }


    /**
     * 绘制背景
     */
    private void drawBg(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(bgCoclor);
        paint.setStyle(Paint.Style.FILL);//充满
        paint.setAntiAlias(true);// 设置画笔的锯齿效果
        RectF rectF = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());// 设置个新的长方形
        if (isRound) {
            canvas.drawRoundRect(rectF, getMeasuredHeight() / 2, getMeasuredHeight() / 2, paint);//第二个参数是x半径，第三个参数是y半径
        } else {
            canvas.drawRect(rectF, paint);
        }
    }

    /**
     * 绘制进度条
     *
     * @param canvas
     */
    private void drawProgress(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(progressCoclor);
        paint.setStyle(Paint.Style.FILL);//充满
        paint.setAntiAlias(true);// 设置画笔的锯齿效果
        if (isRound) {
            if (progress == 0) return;
            if (progress >= max) {
                RectF rectPro = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
                canvas.drawRoundRect(rectPro, getMeasuredHeight()/2, getMeasuredHeight()/2, paint);
                return;
            }
            RectF rectAce = new RectF(0, 0, getMeasuredHeight(), getMeasuredHeight());
            canvas.drawArc(rectAce, //弧线所使用的矩形区域大小
                    90,  //开始角度
                    180, //扫过的角度
                    false, //是否使用中心
                    paint);
            int progressWidth = getMeasuredWidth() * progress / max;
            if(progressWidth > getMeasuredWidth() - getMeasuredHeight()/2) {
                progressWidth = getMeasuredWidth() - getMeasuredHeight()/2;
            }
            if (progressWidth > getMeasuredHeight() / 2) {
                RectF rectPro = new RectF(getMeasuredHeight() / 2, 0, progressWidth, getMeasuredHeight());
                canvas.drawRect(rectPro, paint);//第二个参数是x半径，第三个参数是y半径
            }
        } else {
            RectF rectF = new RectF(0, 0, getMeasuredWidth() * progress / max, getMeasuredHeight());// 设置个新的长方形
            canvas.drawRect(rectF, paint);
        }
    }
}
