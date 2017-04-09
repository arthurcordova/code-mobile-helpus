package br.com.codemobile.helpus.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.codemobile.helpus.R;
import br.com.codemobile.helpus.utils.FormValidate;
import br.com.codemobile.helpus.utils.MessageAnimationBar;
import br.com.codemobile.helpus.utils.SharedLogin;

public class RegisterActivity extends Activity {

    View mNotificationView;
    EditText mEditName;
    TextInputLayout mLayoutName;
    EditText mEditLastName;
    TextInputLayout mLayoutLastName;
    EditText mEditEmail;
    TextInputLayout mLayoutEmail;
    EditText mEditPwd;
    TextInputLayout mLayoutPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mNotificationView = findViewById(R.id.notification_view);
        mEditName = (EditText) findViewById(R.id.edit_name);
        mLayoutName = (TextInputLayout) findViewById(R.id.layout_name);

        mEditLastName = (EditText) findViewById(R.id.edit_last_name);
        mLayoutLastName = (TextInputLayout) findViewById(R.id.layout_last_name);

        mEditEmail = (EditText) findViewById(R.id.edit_email);
        mLayoutEmail = (TextInputLayout) findViewById(R.id.layout_email);

        mEditPwd = (EditText) findViewById(R.id.edit_password);
        mLayoutPwd = (TextInputLayout) findViewById(R.id.layout_password);

        findViewById(R.id.view_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ((TextView) findViewById(R.id.view_title)).setText(getString(R.string.label_register_user));

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkFieldsEmpty()) {
                    if (checkFieldsChars()) {
                        if (checkEmail()) {
                            SharedLogin sh = SharedLogin.getInstance(RegisterActivity.this);
                            sh.save(mEditEmail.getText().toString(), mEditPwd.getText().toString(), true);
                            MessageAnimationBar.anime(RegisterActivity.this, mNotificationView, null, true);
                        }
                    }
                }
            }
        });
    }

    protected boolean checkFieldsEmpty() {
        return (!FormValidate.isEmpty(mEditName, mLayoutName) &&
                !FormValidate.isEmpty(mEditLastName, mLayoutLastName) &&
                !FormValidate.isEmpty(mEditEmail, mLayoutEmail) &&
                !FormValidate.isEmpty(mEditPwd, mLayoutPwd));
    }

    protected boolean checkFieldsChars() {
        return (!FormValidate.isValidCharacters(mEditName, mLayoutName, getString(R.string.label_invalid_name), 2, 100) &&
                !FormValidate.isValidCharacters(mEditLastName, mLayoutLastName, getString(R.string.label_invalid_last), 2, 100) &&
                !FormValidate.isValidCharacters(mEditEmail, mLayoutEmail, getString(R.string.label_invalid_email), 2, 100) &&
                !FormValidate.isValidCharacters(mEditPwd, mLayoutPwd, getString(R.string.label_invalid_password), 8, 8));
    }

    protected boolean checkEmail() {
        return !FormValidate.isValidEmail(mEditEmail, mLayoutEmail);
    }


    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }

    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }
}
