package com.example.b0302s.line2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Write_TimeLineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write__time_line);

        ImageView close_write_timeline = (ImageView)findViewById(R.id.close_write_timeline);
        onClick_Finish_Listener(close_write_timeline);

    }

    public void onClick_Finish_Listener(ImageView imageView)
    {
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }
}
