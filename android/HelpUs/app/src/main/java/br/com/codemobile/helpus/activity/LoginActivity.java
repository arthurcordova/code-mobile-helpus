package br.com.codemobile.helpus.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import br.com.codemobile.helpus.MapsActivity;
import br.com.codemobile.helpus.R;
import br.com.codemobile.helpus.utils.SharedLogin;

public class LoginActivity extends AppCompatActivity {

    Context mContext;
    EditText mLogin;
    EditText mPwd;
    FirebaseAuth mAuth;

//    FirebaseAuth.AuthStateListener mAuthListener = new FirebaseAuth.AuthStateListener() {
//        @Override
//        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//            FirebaseUser user = firebaseAuth.getCurrentUser();
//
//            if (user != null) {
//
////---- HERE YOU CHECK IF EMAIL IS VERIFIED
//
//                if (user.isEmailVerified()) {
//                    Toast.makeText(LoginActivity.this,"You are in =)",Toast.LENGTH_LONG).show();
//                }
//
//                else {
//
////---- HERE YOU SEND THE EMAIL
//
//                    user.sendEmailVerification();
//                    Toast.makeText(LoginActivity.this,"Check your email first...",Toast.LENGTH_LONG).show();
//                }
//
//            } else {
//                // User is signed out
//                Log.d("TESTE", "onAuthStateChanged:signed_out");
//            }
//            // [START_EXCLUDE]
//
//            // [END_EXCLUDE]
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
//        mAuth.addAuthStateListener(mAuthListener);


        mContext = this;
        mLogin = (EditText) findViewById(R.id.edit_login);
        mPwd = (EditText) findViewById(R.id.edit_pwd);


        findViewById(R.id.btn_sign_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, MapsActivity.class));

//
//                mAuth.createUserWithEmailAndPassword(mLogin.getText().toString(), mPwd.getText().toString()).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        Log.d("Login", "createUserWithEmail:onComplete:" + task.isSuccessful());
//
//
//                        mAuth.getCurrentUser().sendEmailVerification();
//                        if (mAuth.getCurrentUser().isEmailVerified()){
//                            Toast.makeText(LoginActivity.this, "USER OK",
//                                    Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(LoginActivity.this, "NOT VERIFY",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//
//                        // If sign in fails, display a message to the user. If sign in succeeds
//                        // the auth state listener will be notified and logic to handle the
//                        // signed in user can be handled in the listener.
//
//
//                        if (!task.isSuccessful()) {
//                            Toast.makeText(LoginActivity.this, "Athentication failu",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//
//                        // ...
//                    }
//                });


//                String token = FirebaseInstanceId.getInstance().getToken();
//                Toast.makeText(LoginActivity.this, "My token: " + token, Toast.LENGTH_SHORT).show();
            }
        });


        findViewById(R.id.tv_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, RegisterActivity.class));

//                FirebaseMessaging.getInstance().subscribeToTopic("news");
//                // [END subscribe_topics]
//                Toast.makeText(LoginActivity.this, "Inscrição FCM", Toast.LENGTH_SHORT).show();

            }
        });


//        if (getIntent().getExtras() != null) {
//            for (String key : getIntent().getExtras().keySet()) {
//                Object value = getIntent().getExtras().get(key);
//                Log.d("ARTHUR", "Key: " + key + " Value: " + value);
//            }
//        }

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedLogin sh = SharedLogin.getInstance(LoginActivity.this);
        mLogin.setText(sh.getLogin());
        if (sh.isNew()) {
            mPwd.setText(sh.getPwd());
        } else {
            mPwd.setText("");
        }
        sh.save(sh.getLogin(), "", false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onPause() {
        super.onPause();
//        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }
}
