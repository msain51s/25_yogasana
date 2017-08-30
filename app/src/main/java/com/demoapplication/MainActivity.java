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
    String []title_arr,yoga_steps_arr,yoga_benefits_arr,precautions_arr;
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

        getList();

    }

    /*Method to in initialize toolbar*/
    private void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void getList(){
        YogaDetailModel model=null;
        list=new ArrayList<>();
        title_arr=getResources().getStringArray(R.array.title_array);
        yoga_steps_arr=getResources().getStringArray(R.array.steps_array);
        yoga_benefits_arr=getResources().getStringArray(R.array.benefits_array);
        precautions_arr=getResources().getStringArray(R.array.precautions_array);

        for(int i=0;i<title_arr.length;i++){
            model=new YogaDetailModel();
            model.setYogaTitle(title_arr[i]);
            model.setStepsOfYoga(yoga_steps_arr[i]);
            model.setBenefitsOfYoga(yoga_benefits_arr[i]);
            model.setPrecautions(precautions_arr[i]);

            list.add(model);
        }

        adapter=new ListAdapter(list,this);
        recyclerView.setAdapter(adapter);
    }
}
