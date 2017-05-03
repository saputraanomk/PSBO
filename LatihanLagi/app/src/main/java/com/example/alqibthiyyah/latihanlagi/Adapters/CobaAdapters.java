package com.example.alqibthiyyah.latihanlagi.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.alqibthiyyah.latihanlagi.AppController;
import com.example.alqibthiyyah.latihanlagi.Models.Post;
import com.example.alqibthiyyah.latihanlagi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alqibthiyyah on 03/05/2017.
 */

public class CobaAdapters extends BaseAdapter {
    List<Post> postList;
    Context mContext; //jika mau pindah halaman, memindah item ke halamam lain
    private static final String url = "https://jsonplaceholder.typicode.com/posts/";

    public CobaAdapters(List<String> stringList) {
        this.postList = postList;
    }

    public CobaAdapters(Context mContext) {
        postList = new ArrayList<>();
        this.mContext = mContext;
        fetchdata();
    }

    private void fetchdata() {
        final String req_tag = "COBA_REQ";

        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, url, null, fetchdataListener(), errorListener());

        AppController.getInstance().addToRequestQueue(req, req_tag);
    }

    private Response.ErrorListener errorListener(){
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                return ;
            }
        };
    }
    private Response.Listener<JSONArray> fetchdataListener(){
        return new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Coba",response.toString());
                for (int i = 0; i < response.length() ; i++) {
                    try {
                        JSONObject postObj = response.getJSONObject(i);
                        Log.d("blaaaa",postObj.toString());
                        Post post = new Post (postObj.getString("title"), postObj.getString("body"));
                        postList.add(post);
                    } catch (JSONException e) //ngeprint eror ke kontrol
                    {
                        e.printStackTrace();
                    }
                }

            }
        };
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Post getItem(int i) {
        return postList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    //fungsinya ketika data ada, mau diapain tampilannya
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = null;

        if(getCount() != 0){
            v = View.inflate(mContext, R.layout.list_item_coba, null);
            TextView titleTxtVw, bodyTxtVw;
            titleTxtVw = (TextView)v.findViewById(R.id.titleTxtVw);
            bodyTxtVw = (TextView) v.findViewById(R.id.bodyTxtVw);
            titleTxtVw.setText(getItem(i).getTitle());
            bodyTxtVw.setText(getItem(i).getBody());
        }
        return v;
    }
}