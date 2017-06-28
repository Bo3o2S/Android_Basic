package com.example.b0302s.line2;


import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * Created by B0302S on 2017-06-26.
 */

public class ProfileDialog extends DialogFragment {

    private TextView textview_name;
    private TextView textview_phone_number;
    private ImageView imageview_profile_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_profile_dialog, container);
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        String phone_number = bundle.getString("phone_number");
        int imageview = bundle.getInt("profile_image");
        textview_name = (TextView)view.findViewById(R.id.profile_name);
        textview_name.setText(name);
        textview_phone_number = (TextView)view.findViewById(R.id.phone_number);
        textview_phone_number.setText(phone_number);
        imageview_profile_image = (ImageView)view.findViewById(R.id.profile_image);
        imageview_profile_image.setImageResource(imageview);
        return view;
    }
}
//public class ProfileDialog extends Dialog {
//    private TextView mTextView;
//    private String mText;
//    private ImageView mImageView;
//    private View.OnClickListener mLeftClickListener;
//    private View view;
//    protected void onCreate(Bundle saveInstanceState) {
//        super.onCreate(saveInstanceState);
//        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
//        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
//        lpWindow.dimAmount = 0.8f;
//        getWindow().setAttributes(lpWindow);
//
//        setContentView(R.layout.activity_profile_dialog);
//        setLayout();
//        setImage();
//        setProfileName(mText);
//        //setClickListener(mLeftClickListener);
//    }
//
//
//
//    public ProfileDialog(Context context, String profileName, View.OnClickListener singleListener, View view)
//    {
//        super(context, android.R.style.Theme_Translucent_NoTitleBar);
//        this.mText = profileName;
//        this.mLeftClickListener = singleListener;
//        this.view = view;
//    }
//
//    private void setLayout() {
//        mImageView = (ImageView)findViewById(R.id.profile_image);
//        mTextView = (TextView)findViewById(R.id.profile_text);
//    }
//
//    private void setProfileName(String profilename) {
//        mTextView.setText(profilename);
//    }
//
//    private void setImage()
//    {
//        mImageView.setImageResource(R.drawable.profile);
//        }
//
//    private void setClickListener(View.OnClickListener left)
//    {
//        if(left!=null)
//        {
//            mLeftClickListener.onClick(view);
//        }
//    }
//}
