package wedo.job.fragment.third;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import wedo.job.MainActivity;
import wedo.job.R;
import wedo.job.activity.LoginActivity;
import wedo.job.fragment.BackHandleFragment;
import wedo.job.fragment.third.child.AboutActivity;
import wedo.job.fragment.third.child.MessageActivity;
import wedo.job.fragment.third.child.SettingActivity;
import wedo.job.fragment.third.child.SuggestionActivity;
import wedo.job.fragment.third.child.EditActivity;
import wedo.job.util.PreferenceUtils;


public class FragmentThree extends BackHandleFragment {
    private ImageView iv_head;
    private Toolbar toolbar;

    private View head_layout;
    private View login_layout;
    private View suggestion_layout;
    private View about_layout;
    private View message_layout;

    public static FragmentThree newInstance() {
        Bundle args = new Bundle();
        FragmentThree fragment = new FragmentThree();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        initView(view);
        initData();
        initEvent();
        getArgs();
        return view;
    }

    public void initView(View view) {
        head_layout=view.findViewById(R.id.head_layout);
        login_layout=view.findViewById(R.id.login_layout);
        suggestion_layout=view.findViewById(R.id.linear_suggestion);
        about_layout=view.findViewById(R.id.linear_about);
        message_layout=view.findViewById(R.id.linear_message);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        //设置系统的actionbar为我们的toolbar
        iv_head = (ImageView) view.findViewById(R.id.head_iv);
    }
    public void initData(){
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if(PreferenceUtils.readBoolean(getContext(),"userConfig","hasLogin")){
            head_layout.setVisibility(View.VISIBLE);
            login_layout.setVisibility(View.GONE);
            String imgPath=PreferenceUtils.readString(getContext(),"userConfig","headIcon");
            if(imgPath!=""&&imgPath!=null){
                //加载头像为圆角图片
                Glide.with(this).load(imgPath).bitmapTransform(new RoundedCornersTransformation(this.getActivity(),
                        90, 0)).into(iv_head);
            }else{
                Glide.with(this).load(R.drawable.default_usericon).bitmapTransform(new RoundedCornersTransformation(this.getActivity(),
                        90, 0)).into(iv_head);
            }
        }else {
            head_layout.setVisibility(View.GONE);
            login_layout.setVisibility(View.VISIBLE);
        }
    }

    public void initEvent() {
        toolbar.findViewById(R.id.btn_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), SettingActivity.class);
                startActivity(i);
            }
        });
        head_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), EditActivity.class);
                startActivity(i);
            }
        });
        login_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        suggestion_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), SuggestionActivity.class);
                startActivity(i);
            }
        });
        about_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), AboutActivity.class);
                startActivity(i);
            }
        });
        message_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), MessageActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onStart() {
        initData();
        super.onStart();
    }

    private void getArgs() {
        Bundle bundle = getArguments();

    }

    @Override
    public boolean onBackPressed() {
        getFragmentManager().beginTransaction().hide(this).commit();
        if(getActivity() instanceof MainActivity){
            MainActivity mainActivity= (MainActivity) getActivity();
            mainActivity.backToFirstFragment();
        }
        return true;
    }
}
