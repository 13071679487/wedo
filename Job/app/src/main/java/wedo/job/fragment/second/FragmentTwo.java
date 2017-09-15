package wedo.job.fragment.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wedo.job.R;
import wedo.job.ui.BaseMainFragment;


public class FragmentTwo extends BaseMainFragment {


    public static FragmentTwo newInstance() {
        Bundle args = new Bundle();
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_main,container,false);
        getArgs();
        return view;
    }



    private void getArgs(){
        Bundle bundle = getArguments();

    }
}
