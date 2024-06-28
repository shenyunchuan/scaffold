package com.example.scaffold.CommonDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.scaffold.R;

public class CommonDialog extends Dialog {
    private Button btn_dialog;

    public CommonDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commondialog);
        //初始化控件
        btn_dialog = findViewById(R.id.btn_dialog);
        //dialog中button的点击事件
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               moncommonCilckListener.onClick();
            }
        });

    }
    private OncommonCilckListener moncommonCilckListener;
    public interface OncommonCilckListener{
        void onClick();
    }
    public void setOncommonCilckListener(OncommonCilckListener oncommonCilckListener){
        this.moncommonCilckListener =oncommonCilckListener;
    }

}
