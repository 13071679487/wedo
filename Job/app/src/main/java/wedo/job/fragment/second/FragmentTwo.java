package wedo.job.fragment.second;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import wedo.job.R;


public class FragmentTwo extends Fragment {
    private Toolbar toolbar;

    public static FragmentTwo newInstance() {
        Bundle args = new Bundle();
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two,container,false);
        initView(view);
        initEvent();
        getArgs();
        return view;
    }

    public void initView(View view){
        toolbar= (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }
    public void initEvent(){
        toolbar.findViewById(R.id.btn_overflow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 溢出菜单
            }
        });
    }

    private void getArgs(){
        Bundle bundle = getArguments();

    }
}
