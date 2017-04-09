package br.com.codemobile.helpus.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;

/**
 * Created by acstapassoli on 23/01/2017.
 */

public class AnimationUtils {

    public static LayoutAnimationController fadeIn() {
        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(500);
        set.addAnimation(animation);

        animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f
        );
        animation.setDuration(100);
        set.addAnimation(animation);
        return new LayoutAnimationController(set, 0.5f);
    }

    public static LayoutAnimationController slideInLeft(Context ctx) {
        AnimationSet set = new AnimationSet(true);

        Animation animation = android.view.animation.AnimationUtils.loadAnimation(ctx, android.R.anim.slide_in_left);
        animation.setDuration(300);
        set.addAnimation(animation);

        animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f
        );
        animation.setDuration(50);
        set.addAnimation(animation);
        return new LayoutAnimationController(set, 0.5f);
    }

    public static LayoutAnimationController slideInRight(Context ctx) {
        AnimationSet set = new AnimationSet(true);

//        Animation animation = android.view.animation.AnimationUtils.loadAnimation(ctx, R.anim.slide_right_to_left);
        Animation animation = android.view.animation.AnimationUtils.loadAnimation(ctx, android.R.anim.fade_in);
        animation.setDuration(300);
        set.addAnimation(animation);

        animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f
        );
        animation.setDuration(50);
        set.addAnimation(animation);
        return new LayoutAnimationController(set, 0.5f);
    }


    public static void slideToTop(final View view) {
        view.animate()
                .translationY(-view.getBottom()).setInterpolator(new AccelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        view.setVisibility(View.GONE);
                    }
                }).start();

    }

    public static void slideToBottom(final View view) {
        view.animate()
                .translationY(view.getTop()).setInterpolator(new AccelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        view.setVisibility(View.VISIBLE);
                    }
                }).start();

    }

}
