package wedo.job.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import wedo.job.R;

public class RegisterActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button btn_register;
    private EditText et_phoneNum, et_pwd;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initEvent();
    }

    public void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btn_register = (Button) findViewById(R.id.btn_register);
        et_phoneNum = (EditText) findViewById(R.id.et_phoneNum);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
    }

    public void initEvent() {
        toolbar.findViewById(R.id.btn_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.this.finish();
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = et_phoneNum.getText().toString().trim();
                String pwd = et_pwd.getText().toString().trim();
                if (canRegister(phoneNum, pwd)) {
                    if (registerSuccess(phoneNum, pwd)) {
                        Toast.makeText(getApplication(), "注册成功，正在返回登录...", Toast.LENGTH_SHORT).show();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                RegisterActivity.this.finish();
                            }
                        }, 1000);

                    }
                }
            }
        });
    }

    public boolean canRegister(String phoneNum, String pwd) {
        return true;
    }

    public boolean registerSuccess(String phoneNum, String pwd) {
        return true;
    }
}
