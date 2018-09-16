package com.predator.medicon;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AmbulanceActivity extends AppCompatActivity {

    EditText editText;
    Button submit;
    DatabaseReference rootRef,demoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        editText = findViewById(R.id.tv);
        submit = findViewById(R.id.btnsubmit);

        rootRef = FirebaseDatabase.getInstance().getReference();

        demoRef = rootRef.child("demo");

    }

    public void send(View view){
        String value = editText.getText().toString();
        demoRef.push().setValue(value);
    }

    public void ambulance1(View view){
        String  phone = "8860873451";

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+phone));
        startActivity(callIntent);

    }

    public void ambulance2(View view){
        String  phone = "8860873451";

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+phone));
        startActivity(callIntent);

    }
}
