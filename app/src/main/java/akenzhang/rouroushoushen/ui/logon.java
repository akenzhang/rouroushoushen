package akenzhang.rouroushoushen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import akenzhang.rouroushoushen.MainActivity;
import akenzhang.rouroushoushen.R;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class logon extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);
    }
    public void login(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
