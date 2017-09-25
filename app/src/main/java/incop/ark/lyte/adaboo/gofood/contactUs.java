package incop.ark.lyte.adaboo.gofood;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adaboo on 8/19/17.
 */

public class contactUs extends AppCompatActivity  {

    //for the sliding view


    private RecyclerView recyclerView;
    private RestaurantAdapter adapter;

    final String TAG = this.getClass().getSimpleName();


    String url ="https://gofoodpng.biz/api/hello/place_order/?itemname=1&sububurb=Alice&quantity=Alice";

    private ProgressBar progressBar;
    // String data = "";
    // Defining the Volley request queue that handles the URL request concurrently
    RequestQueue requestQueue;
    ProgressDialog progress;
    JSONArray products  = null;
    GridView grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);

        //String url = "https://gofoodpng.biz/api/hello/place_order";
        //requestQueue = Volley.newRequestQueue(this);

        // progressBar=(ProgressBar)findViewById(R.id.progressBar);

        /**
        progress = new ProgressDialog(this);
        //initialize the progress dialog and show it
        progress.setMessage("loading The data....");
        progress.show();

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub

                ArrayList<restaurant_List_Bulk> items = new ArrayList<restaurant_List_Bulk>();
                try {

                    if (response != null) {

                     // String  products = response.get("status");
                        Log.d(TAG,  response.get("status").toString());

                    }

                }catch (JSONException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } catch (Exception ex) {
                    // TODO: handle exception
                    ex.printStackTrace();
                    System.out.println("********************* "
                            + ex.toString());
                    Toast.makeText(contactUs.this,
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

*/


    }


}