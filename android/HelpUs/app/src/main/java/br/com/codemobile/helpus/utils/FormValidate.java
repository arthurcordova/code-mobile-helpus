package br.com.codemobile.helpus.utils;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import br.com.codemobile.helpus.R;

/**
 * Created by acstapassoli on 08/03/2017.
 */

public class FormValidate {

    public static boolean isEmpty(EditText edit, TextInputLayout hint){
        Context ctx = edit.getContext();
        if (!(edit.getText().toString().length() > 0)){
            hint.setError(ctx.getString(R.string.label_invalid_field));
            return true;
        }
        hint.setError(null);
        return false;
    }

    public static boolean isValidCharacters(EditText edit, TextInputLayout hint, String error, int min, int max){
        int chars = edit.getText().toString().length();
        if (!(chars >= min && chars <= max)){
            hint.setError(error);
            return true;
        }
        hint.setError(null);
        return false;
    }

    public static boolean isValidEmail(EditText edit, TextInputLayout hint){
        Context ctx = edit.getContext();
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(edit.getText().toString()).matches()){
            hint.setError(ctx.getString(R.string.label_invalid_email));
            return true;
        }
        hint.setError(null);
        return false;
    }

}
