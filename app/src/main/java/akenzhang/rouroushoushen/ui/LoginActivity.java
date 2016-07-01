package akenzhang.rouroushoushen.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Request;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import akenzhang.rouroushoushen.MainActivity;
import akenzhang.rouroushoushen.R;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class LoginActivity extends AppCompatActivity{

    //QQ登陆
    private static String APP_ID="1105434609";
    private Tencent mTencent;
    private UserInfo mUserInfo;

    private EditText edloginphone;
    private EditText edloginpwd;
    private TextView tvForgetPWD;

    private TextView tvLogin;
    private TextView tvRegister;
    private ImageView ivRegisterqq;

    //id_login
    //id_register

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edloginphone = (EditText) this.findViewById(R.id.id_login_phone);
        edloginpwd = (EditText) this.findViewById(R.id.id_login_pwd);
        ivRegisterqq = (ImageView) this.findViewById(R.id.id_register_qq);
        tvForgetPWD = (TextView) this.findViewById(R.id.id_forget_pwd);

        tvForgetPWD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,PWDChange01Activity.class);
                startActivity(intent);
            }
        });

        ivRegisterqq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTencent.login(LoginActivity.this, "get_user_info", new LoginUiListener());
            }
        });


        tvLogin = (TextView) this.findViewById(R.id.id_login);
        tvRegister = (TextView) this.findViewById(R.id.id_register);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        // Tencent类是SDK的主要实现类，开发者可通过Tencent类访问腾讯开放的OpenAPI。
        // 其中APP_ID是分配给第三方应用的appid，类型为String。
        if(mTencent==null) {
            mTencent = Tencent.createInstance(APP_ID, this.getApplicationContext());
        }

    }

    public void login(View view){

        //点击登录按钮，进行用户名和密码的验证
        final String strLoginPhone = edloginphone.getText().toString();
        String strPwd = edloginpwd.getText().toString();

       if(strLoginPhone.equals("") )
        {
            Toast.makeText(LoginActivity.this,"用户名不能为空~",Toast.LENGTH_SHORT).show();
            return;
        }

        if( strPwd.equals(""))
        {
            Toast.makeText(LoginActivity.this,"密码不能为空~",Toast.LENGTH_SHORT).show();
            return;
        }

        if(!TextUtils.isDigitsOnly(strLoginPhone))
        {
            Toast.makeText(LoginActivity.this,"手机号码不能带字符~",Toast.LENGTH_SHORT).show();
            return;
        }


        //调用OkHttpUtils获取网络资源
        String requestUrl = "http://www.1316818.com/jsonserver.aspx?username="+ strLoginPhone +"&password="+ strPwd +"";
        OkHttpUtils.getAsync(requestUrl, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {}

            @Override
            public void requestSuccess(String result) {

                try {
                    JSONObject jsonObject = new JSONObject(result);
                    int intStatus = jsonObject.getInt("status");

                    if(intStatus==1){

                        //将获取到的用户信息保存起来
                        SharedPreferences mySharedPreferences = getSharedPreferences("akenzhang", Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = mySharedPreferences.edit();
                        editor.putString("nickname",strLoginPhone );
                        editor.putString("image","http://q.qlogo.cn/qqapp/1105434609/3AB2E5A88E27ACFE39CE6AB4BE4194CE/100" );
                        editor.putString("gender","未知" );
                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this,"用户名或者密码不正确，登陆失败！",Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            mTencent.onActivityResultData(requestCode, resultCode, data, new LoginUiListener());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //实现QQ登陆的回调接口
    class LoginUiListener implements IUiListener {

        @Override
        public void onComplete(Object o) {
            JSONObject jsonObject = (JSONObject)o;

            try {
                String openid = jsonObject.getString("openid");
                String expires_in = jsonObject.getString("expires_in");
                String token = jsonObject.getString("access_token");
                if (!TextUtils.isEmpty(openid)&&!TextUtils.isEmpty(expires_in)&&!TextUtils.isEmpty(token)){
                    mTencent.setOpenId(openid);
                    mTencent.setAccessToken(token,expires_in);

                    //拿到QQ用户的数据
                    mUserInfo = new UserInfo(LoginActivity.this,mTencent.getQQToken());
                    mUserInfo.getUserInfo(new IUiListener() {
                        @Override
                        public void onComplete(Object o) {
                            JSONObject json = (JSONObject)o;

                            try {
                                String nickname = json.getString("nickname");
                                String image = json.getString("figureurl_qq_2");
                                String gender = json.getString("gender");

                                //将获取到的用户信息保存起来
                                SharedPreferences mySharedPreferences = getSharedPreferences("akenzhang", Activity.MODE_PRIVATE);
                                SharedPreferences.Editor editor = mySharedPreferences.edit();
                                editor.putString("nickname",nickname );
                                editor.putString("image",image );
                                editor.putString("gender",gender );
                                editor.commit();

                                //登录后跳转
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(UiError uiError) {
                            String strMsg = uiError.errorMessage;
                        }

                        @Override
                        public void onCancel() {}
                    });
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError e) {

            Toast.makeText(LoginActivity.this,e.errorMessage,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {}

    }
}
