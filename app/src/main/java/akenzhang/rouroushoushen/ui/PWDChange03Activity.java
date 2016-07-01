package akenzhang.rouroushoushen.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import akenzhang.rouroushoushen.R;

/**
 * Created by Administrator on 2016/7/1.
 */
public class PWDChange03Activity extends BaseActivity {

    private EditText pwd_firstinput;
    private EditText pwd_confirm;
    private Button pwd_ok;

    private String strPhone;
    private String strCode;

    @Override
    protected int getLayout() {
        return R.layout.activity_pwdchange03_layout;
    }

    @Override
    protected void initView() {

        pwd_firstinput = (EditText) this.findViewById(R.id.id_pwd_firstinput);
        pwd_confirm = (EditText) this.findViewById(R.id.id_pwd_confirm);
        pwd_ok = (Button) this.findViewById(R.id.id_pwd_ok);

    }

    @Override
    protected void initVariable() {

        strPhone = this.getIntent().getStringExtra("phone");
        strCode = this.getIntent().getStringExtra("code");

    }

    @Override
    protected void initListener() {

        pwd_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!pwd_firstinput.getText().toString().equals(pwd_confirm.getText().toString())){
                    Toast.makeText(PWDChange03Activity.this,"请确认前后输入的密码一致！",Toast.LENGTH_SHORT).show();
                    return;
                }else {

                    String strUpdatePWDSQL = "http://www.1316818.com/jsonserver.aspx?change_username="+ strPhone +"&change_memo="+ strCode +"&change_pwd="+ pwd_firstinput.getText().toString();
                    OkHttpUtils.getAsync(strUpdatePWDSQL, new OkHttpUtils.DataCallBack() {
                        @Override
                        public void requestFailure(Request request, IOException e) {}
                        @Override
                        public void requestSuccess(String result) {
                            try {
                                JSONObject json = new JSONObject(result);
                                String strStatus = json.getString("status");

                                if(strStatus.equals("1")){
                                    Toast.makeText(PWDChange03Activity.this,"密码修改成功！",Toast.LENGTH_SHORT).show();
                                    Log.e("=====>***",json.getString("msg"));
                                    Intent intent =new Intent(PWDChange03Activity.this,LoginActivity.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(PWDChange03Activity.this,"密码修改不成功！",Toast.LENGTH_SHORT).show();
                                    return;
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }

            }
        });

    }

    @Override
    protected void bindData() {

    }
}
