package com.example.b0302s.line2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {
    private TextView mTextView;
    private ImageButton imgButton;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Drawable alpha = ((ImageView)findViewById(R.id.sea_image)).getBackground();
        alpha.setAlpha(90);
        setTitle();
        backButton_Listner();
    }

    private void setTitle()
    {
        Intent intent = getIntent();
        String friends_name = intent.getExtras().getString("friends_name");
        mTextView = (TextView)findViewById(R.id.chat_title);
        mTextView.setText(friends_name);
    }

    private void backButton_Listner()
    {
        imgButton = (ImageButton) findViewById(R.id.back_to_friendlist);
        imgButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }
}
