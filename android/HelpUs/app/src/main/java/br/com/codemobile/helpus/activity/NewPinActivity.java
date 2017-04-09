package br.com.codemobile.helpus.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.codemobile.helpus.R;
import br.com.codemobile.helpus.adapter.RVAdapterClassification;
import br.com.codemobile.helpus.utils.AnimationUtils;

public class NewPinActivity extends Activity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pin);

        findViewById(R.id.view_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ((TextView) findViewById(R.id.view_title)).setText(getString(R.string.label_rate_your_issue));
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_classification);

        List<Bitmap> list = new ArrayList<>();
        list.add(getBitmap(this, R.drawable.ic_flash));
        list.add(getBitmap(this, R.drawable.ic_drop));
        list.add(getBitmap(this, R.drawable.ic_road));
        list.add(getBitmap(this, R.drawable.ic_police));
        list.add(getBitmap(this, R.drawable.ic_cone));

        List<String> names = new ArrayList<>();
        names.add("Eletricidade");
        names.add("Saneamento");
        names.add("Pavimentação");
        names.add("Segurança");
        names.add("Obras");

        RVAdapterClassification adapter = new RVAdapterClassification(list, names);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutAnimation(AnimationUtils.slideInRight(this));

    }

    private Bitmap getBitmap(VectorDrawable vectorDrawable) {
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        Log.e("IMAGE", "getBitmap: 1");
        return bitmap;
    }

    private Bitmap getBitmap(Context context, int drawableId) {
        Log.e("IMAGE", "getBitmap: 2");
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (drawable instanceof BitmapDrawable) {
            return BitmapFactory.decodeResource(context.getResources(), drawableId);
        } else if (drawable instanceof VectorDrawable) {
            return getBitmap((VectorDrawable) drawable);
        } else {
            throw new IllegalArgumentException("unsupported drawable type");
        }
    }

}
