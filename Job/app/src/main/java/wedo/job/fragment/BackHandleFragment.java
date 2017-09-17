package wedo.job.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import wedo.job.impl.BackHandleInterface;

/**
 * Created by Lifu on 2017/9/17.
 */

public abstract class BackHandleFragment extends Fragment {
    protected BackHandleInterface backHandleInterface;
    public abstract boolean onBackPressed();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!(getActivity() instanceof BackHandleInterface)){
            throw new ClassCastException("宿主activity必须继承BackHandkeInterface接口");
        }else{
            this.backHandleInterface= (BackHandleInterface) getActivity();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        backHandleInterface.setSelectedFragment(this);
    }
}
