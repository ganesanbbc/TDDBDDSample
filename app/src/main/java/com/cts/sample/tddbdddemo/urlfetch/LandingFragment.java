package com.cts.sample.tddbdddemo.urlfetch;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cts.sample.tddbdddemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LandingFragment extends Fragment {

    private View view;
    private Button mBtnLogout;
    private OnLandingFragmentListener mListener;

    public LandingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnLandingFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnLandingFragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_landing, container, false);
        mBtnLogout = (Button)view.findViewById(R.id.btn_logout);
        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null) {
                    mListener.onLogout();
                }
            }
        });
        return view;
    }

    public interface OnLandingFragmentListener {
        void onLogout();
    }
}
