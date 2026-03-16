package com.digitalsmartsoil.app.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;

public class GlassCardView extends CardView {
    
    public GlassCardView(Context context) {
        super(context);
        init();
    }

    public GlassCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setRadius(12);
        setCardElevation(8);
        setContentPadding(16, 16, 16, 16);
    }

    public void setGlassStyle() {
        setAlpha(0.9f);
        setElevation(0);
    }
}
