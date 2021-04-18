package com.example.doanchuyennganhadmin.ui.quanlycudan;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doanchuyennganhadmin.Common.Common;
import com.example.doanchuyennganhadmin.R;
import com.example.doanchuyennganhadmin.model.ResidentModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ThemcudanFragment extends Fragment {
    NavController navController;
    EditText et_owner, et_phone, et_cmnd, et_email, et_block, et_apartment, et_idbusiness, et_account, et_password;
    Button btn_addResident;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_themcudan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference residentRef = firebaseDatabase.getReference(Common.RESIDENT_REF);

        et_owner = view.findViewById(R.id.et_owner);
        et_phone = view.findViewById(R.id.et_phone);
        et_cmnd = view.findViewById(R.id.et_cmnd);
        et_email = view.findViewById(R.id.et_email);
        et_block = view.findViewById(R.id.et_block);
        et_apartment = view.findViewById(R.id.et_apartment);
        et_idbusiness = view.findViewById(R.id.et_idbusiness);
        et_account = view.findViewById(R.id.et_account);
        et_password = view.findViewById(R.id.et_password);

        btn_addResident = view.findViewById(R.id.btn_addResident);

        btn_addResident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(getActivity());
                mDialog.setMessage("Đang xử lý...");
                mDialog.show();
                residentRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mDialog.dismiss();
                        ResidentModel residentModel = new ResidentModel(
                                et_account.getText().toString(),
                                et_apartment.getText().toString(),
                                et_block.getText().toString(),
                                et_cmnd.getText().toString(),
                                et_email.getText().toString(),
                                et_idbusiness.getText().toString(),
                                et_owner.getText().toString(),
                                et_password.getText().toString(),
                                et_phone.getText().toString()
                        );
                        residentRef.child(et_block.getText().toString()).child(et_account.getText().toString()).setValue(residentModel);
                        Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}