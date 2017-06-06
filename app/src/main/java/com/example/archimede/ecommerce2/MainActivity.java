package com.example.archimede.ecommerce2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.archimede.ecommerce2.data.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rView = (RecyclerView)findViewById(R.id.objs_recycler_view);
        rView.setHasFixedSize(true);

        final List<Category> CategoryList = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            CategoryList.add(new Category("Title", "Image", "Description"));
        }

    }

}
