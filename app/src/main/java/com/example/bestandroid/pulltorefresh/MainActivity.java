package com.example.bestandroid.pulltorefresh;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editText_ID;
    private EditText editText_pwd;
   private Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editText_ID = (EditText) this.findViewById(R.id.editText1);
        this.editText_pwd = (EditText) this.findViewById(R.id.editText2);
      this.resources=this.getResources();
    }

    public void resert(View view) {
        editText_ID.setText("");
        editText_pwd.setText("");

        this.editText_ID.requestFocus();


    }

    public void ok(View view) {
        String id = editText_ID.getText().toString().trim();
        String pwd = editText_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            editText_ID.setError(this.resources.getString(R.string.user_name_error));
            editText_ID.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            editText_pwd.setError(this.resources.getString(R.string.pwd_name_error));
            editText_pwd.requestFocus();
        } else if ("12345".equals(id) && "123".equals(pwd)) {
            Toast.makeText(this, id + this.resources.getString(R.string.login_success), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, this.resources.getString(R.string.login_error), Toast.LENGTH_SHORT).show();
        }

    }
}
