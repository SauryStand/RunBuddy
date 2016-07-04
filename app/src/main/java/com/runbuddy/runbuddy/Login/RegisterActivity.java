package com.runbuddy.runbuddy.Login;

import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.runbuddy.runbuddy.sqlite.MytabOperate;


/**
 * Created by Administrator on 2016/6/4.
 */
public class RegisterActivity extends Activity {

    private Button registerBack;
    private Button registerCheck;
    private Button registerBtn;
    private EditText registerId;
    private EditText registerPassword;
    private EditText registerAuth;
    private EditText turePassword;
    private TextView registerBackText;
    private TextView registerIdText;
    private TextView registerPwText;
    private TextView turePwText;
    private TextView registerAuthText;
    private ImageView registerAuthimg;
    private String isPhone, isPassword, isTruePassword, Autecode, Autecodeimg;
    private int flagPhone, flagPassword, flagTruePassword, flagAutecode;
    private SQLiteOpenHelper helper;
    private MytabOperate mylogin;



}
