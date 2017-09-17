package wedo.job.fragment.third.child;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;

import me.yokeyword.fragmentation.SupportFragment;
import wedo.job.R;
import wedo.job.bean.User;
import wedo.job.util.PreferenceUtils;


public class FragmentEdit extends SupportFragment {

    private Toolbar toolbar;
    //退出登录按钮
    private Button btn_exit;

    private View update_headicon;

    private Handler handler = new Handler();
    public static FragmentEdit newInstance() {
        Bundle args = new Bundle();
        FragmentEdit fragment = new FragmentEdit();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        initView(view);
        initEvent();
        getArgs();
        return view;
    }

    public void initView(View view) {
        toolbar= (Toolbar) view.findViewById(R.id.toolbar);
        btn_exit= (Button) view.findViewById(R.id.btn_exit);
        update_headicon=view.findViewById(R.id.linear_headicon);
    }

    public void initEvent() {
        toolbar.findViewById(R.id.btn_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        toolbar.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(saveSuccess(new User())){
                    Toast.makeText(getContext(),"保存成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceUtils.write(getContext(),"userConfig","hasLogin",false);
                Toast.makeText(getContext(),"退出登录成功，正在返回..",Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getActivity().finish();
                    }
                }, 1000);
            }
        });
        update_headicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),EditHeadiconActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean saveSuccess(User user){
        return true;
    }


    private void getArgs() {
        Bundle bundle = getArguments();

    }
}
