package com.example.researchtransition2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import androidx.fragment.app.Fragment;

public class SecondScreenFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {

    View root = inflater.inflate(R.layout.fragment_second, container, false);

    final View v1 = root.findViewById(R.id.view_transition_1);
    final View v2 = root.findViewById(R.id.view_transition_2);

    v1.setOnClickListener(v -> replace(v, v2));
    v2.setOnClickListener(v -> replace(v, v1));

    return root;
  }

  public static SecondScreenFragment instance() {
    return new SecondScreenFragment();
  }

  private static void replace(View front, View back) {
    animateViewScale(front, 1, 4, 1, 4, 500, () -> {});

    //animateViewScale(back, 1, 0.33f, 1, 0.33f, 500, back::bringToFront);

    animateViewScale(back, 1, 0.33f, 1, 0.33f, 500, () -> {
      back.setTranslationZ(1f);
      front.setTranslationZ(0f);
    });
  }

  private static void animateViewScale(View v1,
                                       float fromX, float toX,
                                       float fromY, float toY,
                                       int duration,
                                       Runnable after) {

    Animation anim = new ScaleAnimation(
      fromX, toX, // Start and end values for the X axis scaling
      fromY, toY, // Start and end values for the Y axis scaling
      Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
      Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
    anim.setFillAfter(true); // Needed to keep the result of the animation
    anim.setDuration(duration);
    v1.startAnimation(anim);
    v1.postDelayed(after, duration);
  }


}
