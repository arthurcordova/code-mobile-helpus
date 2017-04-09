package br.com.codemobile.helpus.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import br.com.codemobile.helpus.R;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        findViewById(R.id.view_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ((TextView) findViewById(R.id.view_title)).setText(getString(R.string.label_settings));
    }

}
