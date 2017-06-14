package com.example.archimede.ecommerce2.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.archimede.ecommerce2.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private List<Product> mDataset;
    private Context context;
    private OnAdapterItemClickListener listener;
    private NumberFormat nf = NumberFormat.getInstance(Locale.ITALIAN);

    public ProductAdapter(List<Product> mDataset, Context context, OnAdapterItemClickListener listener) {
        this.mDataset = mDataset;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_row_adapter, parent, false);
        ViewHolder vh = new ViewHolder(v);

        vh.name = (TextView) v.findViewById(R.id.textViewName);
        vh.desc= (TextView) v.findViewById(R.id.textViewDescription);
        vh.price= (TextView) v.findViewById(R.id.textViewPrice);
        vh.productImage= (ImageView) v.findViewById(R.id.imageViewProduct);
        vh.buyButton= (Button) v.findViewById(R.id.ButtonBuy);
        vh.favorite= (ImageButton) v.findViewById(R.id.ButtonFavorite);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(mDataset.get(position).getName());
        holder.desc.setText(mDataset.get(position).getDesc());
        holder.price.setText(nf.format(mDataset.get(position).getPrice()));
        holder.productImage.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ImageView productImage;
        public TextView name;
        public TextView desc;
        public TextView price;
        public Button buyButton;
        public ImageButton favorite;



        public ViewHolder(View itemView) {
            super(itemView);

        }
    }



}
