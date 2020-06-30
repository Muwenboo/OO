package net.melove.demo.OO;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hyphenate.chat.EMClient;

import net.melove.demo.OO.model.Model;

//欢迎界面
public class HelloActivity extends Activity {

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            //如果当前activity已经退出，则不处理handler消息
            if (isFinishing()){
                return;
            }

            //判断进入主页面还是登陆界面
            toMainOrLogin();
        }
    };
    //判断进入主页面还是登陆界面
    private void toMainOrLogin() {
       // new Thread(){
        //    public void run() {


         //   }
       // }.start();

        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                //判断当前账号是否登陆过
                if (EMClient.getInstance().isLoggedInBefore()){//登陆过
                    //跳主页面
                    Intent intent = new Intent(HelloActivity.this, MainActivity.class);
                    startActivity(intent);

                }else{//没登录过跳登陆
                    Intent intent = new Intent(HelloActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        //发送2s延时
        handler.sendMessageDelayed(Message.obtain(),2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁延时消息
        handler.removeCallbacksAndMessages(null);
    }
}