package incop.ark.lyte.adaboo.gofood;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adaboo on 9/14/17.
 */

public class OrderNow extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RestaurantAdapter adapter;

    Button order;
    //my setter go here
    private List<Restaurant_Model> albumList;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.order_now);

        order = (Button) findViewById(R.id.order_now);

        order.setOnClickListener(this);

        }


    @Override
    public void onClick(View v) {

    }
}
