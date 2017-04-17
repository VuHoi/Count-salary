package com.example.billy.tinhluong;

import android.app.DatePickerDialog;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView txtChoose;
    ImageView imgCalendar;
    Date selected;
    Calendar cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControl();
        AddEvent();
    }
    private void ShowCalendar()
    {
        DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
            //Sự kiện khi click vào nút Done trên Dialog
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // Set text cho textView
                txtChoose.setText(day + "/" + (month +1) + "/" + year);
                //Lưu vết lại ngày mới cập nhật
                //Toast.makeText(MainActivity.this,day+" "+month+" "+year,Toast.LENGTH_LONG).show();
                cal.set(year,month,day);
                selected = cal.getTime();

            }
        };
        String s=txtChoose.getText()+"";
        //Lấy ra chuỗi của textView Date
        String strArrtmp[]=s.split("/");
        int ngay=Integer.parseInt(strArrtmp[0]);
        int thang=Integer.parseInt(strArrtmp[1]) - 1;
        int nam=Integer.parseInt(strArrtmp[2]);
        //Hiển thị ra Dialog
        DatePickerDialog pic=new DatePickerDialog(
                MainActivity.this,
                callback, nam, thang, ngay);
        pic.setTitle("Chọn ngày hoàn thành");
        pic.show();
    }
    private void AddEvent() {
        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             ShowCalendar();
            }
        });

    }

    private void AddControl() {
        txtChoose = (TextView) findViewById(R.id.txtDate);
        imgCalendar = (ImageView) findViewById(R.id.imgCalendar);
        cal=Calendar.getInstance();
        Date current = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtChoose.setText(sdf.format(current).toString());
    }
}




