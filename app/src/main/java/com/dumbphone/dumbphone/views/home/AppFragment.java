package com.dumbphone.dumbphone.views.home;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dumbphone.dumbphone.R;
import com.dumbphone.dumbphone.model.AppModel;
import com.dumbphone.dumbphone.utils.BaseFragment;
import com.dumbphone.dumbphone.utils.Singleton;

import java.util.ArrayList;
import java.util.List;

public class AppFragment extends BaseFragment {
    private View view;
    private RecyclerView app_list;
    private GridLayoutManager gridLayoutManager;
    private static final String TAG = AppFragment.class.getSimpleName();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.app_fragment, container, false);
        Singleton.getInstance().setContext(getContext());

        initApp();
        initViews();
        initListeners();

        return view;
    }

    public void initApp(){
        getInstalledApps(true);
    }

    public void initViews(){
        app_list = view.findViewById(R.id.app_list);
    }

    public void initListeners(){

    }

    private ArrayList<AppModel> getInstalledApps(boolean getSysPackages) {
        ArrayList<AppModel> res = new ArrayList<AppModel>();
        List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);
        for(int i=0;i<packs.size();i++) {
            PackageInfo p = packs.get(i);
            if ((!getSysPackages) && (p.versionName == null)) {
                continue ;
            }
            AppModel newInfo = new AppModel();
            Log.d(TAG, p.applicationInfo.loadLabel(getActivity().getPackageManager()).toString());
            newInfo.pname = p.packageName;
            newInfo.versionName = p.versionName;
            newInfo.versionCode = p.versionCode;
            newInfo.icon = p.applicationInfo.loadIcon(getActivity().getPackageManager());
            res.add(newInfo);
        }
        return res;
    }

    public static AppFragment newInstance(String s) {
        Log.d(TAG, s);
        AppFragment appFragment = new AppFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TAG, s);
        return appFragment;
    }
}