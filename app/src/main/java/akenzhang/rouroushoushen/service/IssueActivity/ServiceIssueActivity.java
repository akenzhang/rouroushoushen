package akenzhang.rouroushoushen.service.IssueActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import akenzhang.rouroushoushen.R;

public class ServiceIssueActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_click_issue);

        textView = (TextView) findViewById(R.id.backward);

        textView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        ServiceIssueActivity.this.finish();
    }
}
