package com.project.mad.fincheck;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.kaelaela.verticalviewpager.VerticalViewPager;
import me.kaelaela.verticalviewpager.transforms.StackTransformer;
import me.kaelaela.verticalviewpager.transforms.ZoomOutTransformer;

public class DayFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static DayFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        DayFragment fragment = new DayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);

    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_day_fragment, container, false);
        VerticalViewPager viewPager = (VerticalViewPager) view.findViewById(R.id.vertical_viewpager);
        //viewPager.setPageTransformer(false, new ZoomOutTransformer());
        viewPager.setPageTransformer(true, new StackTransformer());
        viewPager.setAdapter(new ContentFragmentAdapter(getChildFragmentManager()));

                //If you setting other scroll mode, the scrolled fade is shown from either side of display.
                viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
        return view;
    }


}
