package app.sharma.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RequestActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.submit);

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker1);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        Request from = new Request(day, month, year, 0);


        DatePicker datePicker2 = (DatePicker) findViewById(R.id.datePicker2);
        day = datePicker2.getDayOfMonth();
        month = datePicker2.getMonth() + 1;
        year = datePicker2.getYear();

        Request to = new Request(day, month, year, 0);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
