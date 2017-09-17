package wedo.job.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import wedo.job.R;
import wedo.job.util.PreferenceUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private Button btn_login,btn_register,btn_find_password;
    private EditText et_phoneNum,et_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
    }
    public void initView(){
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_register= (Button) findViewById(R.id.btn_register);
        btn_find_password= (Button) findViewById(R.id.btn_find_password);
        et_phoneNum= (EditText) findViewById(R.id.et_phoneNum);
        et_pwd= (EditText) findViewById(R.id.et_pwd);
        setSupportActionBar(toolbar);
    }
    public void initEvent(){
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_find_password.setOnClickListener(this);
        toolbar.findViewById(R.id.btn_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:
                String phoneNum=et_phoneNum.getText().toString().trim();
                String pwd=et_pwd.getText().toString().trim();
                if(canLogin(phoneNum,pwd)){
                    if(loginSuccess(phoneNum,pwd)){
                        //使用sp记录登录状态
                        PreferenceUtils.write(this,"userConfig","hasLogin",true);
                        Toast.makeText(this,"登陆成功...",Toast.LENGTH_SHORT).show();
                        this.finish();
                    }
                }
                break;
            case R.id.btn_register:
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
                break;
            case R.id.btn_find_password:
                break;
        }
    }

    public boolean canLogin(String phoneNum,String pwd){

        return true;
    }

    public boolean loginSuccess(String phoneNum,String pwd){
        return true;
    }
}
