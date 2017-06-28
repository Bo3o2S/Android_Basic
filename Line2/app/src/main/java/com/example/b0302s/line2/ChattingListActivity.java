package com.example.b0302s.line2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChattingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        ListView friends_listView = (ListView)findViewById(R.id.friend_list);
        ListView profile_listView = (ListView)findViewById(R.id.profile);

        ArrayList<item_profile_list> profile_data = new ArrayList<>();
        item_profile_list profile = new item_profile_list(R.drawable.profile, "이민재", "010-4432-5569");
        profile_data.add(profile);

        ArrayList<item_friends_list> data = new ArrayList<>();
        item_friends_list friend1 = new item_friends_list(R.drawable.profile, "친구1", "010-4433-5532");
        item_friends_list friend2 = new item_friends_list(R.drawable.profile, "친구2", "010-2256-2192");
        item_friends_list friend3 = new item_friends_list(R.drawable.profile, "친구3", "010-7654-4321");
        item_friends_list friend4 = new item_friends_list(R.drawable.profile, "친구4", "010-6643-4432");
        item_friends_list friend5 = new item_friends_list(R.drawable.profile, "친구5", "010-5522-4432");

        data.add(friend1);
        data.add(friend2);
        data.add(friend3);
        data.add(friend4);
        data.add(friend5);

        Profile_ListviewAdapter profile_adapter = new Profile_ListviewAdapter(this, R.layout.item_profile_list, profile_data);
        profile_listView.setAdapter(profile_adapter);
        Profilelist_ClickListner profile_listner = new Profilelist_ClickListner();
        profile_listView.setOnItemClickListener(profile_listner);

        Friends_ListviewAdapter adapter = new Friends_ListviewAdapter(this, R.layout.item_friends_list, data);
        friends_listView.setAdapter(adapter);
        Friendslist_ClickListner friendlist_listner = new Friendslist_ClickListner();
        friends_listView.setOnItemClickListener(friendlist_listner);

        TextView title = (TextView)findViewById(R.id.friend_titlebar);
        title.setText("대화");
        title.setTextSize(20);

        EditText search = (EditText)findViewById(R.id.search_bar);
        search.setHint("대화찾기");
        TextView profile_title = (TextView)findViewById(R.id.profile_name);
        TextView friend_title = (TextView)findViewById(R.id.friend);
        profile_title.setVisibility(View.GONE);
        friend_title.setVisibility(View.GONE);
    }

    private class Friendslist_ClickListner implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
        {
            item_friends_list data = (item_friends_list)adapterView.getItemAtPosition(position);
            Intent i = new Intent(ChattingListActivity.this, ChatActivity.class);
            i.putExtra("friends_name", data.getName());
            startActivity(i);
            onStop();
        }
    }

    private class Profilelist_ClickListner implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
        {
            item_profile_list data= (item_profile_list)adapterView.getItemAtPosition(position);
            Intent i = new Intent(ChattingListActivity.this, ChatActivity.class);
            i.putExtra("friends_name", data.getName());
            startActivity(i);
            onStop();
        }
    }

}
