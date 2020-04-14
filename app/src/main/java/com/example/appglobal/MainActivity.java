package com.example.appglobal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView txtThongTin;
    Button btnXacNhan;
    EditText edtHoTen,edtEmail,edtSDT;
    ImageView imgVietNam,imgEngland;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        imgEngland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganNgonNgu("en");
            }
        });

        imgVietNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganNgonNgu("vi");
            }
        });

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtHoTen.getText().toString();
                String email = edtEmail.getText().toString();
                String sdt = edtSDT.getText().toString();

                String textChaoBan = getResources().getString(R.string.textChaoBan);
                String textEmail = getResources().getString(R.string.text_Email);
                String textSDT = getResources().getString(R.string.textSDT);
                txtThongTin.setText(textChaoBan + ": " + hoten + "\n" + textEmail + ": " + email + "\n" + textSDT + ": " + sdt);
            }
        });
    }

    private void anhXa()
    {
        txtThongTin = (TextView) findViewById(R.id.txtThongTin);
        btnXacNhan  = (Button) findViewById(R.id.btnXacNhan);
        edtHoTen    = (EditText) findViewById(R.id.edtHoTen);
        edtEmail    = (EditText) findViewById(R.id.edtEmail);
        edtSDT      = (EditText) findViewById(R.id.edtSDT);
        imgVietNam  = (ImageView) findViewById(R.id.imgVietNam);
        imgEngland  = (ImageView) findViewById(R.id.imgEngland);
    }

    private void ganNgonNgu(String language)
    {
        Locale locale = new Locale(language); //chèn vào ngôn ngữ
        Configuration config = new Configuration(); //cấu tạo lại hệ thống
        config.locale = locale; //cấu hình lại ngôn ngữ
        getBaseContext().getResources().updateConfiguration(
                config,
                getBaseContext().getResources().getDisplayMetrics()
        ); // cập nhập lại Resource strings ngôn ngữ

        Intent intent = new Intent(MainActivity.this,MainActivity.class);//load lại ngôn ngữ lên
        startActivity(intent); //load lại ngôn ngữ lên
    }
}
