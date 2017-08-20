package incop.ark.lyte.adaboo.gofood;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adaboo on 8/19/17.
 */

public class ChooseRestaurant extends AppCompatActivity {

    //for the sliding view
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.banner1,R.drawable.banner2,R.drawable.banner3};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();


    private RecyclerView recyclerView;
    private RestaurantAdapter adapter;

    //my setter go here
    private List<Restaurant_Model> albumList;

    DrawerLayout drawerLayout;

    final String TAG = this.getClass().getSimpleName();

    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);
        

        String url ="http://www.example.com";

        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response

                        Log.d(TAG,response );
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });



        // Add a request (in this example, called stringRequest) to your RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(stringRequest);

        }
    }