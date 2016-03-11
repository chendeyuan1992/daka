package daka.com.example.chen.daka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chen on 2016/3/11.
 */
public class MemberListActivity extends AppCompatActivity{
    @Bind(R.id.tv_member)
    public TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memberlist_activity);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String plans_uri = (String) bundle.get("personal");
        tv.setText(plans_uri);

    }
}
