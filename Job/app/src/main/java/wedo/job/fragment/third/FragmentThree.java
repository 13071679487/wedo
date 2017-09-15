package wedo.job.fragment.third;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wedo.job.R;
import wedo.job.ui.BaseMainFragment;


public class FragmentThree extends BaseMainFragment {


    public static FragmentThree newInstance() {
        Bundle args = new Bundle();
        FragmentThree fragment = new FragmentThree();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_main,container,false);
        getArgs();
        return view;
    }

    private void getArgs(){
        Bundle bundle = getArguments();

    }
}
