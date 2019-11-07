package com.example.volley_post.Result;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.volley_post.Model.Room;
import com.example.volley_post.R;

public class next_activity extends AppCompatActivity
{
    TextView tv1,tv2,tv3,tv4,tv6,tv7;
    Room room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_activity);

        tv1= findViewById(R.id.tv1);
        tv2= findViewById(R.id.tv2);
        tv3= findViewById(R.id.tv3);
        tv4= findViewById(R.id.tv4);
        tv6= findViewById(R.id.tv6);
        tv7= findViewById(R.id.tv7);


        room = (Room) getIntent().getSerializableExtra("Room");

        tv1.setText(String.valueOf(room.getPropertyID()));
        tv2.setText(String.valueOf(room.getPropertyLocation()));
        tv3.setText(String.valueOf(room.getPropertyName()));
        tv4.setText(String.valueOf(room.getRoomsCount()));
        tv6.setText(String.valueOf(room.getCreatedBy()));








    }
}
