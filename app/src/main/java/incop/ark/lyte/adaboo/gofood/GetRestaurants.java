package incop.ark.lyte.adaboo.gofood;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by adaboo on 9/13/17.
 */

public class GetRestaurants  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.getrestaurants);


            CustomGrid adapter = new CustomGrid(GetRestaurants.this, web, imageId);
            grid=(GridView)findViewById(R.id.grid);
            grid.setAdapter(adapter);
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Toast.makeText(GetRestaurants.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

                }
            });

        }


    GridView grid;
    String[] web = {
            "Tasty Bites",
            "Kopitiam",
            "Beijing Noodle House",
            "Enzo's Express Takeaway",
            "Buffalo Burger",
            "Cellar-Restaurant",
            "Golden Bowl",
            "Mr Mikes",
            "Big Boi Burger",
            "Fusion Bistro",
    } ;
    String [] imageId = {
            "https://gofoodpng.biz/wp-content/uploads/2017/01/Tasty-Bites-Logo.png",
            "https://gofoodpng.biz/wp-content/uploads/2017/01/Kopitiam-logo-small.png",
            "https://gofoodpng.biz/wp-content/uploads/2017/02/Beijing-Noodle-HouseLogo.png",
            "https://gofoodpng.biz/wp-content/uploads/2017/02/Enzos-logo-NEW.png",
            "https://gofoodpng.biz/wp-content/uploads/2017/02/Buffalo-logo-20.png",
            "https://gofoodpng.biz/wp-content/uploads/2017/02/The-cellar-restaurant-400x270.png",
            "https://gofoodpng.biz/wp-content/uploads/2017/01/GoldenBowl-Logo-small.png",
            "https://gofoodpng.biz/wp-content/uploads/2017/02/Mr-Mikes-small.png",
            "https://gofoodpng.biz/wp-admin/upload.php?item=269",
            "https://gofoodpng.biz/wp-admin/upload.php?item=248"
    };


}
