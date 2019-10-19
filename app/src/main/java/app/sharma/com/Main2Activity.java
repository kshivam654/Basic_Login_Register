package app.sharma.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    TextView back;

    EditText name, email, password, cpassword, year, branch, group;

    Button signup;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        mAuth = FirebaseAuth.getInstance();

        back = (TextView) findViewById(R.id.back);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.confirmpassword);
        year = (EditText) findViewById(R.id.year);
        branch = (EditText) findViewById(R.id.branch);
        group = (EditText) findViewById(R.id.group);

        signup = (Button) findViewById(R.id.signup);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!password.getText().toString().equals(cpassword.getText().toString())){
                    Snackbar.make(v,"Passwords need to be same...", Snackbar.LENGTH_LONG).show();

                }
                else
                    startRegis(email.getText().toString().trim(),password.getText().toString().trim());



            }
        });
    }

    private void startRegis(final String email, String password) {

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            String uid = "";
                            User user = new User();
                            user.setName(name.getText().toString());
                            user.setEmail(name.getText().toString());
                            user.setYear(year.getText().toString());
                            user.setBranch(branch.getText().toString());
                            user.setGroup(group.getText().toString());

                            FirebaseUser firebaseUser = mAuth.getCurrentUser();

                            if(firebaseUser != null) uid = firebaseUser.getUid();

                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
                            Map<String, String> map = new HashMap<String, String>();

                            map.put("name", user.getName());
                            map.put("email", user.getEmail());
                            map.put("year", user.getYear());
                            map.put("branch", user.getBranch());
                            map.put("group", user.getGroup());

                            Log.e("if name is correct", user.getName());

                            reference.setValue(map);

                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Registration failed! Please try again later", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
