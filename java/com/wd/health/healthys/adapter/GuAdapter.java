package com.wd.health.healthys.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.health.healthys.R;
import com.wd.health.healthys.bean.FindSickCircleBean;

import java.util.List;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/20
 * Time: 19:24
 */
public class GuAdapter extends RecyclerView.Adapter<GuAdapter.GuHelper> {
    private List<FindSickCircleBean.ResultBean> list;

    public GuAdapter(List<FindSickCircleBean.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public GuHelper onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_list_view, null);
        return new GuHelper(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull GuHelper holder, int position) {
        holder.CircleTitle.setText(list.get(position).getTitle());
        holder.CircleTime.setText(list.get(position).getReleaseTime() + "");
        holder.CircleDetail.setText(list.get(position).getDetail());
        holder.CircleCommentNum.setText("建议:" + list.get(position).getCommentNum());
        holder.CircleCollectionNum.setText("评论" + list.get(position).getCollectionNum());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guItemClick != null) {
                    guItemClick.SetItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GuHelper extends RecyclerView.ViewHolder {
        TextView CircleTitle;
        TextView CircleTime;
        TextView CircleDetail;
        TextView CircleCommentNum;
        TextView CircleCollectionNum;

        public GuHelper(@NonNull View itemView) {
            super(itemView);
            CircleTitle = itemView.findViewById(R.id.Circle_Title);
            CircleTime = itemView.findViewById(R.id.Circle_Time);
            CircleDetail = itemView.findViewById(R.id.Circle_Detail);
            CircleCommentNum = itemView.findViewById(R.id.Circle_commentNum);
            CircleCollectionNum = itemView.findViewById(R.id.Circle_collectionNum);
        }
    }

    interface GuItemClick {
        void SetItemClick(int i);
    }

    private GuItemClick guItemClick;

    public void setGuItemClick(GuItemClick guItemClick) {
        this.guItemClick = guItemClick;
    }
}
