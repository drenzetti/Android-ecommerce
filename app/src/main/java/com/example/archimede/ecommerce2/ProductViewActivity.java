package com.example.archimede.ecommerce2;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.archimede.ecommerce2.data.ProductAdapter;

public class ProductViewActivity extends AppCompatActivity {

    private TextView name;
    private TextView shortDesc;
    private TextView longDesc;
    private RatingBar rating;
    private Button buyButton;
    private ImageButton bookmark;
    private ImageView image;
    private TextView price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        name = (TextView)findViewById(R.id.textViewItemName);
        shortDesc = (TextView)findViewById(R.id.textViewItemDescription);
        longDesc = (TextView)findViewById(R.id.textViewItemLongDesc);
        rating = (RatingBar)findViewById(R.id.ratingBarItem);
        buyButton = (Button)findViewById(R.id.buttonItemBuy);
        bookmark = (ImageButton)findViewById(R.id.buttonItemFavorite);
        image = (ImageView)findViewById(R.id.imageViewItemProduct);
        price = (TextView)findViewById(R.id.textViewItemPrice);




    }
}
