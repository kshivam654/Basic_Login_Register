package app.sharma.com;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RequestActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;

    FirebaseAuth mAuth;

    Request to, from;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        floatingActionButton = findViewById(R.id.submit);

        mAuth = FirebaseAuth.getInstance();

        final DatePicker datePicker = findViewById(R.id.datePicker1);

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int yearr = datePicker.getYear();

                from = new Request(String.valueOf(day), String.valueOf(month), String.valueOf(year), "0");
            }
        });


        final DatePicker datePicker2 = findViewById(R.id.datePicker2);
        datePicker2.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int day = datePicker2.getDayOfMonth();
                int month = datePicker2.getMonth() + 1;
                int yearr = datePicker2.getYear();

                to = new Request(String.valueOf(day), String.valueOf(month), String.valueOf(year), "0");
            }
        });


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

                DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("Leave").child(time).child("requested");
                reference3.setValue("0");

                finish();
                Toast.makeText(RequestActivity.this, "Your Request has been submitted", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
