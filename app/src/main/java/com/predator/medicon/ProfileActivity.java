package com.predator.medicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth auth;
    private TextView textViewUserEmail;
    private Button buttonLogout;

    private RecyclerView mRecyclerView;
    private CategoryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user= auth.getCurrentUser();

        textViewUserEmail = findViewById(R.id.textViewUserEmail);

        textViewUserEmail.setText("Welcome " + user.getEmail());

        buttonLogout = findViewById(R.id.buttonLog);

        buttonLogout.setOnClickListener(this);

        final ArrayList<CategoryItem> categoryList= new ArrayList<>();
        categoryList.add(new CategoryItem(R.drawable.doctor,"Specialist"));
        categoryList.add(new CategoryItem(R.drawable.hospital,"Hospital"));
        categoryList.add(new CategoryItem(R.drawable.blood,"Blood Bank"));
        categoryList.add(new CategoryItem(R.drawable.ambulance,"Ambulance"));



        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CategoryAdapter(categoryList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                categoryList.get(position);
                if(position == 0){
                    Intent intent = new Intent(ProfileActivity.this,SpecialistActivity.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(ProfileActivity.this,HospitalActivity.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(ProfileActivity.this,BloodBank.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(ProfileActivity.this,AmbulanceActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public void onClick(View view) {

        if(view == buttonLogout){
            auth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}
