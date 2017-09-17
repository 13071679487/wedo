package wedo.job.fragment.third.child;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import wedo.job.R;

public class MessageActivity extends AppCompatActivity {
    //返回按钮和提交按钮
    private Button btn_callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        initView();
        initEvent();
    }
    public void initView(){
        btn_callback= (Button) findViewById(R.id.btn_callback);
    }
    public void initEvent(){
        btn_callback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageActivity.this.finish();
            }
        });
    }
}
