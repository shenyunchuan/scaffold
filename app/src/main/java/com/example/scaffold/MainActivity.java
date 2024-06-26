package com.example.scaffold;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);

        //普通对话框
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("我是标题")
                        .setMessage("我是内容")
                        //消极回答
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        //积极回答
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        //中性回答
                        .setNeutralButton("其他", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "点击了其他按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });


        //列表对话框
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"1", "2", "3", "4"};
                AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("我是标题")
                        .setItems(strings, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, strings[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        //消极回答
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        //积极回答
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        //中性回答
                        .setNeutralButton("其他", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "点击了其他按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        //单选列表对话框
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"1", "2", "3", "4"};
                AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("我是标题")
                        //单选,设置为-1则默认不选中
                        .setSingleChoiceItems(strings, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "选择了"+strings[which], Toast.LENGTH_SHORT).show();
                                //选择后对话框消失
                                dialog.dismiss();
                            }
                        })
                        //点击对话框外部，对话框不消失
                        .setCancelable(false)
                        .show();
            }
        });

        //多选对话框
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"1", "2", "3", "4"};
                boolean[] booleans = {false, false, false, false};
                AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("我是标题")
                        //多选
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(MainActivity.this, "选择了"+strings[which]+isChecked, Toast.LENGTH_SHORT).show();
                            }
                        })
                        //消极回答
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        //积极回答
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        //半自定义对话框
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialogfive, null);
                EditText text1 = inflate.findViewById(R.id.text1);
                EditText btn1 = inflate.findViewById(R.id.btn1);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "成功", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("请输入")
                        .setView(inflate)
                        .show();
            }
        });

    }
}