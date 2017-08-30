package com.demoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.demoapplication.adapter.ListAdapter;
import com.demoapplication.model.YogaDetailModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolbar_title_text;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ListAdapter adapter;
    ArrayList<YogaDetailModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        toolbar_title_text= (TextView) findViewById(R.id.toolbar_title_text);
        toolbar_title_text.setText("25 योग आसन");
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        list=new ArrayList<>();
        YogaDetailModel model=new YogaDetailModel();
        model.setGifOrNormal(1);
        model.setImageName("surya_namaskar");
        model.setYogaTitle("Anulom-Vilom");
        model.setStepsOfYoga("My experience inspired me to pore over the scientific studies I'd collected in India as well as the West to identify and explain how yoga can both prevent disease and help you recover from it");
        model.setBenefitsOfYoga("1. Builds muscle strength \n" +
                                "2. Betters your bone health");
        model.setPrecautions("1. Maintains your nervous system");
        list.add(model);

        adapter=new ListAdapter(list,this);
        recyclerView.setAdapter(adapter);
    }

    /*Method to in initialize toolbar*/
    private void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
