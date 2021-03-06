package base.tonghu.com.viewdraghelpertest;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by  on 4/14/16.
 */
public class DragLayout extends LinearLayout{
    private final ViewDragHelper mDragHelper;
    private View mDragView;

    public DragLayout(Context context) {
        this(context, null);
    }

    public DragLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mDragHelper = ViewDragHelper.create(this, 1.0f, new DragHelperCallback());
    }


    private class DragHelperCallback extends ViewDragHelper.Callback {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return false;
        }
    }
}
