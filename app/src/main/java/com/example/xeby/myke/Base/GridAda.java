package com.example.xeby.myke.Base;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xeby.myke.R;
import com.example.xeby.myke.entity.Classs;

import java.util.Random;


/**
 * @author MiTa
 * @date 2017/11/20.
 */
public class GridAda extends RecyclerView.Adapter<GridAda.DateViewHolder> {
    private static final int[] COLOR = {R.color.hole_blue, R.color.light_blue,
            R.color.light_green, R.color.light_pink};
    private Context context;
    private Classs[] list;

    public GridAda(Context context, Classs[] list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.item_ke, parent, false);
        return new DateViewHolder(convertView);
    }


    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        int heig=context.getResources().getDisplayMetrics().heightPixels/12;
        Classs classs = list[position];
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.width = (context.getResources().getDisplayMetrics().widthPixels - 40) / 7;
        if (classs == null) {//留白
            holder.mTvDate.setText("");
            holder.mTvDesc.setText("");
            holder.itemView.setClickable(false);
            if (position>=21&&list[position-21]!=null&&list[position-21].getCount()==4
                    ||position>=14&&list[position-14]!= null&&list[position-14].getCount()==4
                    ||position >= 7 && position < 56 && list[position - 7] != null
                    || position >= 63 && list[position - 7] != null
                    ||position >=70&&list[position - 14] != null) {
                params.height = 0;
            } else {
                params.height = heig;
            }
            holder.itemView.setLayoutParams(params);
        } else {
            if (position >=14 && list[position + 14] != null && classs.getClassName().equals(list[position + 14].getClassName())) {
                list[position + 14] = null;
                list[position].setCount(list[position].getCount() + 2);
            }
            holder.mTvDate.setText(classs.getClassName());
            holder.mTvDesc.setText(classs.getLocation() == null ? "" : classs.getLocation());
           // holder.mLlDate.setMeasureWithLargestChildEnabled(true);
            params.height = classs.getCount() * heig;
            holder.itemView.setAlpha(0.88F);
//                holder.itemView.
            GradientDrawable drawable = (GradientDrawable) context.getResources().getDrawable(R.drawable.cls_bg);
            drawable.setColor(context.getResources().getColor(COLOR[new Random().nextInt(COLOR.length)]));
            holder.itemView.setBackground(drawable);
            params.width = (context.getResources().getDisplayMetrics().widthPixels - 32) / 7;
            holder.itemView.setLayoutParams(params);
        }


        //holder.mTvDate.setText(date == 77 ? "今天" : String.valueOf(de.getDate()));
//            holder.mTvDate.setTextColor(date == 77 ? ContextCompat.getColor(context, R.color.blue_85) : ContextCompat.getColor(context, R.color.black_2c));
//            holder.mTvDesc.setText(de.getDesc());

//            int mod = position % 7;
//            if (mod == 5 || mod == 6) {
//                holder.mTvDate.setTextColor(ContextCompat.getColor(context, R.color.color_red));
//                holder.mTvDesc.setTextColor(ContextCompat.getColor(context, R.color.color_red));
//            }
//        } else if (type == 3) {//日常选中
//            holder.mTvDate.setText(date == 77 ? "今天" : String.valueOf(de.getDate()));
//            holder.mTvDesc.setText(de.getDesc());
//            holder.mTvDate.setTextColor(ContextCompat.getColor(context, R.color.white));
//            holder.mTvDesc.setTextColor(ContextCompat.getColor(context, R.color.white));
//            holder.mLlDate.setBackgroundResource(R.drawable.state_selected);
//        } else if (type == 4) {//今天之前的日期
//            holder.itemView.setClickable(false);
//            holder.mTvDate.setText(String.valueOf(de.getDate()));
//            holder.mTvDesc.setText(de.getDesc());
//            holder.mTvDate.setTextColor(ContextCompat.getColor(context, R.color.black_cc));
//            holder.mTvDesc.setTextColor(ContextCompat.getColor(context, R.color.black_cc));
//        } else if (type == 5) {//中间
//            holder.mTvDate.setText(String.valueOf(de.getDate()));
//            holder.mTvDesc.setText(de.getDesc());
//            holder.mTvDate.setTextColor(ContextCompat.getColor(context, R.color.white));
//            holder.mTvDesc.setTextColor(ContextCompat.getColor(context, R.color.white));
//            holder.mLlDate.setBackgroundResource(R.drawable.state_middle_range);
//        } else if (type == 6) {//终点
//            holder.mTvDate.setText(String.valueOf(de.getDate()));
//            holder.mTvDesc.setText("离店");
//            holder.mTvDate.setTextColor(ContextCompat.getColor(context, R.color.white));
//            holder.mTvDesc.setTextColor(ContextCompat.getColor(context, R.color.white));
//            holder.mLlDate.setBackgroundResource(R.drawable.state_end_range);
//        } else if (type == 7) {//起点
//            holder.mTvDate.setText(date == 77 ? "今天" : String.valueOf(de.getDate()));
//            holder.mTvDesc.setText("入住");
//            holder.mTvDate.setTextColor(ContextCompat.getColor(context, R.color.white));
//            holder.mTvDesc.setTextColor(ContextCompat.getColor(context, R.color.white));
//            holder.mLlDate.setBackgroundResource(R.drawable.state_first_range);
//        } else if (type == 8) {//单选
//            holder.mTvDate.setText(date == 77 ? "今天" : String.valueOf(de.getDate()));
//            holder.mTvDesc.setText(de.getDesc());
//            holder.mTvDate.setTextColor(ContextCompat.getColor(context, R.color.white));
//            holder.mTvDesc.setTextColor(ContextCompat.getColor(context, R.color.white));
//            holder.mLlDate.setBackgroundResource(R.drawable.state_selected);
//        }

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.length;
    }

    static class DateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        DateViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTvDate = itemView.findViewById(R.id.tv_ke_name);
            mTvDesc = itemView.findViewById(R.id.tv_ke_loc);
            mLlDate = itemView.findViewById(R.id.ke_item);
        }

        TextView mTvDate, mTvDesc;
        LinearLayout mLlDate;

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
//                if (view != null && view.getTag(R.id.tag_parent_pos) != null && view.getTag(R.id.tag_pos) != null) {
//                    clickListener.onDateClick((Integer) view.getTag(R.id.tag_parent_pos), (Integer) view.getTag(R.id.tag_pos));
            }
        }
    }


    private static OnDateClickListener clickListener;

    public interface OnDateClickListener {
        void onDateClick(int parentPos, int pos);
    }

    public void setClickListener(OnDateClickListener clickListener) {
        GridAda.clickListener = clickListener;
    }
}