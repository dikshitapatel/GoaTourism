package com.example.admin.goatourism;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainList extends AppCompatActivity {
    private List<ListData> listData;
    private RecyclerView rv;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        rv = (RecyclerView) findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        listData = new ArrayList<>();



        final DatabaseReference nm = FirebaseDatabase.getInstance().getReference("monuments");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                        ListData l = npsnapshot.getValue(ListData.class);
                        listData.add(l);
                    }
                    adapter = new MyAdapter(listData, getBaseContext());
                    rv.setAdapter(adapter);

                    adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {

                            Toast.makeText(MainList.this,"click",Toast.LENGTH_SHORT);
//                            Intent monumentDetail = new Intent(MainList.this,MonumentDetail.class);
//
//                            monumentDetail.putExtra("Id",listData.get(position).getName());

                        }
                    });


                }
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}


