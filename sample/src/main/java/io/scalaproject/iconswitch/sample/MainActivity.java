package io.scalaproject.iconswitch.sample;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import io.scalaproject.iconswitch.IconSwitch;
import io.scalaproject.iconswitch.IconSwitch.Checked;

public class MainActivity extends AppCompatActivity {

    private static final int DURATION_COLOR_CHANGE_MS = 400;

    private static final Uri URL_GITHUB_POLYAK = Uri.parse("https://github.com/polyak01");
    private static final Uri URL_GITHUB_YAROLEGOVICH = Uri.parse("https://github.com/yarolegovich");
    private static final Uri URL_DRIBBBLE_PROKHODA = Uri.parse("https://dribbble.com/prokhoda");

    /*private int[] toolbarColors;
    private int[] statusBarColors;
    private ValueAnimator statusBarAnimator;
    private Interpolator contentInInterpolator;
    private Interpolator contentOutInterpolator;
    private Point revealCenter;*/

    private Window window;
    private View toolbar;
    private View content;
    private IconSwitch iconSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        window = getWindow();

        //initColors();
        //initAnimationRelatedFields();

        //content = findViewById(R.id.content);
        toolbar = findViewById(R.id.toolbar);
        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText(R.string.app_name);

        iconSwitch = (IconSwitch) findViewById(R.id.icon_switch);
        //iconSwitch.setCheckedChangeListener((IconSwitch.CheckedChangeListener) this);
        //updateColors(false);

        /*FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment fragment = (SupportMapFragment) fm.findFragmentById(R.id.map_container);
        if (fragment == null) {
            fragment = new SupportMapFragment();
            fm.beginTransaction().replace(R.id.map_container, fragment).commit();
        }
        fragment.getMapAsync(this);*/

        /*findViewById(R.id.credit_polyak).setOnClickListener(this);
        findViewById(R.id.credit_yarolegovich).setOnClickListener(this);
        findViewById(R.id.credit_prokhoda).setOnClickListener(this);*/
    }

    /*private void updateColors(boolean animated) {
        int colorIndex = iconSwitch.getChecked().ordinal();
        toolbar.setBackgroundColor(toolbarColors[colorIndex]);
        if (animated) {
            switch (iconSwitch.getChecked()) {
                case LEFT:
                    statusBarAnimator.reverse();
                    break;
                case RIGHT:
                    statusBarAnimator.start();
                    break;
            }
            revealToolbar();
        } else {
            window.setStatusBarColor(statusBarColors[colorIndex]);
        }
    }

    private void revealToolbar() {
        iconSwitch.getThumbCenter(revealCenter);
        moveFromSwitchToToolbarSpace(revealCenter);
        ViewAnimationUtils.createCircularReveal(toolbar,
                revealCenter.x, revealCenter.y,
                iconSwitch.getHeight(), toolbar.getWidth())
                .setDuration(DURATION_COLOR_CHANGE_MS)
                .start();
    }

    private void changeContentVisibility() {
        int targetTranslation = 0;
        Interpolator interpolator = null;
        switch (iconSwitch.getChecked()) {
            case LEFT:
                targetTranslation = 0;
                interpolator = contentInInterpolator;
                break;
            case RIGHT:
                targetTranslation = content.getHeight();
                interpolator = contentOutInterpolator;
                break;
        }
        content.animate().cancel();
        content.animate()
                .translationY(targetTranslation)
                .setInterpolator(interpolator)
                .setDuration(DURATION_COLOR_CHANGE_MS)
                .start();
    }

    private void initAnimationRelatedFields() {
        revealCenter = new Point();
        statusBarAnimator = createArgbAnimator(
                statusBarColors[Checked.LEFT.ordinal()],
                statusBarColors[Checked.RIGHT.ordinal()]);
        contentInInterpolator = new OvershootInterpolator(0.5f);
        contentOutInterpolator = new DecelerateInterpolator();
    }

    private void initColors() {
        toolbarColors = new int[Checked.values().length];
        statusBarColors = new int[toolbarColors.length];
        toolbarColors[Checked.LEFT.ordinal()] = color(R.color.informationPrimary);
        statusBarColors[Checked.LEFT.ordinal()] = color(R.color.informationPrimaryDark);
        toolbarColors[Checked.RIGHT.ordinal()] = color(R.color.mapPrimary);
        statusBarColors[Checked.RIGHT.ordinal()] = color(R.color.mapPrimaryDark);
    }

    private ValueAnimator createArgbAnimator(int leftColor, int rightColor) {
        ValueAnimator animator = ValueAnimator.ofArgb(leftColor, rightColor);
        animator.setDuration(DURATION_COLOR_CHANGE_MS);
        animator.addUpdateListener((ValueAnimator.AnimatorUpdateListener) this);
        return animator;
    }*/

    private void moveFromSwitchToToolbarSpace(Point point) {
        point.set(point.x + iconSwitch.getLeft(), point.y + iconSwitch.getTop());
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }
}
