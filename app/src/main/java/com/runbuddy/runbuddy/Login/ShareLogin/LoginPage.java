package com.runbuddy.runbuddy.Login.ShareLogin;

/**
 * Created by Administrator on 2016/6/6.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import com.runbuddy.runbuddy.R;

import java.util.HashMap;

import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;


public class LoginPage extends Activity implements OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        initPlatformList();
    }

    /* 获取平台列表,显示平台按钮*/
    private void initPlatformList() {
        ShareSDK.initSDK(this);
        Platform[] Platformlist = ShareSDK.getPlatformList();
        if (Platformlist != null) {
            LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            lp.weight = 1;
            for (Platform platform : Platformlist) {
                if (!Tool.canGetUserInfo(platform)) {
                    continue;
                }

                if (platform instanceof CustomPlatform) {
                    continue;
                }

                Button btn = new Button(this);
                btn.setSingleLine();
                String name = platform.getName();
                System.out.println("名字" + name);
                if (platform.isAuthValid()) {
                    btn.setText(getString(R.string.remove_to_format, name));
                } else {
                    btn.setText(getString(R.string.login_to_format, name));
                }
                btn.setTextSize(16);
                btn.setTag(platform);
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(this);
                linear.addView(btn, lp);
            }
        }
    }

    public void onClick(View v) {
        Button btn = (Button) v;
        Object tag = v.getTag();
        if (tag != null) {
            Platform platform = (Platform) tag;
            String name = platform.getName();
            System.out.println("名字" + name + " " + getString(R.string.login_to_format, name));
            if (!platform.isAuthValid()) {
                btn.setText(getString(R.string.remove_to_format, name));
            } else {
                btn.setText(getString(R.string.login_to_format, name));
                String msg = getString(R.string.remove_to_format_success, name);
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
            //登陆逻辑的调用
            login(name);
        }
    }

    /*
     * 演示执行第三方登录/注册的方法
     * <p>
     * 这不是一个完整的示例代码，需要根据您项目的业务需求，改写登录/注册回调函数
     *
     * @param platformName 执行登录/注册的平台名称，如：SinaWeibo.NAME
     */
    private void login(String platformName) {
        LoginApi api = new LoginApi();
        //设置登陆的平台后执行登陆的方法
        api.setPlatform(platformName);
        api.setOnLoginListener(new OnLoginListener() {
            public boolean onLogin(String platform, HashMap<String, Object> res) {
                // 在这个方法填写尝试的代码，返回true表示还不能登录，需要注册
                // 此处全部给回需要注册
                return true;
            }

            public boolean onRegister(UserInfo info) {
                // 填写处理注册信息的代码，返回true表示数据合法，注册页面可以关闭
                return true;
            }
        });
        api.login(this);
    }

}
