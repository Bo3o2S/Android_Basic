package com.example.b0302s.line2;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class TimelineActivity extends AppCompatActivity {
    private ImageView imageView_photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        TextView textView_write = (TextView)findViewById(R.id.write_timeline);
        onClick_Writetimeline_Listener(textView_write);
        TextView textView_photo = (TextView)findViewById(R.id.photo_timeline);
        onClick_Phototimeline_Listener(textView_photo);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
    public void onClick_Writetimeline_Listener(TextView textView)
    {
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimelineActivity.this, Write_TimeLineActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    public void onClick_Phototimeline_Listener(TextView textView)
    {
        imageView_photo = (ImageView)findViewById(R.id.picture_timeline);
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        imageView_photo.setImageURI(data.getData());
    }
}
