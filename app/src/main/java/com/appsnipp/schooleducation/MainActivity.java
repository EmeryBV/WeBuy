package com.appsnipp.schooleducation;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.appsnipp.schooleducation.ui.AchatGroupe.GroupeAdapter;
import com.appsnipp.schooleducation.ui.accueil.AccueilFragment;
import com.appsnipp.schooleducation.ui.achats.AchatsFragment;
import com.appsnipp.schooleducation.ui.amis.AmisFragment;
import com.appsnipp.schooleducation.ui.magasins.Magasin;
import com.appsnipp.schooleducation.ui.magasins.MagasinsFragment;
import com.appsnipp.schooleducation.ui.produits.Produit;
import com.appsnipp.schooleducation.ui.promotions.AchatGroupe;
import com.appsnipp.schooleducation.ui.utilisateurs.LoginFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public ArrayList<com.appsnipp.schooleducation.ui.AchatGroupe.AchatGroupe> groupes;
    public ArrayList<Magasin> magasins;
    private ArrayList<AchatGroupe> promotions;
    private ArrayList<Produit> produits;
    static GroupeAdapter adapter;
    private static ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setDarkMode(getWindow());
        setContentView(R.layout.activity_main);


        GetAllMagasinsTask task = new GetAllMagasinsTask(this);
        task.execute();


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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nav_home:
                fragment = new AccueilFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commitAllowingStateLoss();;
                break;
            case R.id.nav_shop:
                fragment = new MagasinsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
                break;
            case R.id.nav_buy:
                fragment = new AchatsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
                break;
            case R.id.nav_friends:
                fragment = new AmisFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
                break;
            case R.id.nav_connexion:
                fragment = new LoginFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
                break;
            case R.id.nav_tools:
                break;
            case R.id.nav_dark_mode:
                DarkModePrefManager darkModePrefManager = new DarkModePrefManager(this);
                darkModePrefManager.setDarkMode(!darkModePrefManager.isNightMode());
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //create a seperate class file, if required in multiple activities
    public void setDarkMode(Window window){
        if(new DarkModePrefManager(this).isNightMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            changeStatusBar(0,window);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            changeStatusBar(1,window);
        }
    }
    public void changeStatusBar(int mode, Window window){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.contentBodyColor));
            //white mode
            if(mode==1){
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }

    public void openDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.openDrawer(GravityCompat.START);
    }


    public class GetAllMagasinsTask extends AsyncTask<Void, Void, Void> {
        private int i = 0;
        private MainActivity activity;

        public GetAllMagasinsTask(MainActivity a) {
            this.activity = a;
        }

        @Override
        protected void onPreExecute() {
            Fragment splashFragment = new splashScreen();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,splashFragment).commit();
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            groupes = com.appsnipp.schooleducation.ui.AchatGroupe.AchatGroupe.getAllGroupes();
            magasins = Magasin.getAllMagasins();
            promotions = AchatGroupe.getAllPromotions();
            produits=Produit.getAllProduit();

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... progress) {
            super.onProgressUpdate(progress);

        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            adapter = new GroupeAdapter(activity, groupes,magasins,promotions,produits);
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(activity);
            onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_home));

        }

    }

}