package com.digitalsmartsoil.app.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomProgressBar extends View {
    private float progress = 0f;
    private int progressColor = Color.GREEN;
    private Paint progressPaint;
    private Paint backgroundPaint;
    private int barHeight = 10;

    public CustomProgressBar(Context context) {
        super(context);
        init();
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        progressPaint = new Paint();
        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.LTGRAY);
    }

    public void setProgress(float progress) {
        this.progress = Math.min(progress, 100f);
        progressPaint.setColor(progressColor);
        invalidate();
    }

    public void setProgressColor(int color) {
        this.progressColor = color;
    }

    public void animateProgress(float targetProgress) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", progress, targetProgress);
        animator.setDuration(1000);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        int width = getWidth();
        int height = getHeight();
        
        // Draw background
        canvas.drawRect(0, (height - barHeight) / 2, width, (height + barHeight) / 2, backgroundPaint);
        
        // Draw progress
        float progressWidth = (progress / 100f) * width;
        canvas.drawRect(0, (height - barHeight) / 2, progressWidth, (height + barHeight) / 2, progressPaint);
    }
}
