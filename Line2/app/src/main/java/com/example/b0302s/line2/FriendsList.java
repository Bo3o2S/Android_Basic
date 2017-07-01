package com.example.b0302s.line2;


import android.content.Intent;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

//implements ProfileDialog.NoticeDialogListener
public class FriendsList extends AppCompatActivity{

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
        item_friends_list friend1 = new item_friends_list(R.drawable.profile, "강성호", "010-4433-5532");
        item_friends_list friend2 = new item_friends_list(R.drawable.profile, "강옥태", "010-2256-2192");
        item_friends_list friend3 = new item_friends_list(R.drawable.profile, "김경섭", "010-7654-4321");
        item_friends_list friend4 = new item_friends_list(R.drawable.profile, "이우종", "010-6643-4432");
        item_friends_list friend5 = new item_friends_list(R.drawable.profile, "이관호", "010-5522-4432");
        item_friends_list friend6 = new item_friends_list(R.drawable.profile, "구승회", "010-8756-7543");
        item_friends_list friend7 = new item_friends_list(R.drawable.profile, "기하영", "010-1234-5321");
        item_friends_list friend8 = new item_friends_list(R.drawable.profile, "남철안", "010-6785-4432");
        item_friends_list friend9 = new item_friends_list(R.drawable.profile, "박노바", "010-5332-4432");
        item_friends_list friend10 = new item_friends_list(R.drawable.profile, "박영후", "010-5532-1123");
        item_friends_list friend11 = new item_friends_list(R.drawable.profile, "박정은", "010-5552-6678");
        item_friends_list friend12 = new item_friends_list(R.drawable.profile, "서홍석", "010-1234-5553");
        item_friends_list friend13 = new item_friends_list(R.drawable.profile, "신예지", "010-6663-2223");
        item_friends_list friend14 = new item_friends_list(R.drawable.profile, "이유창", "010-8875-5681");

        data.add(friend1);
        data.add(friend2);
        data.add(friend3);
        data.add(friend4);
        data.add(friend5);
        data.add(friend6);
        data.add(friend7);
        data.add(friend8);
        data.add(friend9);
        data.add(friend10);
        data.add(friend11);
        data.add(friend12);
        data.add(friend13);
        data.add(friend14);

        Profile_ListviewAdapter profile_adapter = new Profile_ListviewAdapter(this, R.layout.item_profile_list, profile_data);
        profile_listView.setAdapter(profile_adapter);
        Profilelist_ClickListner profile_listner = new Profilelist_ClickListner();
        profile_listView.setOnItemClickListener(profile_listner);

        Friends_ListviewAdapter friendslist_adapter = new Friends_ListviewAdapter(this, R.layout.item_friends_list, data);
        friends_listView.setAdapter(friendslist_adapter);
        Friendslist_ClickListner listner = new Friendslist_ClickListner();
        friends_listView.setOnItemClickListener(listner);

        int itemcount = friends_listView.getCount();
        TextView title = (TextView)findViewById(R.id.friend_titlebar);
        title.setText("친구"+"("+itemcount+")");
        title.setTextSize(20);
    }

    private class Friendslist_ClickListner implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
        {

              ProfileDialog profiledialog = new ProfileDialog();
              item_friends_list data =  (item_friends_list)adapterView.getItemAtPosition(position);

              Bundle bundle = new Bundle();
              bundle.putString("name", data.getName());
              bundle.putString("phone_number", data.getPhone_number());
              bundle.putInt("profile_image", data.getIcon());
              profiledialog.setArguments(bundle);
              profiledialog.show(getFragmentManager(), "FriendDialog");
              onPause();
        }
    }

    private class Profilelist_ClickListner implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
        {

            ProfileDialog profiledialog = new ProfileDialog();
            item_profile_list data =  (item_profile_list)adapterView.getItemAtPosition(position);
            Bundle bundle = new Bundle();
            bundle.putString("name", data.getName());
            bundle.putString("phone_number", data.getPhone_number());
            bundle.putInt("profile_image", data.getIcon());
            profiledialog.setArguments(bundle);
            profiledialog.show(getFragmentManager(), "FriendDialog");
            onPause();
        }
    }
}
