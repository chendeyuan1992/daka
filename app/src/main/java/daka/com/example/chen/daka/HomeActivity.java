package daka.com.example.chen.daka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;



import butterknife.ButterKnife;
import butterknife.OnClick;
import daka.com.example.chen.daka.util.ShareUtil;


public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.lv_right)
    public void onClick(){
        ShareUtil.putInt("flag", 2);
        ShareUtil.putBoolean("home_flag",true);
        startActivity(new Intent(this, DetailsActivity.class));

        finish();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK&& ShareUtil.getInt("flag") == 1){
            ShareUtil.putInt("flag", 2);
            startActivity(new Intent(this, DetailsActivity.class));
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();

    }
}
