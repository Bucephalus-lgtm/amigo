package com.example.sarthi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sarthi.R;
import com.example.sarthi.adapter.IntroViewPagerAdapter;
import com.example.sarthi.model.OnBoardingItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroScreen extends AppCompatActivity {
    private ViewPager screenPage;
    IntroViewPagerAdapter introViewPagerAdapter;
    Button next, getStarted;
    int position = 0;

    ConstraintLayout layout;
    TextView title,desc;
    LottieAnimationView anim;

    Animation btnAnim;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_screen);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,1);

        if(restorePrefData()){
            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(login);
            finish();
        }

        tabLayout = findViewById(R.id.tabLayout);

        next = findViewById(R.id.btn_next);
        getStarted = findViewById(R.id.btn_getStarted);
        layout = findViewById(R.id.layoutIntro);
        title = findViewById(R.id.intro_title);
        desc = findViewById(R.id.intro_desc);
        anim = findViewById(R.id.intro_anim);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.get_started);



        List<OnBoardingItem> mList = new ArrayList<>();
        mList.add(new OnBoardingItem(getString(R.string.step_t1),getString(R.string.step_d1),R.raw.shopping));
        mList.add(new OnBoardingItem(getString(R.string.step_t2),getString(R.string.step_d2),R.raw.delivery));
        mList.add(new OnBoardingItem(getString(R.string.step_t3),getString(R.string.step_d3),R.raw.distancing));

        screenPage = findViewById(R.id.viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPage.setAdapter(introViewPagerAdapter);

        tabLayout.setupWithViewPager(screenPage);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPage.getCurrentItem();
                if(position<mList.size()){
                    position++;
                    screenPage.setCurrentItem(position);
                }

                if(position==mList.size()-1){
                    loadLastScreen();
                }
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                savePrefsData();
                finish();

            }
        });

    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroDone = pref.getBoolean("isIntroDone",false);
        return isIntroDone;
    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroDone",true);
        editor.commit();
    }

    private void loadLastScreen() {
        next.setVisibility(View.INVISIBLE);
        getStarted.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.INVISIBLE);
        getStarted.setAnimation(btnAnim);
    }
}