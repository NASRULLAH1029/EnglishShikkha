package com.rubi.englishshikkha;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class class_12 extends AppCompatActivity {
    TextView server_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class12);

        server_text = findViewById(R.id.server_text);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://rubiappsbd.xyz/english_shikkha/class12.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                server_text.setText("Server Response:\n" + response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                server_text.setText("That didn't work!");

            }
        }
        );


        RequestQueue requestQueue = Volley.newRequestQueue(class_12.this);
        requestQueue.add(stringRequest);
    }
}