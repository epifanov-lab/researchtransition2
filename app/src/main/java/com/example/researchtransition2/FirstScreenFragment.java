package com.example.researchtransition2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FirstScreenFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {

    View root = inflater.inflate(R.layout.fragment_first, container, false);
    final View view = root.findViewById(R.id.view_transition_1);
    view.setOnClickListener(this::click);
    return root;
  }

  public static FirstScreenFragment instance() {
    return new FirstScreenFragment();
  }

  private void click(View view) {
    System.out.println("CLICK ^^%^%^&%&");

    SecondScreenFragment second = SecondScreenFragment.instance();
    second.setSharedElementEnterTransition(new DetailsTransition());
    //second.setEnterTransition(new Explode());
    //second.setEnterTransition(new Fade());
    //setExitTransition(new Fade());
    second.setSharedElementReturnTransition(new DetailsTransition());

    getActivity().getSupportFragmentManager()
      .beginTransaction()
      .addSharedElement(view, "view_transition")
      .replace(R.id.replace_fragment, second)
      .addToBackStack(null)
      .commit();
  }

}
