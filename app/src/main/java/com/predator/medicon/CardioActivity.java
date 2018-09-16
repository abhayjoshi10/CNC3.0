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

public class CardioActivity extends AppCompatActivity {

    private ListView infoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);

        infoListView = (ListView) findViewById(R.id.infoListView);

        String[] Option = {"Dr. James Moriarty","Dr. Sherlock Holmes"};
        ListAdapter optionAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Option);
        infoListView.setAdapter(optionAdapter);

        infoListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //String Option = String.valueOf(parent.getItemAtPosition(position));


                        if(position == 0){
                            String  phone = "8860873451";

                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:"+phone));
                            startActivity(callIntent);
                        }
                        if(position == 1){
                            String  phone = "8860873451";

                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:"+phone));
                            startActivity(callIntent);
                        }

                    }
                });
    }
}
