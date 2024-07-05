package com.example.scaffold.Dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.scaffold.R;

public class InviteDialog extends Dialog {
    private TextView yes;
    private TextView no;
    private EditText ed_invite;

    public InviteDialog(@NonNull Context context) {
        super(context,R.style.DialogStyle);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invitedialog);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        ed_invite =findViewById(R.id.ed_invite);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_invite.length()==0){
                Toast.makeText(getContext(), "请输入邀请码", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
