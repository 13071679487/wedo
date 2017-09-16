package wedo.job.fragment.third;

import android.app.Fragment;
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
import wedo.job.R;
import wedo.job.fragment.third.child.EditActivity;


public class FragmentThree extends Fragment {
    private ImageView iv_head;
    private Toolbar toolbar;

    private View head_layout;

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
        initEvent();
        getArgs();
        return view;
    }

    public void initView(View view) {
        head_layout=view.findViewById(R.id.head_layout);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("2276");
        //设置系统的actionbar为我们的toolbar
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        iv_head = (ImageView) view.findViewById(R.id.head_iv);
        Glide.with(this).load("http://39.108.177.230:8080/head_icon.jpg").bitmapTransform(new RoundedCornersTransformation(this.getActivity(),
                90, 0)).into(iv_head);
    }

    public void initEvent() {
        head_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), EditActivity.class);
                startActivity(i);
            }
        });
    }


    private void getArgs() {
        Bundle bundle = getArguments();

    }
}
