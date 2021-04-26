package com.example.sarthi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;

import com.example.sarthi.R;
import com.example.sarthi.model.OnBoardingItem;

import java.util.List;

public class IntroViewPagerAdapter extends PagerAdapter {

   Context mContext;
   List<OnBoardingItem> mListScreen;

    public IntroViewPagerAdapter(Context mContext, List<OnBoardingItem> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen,null);

        LottieAnimationView anim = layoutScreen.findViewById(R.id.intro_anim);
        TextView title = layoutScreen.findViewById(R.id.intro_title);
        TextView desc = layoutScreen.findViewById(R.id.intro_desc);

        title.setText(mListScreen.get(position).getTitle());
        desc.setText(mListScreen.get(position).getDesc());
        anim.setAnimation(mListScreen.get(position).getScreenAnim());
        anim.setRepeatCount(10000);
        anim.playAnimation();
        container.addView(layoutScreen);

        return  layoutScreen;
    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }





    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }
}
