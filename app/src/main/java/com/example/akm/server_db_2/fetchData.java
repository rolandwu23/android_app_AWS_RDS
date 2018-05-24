package com.example.akm.server_db_2;

import android.os.AsyncTask;

import com.example.akm.server_db_2.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class fetchData extends AsyncTask<Void,Void,Void> {
String data="";
String dataParsed="";
String singleParsed="";

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url=new URL("http://**************.compute-1.amazonaws.com/getNews.php");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null){
                line=bufferedReader.readLine();
                data=data+line;
            }

            JSONArray ja=new JSONArray(data);
            for(int i=0;i<ja.length();i++){
                JSONObject jo=(JSONObject)ja.get(i);
                singleParsed="Title  "+jo.get("title")+"\n"+
                        "News   "+jo.get("news")+"\n"+
                        "Time   "+jo.get("time")+"\n";
                dataParsed=dataParsed+singleParsed;

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.t.setText(this.dataParsed);
    }
}
