package com.nguyenminhngan.hocintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nguyenminhngan.hocintent.databinding.ActivityXuLyNhanVaTraDuLieuBinding;

import java.util.ArrayList;

public class XuLyNhanVaTraDuLieuActivity extends AppCompatActivity {

    ActivityXuLyNhanVaTraDuLieuBinding binding;
    int N=1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityXuLyNhanVaTraDuLieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        N=getIntent().getIntExtra("SO",1);
        binding.txtSo.setText(N+"");
    }

    public void traDanhSachUocSo(View view) {
        ArrayList<Integer> dsUocSo = new ArrayList<>();
        for (int i=1;i<=N;i++){
            if (N%i==0) dsUocSo.add(i);
        }
        Intent intent = getIntent();
        intent.putExtra("dsUocSo",dsUocSo);
        setResult(113, intent);
        finish();
    }
}
