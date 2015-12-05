package com.cts.sample.tddbdddemo.introscreen;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cts.sample.tddbdddemo.R;

import org.w3c.dom.Text;

import static com.cts.sample.tddbdddemo.R.id.header;
import static com.cts.sample.tddbdddemo.R.id.viewpager;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private ViewPager viewPager;
    private ValueAnimator mColorAnimation;




    public WelcomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (ViewPager) view.findViewById(viewpager);
        viewPager.setAdapter(new MyPageAdapter(getActivity().getSupportFragmentManager()));
        viewPager.setPageTransformer(true, new DepthPageTransformer());
    }

    private class MyPageAdapter extends FragmentPagerAdapter {
        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new MyFragment(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


    public class MyFragment extends Fragment {

        private TextView textView;
        private int position;
        private LinearLayout headerView;

        int[] bgColor = {R.color.material_deep_teal_500,
                R.color.material_blue_grey_800,
                R.color.colorAccent,
                R.color.material_blue_grey_950};

        public MyFragment(int position) {
            this.position = position;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment, container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            textView = (TextView) view.findViewById(R.id.textview);
            textView.setText(String.valueOf(position));
            headerView = (LinearLayout) view.findViewById(R.id.header);
            headerView.setBackgroundResource(bgColor[position]);
//            headerView.setBackgroundColor(bgColor[position]);
        }
    }
}
