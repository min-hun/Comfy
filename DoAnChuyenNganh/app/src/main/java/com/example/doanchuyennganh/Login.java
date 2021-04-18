package com.example.doanchuyennganh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doanchuyennganh.Common.Common;
import com.example.doanchuyennganh.model.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText account;
    EditText password;
    private DatabaseReference userRef;
    Button btnLogin;
    Boolean validate = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        account = findViewById(R.id.etID);
        password = findViewById(R.id.etPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        userRef = FirebaseDatabase.getInstance().getReference(Common.USER_REFERENCES);

        btnLogin.setOnClickListener(v -> {
            // Goi ham check
            checkInput();
            //check id
            // Kiem tra tai khoan va dang nhap
            userRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    //kiem tra tai khoan trong database

                    for (DataSnapshot blockSnapshot : dataSnapshot.getChildren()) {
                        if (blockSnapshot.child(account.getText().toString()).exists()) {
                            validate = true;
                            UserModel user = blockSnapshot.child(account.getText().toString()).getValue(UserModel.class);
                            if (user.getPassword().equals(password.getText().toString())) {
                                Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                gotohomeactivity(user);
                            } else {
                                Toast.makeText(Login.this, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
                            }
                        } else if (!validate) {
                            Toast.makeText(Login.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                        }
                    }
//                    if (dataSnapshot.child(account.getText().toString()).exists()) {
//                        //lay thong tin nguoi dung
//                        UserModel user = dataSnapshot.child(account.getText().toString()).getValue(UserModel.class);
//                        if (user.getPassword().equals(password.getText().toString())) {
//                            userRef.child(user.getAccount()).setValue(user)
//                                    .addOnCompleteListener(task -> {
//                                        if (task.isSuccessful()) {
//                                            Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                                            UserModel userModel = dataSnapshot.getValue(UserModel.class);
//                                            gotohomeactivity(userModel);
//                                        }
//                                    });
//                        } else {
//                            Toast.makeText(Login.this, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(Login.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
//                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Login.this, "DatabaseError", Toast.LENGTH_SHORT).show();
                }
            });
        });


    }

    private void checkInput() {
        if (account.equals("")){
            Toast.makeText(this, "Vui lòng nhập tài khoản", Toast.LENGTH_SHORT).show();
        }
        if (password.equals("")){
            Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
        }
    }


    private void gotohomeactivity(UserModel user) {
        Common.currentUser = user;

        startActivity(new Intent(Login.this, MainActivity.class));
    }
}