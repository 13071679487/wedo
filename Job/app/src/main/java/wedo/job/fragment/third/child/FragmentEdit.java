package wedo.job.fragment.third.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.SupportFragment;
import wedo.job.R;


public class FragmentEdit extends SupportFragment {

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

    }

    public void initEvent() {

    }


    private void getArgs() {
        Bundle bundle = getArguments();

    }
}
