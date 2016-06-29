package akenzhang.rouroushoushen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.connect.common.Constants;
import com.tencent.open.utils.HttpUtils;
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
public class Login extends AppCompatActivity{

    private Button btn_qq;
    //QQ登陆
    private static String APP_ID="1105434609";
    private Tencent mTencent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);

        btn_qq = (Button) this.findViewById(R.id.btn_qq);

        // Tencent类是SDK的主要实现类，开发者可通过Tencent类访问腾讯开放的OpenAPI。
        // 其中APP_ID是分配给第三方应用的appid，类型为String。
        if(mTencent==null) {
            mTencent = Tencent.createInstance(APP_ID, this.getApplicationContext());
        }
        btn_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mTencent.isSessionValid())
                {
                    mTencent.login(Login.this, "get_user_info", new BaseUiListener());
                }
            }
        });

    }
    public void login(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            mTencent.onActivityResultData(requestCode, resultCode, data, new BaseUiListener());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //实现QQ登陆的回调接口
    class BaseUiListener implements IUiListener {

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

                    new Thread(){
                        @Override
                        public void run() {
                            JSONObject json = null;
                            try {
                                json = mTencent.request(Constants.GRAPH_BASE, null, Constants.HTTP_GET);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (HttpUtils.NetworkUnavailableException e) {
                                e.printStackTrace();
                            } catch (HttpUtils.HttpStatusException e) {
                                e.printStackTrace();
                            }

                            System.out.println(json);
                            Log.e("===========",json.toString());

                            //Toast.makeText(Login.this,json.toString(),Toast.LENGTH_SHORT).show();

                        }
                    }.start();


                    /*
                    mTencent.requestAsync(
                            Constants.GRAPH_SIMPLE_USER_INFO
                            , null
                            , Constants.HTTP_GET
                            ,new BaseApiListener("get_simple_userinfo", false)
                            ,null);
                      */
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);

        }

        @Override
        public void onError(UiError e) {

            Toast.makeText(Login.this,e.errorMessage,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {}

    }
}
