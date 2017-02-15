package com.example.sam.lect8_dialogs_fragments;

import android.app.DatePickerDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
   TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_main);
        LinearLayout childLayout = new LinearLayout(this);
        childLayout.setOrientation(LinearLayout.VERTICAL);
        textView=new TextView(this);
        childLayout.addView(textView);

        for (int i = 0; i <= 10; i++) {
            Button button = new Button(this);
            button.setText("" + i);
            button.setWidth(30);
            button.setHeight(10);
            button.setOnClickListener(new MyLstn());
            childLayout.addView(button);
        }
        linearLayout.addView(childLayout);
    }

    class MyLstn implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String str = ((Button) view).getText().toString();
            Toast.makeText(MainActivity.this, "You clicked" + str, Toast.LENGTH_LONG).show();

            switch (str) {
                case "0":
                    AlertDialog.Builder alertBox = new AlertDialog.Builder(MainActivity.this);
                    alertBox.setTitle("Alert When Click");
                    alertBox.setMessage("Button one is clicked");
                    alertBox.show();
                    break;
                case "1":
                    DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int day) {
                            textView.setText("Selected " + year+"-"+(month+1)+"-"+day);
                        }
                    },2017,0,1);
                    datePickerDialog.show();
            }
        }
    }
}

