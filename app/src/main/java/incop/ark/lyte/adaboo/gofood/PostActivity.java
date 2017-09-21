package incop.ark.lyte.adaboo.gofood;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by adaboo on 8/23/17.
 */

    //private static final String ENDPOINT = "https://kylewbanks.com/rest/posts.json";

    public class PostActivity extends AppCompatActivity {
        // Will show the string "data" that holds the results
        //TextView results;
        // URL of object to be parsed
       // String JsonURL = "https://raw.githubusercontent.com/ianbar20/JSON-Volley-Tutorial/master/Example-JSON-Files/Example-Object.JSON";
        // This string will hold the results
       private static final String JsonURL = "https://gofoodpng.biz/api/hello/get_categories_tastybites/";
        private ProgressBar progressBar;
        // String data = "";
        // Defining the Volley request queue that handles the URL request concurrently
        RequestQueue requestQueue;
        ProgressDialog progress;
        JSONArray  products  = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_post);
            // Creates the Volley request queue
             requestQueue = Volley.newRequestQueue(this);

            String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyBmSXUzVZBKQv9FJkTpZXn0dObKgEQOIFU&cx=014099860786446192319:t5mr0xnusiy&q=AndroidDev&alt=json&searchType=image";
           // progressBar=(ProgressBar)findViewById(R.id.progressBar);

            progress = new ProgressDialog(this);
            //initialize the progress dialog and show it
            progress.setMessage("loading The data....");
            progress.show();

            JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, JsonURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub

                    try {


                    if (response != null) {



                        products = response.getJSONArray("results");

                        for (int i = 0; i <= products.length();  i++) {


                        Toast.makeText(PostActivity.this, products.get(i).toString(),
                                Toast.LENGTH_SHORT).show();

                        //Log.d(e,response.toString());

                        }

                        }

                    }//catch (JSONException e) {
                        // TODO: handle exception
                       // e.printStackTrace();
                    //}
                    catch (Exception ex) {
                        // TODO: handle exception
                        ex.printStackTrace();
                        System.out.println("********************* "
                                + ex.toString());
                        Toast.makeText(PostActivity.this,
                                ex.toString(), Toast.LENGTH_LONG)
                                .show();
                    }


                    progress.dismiss();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                    progress.dismiss();
                }
            });
            requestQueue.add(jsObjRequest);
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity__home, menu);
        return true;
    }

}