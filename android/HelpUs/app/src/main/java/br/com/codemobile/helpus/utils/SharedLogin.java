package br.com.codemobile.helpus.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by acstapassoli on 08/12/2016.
 */

public class SharedLogin {

    private Context mCtx;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;
    private final String SHARED_ID = "shared_login";

    private final String LOGIN = "1";
    private final String PWD = "2";
    private final String NEW = "3";

    public static SharedLogin getInstance(Context ctx) {
        return new SharedLogin(ctx);
    }

    private SharedLogin(Context ctx) {
        mCtx = ctx;
        mShared = mCtx.getSharedPreferences(SHARED_ID, Context.MODE_PRIVATE);
        mEditor = mShared.edit();
    }

    public void save(String email, String pwd, boolean isNew) {
        mEditor.putString(LOGIN, email);
        mEditor.putString(PWD, pwd);
        mEditor.putBoolean(NEW, isNew);
        mEditor.commit();
    }

    public String getLogin() {
        return mShared.getString(LOGIN, "");
    }

    public String getPwd() {
        return mShared.getString(PWD, "");
    }

    public boolean isNew () {
        return mShared.getBoolean(NEW, false);
    }

    public void clear() {
        mEditor.clear();
        mEditor.commit();
    }
}
