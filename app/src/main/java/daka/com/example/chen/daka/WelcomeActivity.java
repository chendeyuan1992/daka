package daka.com.example.chen.daka;

import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import daka.com.example.chen.daka.util.ShareUtil;


public class WelcomeActivity extends AppCompatActivity {
    private static Handler handler = new Handler() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ShareUtil.putInt("flag", 0);
        setContentView(R.layout.welcome_home);

            if (ShareUtil.getInt("flag")==0){
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (ShareUtil.getBoolean("home_flag")){
                            ShareUtil.putInt("flag", 2);
                            startActivity(new Intent(WelcomeActivity.this, DetailsActivity.class));

                        }else{
                            ShareUtil.putInt("flag", 1);
                            startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
                        }
                        finish();

                    }
                }, 3000);
            }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && ShareUtil.getInt("flag")==0){
            ShareUtil.putInt("flag",1);

            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }






}
