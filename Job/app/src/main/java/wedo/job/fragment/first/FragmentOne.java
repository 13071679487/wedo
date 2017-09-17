package wedo.job.fragment.first;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import wedo.job.R;
import wedo.job.fragment.BackHandleFragment;
import wedo.job.util.PopupWindowUtil;


public class FragmentOne extends BackHandleFragment {
    private Toolbar toolbar;
    //toolbar上面的溢出菜单
    private Button btn_overflow;

    private View container;

    //记录第一个fragment点击返回的次数
    private int clickNum = 0;
    //间隔1.5秒初始化clickNum
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            clickNum = msg.what;
        }
    };

    public static FragmentOne newInstance() {
        Bundle args = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        initView(view);
        initEvent();
        getArgs();
        return view;
    }

    public void initView(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        btn_overflow = (Button) toolbar.findViewById(R.id.btn_overflow);
        container = view.findViewById(R.id.container);
    }

    public void initEvent() {
        btn_overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO  溢出菜单
                PopupWindowUtil.showPopupWindowOverFlowMenu(getContext(), R.layout.fragmentone_overflowmenu, btn_overflow);
                View view = PopupWindowUtil.getContentView();
                Button send = (Button) view.findViewById(R.id.btn_send);
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击之后使得pop消失掉
                        PopupWindowUtil.getPopupWindow().dismiss();
                    }
                });
            }
        });
    }

    private void getArgs() {
        Bundle bundle = getArguments();

    }

    @Override
    public boolean onBackPressed() {
        clickNum++;
        Message msg = Message.obtain();
        msg.what = 0;
        handler.sendMessageDelayed(msg, 1500);
        if (clickNum >= 2)
            showExitDialog();
        return true;
    }

    public void showExitDialog() {
        PopupWindowUtil.showPopupWindowWhenExit(getContext(), R.layout.exit_dialog_layout, container);
        View v = PopupWindowUtil.getContentView();
        v.findViewById(R.id.btn_positive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindowUtil.getPopupWindow().dismiss();
                getActivity().finish();
            }
        });
        v.findViewById(R.id.btn_navigation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindowUtil.getPopupWindow().dismiss();
            }
        });
    }
}
