package org.danas.customprogress;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.danascustomprogeres.progress.BaseProgress;

public class DanasCustomProgress extends RelativeLayout {
    public  DanasCustomProgress(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public DanasCustomProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    /**
     * 添加自己目标效果的组件
     */
    public void add(BaseProgress progress) {
        LayoutParams params = new LayoutParams(-1, progress.getHeightPX());
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(progress, params);
        requestLayout();
        progress.requestLayout();
    }

}
