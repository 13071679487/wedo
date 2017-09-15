package wedo.job.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import wedo.job.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
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
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_register= (Button) findViewById(R.id.btn_register);
        btn_find_password= (Button) findViewById(R.id.btn_find_password);
        et_phoneNum= (EditText) findViewById(R.id.et_phoneNum);
        et_pwd= (EditText) findViewById(R.id.et_pwd);
    }
    public void initEvent(){
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_find_password.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:
                break;
            case R.id.btn_register:
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
                this.finish();
                break;
            case R.id.btn_find_password:
                break;
        }
    }
}
