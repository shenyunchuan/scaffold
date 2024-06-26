package com.example.scaffold;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    //定义Fragment
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThridFragment thridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        //初始化控件
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //默认首页选中
        selectedFragment(0);

        //导航栏bottomNavigationView点击事件
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //判断点击导航栏哪个按钮
                if (menuItem.getItemId()==R.id.first){
                    selectedFragment(0);
                } else if (menuItem.getItemId()==R.id.second) {
                    selectedFragment(1);
                }else {
                    selectedFragment(2);
                }

                return true;
            }
        });

    }

    private void selectedFragment(int positon) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hiadeFragment(fragmentTransaction);
        if (positon==0){
            if (firstFragment==null) {
                firstFragment = new FirstFragment();
                fragmentTransaction.add(R.id.content, firstFragment);
            }else{
                fragmentTransaction.show(firstFragment);
            }
        } else if (positon==1) {
            if (secondFragment==null){
                secondFragment = new SecondFragment();
                fragmentTransaction.add(R.id.content,secondFragment);
            }else{
                fragmentTransaction.show(secondFragment);
            }
        }else{
            if (thridFragment==null){
                thridFragment = new ThridFragment();
                fragmentTransaction.add(R.id.content,thridFragment);
            }else{
                fragmentTransaction.show(thridFragment);
            }
        }
        //提交，一定要
        fragmentTransaction.commit();
    }
    private void hiadeFragment(FragmentTransaction fragmentTransaction){
        if (firstFragment!=null){
            fragmentTransaction.hide(firstFragment);
        }
        if (secondFragment!=null){
            fragmentTransaction.hide(secondFragment);
        }
        if (thridFragment!=null){
            fragmentTransaction.hide(thridFragment);
        }
    }
}