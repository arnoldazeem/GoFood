package incop.ark.lyte.adaboo.gofood;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Activity_Home extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity__home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //toolbar added drawer capabilities
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        initCollapsingToolbar();
        init();


        //NAV drawer is used here
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new RestaurantAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(Activity_Home.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        try {

                            if (position == 0) {

                                Intent myIntent = new Intent(Activity_Home.this, OrderNow.class);
                                //myIntent.putExtra("key", value); //Optional parameters
                                startActivity(myIntent);

                            } else if (position == 1) {

                                Intent myIntent = new Intent(Activity_Home.this, GetRestaurants.class);
                                //myIntent.putExtra("key", value); //Optional parameters
                                startActivity(myIntent);

                            } else if (position == 2) {

                                Intent myIntent = new Intent(Activity_Home.this, PostActivity.class);
                                //myIntent.putExtra("key", value); //Optional parameters
                                startActivity(myIntent);


                            } else if (position == 3) {
                                alertme();
                            } else if (position == 4) {

                            } else if (position == 5) {

                            }else if (position == 6) {

                                alertme();

                            }else if (position == 7) {

                                Intent myInten = new Intent(Activity_Home.this, contactUs.class);
                                //myIntent.putExtra("key", value); //Optional parameters
                                startActivity(myInten);

                            }



                        }catch (Exception ex){

                        }

                    }
                })
        );



        prepareAlbums();

        try {

            Glide.with(this).load(R.drawable.beach).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }



        }

             /**
              * Initializing collapsing toolbar
              * Will show and hide the toolbar title on scroll
              */
             private void initCollapsingToolbar() {
                 final CollapsingToolbarLayout collapsingToolbar =
                         (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
                 collapsingToolbar.setTitle(" ");
                 AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
                 appBarLayout.setExpanded(true);

                 // hiding & showing the title when toolbar expanded & collapsed
                 appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                     boolean isShow = false;
                     int scrollRange = -1;

                     @Override
                     public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                         if (scrollRange == -1) {
                             scrollRange = appBarLayout.getTotalScrollRange();
                         }
                         if (scrollRange + verticalOffset == 0) {
                             collapsingToolbar.setTitle(getString(R.string.app_name));
                             isShow = true;
                         } else if (isShow) {
                             collapsingToolbar.setTitle(getString(R.string.app_name));
                             isShow = false;
                         }
                     }
                 });
             }

             /**
              * Adding few images for first page
              */
             private void prepareAlbums() {
                 int[] covers = new int[]{
                         R.drawable.album1,
                         R.drawable.album2,
                         R.drawable.album3,
                         R.drawable.album4,
                         R.drawable.album5,
                         R.drawable.album6,
                         R.drawable.album7,
                        };

                 Restaurant_Model a = new Restaurant_Model("ORDER NOW", covers[0]);
                 albumList.add(a);

                 a = new Restaurant_Model("RESTAURANTS", covers[1]);
                 albumList.add(a);

                 a = new Restaurant_Model("SCHOOL LUNCH ORDERS", covers[2]);
                 albumList.add(a);

                 a = new Restaurant_Model("GROCERIES", covers[3]);
                 albumList.add(a);

                 a = new Restaurant_Model("DELIVERY ZONES", covers[4]);
                 albumList.add(a);

                 a = new Restaurant_Model("ABOUT US", covers[5]);
                 albumList.add(a);

                 a = new Restaurant_Model("CONTACT US", covers[6]);
                 albumList.add(a);


                 //albumList.add(a);

                 adapter.notifyDataSetChanged();
             }

             /**
              * RecyclerView item decoration - give equal margin around grid item
              */
             public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

                 private int spanCount;
                 private int spacing;
                 private boolean includeEdge;

                 public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
                     this.spanCount = spanCount;
                     this.spacing = spacing;
                     this.includeEdge = includeEdge;
                 }

                 @Override
                 public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                     int position = parent.getChildAdapterPosition(view); // item position
                     int column = position % spanCount; // item column

                     if (includeEdge) {
                         outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                         outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                         if (position < spanCount) { // top edge
                             outRect.top = spacing;
                         }
                         outRect.bottom = spacing; // item bottom
                     } else {
                         outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                         outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                         if (position >= spanCount) {
                             outRect.top = spacing; // item top
                         }
                     }
                 }
             }



             /**
              * Converting dp to pixel
              */
             private int dpToPx(int dp) {
                 Resources r = getResources();
                 return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
             }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity__home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.order_now) {
            Intent myIntent = new Intent(Activity_Home.this, OrderNow.class);
            //myIntent.putExtra("key", value); //Optional parameters
            startActivity(myIntent);


        } else if (id == R.id.restaurants) {

            Intent myIntent = new Intent(Activity_Home.this, GetRestaurants.class);
            //myIntent.putExtra("key", value); //Optional parameters
            startActivity(myIntent);


        } else if (id == R.id.school_lunch) {

        } else if (id == R.id.groceries) {

        } else if (id == R.id.delivery_zone) {

        }else if (id == R.id.about_us) {

            alertme();

        }else if (id == R.id.contact_us) {

            Intent myInten = new Intent(Activity_Home.this, contactUs.class);
            //myIntent.putExtra("key", value); //Optional parameters
            startActivity(myInten);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //alert

   public void alertme(){


        // custom dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.about_us);
        dialog.setTitle("ABOUT US.");

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText("Android custom dialog example!");
        ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //image.setImageResource(R.drawable.ic_launcher);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }




    //for the view pager
    private void init() {
        for(int i=0;i<IMAGES.length;i++)

            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new SlidingImage_Adapter(Activity_Home.this,ImagesArray));


        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }


}







        /*

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    */



