package com.example.akm.server_db_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button b,put;
    public static TextView t;
    EditText ed1,ed2,ed3;
    RequestQueue requestQueue;


   // String insert="http://10.0.2.2:80/server/putNews.php";
    String insert="http://****************.compute-1.amazonaws.com/putNews.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(Button)findViewById(R.id.button);
        t=(TextView)findViewById(R.id.text);

        put=(Button)findViewById(R.id.btnPut);
        ed1=(EditText)findViewById(R.id.edTitle);
        ed2=(EditText)findViewById(R.id.edNews);
        ed3=(EditText)findViewById(R.id.edTime);

        requestQueue= Volley.newRequestQueue(getApplicationContext());

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
  fetchData process=new fetchData();
  process.execute();

            }
        });

       put.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              StringRequest request=new StringRequest(Request.Method.POST, insert, new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {

                   }
               }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {

                   }
               }){
                   @Override
                   protected Map<String, String> getParams() throws AuthFailureError {
                       HashMap<String,String>parameters=new HashMap<String,String>();
                       parameters.put("title",ed1.getText().toString());
                       parameters.put("news",ed2.getText().toString());
                       parameters.put("time",ed3.getText().toString());
                       return parameters;
                   }
               };
               requestQueue.add(request);
           }
       });

    }

    }
