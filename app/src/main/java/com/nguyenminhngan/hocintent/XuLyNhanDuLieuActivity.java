package com.nguyenminhngan.hocintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.nguyenminhngan.hocintent.databinding.ActivityXuLyNhanDuLieuBinding;

public class XuLyNhanDuLieuActivity extends AppCompatActivity {

    ActivityXuLyNhanDuLieuBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityXuLyNhanDuLieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        xuLyLayDuLieuTuBenKia();
    }

    private void xuLyLayDuLieuTuBenKia() {
        //lấy intent bên kia
        Intent intent = getIntent();
        // lấy giá trị ra
        String value = intent.getStringExtra("VALUE");
        int giaTri = intent.getIntExtra("GIA_TRI",0);
        binding.txtName.setText(value+"\n"+giaTri);
    }
}
