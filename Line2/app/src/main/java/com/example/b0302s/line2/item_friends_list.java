package com.example.b0302s.line2;

/**
 * Created by Bo3o2S on 2017-06-26.
 */

public class item_friends_list {
    private int icon;
    private String name;
    private String phone_number;
    public int getIcon() {return icon;}
    public String getName() {return name;}
    public String getPhone_number(){return phone_number;}

    public item_friends_list(int icon, String name, String phone_number)
    {
        this.icon = icon;
        this.name = name;
        this.phone_number = phone_number;
    }
}
