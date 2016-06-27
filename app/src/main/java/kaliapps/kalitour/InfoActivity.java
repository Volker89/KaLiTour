package kaliapps.kalitour;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class InfoActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    private class CustomAdapter extends FragmentPagerAdapter {
        private String fragments [] = {"Text","Bild","Audio"};

        Intent intent = getIntent();
        String prevActivity = intent.getStringExtra("FROM_ACTIVITY");

        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Fragment Fragment1 = new Fragment1();

                    Bundle args1 = new Bundle();
                    args1.putString("FRAGMENT_KEY",prevActivity);
                    Fragment1.setArguments(args1);

                    return Fragment1;
                case 1:
                    Fragment Fragment2 = new Fragment2();

                    Bundle args2 = new Bundle();
                    args2.putString("FRAGMENT_KEY",prevActivity);
                    Fragment2.setArguments(args2);

                    return Fragment2;
                case 2:
                    return new Fragment3();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Intent ia = new Intent(InfoActivity.this, InstructActivity.class);
                startActivity(ia);
                return true;
            case R.id.item2:
                return true;
            case R.id.item2_1:
                Intent i1 = new Intent(InfoActivity.this, InfoActivity.class);
                i1.putExtra("FROM_ACTIVITY","Altes Rathaus");
                startActivity(i1);
                return true;
            case R.id.item2_2:
                Intent i2 = new Intent(InfoActivity.this, InfoActivity.class);
                i2.putExtra("FROM_ACTIVITY","Johannstrasse");
                startActivity(i2);
                return true;
            case R.id.item2_3:
                Intent i3 = new Intent(InfoActivity.this, InfoActivity.class);
                i3.putExtra("FROM_ACTIVITY","Alfredstrasse");
                startActivity(i3);
                return true;
            case R.id.item2_4:
                Intent i4 = new Intent(InfoActivity.this, InfoActivity.class);
                i4.putExtra("FROM_ACTIVITY","Georgstrasse");
                startActivity(i4);
                return true;
            case R.id.item2_5:
                Intent i5 = new Intent(InfoActivity.this, InfoActivity.class);
                i5.putExtra("FROM_ACTIVITY","Markt");
                startActivity(i5);
                return true;
            case R.id.item2_6:
                Intent i6 = new Intent(InfoActivity.this, InfoActivity.class);
                i6.putExtra("FROM_ACTIVITY","Antonstrasse");
                startActivity(i6);
                return true;
            case R.id.item2_7:
                Intent i7 = new Intent(InfoActivity.this, InfoActivity.class);
                i7.putExtra("FROM_ACTIVITY","Lotharstrasse");
                startActivity(i7);
                return true;
            case R.id.item2_8:
                Intent i8 = new Intent(InfoActivity.this, InfoActivity.class);
                i8.putExtra("FROM_ACTIVITY","Barbarastrasse");
                startActivity(i8);
                return true;
            case R.id.item2_9:
                Intent i9 = new Intent(InfoActivity.this, InfoActivity.class);
                i9.putExtra("FROM_ACTIVITY","Vinnstrasse");
                startActivity(i9);
                return true;
            case R.id.item2_10:
                Intent i10 = new Intent(InfoActivity.this, InfoActivity.class);
                i10.putExtra("FROM_ACTIVITY","Maxstrasse");
                startActivity(i10);
                return true;
            case R.id.item3:
                Intent ib = new Intent(InfoActivity.this, CreditsActivity.class);
                startActivity(ib);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
