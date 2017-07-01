package com.example.b0302s.line2;

import android.app.LocalActivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabHost tabHost = (TabHost) findViewById(R.id.tabhost_main);
        LocalActivityManager mLocalActivityManager = new LocalActivityManager(this, false);
        mLocalActivityManager.dispatchCreate(savedInstanceState);
        tabHost.setup(mLocalActivityManager);
        //tabHost.setup();

        // 첫번째 탭
        intent = new Intent().setClass(this, FriendsList.class);
        TabHost.TabSpec ts_friendlist = tabHost.newTabSpec("friendlist");
        ts_friendlist.setIndicator("", getResources().getDrawable(R.drawable.tab_selector_friendslist));
        ts_friendlist.setContent(intent);
        tabHost.addTab(ts_friendlist);

        // 두번째 탭
        // 차후 채팅룸 추가 필요!!!!!
        intent = new Intent().setClass(this, ChattingListActivity.class);
        TabHost.TabSpec ts_chat = tabHost.newTabSpec("chatlist");
        ts_chat.setIndicator("", getResources().getDrawable(R.drawable.tab_selector_chatroom));
        ts_chat.setContent(intent);
        tabHost.addTab(ts_chat);


        // 세번째 탭
        intent = new Intent().setClass(this, TimelineActivity.class);
        TabHost.TabSpec ts_timeline = tabHost.newTabSpec("timeline");
        ts_timeline.setIndicator("", getResources().getDrawable(R.drawable.tab_selector_timeline));
        ts_timeline.setContent(intent);
        tabHost.addTab(ts_timeline);

        //네번째 탭
        //폰콜 activity 추가 필요!!!
        intent = new Intent().setClass(this, TimelineActivity.class);
        TabHost.TabSpec ts_phonecall = tabHost.newTabSpec("phonecall");
        ts_phonecall.setIndicator("", getResources().getDrawable(R.drawable.tab_selector_phonecall));
        ts_phonecall.setContent(intent);
        tabHost.addTab(ts_phonecall);

        //다섯째 탭
        intent = new Intent().setClass(this, SettingsActivity.class);
        TabHost.TabSpec ts_settings = tabHost.newTabSpec("settings");
        ts_settings.setIndicator("", getResources().getDrawable(R.drawable.tab_selector_settings));
        ts_settings.setContent(intent);
        tabHost.addTab(ts_settings);
    }
}
