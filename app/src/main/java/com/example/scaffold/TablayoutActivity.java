package com.example.scaffold;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.scaffold.Fragment.TablayoutFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class TablayoutActivity extends AppCompatActivity {
    private String[] titles = {"1","2","3","4","5","6","7","8","9"};
    private TabLayout tablayout;
    private ViewPager2 viewpager2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        //初始化控件
        tablayout = findViewById(R.id.tablayout);
        viewpager2 = findViewById(R.id.viewpager2);

        //viewpager需要设置一个adapter
        viewpager2.setAdapter(new FragmentStateAdapter(TablayoutActivity.this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                String title = titles[position];
                TablayoutFragment tablayoutFragment = TablayoutFragment.newInstance(title);
                return tablayoutFragment;
            }

            @Override
            public int getItemCount() {
                return titles.length;
            }
        });
        //tablayout点击事件
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //设置viewpager选中当前页
                viewpager2.setCurrentItem(tab.getPosition(),false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //tablayout和viewpager关联在一起
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tablayout, viewpager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                tab.setText(titles[i]);
            }
        });
        //这句话一定不能少
        tabLayoutMediator.attach();
    }
}
