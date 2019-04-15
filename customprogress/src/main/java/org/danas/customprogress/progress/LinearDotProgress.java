package org.danas.customprogress.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * 线性原点进度条
 */
public class LinearDotProgress extends BaseProgress {
    private int defultColor = 0xff999999;
    private int selectColor = 0xffFFD700;
    private int dotCount = 5;

    public LinearDotProgress(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    LinearDotProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    /**
     * @param defultColor 圆点默认的颜色
     * @return
     */
    public LinearDotProgress setDefultColor(int defultColor) {
        this.defultColor = defultColor;
        return this;
    }

    /**
     * 圆点被选中的color
     *
     * @param selectColor
     * @return
     */
    public LinearDotProgress setSelectColor(int selectColor) {
        this.selectColor = selectColor;
        return this;
    }

    /**
     * 圆点数量
     *
     * @param dotCount
     */
    public LinearDotProgress setDotCount(int dotCount) {
        this.dotCount = dotCount;
        return this;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int diameter = getMeasuredHeight();
        Paint paint = new Paint();
        for (int i = 0; i < dotCount; i++) {
            int cx = getMeasuredWidth() / (dotCount + 1) * (i +1);
            if (((float) progress / max) >= ((float) (i + 1)  / (dotCount+ 1))) {
                paint.setAntiAlias(true);
                paint.setColor(selectColor);
                canvas.drawCircle(cx, diameter / 2, diameter / 2, paint);
            } else {
                paint.setAntiAlias(true);
                paint.setColor(defultColor);
                canvas.drawCircle(cx, diameter / 2, diameter / 2, paint);
            }
        }

    }
}
