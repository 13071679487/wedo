package wedo.job.fragment.third;

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
import me.yokeyword.fragmentation.SupportActivity;
import wedo.job.R;
import wedo.job.ui.BaseMainFragment;


public class FragmentThree extends BaseMainFragment {
    private ImageView iv_head;
    private Toolbar toolbar;

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
        initView(view);
        initEvent();
        getArgs();
        return view;
    }

    public void initView(View view){
        toolbar= (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        //设置系统的actionbar为我们的toolbar
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        iv_head= (ImageView) view.findViewById(R.id.head_iv);
        Glide.with(this).load(R.drawable.login_input_user).bitmapTransform(new RoundedCornersTransformation(this.getActivity(),
                90, 0)).into(iv_head);
    }
    public void initEvent(){

    }

    private void getArgs(){
        Bundle bundle = getArguments();

    }
}
