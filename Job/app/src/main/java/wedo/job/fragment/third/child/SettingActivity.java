package wedo.job.fragment.third.child;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import wedo.job.R;

public class SettingActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private View linear_clearCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initEvent();
    }
    public void initView(){
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        linear_clearCache=findViewById(R.id.linear_clearCache);
    }
    public void initEvent(){
        toolbar.findViewById(R.id.btn_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingActivity.this.finish();
            }
        });
        linear_clearCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"清理完成",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
