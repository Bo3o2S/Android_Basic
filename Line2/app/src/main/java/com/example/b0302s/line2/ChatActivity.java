package com.example.b0302s.line2;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Drawable alpha = ((ImageView)findViewById(R.id.sea_image)).getBackground();
        alpha.setAlpha(90);
    }
}
