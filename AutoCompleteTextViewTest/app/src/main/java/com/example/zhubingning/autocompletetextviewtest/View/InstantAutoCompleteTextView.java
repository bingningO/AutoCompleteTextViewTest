package com.example.zhubingning.autocompletetextviewtest.View;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;

/**
 * Created by zhubingning on 16/09/11.
 */
public class InstantAutoCompleteTextView extends AutoCompleteTextView {

    public InstantAutoCompleteTextView(Context context) {
        super( context );
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attrs) {
        super( context, attrs );
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super( context, attrs, defStyle );
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused && getAdapter() != null) {
            performFiltering(getText(), KeyEvent.KEYCODE_UNKNOWN);
        }
    }

    @Override
    public boolean enoughToFilter() {
        return true;
    }

}