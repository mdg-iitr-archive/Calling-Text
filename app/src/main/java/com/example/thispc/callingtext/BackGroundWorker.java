package com.example.thispc.callingtext;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by this pc on 08-08-2016.
 */
public class BackGroundWorker extends AsyncTask<String,Void,String> {
    private Context context;
    AlertDialog a;
    int n1;
    public BackGroundWorker(Context context1,int n) {
        context = context1;n1=n;
    }
    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection h=null;
        String postdata=null;
        BufferedWriter br=null;
        String caller = params[0];
        String receiver = params[1];
        URL url= null;
        try {
            if(n1!=1)
                url = new URL("http://pulkit123.coolpage.biz/saveMsg.php");
            else
                url=new URL("http://pulkit123.coolpage.biz/sendMsg.php");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            h=(HttpURLConnection)url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            h.setRequestMethod("POST");
            h.setDoInput(true);
            h.setDoOutput(true);
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        OutputStream wr = null;
        try {
            wr = h.getOutputStream();
            br =new BufferedWriter(new OutputStreamWriter(wr,"UTF-8"));
            if(n1!=1)
            postdata= URLEncoder.encode("caller", "UTF-8")+"="+URLEncoder.encode(caller,"UTF-8");
            br.write(postdata);
            br.flush();
            br.close();
            wr.close();
            InputStream i=h.getInputStream();
            BufferedReader b=new BufferedReader(new InputStreamReader(i,"iso-8859-1"));
            String result="";
            String line="";
            while((line=b.readLine())!=null)
            {
                result+=line;
            }
            b.close();
            return  result;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  null;
    }

    @Override
    protected void onPostExecute(String result) {
        a.setMessage(result);
        a.show();
    }

    @Override
    protected void onPreExecute() {
        a=new AlertDialog.Builder(context).create();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
