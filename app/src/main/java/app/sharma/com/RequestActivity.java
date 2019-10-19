package app.sharma.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RequestActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.submit);

        mAuth = FirebaseAuth.getInstance();

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker1);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        final Request from = new Request(day, month, year, 0);


        DatePicker datePicker2 = (DatePicker) findViewById(R.id.datePicker2);
        day = datePicker2.getDayOfMonth();
        month = datePicker2.getMonth() + 1;
        year = datePicker2.getYear();

        final Request to = new Request(day, month, year, 0);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uid = mAuth.getCurrentUser().getUid();
                String time = String.valueOf(System.currentTimeMillis());

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("Leave").child(time).child("To");
                Map<String, String> map = new HashMap<String, String>();

                map.put("Date", String.valueOf(to.getDate()));
                map.put("Month", String.valueOf(to.getMonth()));
                map.put("Year", String.valueOf(to.getYear()));


                reference.setValue(map);

                DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("Leave").child(time).child("From");
                Map<String, String> map2 = new HashMap<String, String>();

                map2.put("Date", String.valueOf(from.getDate()));
                map2.put("Month", String.valueOf(from.getMonth()));
                map2.put("Year", String.valueOf(from.getYear()));


                reference2.setValue(map2);

                DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("Leave").child(time).child("Request");
                reference3.setValue("0");

            }
        });

    }
}
