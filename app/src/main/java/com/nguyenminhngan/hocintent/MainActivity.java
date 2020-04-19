package com.nguyenminhngan.hocintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.nguyenminhngan.hocintent.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void moManHinhCheHetToanBo(View view) {
        Intent intent = new Intent(MainActivity.this,ManHinhCheKhuatToanBoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "onDestroy",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "onRestart",Toast.LENGTH_SHORT).show();
    }

    public void moManHinhCheKhuatMotPhan(View view) {
        Intent intent = new Intent(MainActivity.this,ManHinhCheKhuatMotPhanActivity.class);
        startActivity(intent);
    }

    public void moManHinhXuLy(View view) {
        Intent intent = new Intent(MainActivity.this,XuLyNhanDuLieuActivity.class);
        // gửi dữ liệu qua bên kia
        intent.putExtra("VALUE", binding.edtName.getText().toString());
        intent.putExtra("GIA_TRI",122);
        startActivity(intent);
    }

    public void timUocSo(View view) {
        Intent intent = new Intent(MainActivity.this,XuLyNhanVaTraDuLieuActivity.class);
        intent.putExtra("SO", Integer.parseInt(binding.edtSo.getText().toString()));
        startActivityForResult(intent,114);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        ArrayList<Integer> dsUocSo = data.getIntegerArrayListExtra("dsUocSo");
        showListView(dsUocSo);
        super.onActivityResult(requestCode,resultCode,data);
    }

    private void showListView(ArrayList<Integer> dsUocSo) {
        ArrayAdapter<Integer>adapter= new ArrayAdapter<Integer>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                dsUocSo);
        binding.lvUocSo.setAdapter(adapter);
    }
}
