package com.example.scaffold;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.scaffold.Dialog.InviteDialog;

public class MineActivity extends AppCompatActivity {
    private RelativeLayout invite;
    private RelativeLayout download;
    private RelativeLayout question;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        invite = findViewById(R.id.invite);
        download = findViewById(R.id.download);
        question = findViewById(R.id.question);

      invite.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              InviteDialog inviteDialog = new InviteDialog(MineActivity.this);
              inviteDialog.show();
          }
      });
      download.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(MineActivity.this,DownloadinviteActivity.class);
              startActivity(intent);
          }
      });
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MineActivity.this, QuestionAnswersActivity.class);
                startActivity(intent);
            }
        });
    }
}