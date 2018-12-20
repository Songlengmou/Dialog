package com.anningtex.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 自定义简单的Dialog
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAssessmentView assessmentView = new MyAssessmentView(MainActivity.this);
                assessmentView.setOnSureClickListener(new MyAssessmentView.OnSureClickListener() {
                    @Override
                    public void onSureClick() {

                    }
                });
                assessmentView.show();
            }
        });
    }
}
