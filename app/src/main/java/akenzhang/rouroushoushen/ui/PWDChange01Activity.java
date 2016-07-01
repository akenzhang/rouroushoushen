package akenzhang.rouroushoushen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.okhttp.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import akenzhang.rouroushoushen.R;

/**
 * Created by Administrator on 2016/7/1.
 */
public class PWDChange01Activity extends BaseActivity {

    private ImageView imageView_pwd_change;
    private EditText editText_pwd_change;
    private Button btn_pwd_change;

    @Override
    protected int getLayout() {
        return R.layout.activity_pwdchange01_layout;
    }

    @Override
    protected void initView() {

        imageView_pwd_change = (ImageView) this.findViewById(R.id.id_btn_pwd_change_back);
        editText_pwd_change = (EditText) this.findViewById(R.id.id_editview_pwd_change);
        btn_pwd_change = (Button) this.findViewById(R.id.id_btn_pwd_change);

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initListener() {

        imageView_pwd_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PWDChange01Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_pwd_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //首先拿到输入的手机号码
                final String strPhone = editText_pwd_change.getText().toString();
                if(!TextUtils.isDigitsOnly(strPhone) || strPhone.length()<11 || !strPhone.startsWith("1")){
                    Toast.makeText(PWDChange01Activity.this,"手机号码输入不正确！",Toast.LENGTH_SHORT).show();
                    return;
                }

                //查询数据库，看该用户是否存在
                String strCheckPhoneNum = "http://www.1316818.com/jsonserver.aspx?checkphonenum="+ strPhone +"";
                OkHttpUtils.getAsync(strCheckPhoneNum, new OkHttpUtils.DataCallBack() {
                    @Override
                    public void requestFailure(Request request, IOException e) {}

                    @Override
                    public void requestSuccess(String result) {
                        try {
                            JSONObject json =  new JSONObject(result);
                            String strStatus = json.getString("status");

                            if(strStatus.equals("1")){

                                //======================= 这里实现发送短信的逻辑代码 =================================
                                try {
                                    final String strCode  = json.getString("msg");
                                    String strSend = URLEncoder.encode("请输入验证码："+ strCode +"","gb2312");
                                    String strRequestUrl = "http://service.winic.org/sys_port/gateway/?id=13509611303&pwd=1QAZ1qaz&to="+ strPhone +"&content="+ strSend +"&time=\"";

                                    OkHttpUtils.getAsync(strRequestUrl, new OkHttpUtils.DataCallBack() {
                                        @Override
                                        public void requestFailure(Request request, IOException e) {}

                                        @Override
                                        public void requestSuccess(String result) {
                                            Log.e("已发送短信--->",result);

                                            Bundle bundle = new Bundle();
                                            bundle.putString("phone",strPhone);
                                            bundle.putString("code",strCode);
                                            Intent intent = new Intent(PWDChange01Activity.this, PWDChange02Activity.class);
                                            intent.putExtras(bundle);
                                            startActivity(intent);
                                        }
                                    });

                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }

                                //========================= 这里实现发送短信的逻辑代码 ===============================

                            }else
                            {
                                Toast.makeText(PWDChange01Activity.this,"手机号码不存在！",Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });

    }

    @Override
    protected void bindData() {

    }
}
