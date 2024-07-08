package com.example.scaffold.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scaffold.R;
import com.example.scaffold.bean.QuestionAnswerModel;

import java.util.ArrayList;

public class QuestionAnswerAdapter extends RecyclerView.Adapter<QuestionAnswerAdapter.MyHolder> {
    Context context;
    ArrayList<QuestionAnswerModel> modelArrayList;
    public QuestionAnswerAdapter(Context context, ArrayList<QuestionAnswerModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }



    @NonNull
    @Override
    public QuestionAnswerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_question_answers,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAnswerAdapter.MyHolder holder, int position) {
        QuestionAnswerModel questionAnswerModel = modelArrayList.get(position);
        holder.tv_question.setText(questionAnswerModel.getQuestion());
        holder.tv_answer.setText(questionAnswerModel.getAnswer());
         holder.arrow.setImageResource(questionAnswerModel.getArrow());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public  static  class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_question;
        TextView tv_answer;
        ImageView arrow;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_answer = itemView.findViewById(R.id.tv_answer);
            tv_question = itemView.findViewById(R.id.tv_question);
            arrow = itemView.findViewById(R.id.arrow);

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnRecyclerItemClickListener !=null){
                       if(tv_answer.isShown()){
                           tv_answer.setVisibility(View.GONE);
                           arrow.setRotation(0);
                       }else {
                           tv_answer.setVisibility(View.VISIBLE);
                           arrow.setRotation(180);
                       }
                    }
                }
            });
        }
    }
    private static OnRecyclerItemClickListener mOnRecyclerItemClickListener;
    public void setRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        mOnRecyclerItemClickListener = listener;
    }
    public interface OnRecyclerItemClickListener{
        void onRecyclerItemClick(int position);
    }
}
