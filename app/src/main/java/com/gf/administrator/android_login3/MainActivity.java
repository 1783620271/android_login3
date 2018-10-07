package com.gf.administrator.android_login3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.gf.administrator.android_login.user_reserve;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_pwd;
    private CheckBox check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //找到我们关心的控件
        et_name = (EditText)findViewById(R.id.et_name);
        et_pwd = (EditText)findViewById(R.id.et_password);
        check = (CheckBox)findViewById(R.id.ec_check);
        Map<String,String> map=user_reserve.info();
        if(map!=null){
            String names=map.get("name");
            String pwds=map.get("pwd");
            et_name.setText(names);
            et_pwd.setText(pwds);
        }
    }
    //写按钮的点击事件
    @SuppressLint("WrongConstant")
    public void click(View V){
        String name=et_name.getText().toString().trim();
        String pwd=et_pwd.getText().toString().trim();
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd)){
            Toast.makeText(MainActivity.this, "请输入用户名和密码", 1).show();
        }else{
            if(check.isChecked()){

                boolean resvers=user_reserve.reserve(name,pwd);
                        if(resvers){
                              Toast.makeText(MainActivity.this, "保存成功", 1).show();
                        }else{
                            Toast.makeText(MainActivity.this, "保存失败", 1).show();
                        }
            }else{
                Toast.makeText(MainActivity.this, "请勾选确认密码", 1).show();
            }
        }

    }


}
