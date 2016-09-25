package com.example.zhiwen.httptest.activity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.toollib.Tools.logger.Logger;
import com.example.libcore.Common.Cmd;
import com.example.zhiwen.httptest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    public static final String TAG = "TAG."+MainActivity.class.getName();
    @BindView(R.id.etURL)
    EditText URL;
    @BindView(R.id.btnPhp)
    Button phpBtn;
    @BindView(R.id.btnHtml)
    Button htmlBtn;
    @BindView(R.id.btnGo)
    Button goBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btnPhp, R.id.btnHtml, R.id.btnGo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPhp:
                break;
            case R.id.btnHtml:
                break;
            case R.id.btnGo:
                postCmd(Cmd.REQUEST_BASE_URL);
                break;
        }
    }

    @Override
    public void onCmdFailed(int cmd, Message obj) {
        super.onCmdFailed(cmd, obj);
        Logger.d(TAG, "onCmdFailed: cmd:" + cmd);
    }

    @Override
    public void onCmdSuccess(int cmd, Message obj) {
        super.onCmdSuccess(cmd, obj);
        Logger.d(TAG,"onCmdSuccess! cmd:" +  cmd + " msg:" + obj.obj );
    }
}
