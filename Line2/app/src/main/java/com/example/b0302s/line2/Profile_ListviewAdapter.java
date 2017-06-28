package com.example.b0302s.line2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bo3o2S on 2017-06-27.
 */

public class Profile_ListviewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<item_profile_list> data;
    private int layout;

    public Profile_ListviewAdapter(Context context, int layout, ArrayList<item_profile_list> data)
    {
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent)
    {
        if(converView == null)
        {
            converView = inflater.inflate(layout, parent, false);
        }
        item_profile_list listviewitem = data.get(position);
        ImageView icon = (ImageView) converView.findViewById(R.id.item_image_profile);
        icon.setImageResource(listviewitem.getIcon());
        TextView name = (TextView) converView.findViewById(R.id.item_text_profile);
        name.setText(listviewitem.getName());

        return converView;
    }
}
