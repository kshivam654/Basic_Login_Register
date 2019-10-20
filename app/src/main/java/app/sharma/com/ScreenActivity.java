package app.sharma.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import app.sharma.com.Adapter.RequestAdapter;

public class ScreenActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;

    RecyclerView recyclerView;

    LinearLayoutManager linearLayoutManager;

    RequestAdapter adapter = null;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        String uid = firebaseUser.getUid();

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingactionbutton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScreenActivity.this, RequestActivity.class);
                startActivity(intent);
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("Leave");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final ArrayList<Leave> list = new ArrayList<Leave>();

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    Leave lp = dataSnapshot1.getValue(Leave.class);
                    list.add(lp);

                }
                adapter = new RequestAdapter(getApplicationContext(), list);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(), "Error occurred while loading values", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
