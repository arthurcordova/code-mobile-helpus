package br.com.codemobile.helpus.utils;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import br.com.codemobile.helpus.R;

/**
 * Created by acstapassoli on 08/03/2017.
 */

public class MessageAnimationBar {

    private static final int DELAY = 3000;

//    public static void anime(final AppCompatActivity activity, final View view, final Intent intent, final boolean isFinished ){
//        final Animation slideInDown = AnimationUtils.loadAnimation(view.getContext(),
//                R.anim.slide_in_down);
//        final Animation slideOutUp = AnimationUtils.loadAnimation(view.getContext(),
//                R.anim.slide_out_up);
//
//        view.setVisibility(View.VISIBLE);
//        view.startAnimation(slideInDown);
//        view.postOnAnimationDelayed(new Runnable() {
//            @Override
//            public void run() {
//                view.startAnimation(slideOutUp);
//                view.postOnAnimation(new Runnable() {
//                    @Override
//                    public void run() {
//                        view.setVisibility(View.GONE);
//
//                        if (intent != null){
//                            activity.startActivity(intent);
//                        }
//                        if (isFinished) {
//                            activity.finish();
//                        }
//                    }
//                });
//            }
//        }, DELAY);
//    }

    public static void anime(final Activity activity, final View view, final Intent intent, final boolean isFinished ){
        final Animation slideInDown = AnimationUtils.loadAnimation(view.getContext(),
                R.anim.slide_in_down);
        final Animation slideOutUp = AnimationUtils.loadAnimation(view.getContext(),
                R.anim.slide_out_up);

        view.setVisibility(View.VISIBLE);
        view.startAnimation(slideInDown);
        view.postOnAnimationDelayed(new Runnable() {
            @Override
            public void run() {
                view.startAnimation(slideOutUp);
                view.postOnAnimation(new Runnable() {
                    @Override
                    public void run() {
                        view.setVisibility(View.GONE);

                        if (intent != null){
                            activity.startActivity(intent);
                        }
                        if (isFinished) {
                            activity.finish();
                        }
                    }
                });
            }
        }, DELAY);
    }
}


