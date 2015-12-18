package com.cts.sample.tddbdddemo.newsstand;

import android.widget.AbsListView;

public interface ScrollTabHolder {

	void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount, int pagePosition);
}
