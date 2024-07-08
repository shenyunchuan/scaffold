package com.example.scaffold;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scaffold.Adapter.CommonrecyleviewAdapter;
import com.example.scaffold.bean.CommonrecyleviewModel;

import java.util.ArrayList;

public class CommonrecyleviewActivity extends AppCompatActivity {
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonrecyleview);
        recyclerview = findViewById(R.id.recyclerview);

        ArrayList<CommonrecyleviewModel> userList = new ArrayList<>();
        userList.add(new CommonrecyleviewModel("小李"));
        userList.add(new CommonrecyleviewModel("小王"));
        userList.add(new CommonrecyleviewModel("小张"));
        CommonrecyleviewAdapter commonrecyleviewAdapter  = new CommonrecyleviewAdapter(CommonrecyleviewActivity.this,userList);

        recyclerview.setAdapter(commonrecyleviewAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(CommonrecyleviewActivity.this));

    }
}