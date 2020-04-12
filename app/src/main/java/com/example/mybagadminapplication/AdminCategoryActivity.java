package com.example.mybagadminapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mybagadminapplication.Model.Category;
import com.example.mybagadminapplication.adapters.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdminCategoryActivity extends AppCompatActivity {

    RecyclerView rv_categories;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        rv_categories = findViewById(R.id.rv_categories);

        List<Category> categories = new ArrayList<>();

        categories.add(new Category("luggage Bag", R.drawable.lagguagebag));
        categories.add(new Category("Hand Bag",R.drawable.handbag));
        categories.add(new Category("Baby Bag",R.drawable.babybag));
        categories.add(new Category("School Bag",R.drawable.logoschoolbag));

        GridLayoutManager manager=new GridLayoutManager(this,2);

        rv_categories.setLayoutManager(manager);
        CategoryAdapter adapter=new CategoryAdapter(this,categories);
        rv_categories.setAdapter(adapter);
    }




}


