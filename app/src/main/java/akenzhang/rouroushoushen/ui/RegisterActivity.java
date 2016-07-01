package akenzhang.rouroushoushen.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
 * Created by Administrator on 2016/6/30.
 */
public class RegisterActivity extends BaseActivity {

    private TextView tvLogin;
    private TextView tvRegister;
    private Button btnRegister;
    private EditText edLoginPhone;
    private EditText edLoginPwd;
    private ImageView ivRegisterqq;

    //QQ登陆
    private static String APP_ID="1105434609";
    private Tencent mTencent;
    private UserInfo mUserInfo;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        tvLogin = (TextView) this.findViewById(R.id.id_login);
        tvRegister = (TextView) this.findViewById(R.id.id_register);
        btnRegister = (Button) this.findViewById(R.id.btn_register);
        edLoginPhone = (EditText) this.findViewById(R.id.id_login_phone);
        edLoginPwd = (EditText) this.findViewById(R.id.id_login_pwd);
        ivRegisterqq = (ImageView) this.findViewById(R.id.id_register_qq);

    }

    @Override
    protected void initVariable() {

        if(mTencent==null) {
            mTencent = Tencent.createInstance(APP_ID, this.getApplicationContext());
        }
    }

    @Override
    protected void initListener() {

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //这里写入注册事件的逻辑
                String strLoginPhone = edLoginPhone.getText().toString();
                String strPwd = edLoginPwd.getText().toString();

                if(strLoginPhone.equals("") )
                {
                    Toast.makeText(RegisterActivity.this,"手机号码不能为空~",Toast.LENGTH_SHORT).show();
                    return;
                }

                if( strPwd.equals(""))
                {
                    Toast.makeText(RegisterActivity.this,"密码不能为空~",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!TextUtils.isDigitsOnly(strLoginPhone))
                {
                    Toast.makeText(RegisterActivity.this,"手机号码不能带字符~",Toast.LENGTH_SHORT).show();
                    return;
                }

                String requestUrl = "http://www.1316818.com/jsonserver.aspx?nusername="+ strLoginPhone +"&npassword="+ strPwd +"";
                OkHttpUtils.getAsync(requestUrl, new OkHttpUtils.DataCallBack() {
                    @Override
                    public void requestFailure(Request request, IOException e) {}

                    @Override
                    public void requestSuccess(String result) {
                        try {
                            JSONObject json = new JSONObject(result);
                            String strUsername = json.getString("username");

                            //将获取到的用户信息保存起来
                            SharedPreferences mySharedPreferences = getSharedPreferences("akenzhang", Activity.MODE_PRIVATE);
                            SharedPreferences.Editor editor = mySharedPreferences.edit();
                            editor.putString("nickname",strUsername );
                            editor.putString("image","http://q.qlogo.cn/qqapp/1105434609/3AB2E5A88E27ACFE39CE6AB4BE4194CE/100" );
                            editor.putString("gender","未知" );
                            editor.commit();

                            //登录后跳转
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        //QQ自动登录
        ivRegisterqq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTencent.login(RegisterActivity.this, "get_user_info", new LoginUiListener());
            }
        });

    }

    @Override
    protected void bindData() {}

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
                    mUserInfo = new UserInfo(RegisterActivity.this,mTencent.getQQToken());
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
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
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

            Toast.makeText(RegisterActivity.this,e.errorMessage,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {}

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            mTencent.onActivityResultData(requestCode, resultCode, data, new LoginUiListener());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
