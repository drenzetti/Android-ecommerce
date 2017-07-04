package com.example.archimede.ecommerce2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.archimede.ecommerce2.data.Category;
import com.example.archimede.ecommerce2.data.CategoryAdapter;
import com.example.archimede.ecommerce2.data.EcommerceOpenHelper;
import com.example.archimede.ecommerce2.data.OnAdapterItemClickListener;
import com.example.archimede.ecommerce2.data.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnAdapterItemClickListener, SharedPreferences.OnSharedPreferenceChangeListener{

    private RecyclerView rView;

    private SharedPreferences preferences;

    private List<Category> categoryList;
    private EcommerceOpenHelper mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDB = new EcommerceOpenHelper(this);
        setContentView(R.layout.activity_main);
        rView = (RecyclerView)findViewById(R.id.objs_recycler_view);

        preferences = getSharedPreferences("ecommerce", MODE_PRIVATE);

        boolean b = preferences.getBoolean("firstUser",true);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("firstUser",true);
        editor.apply();

        if (b == true) {
            Snackbar mySnackbar = Snackbar.make(rView,
                    "Benvenuto! Questa è la prima volta che apri questa applicazione", 8000);
            mySnackbar.show();
        }
        GridLayoutManager layout = new GridLayoutManager(this, 2);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(mLayoutManager);

         categoryList = mDB.getAllCategories();


        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList, this);
        rView.setAdapter(categoryAdapter);
    }

    @Override
    public void OnItemClick(int position) {
        Log.d("Posizione item: ", String.valueOf(position));
        Intent productIntent = new Intent(this, ProductListActivity.class);
        productIntent.putExtra("categoryID", categoryList.get(position).getId());
        startActivity(productIntent);

    }

    @Override
    public void OnItemBuyClick(int position) {

    }

    @Override
    public void OnItemBookmarkClick(int position) {

    }

    @Override
    protected void onResume() {
        super.onResume();

        preferences = getSharedPreferences("ecommerce", MODE_PRIVATE);

        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences preferences
                = getSharedPreferences("ecommerce", MODE_PRIVATE);

        preferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {


        Snackbar snackbar = Snackbar.make(rView,
                "property changed" + key,
                Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void buttonOnclick(View view) {

        preferences = getSharedPreferences("ecommerce", MODE_PRIVATE);

        boolean b = preferences.getBoolean("firstUser", true);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("firstUser",!b);
        editor.apply();
    }
}
