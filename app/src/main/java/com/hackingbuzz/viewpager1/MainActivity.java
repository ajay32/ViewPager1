package com.hackingbuzz.viewpager1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hackingbuzz.viewpager1.fragments.FirstFragment;
import com.hackingbuzz.viewpager1.fragments.FourFragment;
import com.hackingbuzz.viewpager1.fragments.SecondFragment;
import com.hackingbuzz.viewpager1.fragments.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // ViewPager gives a Slideshow type view.... mostly used with fragments... 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(FirstFragment.newInstance());
        fragments.add(SecondFragment.newInstance());
        fragments.add(ThirdFragment.newInstance());
        fragments.add(FourFragment.newInstance());


        CustomPageAdapter customPagerAdapter = new CustomPageAdapter(getSupportFragmentManager(), fragments);

        viewPager.setAdapter(customPagerAdapter);
    }


    class CustomPageAdapter extends FragmentStatePagerAdapter {

        List<Fragment> fragments;

        public CustomPageAdapter(FragmentManager fm, List<Fragment> frags) {
            super(fm);
            fragments = frags;
        }


        @Override
        public Fragment getItem(int position) {  // this method give fragments that our view pager gonna show
            int index = position % fragments.size();  // we have four fragments it will go 4 ..module like 1% 4 = 1 ..so for 2 and 3 ..so its gonna return the counting values and getting fragments for that locations..
            return fragments.get(index);
        }

        @Override
        public int getCount() {   //  how many items are in our view pager ..you can take any integer number
            return Integer.MAX_VALUE;   // if we take fragments.size...then it will stop at end it will not start with frist fragment again
        }
    }
}
