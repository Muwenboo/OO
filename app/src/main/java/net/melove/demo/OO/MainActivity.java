package net.melove.demo.OO;

import android.app.Activity;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import net.melove.demo.OO.fragment.AboutFragment;
import net.melove.demo.OO.fragment.ChatFragment;
import net.melove.demo.OO.fragment.SettingFragment;

public class MainActivity extends FragmentActivity {
    private RadioGroup rg_main;
    private ChatFragment chatFragment;
    private SettingFragment settingFragment;
    private AboutFragment aboutFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();

    }

    private void initListener() {
        //radioGroupde選擇事件
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                Fragment fragment = null;
                switch (checkedId){
                    case R.id.rb_mian_chat:
                        fragment = chatFragment;
                        break;

                    case R.id.rb_main_setting:
                        fragment = settingFragment;
                        break;
                    case R.id.rb_main_about:
                        fragment = aboutFragment;
                        break;

                }

                //實現切換
                switchFragment(fragment);

            }
        });
        rg_main.check(R.id.rb_mian_chat);
    }
    private void switchFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().replace(R.id.fl_main, fragment).commit();
    }

    private void initData() {
        //创建三个fragment
        chatFragment = new ChatFragment();
        settingFragment = new SettingFragment();
        aboutFragment = new AboutFragment();



    }

    private void initView() {
        rg_main = (RadioGroup)findViewById(R.id.rg_main);
    }


}
