package wedo.job.fragment.third.child;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import wedo.job.R;

public class SuggestionActivity extends AppCompatActivity {
    //返回按钮和提交按钮
    private Button btn_callback,btn_commit;

    private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        initView();
        initEvent();
    }
    public void initView(){
        btn_callback= (Button) findViewById(R.id.btn_callback);
        btn_commit= (Button) findViewById(R.id.btn_commit);
    }
    public void initEvent(){
        btn_callback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuggestionActivity.this.finish();
            }
        });
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"提交成功,正在返回",Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        SuggestionActivity.this.finish();
                    }
                },1000);
            }
        });
    }
}
