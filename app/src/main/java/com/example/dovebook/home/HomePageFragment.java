package com.example.dovebook.home;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dovebook.Information.InfoManager;
import com.example.dovebook.R;
import com.example.dovebook.base.BaseFragment;
import com.example.dovebook.contact.contactManager;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends BaseFragment {

    private static String TAG="HomePageFragment";

    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.home_information_textId)
    Button home_information_textId;
    @BindView(R.id.imageView)
    CircleImageView imageView;
    @BindView(R.id.home_friend)
    RelativeLayout home_friend;

    private com.example.dovebook.login.UserManager mUserManager;


    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initWidget(View view) {
        super.initWidget(view);
        mUserManager=new com.example.dovebook.login.UserManager(getActivity());
        home_information_textId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),InfoManager.class));
            }
        });

        home_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),contactManager.class));
            }
        });

    }
    

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_home_page;
    }



    private void updateUI(){
        Log.d(TAG, "print: "+mUserManager.getUser().getUserAvatarPath());
        Glide.with(getActivity()).load(mUserManager.getUser().getUserAvatarPath()).into(imageView);
        userName.setText(mUserManager.getUser().getUserName());
    }
}
