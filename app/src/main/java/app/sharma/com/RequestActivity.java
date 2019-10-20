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

        final Request from = new Request(String.valueOf(day), String.valueOf(month), String.valueOf(year), "0");


        DatePicker datePicker2 = (DatePicker) findViewById(R.id.datePicker2);
        day = datePicker2.getDayOfMonth();
        month = datePicker2.getMonth() + 1;
        year = datePicker2.getYear();

        final Request to = new Request(String.valueOf(day), String.valueOf(month), String.valueOf(year), "0");


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uid = mAuth.getCurrentUser().getUid();
                String time = String.valueOf(System.currentTimeMillis());

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("Leave").child(time);
                Map<String, String> map = new HashMap<String, String>();

                map.put("To_Date", String.valueOf(to.getDate()));
                map.put("To_Month", String.valueOf(to.getMonth()));
                map.put("To_Year", String.valueOf(to.getYear()));

                map.put("From_Date", String.valueOf(from.getDate()));
                map.put("From_Month", String.valueOf(from.getMonth()));
                map.put("From_Year", String.valueOf(from.getYear()));


                reference.setValue(map);

                DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("Leave").child(time).child("Request");
                reference3.setValue("0");

            }
        });

    }
}
