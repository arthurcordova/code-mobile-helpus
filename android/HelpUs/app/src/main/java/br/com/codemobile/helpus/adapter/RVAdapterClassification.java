package br.com.codemobile.helpus.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.codemobile.helpus.R;

/**
 * Created by acstapassoli on 23/01/2017.
 */

public class RVAdapterClassification extends RecyclerView.Adapter<RVAdapterClassification.ViewHolder> {

    private List<Bitmap> mList;
    private List<String> mLabels;

    public RVAdapterClassification(List<Bitmap> items, List<String> labels) {
        mList = items;
        mLabels = labels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_classification, parent, false);
        return new RVAdapterClassification.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        final Dependent model = mList.get(position);
        final Bitmap bit = mList.get(position);
        final String label = mLabels.get(position);
        holder.mImage.setImageBitmap(bit);
        holder.mName.setText(label);
//
//        holder.mName.setText(model.getName());
//        Drawable myDrawable = null;
//        if (position == 1 ){
//            myDrawable = holder.mName.getContext().getResources().getDrawable(R.mipmap.avatar_son);
//        } else {
//            myDrawable = holder.mName.getContext().getResources().getDrawable(R.mipmap.avatar_mother);
//        }
//
//
//        holder.mImage.setImageDrawable(myDrawable);
//        holder.mStatusImage.setImageDrawable(StatusUtils.changeStatus(holder.mStatusImage, model.getStatus()));


    }

    @Override
    public int getItemCount() {
        return (mList != null) ? mList.size() : 0;
    }

    @Override
    public void onViewDetachedFromWindow(RVAdapterClassification.ViewHolder holder) {
        holder.clearAnimation();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final View mContent;

        final ImageView mImage;
        final TextView mName;


        ViewHolder(View view) {
            super(view);
            mView = view;
            mContent =  view.findViewById(R.id.rl_content);
            mImage = (ImageView) view.findViewById(R.id.img_icon);
            mName = (TextView) view.findViewById(R.id.tv_dependent_name);
        }

        void clearAnimation() {
            mView.clearAnimation();
        }

    }
}
