package com.dumbphone.dumbphone.views;

import android.os.Bundle;

import com.dumbphone.dumbphone.R;
import com.dumbphone.dumbphone.adapter.MainAdapter;
import com.dumbphone.dumbphone.utils.BaseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
    }

}