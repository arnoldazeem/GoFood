package incop.ark.lyte.adaboo.gofood;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Activity_Home extends AppCompatActivity  {

             //implements NavigationView.OnNavigationItemSelectedListener

    private RecyclerView recyclerView;
    private RestaurantAdapter adapter;

    //my setter go here
    private List<Restaurant_Model> albumList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.collapse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new RestaurantAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



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
                             collapsingToolbar.setTitle(" ");
                             isShow = false;
                         }
                     }
                 });
             }

             /**
              * Adding few albums for testing
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
                         R.drawable.album8,
                         R.drawable.album9,
                         R.drawable.album10,
                         R.drawable.album11};

                 Restaurant_Model a = new Restaurant_Model("True Romance", 13, covers[0]);
                 albumList.add(a);

                 a = new Restaurant_Model("Xscpae", 8, covers[1]);
                 albumList.add(a);

                 a = new Restaurant_Model("Maroon 5", 11, covers[2]);
                 albumList.add(a);

                 a = new Restaurant_Model("Born to Die", 12, covers[3]);
                 albumList.add(a);

                 a = new Restaurant_Model("Honeymoon", 14, covers[4]);
                 albumList.add(a);

                 a = new Restaurant_Model("I Need a Doctor", 1, covers[5]);
                 albumList.add(a);

                 a = new Restaurant_Model("Loud", 11, covers[6]);
                 albumList.add(a);

                 a = new Restaurant_Model("Legend", 14, covers[7]);
                 albumList.add(a);

                 a = new Restaurant_Model("Hello", 11, covers[8]);
                 albumList.add(a);

                 a = new Restaurant_Model("Greatest Hits", 17, covers[9]);
                 albumList.add(a);

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    */



