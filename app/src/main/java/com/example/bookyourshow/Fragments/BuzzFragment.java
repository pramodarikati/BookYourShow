package com.example.bookyourshow.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bookyourshow.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BuzzFragment extends Fragment {

    private Button entertainment,sports,technology;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_buzz, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.buzzViewpager);
        entertainment = view.findViewById(R.id.btnEnglish);
        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EntertainmentFragment fragment1 = new EntertainmentFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.relativelayout, fragment1);
                fragmentTransaction.commit();
            }
        });

        sports = view.findViewById(R.id.btnHindi);

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SportsFragment fragment1 = new SportsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.relativelayout, fragment1);
                fragmentTransaction.commit();
            }
        });
        technology = view.findViewById(R.id.btnJapanese);
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechnologyFragment fragment1 = new TechnologyFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.relativelayout, fragment1);
                fragmentTransaction.commit();
            }
        });
        setupViewPager(viewPager);
        TabLayout tabs = (TabLayout) view.findViewById(R.id.buzzTabs);
        tabs.setupWithViewPager(viewPager);

        //colour change
        tabs.setSelectedTabIndicatorColor(Color.parseColor("#808080"));
        tabs.setSelectedTabIndicatorHeight((int) (3 * getResources().getDisplayMetrics().density));
        tabs.setTabTextColors(Color.parseColor("#808080"), Color.parseColor("#FF0000"));


        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new EntertainmentFragment(), "Entertainment");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
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

}