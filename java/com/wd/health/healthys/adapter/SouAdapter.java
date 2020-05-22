package com.wd.health.healthys.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.health.healthys.R;
import com.wd.health.healthys.bean.SearchSickCircleBean;

import java.util.List;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/20
 * Time: 20:19
 */
public class SouAdapter extends RecyclerView.Adapter<SouAdapter.SouHelper> {
    private List<SearchSickCircleBean.ResultBean> list;

    public SouAdapter(List<SearchSickCircleBean.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public SouHelper onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_list_view, null);
        return new SouHelper(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SouHelper holder, int position) {
        holder.CircleTitle.setText(list.get(position).getTitle());
        holder.CircleTime.setText(list.get(position).getReleaseTime() + "");
        holder.CircleDetail.setText(list.get(position).getDetail());
        holder.CircleCommentNum.setText("建议:" + list.get(position).getCommentNum());
        holder.CircleCollectionNum.setText("评论" + list.get(position).getCollectionNum());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SouHelper extends RecyclerView.ViewHolder {
        TextView CircleTitle;
        TextView CircleTime;
        TextView CircleDetail;
        TextView CircleCommentNum;
        TextView CircleCollectionNum;

        public SouHelper(@NonNull View itemView) {
            super(itemView);
            CircleTitle = itemView.findViewById(R.id.Circle_Title);
            CircleTime = itemView.findViewById(R.id.Circle_Time);
            CircleDetail = itemView.findViewById(R.id.Circle_Detail);
            CircleCommentNum = itemView.findViewById(R.id.Circle_commentNum);
            CircleCollectionNum = itemView.findViewById(R.id.Circle_collectionNum);
        }
    }
}
