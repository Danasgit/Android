package org.danas.customprogress.progress;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * 进度条基类
 */
public class BaseProgress extends FrameLayout {
    protected int max = 100;//进度条的最大值
    protected int progress = 0;//进度值
    protected int heightPX = 20;//进度条高度

    BaseProgress(Context context) {
        super(context);
    }

    BaseProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    /**
     * 设置进度条高度
     * @param height
     * @return
     */
    public BaseProgress setHeightPX(int height) {
        this.heightPX = height;
        return this;
    }

    public int getHeightPX() {
        return heightPX;
    }

    /**
     *
     * @param progress  进度值
     * @return
     */
    public BaseProgress setProgress(int progress) {
        this.progress = progress;
        return this;
    }

    /**
     *
     * @param max 进度条最大值
     */
    public BaseProgress setMax(int max) {
        this.max = max;
        return this;
    }
}
