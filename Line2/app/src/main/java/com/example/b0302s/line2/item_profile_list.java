package com.example.b0302s.line2;

/**
 * Created by Bo3o2S on 2017-06-27.
 */

public class item_profile_list {
    private int icon;
    private String name;
    private String phone_number;
    public int getIcon() {return icon;}
    public String getName() {return name;}
    public String getPhone_number(){return phone_number;}

    public item_profile_list(int icon, String name, String phone_number)
    {
        this.icon = icon;
        this.name = name;
        this.phone_number = phone_number;
    }
}
