package com.example.admin.goatourism;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class MonumentDetail extends AppCompatActivity {

    TextView name,info;
    ImageView image;
    LinearLayout layout;
    DatabaseReference monuments;
    ListData currentMonument;





    String Id="1";

    FirebaseDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument_detail);

        database = FirebaseDatabase.getInstance();
        monuments = database.getReference("monuments");







        image = (ImageView) findViewById(R.id.image);
        name = (TextView)findViewById(R.id.name);
        info = (TextView)findViewById(R.id.info);

        layout = (LinearLayout) findViewById(R.id.layout);
        // collapsingToolbarLayout = setExpandedTitleAppearance(R.style.ExpandedAppbar);
        //  collapsingToolbarLayout = setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

//        if (getIntent() != null)
//            Id = getIntent().getStringExtra("Id");
//        if (!Id.isEmpty()) {
//            {
//                getDetailFood(Id);
//            }
//        }
        getDetailFood("1");
    }





    private void getDetailFood(String foodId){
        monuments.child(Id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentMonument=dataSnapshot.getValue(ListData.class);


                Picasso.with(getBaseContext()).load(currentMonument.getImage())
                        .into(image);
                name.setText(currentMonument.getName());
                info.setText(currentMonument.getInfo());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }







}
