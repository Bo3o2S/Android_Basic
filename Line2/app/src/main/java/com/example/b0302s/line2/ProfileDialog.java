package com.example.b0302s.line2;


import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
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
    private ImageView imageview_chatroom;
    private ImageView imageview_call;
    private ImageView imageview_videocall;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_profile_dialog, container);
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        String phone_number = bundle.getString("phone_number");
        int imageview = bundle.getInt("profile_image");
        textview_name = view.findViewById(R.id.profile_name);
        textview_name.setText(name);
        textview_phone_number = view.findViewById(R.id.phone_number);
        textview_phone_number.setText(phone_number);
        imageview_profile_image = view.findViewById(R.id.profile_image);
        imageview_profile_image.setImageResource(imageview);
        onclick_PhoneNumber(textview_phone_number); //전화연결
        imageview_chatroom = view.findViewById(R.id.chatroom_profiledialog);
        onclick_Chatting(imageview_chatroom, name); //채팅룸 연결
        imageview_call = view.findViewById(R.id.call_profiledialog);
        onclick_Call(imageview_call, phone_number);
        imageview_videocall = view.findViewById(R.id.videocall_profiledialog);
        onclick_Sms(imageview_videocall, phone_number);
        return view;
    }

    public void onclick_PhoneNumber(final TextView textView)
    {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isClickable())
                {
                    String phone_number = "tel:" + textView.getText().toString().replaceAll("-","");
                    startActivity(new Intent("android.intent.action.DIAL", Uri.parse(phone_number)));
                    onPause();
                }
            }
        });
    }

    public void onclick_Chatting(final ImageView imageView, final String name)
    {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isClickable())
                {
                    Intent intent = new Intent(getContext(), ChatActivity.class);
                    String friends_name = name;
                    intent.putExtra("friends_name", friends_name);
                    startActivity(intent);
                    onPause();
                }
            }
        });
    }

    public void onclick_Call(final ImageView imageView, final String phoneNumber)
    {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isClickable())
                {
                    String phone_number = "tel:" + phoneNumber.replaceAll("-","");
                    startActivity(new Intent("android.intent.action.DIAL", Uri.parse(phone_number)));
                    onPause();
                }
            }
        });
    }

    public void onclick_Sms(final ImageView imageView, final String phoneNumber)
    {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isClickable())
                {
                    String sms = "smsto:" + phoneNumber.replaceAll("-","");
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(sms));
                    startActivity(intent);
                    onPause();
                }
            }
        });
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
