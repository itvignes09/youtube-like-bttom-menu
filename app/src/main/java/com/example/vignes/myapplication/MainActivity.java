package com.example.vignes.myapplication;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager vpMain;
    String temp = "";
    public static BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpMain = (ViewPager) findViewById(R.id.vpMain);
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        setupViewPager(vpMain);

        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomBar.setVerticalScrollbarPosition(position);
                bottomBar.selectTabAtPosition(position, false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(int tabId) {
                if (tabId == R.id.tab_home) {
                    vpMain.setCurrentItem(0);
                    temp = temp.replace("-0","") + "-0";
                } else if (tabId == R.id.tab_deals) {
                    vpMain.setCurrentItem(1);
                    temp = temp.replace("-1","") + "-1";
                } else if (tabId == R.id.tab_earn) {
                    vpMain.setCurrentItem(2);
                    temp = temp.replace("-2","") + "-2";
                } else if (tabId == R.id.tab_redeem) {
                    vpMain.setCurrentItem(3);
                    temp = temp.replace("-3","") + "-3";
                } else if (tabId == R.id.tab_account) {
                    vpMain.setCurrentItem(4);
                    temp = temp.replace("-4","") + "-4";
                }
            }
        });

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    vpMain.setCurrentItem(0);
                    temp = temp.replace("-0","") + "-0";
                } else if (tabId == R.id.tab_deals) {
                    vpMain.setCurrentItem(1);
                    temp = temp.replace("-1","") + "-1";
                } else if (tabId == R.id.tab_earn) {
                    vpMain.setCurrentItem(2);
                    temp = temp.replace("-2","") + "-2";
                } else if (tabId == R.id.tab_redeem) {
                    vpMain.setCurrentItem(3);
                    temp = temp.replace("-3","") + "-3";
                } else if (tabId == R.id.tab_account) {
                    vpMain.setCurrentItem(4);
                    temp = temp.replace("-4","") + "-4";
                }
            }
        });

        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentA(), "A");
        adapter.addFragment(new FragmentB(), "B");
        adapter.addFragment(new FragmentC(), "C");
        adapter.addFragment(new FragmentD(), "D");
        adapter.addFragment(new FragmentE(), "E");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {

        String[] words = temp.split("-");
        if(words.length==2)
            finish();
        else {
            temp = temp.replace("-" + words[words.length - 1], "");
            int pos = vpMain.getCurrentItem();
            if (vpMain.getCurrentItem() == pos)
                pos = 2;
            else
                pos = 1;
            vpMain.setCurrentItem(Integer.parseInt(words[words.length - pos]));
        }
    }
}
