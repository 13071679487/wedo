package wedo.job.fragment.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wedo.job.R;
import wedo.job.ui.BaseMainFragment;


public class FragmentOne extends BaseMainFragment {


    public static FragmentOne newInstance() {
        Bundle args = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_main,container,false);
        getArgs();
        return view;
    }


    private void getArgs(){
        Bundle bundle = getArguments();

    }
}
