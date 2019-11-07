package com.example.volley_post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cedarsoftware.util.io.JsonObject;
import com.example.volley_post.Model.Room;
import com.example.volley_post.Result.next_activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText input_email, input_password;
    Button btn_login;
    String url = "https://hdlbwgq418.execute-api.us-east-1.amazonaws.com/dev/checkuserlogin";
    List<Room> rooms = new ArrayList<>();
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        btn_login = findViewById(R.id.btn_login);


        requestQueue = Volley.newRequestQueue(this);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = input_email.getText().toString();
                String pass  = input_password.getText().toString();


                if (!isValidEmail(email) && pass.contains("")) {
                    Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
                    loginUser();

            }
        });
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private void loginUser() {
        final String username = input_email.getText().toString().trim();
        final String password = input_password.getText().toString().trim();

        JSONObject postDataParams = new JSONObject();


        try {
            postDataParams.put("UserName", username);
            postDataParams.put("Password", password);
            postDataParams.put("UserType", "admin");

        } catch (JSONException e)
        {
            e.printStackTrace();
        }


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, postDataParams, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if (response.getInt("Status") == 1) {

                        JSONArray jsonArray = response.getJSONArray("Properties");
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject hit = jsonArray.getJSONObject(i);

                            Integer propertyid = hit.getInt("PropertyID");
                            String propertyname = hit.getString("PropertyName");
                            String propertylocation = hit.getString("PropertyLocation");
                            String propertytype = hit.getString("PropertyType");
                            Integer roomscount = hit.getInt("RoomsCount");
                            String createdby = hit.getString("CreatedBy");


                            rooms.add(new Room(propertyid, propertyname, propertylocation, propertytype, roomscount, createdby));
                            Toast.makeText(MainActivity.this, response.getString("Message"), Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(MainActivity.this, response.getString("Message"), Toast.LENGTH_SHORT).show();
                    }


                    Intent i = new Intent(MainActivity.this, next_activity.class);
                    i.putExtra("Room", rooms.get(0));
                    startActivity(i);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue.add(jsonObjectRequest);

    }
}
