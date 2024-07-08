package com.example.scaffold;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scaffold.Adapter.QuestionAnswerAdapter;
import com.example.scaffold.bean.QuestionAnswerModel;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class QuestionAnswersActivity extends AppCompatActivity {
    RecyclerView qsrecyclerview;
    ArrayList<QuestionAnswerModel> modelArrayList;
    QuestionAnswerAdapter questionAnswerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answers);
        qsrecyclerview = findViewById(R.id.qsrecyclerview);

        modelArrayList = new ArrayList<>();
        modelArrayList.add(new QuestionAnswerModel("1.是否支持多端使用","是的，支持多端使用，您可以根据自己的使用需求在电脑端和手机端使用。" +
                "\n\n电脑端下载地址（支持Windows/MacOS）：" +
                "\n\nhttps://chat.xiaohuodui.cn;" +
                "\n\n手机端ios版在应用市场搜索“积墨Chat进行下载；”" +
                "\n\n\n\n如果您遇到任何问题或者需要帮助，请随时联系我们的客服团队，我们将为您提供满意的服务。\n",R.drawable.ic_qa_down));
        modelArrayList.add(new QuestionAnswerModel("2.【主题】是什么？","主题可以理解为你对AI当前角色或情景的设定，如：请将我说的话翻译为中文，就是让AI充当一个翻译助手的角色；\n",R.drawable.ic_qa_down));
        modelArrayList.add(new QuestionAnswerModel("3.聊天字数有限制吗？","有，受限于API，一次对话（包含问和答）限制在2000-3000字左右\n",R.drawable.ic_qa_down));
        modelArrayList.add(new QuestionAnswerModel("4.【单次会话】 和 【连续对话】 是什么意思，有何区别","【单次会话】没有上下文的概念，就像你问我答，但是回答下一个问题时已经忘记了上一轮的对话；" +
                "\n【连续对话】和【单次会话】不一样的是会储存上下文的语义环境，更像和一个真人进行交流，但是受限于API的限制，有字数限制，只能保存大约2000-3000字左右\n",R.drawable.ic_qa_down));
        modelArrayList.add(new QuestionAnswerModel("5.【我】可以做什么？","我是一个基于大语言模型的聊天机器人，可以理解并生成人类类似的语言，如回答问题，进行对话或提供相关信息等。下面是我可以做的一些事情和例子；" +
                "\n\n1.回答各种问题，例如天气、体育赛事、历史事件等。" +
                "\n2.提供建议，例如美食、酒店、旅游的目的地等。" +
                "\n3.参与对话，例如闲聊、小细节、情感交流等。" +
                "\n4.简化工作流程，例如排班、管理日程、提醒记事等。" +
                "\n5.提供语言支持，例如学习外语、跨语言交流等。" +
                "\n总之，我可以模拟真实的对话，帮助人们实现各种任务和交流目的，并提供一种沟通工具，以帮助人们解决各种问题和难题。\n",R.drawable.ic_qa_down));
        modelArrayList.add(new QuestionAnswerModel("6.为何必须购买才能使用？","AI智能的学习与计算的过程，需要消耗较多资源，每次使用AI服务都会产生一定的成本，为保证服务的可持续性，所以需要付费购买才能使用；\n",R.drawable.ic_qa_down));
        modelArrayList.add(new QuestionAnswerModel("7.有使用建议吗","1尽量明确且详细的表述问题，保持问题的客观性，使其能够理解用户的输入；" +
                "\n2.提取，而不是思考，AI掌握了大量的资料库，通过提问来提取信息，是非常高效的方法；" +
                "\n3.AI的回答仅作为参考，保持清醒，独立思考。\n",R.drawable.ic_qa_down));


        questionAnswerAdapter = new QuestionAnswerAdapter(QuestionAnswersActivity.this,modelArrayList);
        qsrecyclerview.setAdapter(questionAnswerAdapter);
        qsrecyclerview.setLayoutManager(new LinearLayoutManager(QuestionAnswersActivity.this));
        questionAnswerAdapter.setRecyclerItemClickListener(new QuestionAnswerAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onRecyclerItemClick(int position) {
            }
        });



        //下拉上拉刷新
        RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.refreshLayout);
        refreshLayout.setRefreshHeader(new ClassicsHeader(this));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(1000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(500/*,false*/);//传入false表示加载失败
            }
        });






    }
}