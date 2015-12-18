package com.cts.sample.tddbdddemo.newsstand;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.SparseArrayCompat;

/**
 * Created by shanmg02 on 11/12/15.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private SparseArrayCompat<ScrollTabHolder> mScrollTabHolders;
    private final String[] TITLES = {"Page 1", "Page 2", "Page 3", "Page 4"};
    private ScrollTabHolder mListener;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        mScrollTabHolders = new SparseArrayCompat<ScrollTabHolder>();
    }

    public void setTabHolderScrollingContent(ScrollTabHolder listener) {
        mListener = listener;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        ScrollTabHolderFragment fragment = (ScrollTabHolderFragment) SampleListFragment.newInstance(position);

        mScrollTabHolders.put(position, fragment);
        if (mListener != null) {
            fragment.setScrollTabHolder(mListener);
        }

        return fragment;
    }

    public SparseArrayCompat<ScrollTabHolder> getScrollTabHolders() {
        return mScrollTabHolders;
    }

}
