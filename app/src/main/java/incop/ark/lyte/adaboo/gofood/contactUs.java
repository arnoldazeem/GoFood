package incop.ark.lyte.adaboo.gofood;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adaboo on 8/19/17.
 */

public class contactUs extends AppCompatActivity  {

    //for the sliding view


    private RecyclerView recyclerView;
    private RestaurantAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);


       }


    }