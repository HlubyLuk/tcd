package cz.hlubyluk.tcd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;


public class ActivityTop extends ActionBarActivity implements FragmentNavigation.ClickedButton {

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.dlContent, FragmentHome.newInstance());
        fragmentTransaction.replace(R.id.dlNavigation, FragmentNavigation.newInstance());
        fragmentTransaction.commit();

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.dlRoot);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void clickedButton(View view) {
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Intent intent = null;
        switch (view.getId()) {
            case R.id.fnBtCategory:
                intent = new Intent(this, ActivityCategory.class);
                break;
            case R.id.fnBtTop:
                intent = new Intent(this, ActivityDetail.class);
                break;
        }
        startActivity(intent);
    }
}
