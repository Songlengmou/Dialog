package com.anningtex.test;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MyAssessmentView extends Dialog implements View.OnClickListener {
    private Context context;
    private MyAssessmentView.OnSureClickListener listener;
    private TextView tv_ok, tv_cancel;

    public MyAssessmentView(@NonNull Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_view);
        setCanceledOnTouchOutside(false);

        showDialog();
    }

    private void showDialog() {
        Window window = getWindow();
        //设置弹窗动画
        window.setWindowAnimations(R.style.style_dialog);
        WindowManager.LayoutParams wl = window.getAttributes();
        //设置Dialog位置
        wl.gravity = Gravity.CENTER;
        window.setAttributes(wl);

        tv_ok = findViewById(R.id.tv_ok);
        tv_cancel = findViewById(R.id.tv_cancel);
        tv_ok.setOnClickListener(this);
        tv_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_ok:
                if (listener != null) {
                    listener.onSureClick();
                }
                dismiss();
                break;
            case R.id.tv_cancel:
                dismiss();
                break;
        }
    }

    public void setOnSureClickListener(MyAssessmentView.OnSureClickListener listener) {
        this.listener = listener;
    }

    public interface OnSureClickListener {
        void onSureClick();
    }
}
