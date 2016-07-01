package akenzhang.rouroushoushen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
public class PWDChange02Activity extends BaseActivity {

    private EditText editview_reset_change;
    private Button btn_reset_change;
    private TextView textview_notice;
    private TextView requestcode;

    private String strPhone;
    private String strCode;

    @Override
    protected int getLayout() {
        return R.layout.activity_pwdchange02_layout;
    }

    @Override
    protected void initView() {

        editview_reset_change = (EditText) this.findViewById(R.id.id_editview_reset_change);
        btn_reset_change = (Button) this.findViewById(R.id.id_btn_reset_change);
        textview_notice = (TextView) this.findViewById(R.id.id_textview_notice);
        requestcode = (TextView) this.findViewById(R.id.id_requestcode);

    }

    @Override
    protected void initVariable() {

        strPhone = this.getIntent().getStringExtra("phone");
        strCode = this.getIntent().getStringExtra("code");

        textview_notice.setText("我们手机号 "+ strPhone +" 发送了一条短信，请将短信中的4位数字验证码填写在下面。");
    }

    @Override
    protected void initListener() {

        requestcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重新获取验证码
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
                                    strCode  = json.getString("msg");
                                    String strSend = URLEncoder.encode("请输入验证码："+ strCode +"","gb2312");
                                    String strRequestUrl = "http://service.winic.org/sys_port/gateway/?id=13509611303&pwd=1QAZ1qaz&to="+ strPhone +"&content="+ strSend +"&time=\"";

                                    OkHttpUtils.getAsync(strRequestUrl, new OkHttpUtils.DataCallBack() {
                                        @Override
                                        public void requestFailure(Request request, IOException e) {}

                                        @Override
                                        public void requestSuccess(String result) {
                                            Log.e("已发送短信--->",result);
                                        }
                                    });

                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });

        btn_reset_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //这里开始更改核对验证码
                String strCodeInput = editview_reset_change.getText().toString();
                if(strCodeInput.equals(strCode)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("phone",strPhone);
                    bundle.putString("code",strCode);
                    Intent intent = new Intent(PWDChange02Activity.this, PWDChange03Activity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(PWDChange02Activity.this,"验证码不正确！",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }

    @Override
    protected void bindData() {

    }
}
