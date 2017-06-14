package com.example.archimede.ecommerce2;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.archimede.ecommerce2.data.CategoryAdapter;
import com.example.archimede.ecommerce2.data.OnAdapterItemClickListener;
import com.example.archimede.ecommerce2.data.Product;
import com.example.archimede.ecommerce2.data.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity implements OnAdapterItemClickListener {

    private RecyclerView rView;
    private List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);


        rView = (RecyclerView)findViewById(R.id.products_recycler_view);

        GridLayoutManager layout = new GridLayoutManager(this, 1);
        rView.setLayoutManager(layout);

        productList = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            productList.add(new Product("Titolo", "Descrizione poco poco corta", 3.10, "http://writingexercises.co.uk/images2/randomimage/boat.jpg"));
        }

        ProductAdapter productAdapter = new ProductAdapter(productList, this);
        rView.setAdapter(productAdapter);

    }

    @Override
    public void OnItemClick(int position) {

    }

    @Override
    public void OnItemBuyClick(int position) {
        Snackbar mySnackbar = Snackbar.make(rView,
                "Aggiunto al carrello", Snackbar.LENGTH_SHORT);
        mySnackbar.setAction("annulla" , new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Item buy action: ", "annullato");
            }
        });
        mySnackbar.show();

    }

    @Override
    public void OnItemBookmarkClick(int position){
        if(productList.get(position).isBookmark()){
            Log.d("Bookmark action: ", "rimosso");
            productList.get(position).setBookmark(false);

        }else
        {
            Log.d("Bookmark action: ", "aggiunto");
            productList.get(position).setBookmark(true);
        }
    }
}
