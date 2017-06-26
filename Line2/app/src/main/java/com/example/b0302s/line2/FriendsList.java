package com.example.b0302s.line2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        ListView listView = (ListView)findViewById(R.id.friend_list);

        ArrayList<item_friends_list> data = new ArrayList<>();
        item_friends_list friend1 = new item_friends_list(R.drawable.profile, "friends1");
        item_friends_list friend2 = new item_friends_list(R.drawable.profile, "friends2");
        item_friends_list friend3 = new item_friends_list(R.drawable.profile, "friends3");
        item_friends_list friend4 = new item_friends_list(R.drawable.profile, "friends4");

        data.add(friend1);
        data.add(friend2);
        data.add(friend3);
        data.add(friend4);

        Friends_ListviewAdapter adapter = new Friends_ListviewAdapter(this, R.layout.item_friends_list, data);
        listView.setAdapter(adapter);
    }
}
