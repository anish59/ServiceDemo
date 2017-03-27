package com.example.anish.servicedemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;

import android.view.View;
import android.widget.TextView;

import com.example.anish.servicedemo.helper.AppConstants;


public class HomeActivity extends AppCompatActivity {
    TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvDetail = (TextView) findViewById(R.id.txtDescription);
        tvDetail.setText(AppConstants.APP_DESCRIPTION);
        tvDetail.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void clickSkip(View view) {
        startActivity(new Intent(HomeActivity.this, MainActivity.class));
    }

    public void clickDownload(View view) {
        Uri uri = Uri.parse("https://github.com/anish59/ServiceDemo"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
