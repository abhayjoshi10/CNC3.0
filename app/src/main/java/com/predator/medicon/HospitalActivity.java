package com.predator.medicon;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class HospitalActivity extends AppCompatActivity {

    private ListView infoListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        infoListView = (ListView) findViewById(R.id.infoListView);

        String[] Option = {"City Hospital","Life care Hospital","ABC Hospital"};
        ListAdapter optionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Option);
        infoListView.setAdapter(optionAdapter);

        infoListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //String Option = String.valueOf(parent.getItemAtPosition(position));


                        if(position == 0){
                            String location = "Hospital";
                            Uri place = Uri.parse("geo:0,0?q="+ location);
                            Intent intentmap = new Intent(Intent.ACTION_VIEW,place);
                            startActivity(intentmap);
                        }
                        if(position == 1){
                            String location = "Hospital";
                            Uri place = Uri.parse("geo:0,0?q="+ location);
                            Intent intentmap = new Intent(Intent.ACTION_VIEW,place);
                            startActivity(intentmap);
                        }
                        if(position == 2){
                            String location = "Hospital";
                            Uri place = Uri.parse("geo:0,0?q="+ location);
                            Intent intentmap = new Intent(Intent.ACTION_VIEW,place);
                            startActivity(intentmap);
                        }
                    }
                });
    }
}