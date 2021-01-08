package com.dumbphone.dumbphone.views.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dumbphone.dumbphone.R;
import com.dumbphone.dumbphone.utils.BaseFragment;
import com.dumbphone.dumbphone.utils.Singleton;

public class AppFragment extends BaseFragment {
    private View view;
    private static final String TAG = AppFragment.class.getSimpleName();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.app_fragment, container, false);
        Singleton.getInstance().setContext(getContext());

        return view;
    }

    public static AppFragment newInstance(String s) {
        Log.d(TAG, s);
        AppFragment appFragment = new AppFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TAG, s);
        return appFragment;
    }
}