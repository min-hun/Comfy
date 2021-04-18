package com.example.doanchuyennganhadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doanchuyennganhadmin.Common.Common;
import com.example.doanchuyennganhadmin.model.AdminModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etID, etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference adminRef = firebaseDatabase.getReference(Common.ADMIN_REFERENCE);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        etID = findViewById(R.id.etID);
        etPass = findViewById(R.id.etPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInput();
                adminRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(etID.getText().toString()).exists()) {
                            AdminModel adminModel = dataSnapshot.child(etID.getText().toString()).getValue(AdminModel.class);
                            if (adminModel.getPassword().equals(etPass.getText().toString())) {
                                Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                gotohomeactivity(adminModel);
                            } else {
                                Toast.makeText(LoginActivity.this, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "Tài khoản không tồn tại.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(LoginActivity.this, "DatabaseError", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void checkInput() {
        if (etID.equals("")) {
            Toast.makeText(this, "Vui lòng nhập tài khoản", Toast.LENGTH_SHORT).show();
        }
        if (etPass.equals("")) {
            Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
        }
    }

    private void gotohomeactivity(AdminModel adminModel) {
        Common.currentAdmin = adminModel;
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
}