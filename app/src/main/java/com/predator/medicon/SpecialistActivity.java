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

public class SpecialistActivity extends AppCompatActivity {

    private ListView infoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialist);

        infoListView = (ListView) findViewById(R.id.infoListView);

        String[] Option = {"Cardiologist","General Physician","Dentist"};
        ListAdapter optionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Option);
        infoListView.setAdapter(optionAdapter);

        infoListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //String Option = String.valueOf(parent.getItemAtPosition(position));


                        if(position == 0){
                            Intent intent = new Intent(view.getContext(), CardioActivity.class);
                            startActivityForResult(intent,0);
                        }
                        if(position == 1){
                            Intent intent = new Intent(view.getContext(), GenPhyActivity.class);
                            startActivityForResult(intent,1);
                        }
                        if(position == 2){
                            Intent intent = new Intent(view.getContext(), DentistActivity.class);
                            startActivityForResult(intent,2);
                        }
                    }
                });


    }
}
