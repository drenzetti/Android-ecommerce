package com.example.archimede.ecommerce2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.archimede.ecommerce2.data.Category;
import com.example.archimede.ecommerce2.data.CategoryAdapter;
import com.example.archimede.ecommerce2.data.OnAdapterItemClickListener;
import com.example.archimede.ecommerce2.data.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnAdapterItemClickListener{

    private RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rView = (RecyclerView)findViewById(R.id.objs_recycler_view);

        GridLayoutManager layout = new GridLayoutManager(this, 2);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(mLayoutManager);

        final List<Category> categoryList = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            categoryList.add(new Category("Title", "Image", "Description"));
        }

        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList, this);
        rView.setAdapter(categoryAdapter);
    }

    @Override
    public void OnItemClick(int position) {
        Log.d("Posizione item: ", String.valueOf(position));
        Intent productIntent = new Intent(this, ProductListActivity.class);
        startActivity(productIntent);

    }

    @Override
    public void OnItemBuyClick(int position) {

    }

    @Override
    public void OnItemBookmarkClick(int position) {

    }
}
