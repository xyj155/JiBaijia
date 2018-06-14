package com.administrator.jibaijia.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.jibaijia.R;
import com.administrator.jibaijia.base.baseactivity.BaseActivity;

public class LoginActivity extends BaseActivity {


    @Override
    public void initListner() {

    }

    @Override
    public void initView() {
        TextView title = (TextView) findViewById(R.id.title);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        title.setTypeface(typeface);
        ImageView img_finish = (ImageView) findViewById(R.id.finish);
        img_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void handler(Message msg) {

    }
}
