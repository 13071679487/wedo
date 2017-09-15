package wedo.job.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Lifu on 2017/9/14.
 */

public class GuideLayout extends FrameLayout {
    public GuideLayout(Context context) {
        super(context);
    }

    public GuideLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GuideLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            try {
                child.dispatchTouchEvent(ev);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
