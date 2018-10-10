package com.didgustn319.my_memo_app.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.didgustn319.my_memo_app.R;
import com.didgustn319.my_memo_app.adapter.MemoViewPagerAdapter;

import java.util.List;

public class HomeFragment extends Fragment {


    List<String> pageTitles;
    TabLayout homeTabLayout;
    ViewPager homeViewPager;

    public HomeFragment() {
    }


    @SuppressLint("ValidFragment")
    public HomeFragment(List<String> pageTitles) {
        this.pageTitles = pageTitles;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.home_fragment, container, false);

        homeTabLayout = view.findViewById(R.id.home_tab_layout);
        homeViewPager = view.findViewById(R.id.home_view_pager);
        homeTabLayout.setupWithViewPager(homeViewPager);

        homeViewPager
                .setAdapter(
                        new MemoViewPagerAdapter(getFragmentManager(), pageTitles));

        /*
        Log.d("createView", "CreateView");
        pageTitles = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference("my_memo")
//                .addValueEventListener(null)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        pageTitles.clear();
                        Log.d("DATASNAPSHOT", dataSnapshot.toString());
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            MemoVO vo = ds.getValue(MemoVO.class);
                            Log.d("createView", vo.toString());
                            pageTitles.add(vo.getMemoCat());
                            Log.d("GET-DATA", dataSnapshot.toString());
                        }
                        // 중복코드 제거
                        pageTitles = new ArrayList<>(new TreeSet<>(pageTitles));
                        homeViewPager
                                .setAdapter(
                                        new MemoViewPagerAdapter(getFragmentManager(), pageTitles));
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.d("F-ERROR", databaseError.toString());
                    }
                });
*/
        Log.d("pageTiles", ":" + pageTitles.size());
        Log.d("GET-DATA", "END GET");

        return view;

    }
}