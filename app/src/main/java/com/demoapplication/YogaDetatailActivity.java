package com.demoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.demoapplication.model.YogaDetailModel;
import com.whygraphics.gifview.gif.GIFView;

public class YogaDetatailActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView toolbar_title_text;
    GIFView imageView;
    TextView yogaSteps,benefitsOfYoga,precautions;
    YogaDetailModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_detatail);
        initToolBar();

        toolbar_title_text= (TextView) findViewById(R.id.toolbar_title_text);
        imageView= (GIFView) findViewById(R.id.detail_image);
        yogaSteps= (TextView) findViewById(R.id.yoga_steps_detail_text);
        benefitsOfYoga= (TextView) findViewById(R.id.benefits_of_yoga_detail_text);
        precautions= (TextView) findViewById(R.id.precautions_of_yoga_detail_text);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            model= (YogaDetailModel) bundle.get("model");
            imageView.setGifResource("asset:"+model.getImageName());
            yogaSteps.setText(model.getStepsOfYoga());
            benefitsOfYoga.setText(model.getBenefitsOfYoga());
            precautions.setText(model.getPrecautions());

            toolbar_title_text.setText(model.getYogaTitle());
        }
    }

    /*Method to in initialize toolbar*/
    private void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
           finish();
        }
        return super.onOptionsItemSelected(item);

    }
}
