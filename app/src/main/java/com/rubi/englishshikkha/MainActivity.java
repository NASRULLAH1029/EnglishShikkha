package com.rubi.englishshikkha;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.material.navigation.NavigationView;
import com.rubi.englishshikkha.Adapters.RecipeAdapter;
import com.rubi.englishshikkha.Classes.RecyclerItemClickListener;
import com.rubi.englishshikkha.Models.RecipeModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    private AdView adView;
    private InterstitialAd interstitialAd;
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        facebookAds();
    }

    private void facebookAds() {
        AudienceNetworkAds.initialize(this);


        adView = new AdView(this, "...................................", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.loadAd();


        interstitialAd = new InterstitialAd(this, "...........................");
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                Log.e(TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                Log.e(TAG, "Interstitial ad dismissed.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d(TAG, "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d(TAG, "Interstitial ad impression logged!");
            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        ArrayList<RecipeModel> list = new ArrayList<>();
        list.add(new RecipeModel(R.drawable.book_logo, "ক্লাস সম্পর্কে প্রয়োজনীয় কিছু কথা"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১ম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২য় ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (৩য় ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (৪র্থ ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (৫ম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (৬ষ্ঠ ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (৭ম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (৮ম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (৯ম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১০ম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১১তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১২তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১৩তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১৪তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১৫তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১৬তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১৭তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১৮তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (১৯তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২০তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২১তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২২তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২৩তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২৪তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২৫তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২৬তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২৭তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২৮তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (২৯তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলা (৩০তম ক্লাস)"));
        list.add(new RecipeModel(R.drawable.book_logo, "স্পোকেন ইংলিশ\n Lesson-1"));
        list.add(new RecipeModel(R.drawable.book_logo, "স্পোকেন ইংলিশ\n Lesson-2"));
        list.add(new RecipeModel(R.drawable.book_logo, "স্পোকেন ইংলিশ\n Lesson-3"));
        list.add(new RecipeModel(R.drawable.book_logo, "স্পোকেন ইংলিশ\n Lesson-4"));
        list.add(new RecipeModel(R.drawable.book_logo, "স্পোকেন ইংলিশ\n Lesson-5"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলার ফর্মূলা (১-৩০)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলার ফর্মূলা (৩১-৬০)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলার ফর্মূলা (৬১-৯০)"));
        list.add(new RecipeModel(R.drawable.book_logo, "ইংরেজীতে কথা বলার ফর্মূলা (৯১-১২৫)"));
        list.add(new RecipeModel(R.drawable.book_logo, "A দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "B দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "C দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "D দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "E দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "F দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "G দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "H দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "I দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "J দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "K দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "L দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "M দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "N দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "O দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "P দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "Q দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "R দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "S দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "T দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "U দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "V দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "W দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "X দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "Y দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "Z দিয়ে প্রয়োজনীয় শব্দের অর্থ"));
        list.add(new RecipeModel(R.drawable.book_logo, "কথোপকথন শুরু করতে"));
        list.add(new RecipeModel(R.drawable.book_logo, "আত্ম-পরিচয়"));
        list.add(new RecipeModel(R.drawable.book_logo, "উপদেশ মূলক কথোপকথোন"));
        list.add(new RecipeModel(R.drawable.book_logo, "সাধারন কথোপকথোন"));
        list.add(new RecipeModel(R.drawable.book_logo, "হোটেল রেস্টুরেন্ট কথোপকথন"));
        list.add(new RecipeModel(R.drawable.book_logo, "দিক নির্দেশনা মূলক কথোপকথোন"));
        list.add(new RecipeModel(R.drawable.book_logo, "ভালোবাসা সম্পর্কিত কথোপকথোন"));
        list.add(new RecipeModel(R.drawable.book_logo, "মিটিং সম্পর্কিত কথোপকথোন"));
        list.add(new RecipeModel(R.drawable.book_logo, "প্রেজেন্টেশন কথোপকথোন"));


        RecipeAdapter adapter = new RecipeAdapter(list, this);
        recyclerView.setAdapter(adapter);

        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL);
         //recyclerView.setLayoutManager(staggeredGridLayoutManager);


        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(layoutManager);


        //LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, Fast_Activity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        Intent intent1 = new Intent(MainActivity.this, class_1.class);
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(MainActivity.this, class_2.class);
                        startActivity(intent2);
                        break;


                    case 3:
                        Intent intent3 = new Intent(MainActivity.this, calss_3.class);
                        startActivity(intent3);
                        break;


                    case 4:
                        Intent intent4 = new Intent(MainActivity.this, class_4.class);
                        startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new Intent(MainActivity.this, class_5.class);
                        startActivity(intent5);
                        break;


                    case 6:
                        Intent intent6 = new Intent(MainActivity.this, class_6.class);
                        startActivity(intent6);
                        break;


                    case 7:
                        Intent intent7 = new Intent(MainActivity.this, class_7.class);
                        startActivity(intent7);
                        break;


                    case 8:
                        Intent intent8 = new Intent(MainActivity.this, class_8.class);
                        startActivity(intent8);
                        break;


                    case 9:
                        Intent intent9 = new Intent(MainActivity.this, class_9.class);
                        startActivity(intent9);
                        break;

                    case 10:
                        Intent intent10 = new Intent(MainActivity.this, class_10.class);
                        startActivity(intent10);
                        break;

                    case 11:
                        Intent intent11 = new Intent(MainActivity.this, class_11.class);
                        startActivity(intent11);
                        break;

                    case 12:
                        Intent intent12 = new Intent(MainActivity.this, class_12.class);
                        startActivity(intent12);
                        break;

                    case 13:
                        Intent intent13 = new Intent(MainActivity.this, class_13.class);
                        startActivity(intent13);
                        break;


                    case 14:
                        Intent intent14 = new Intent(MainActivity.this, class_14.class);
                        startActivity(intent14);
                        break;


                    case 15:
                        Intent intent15 = new Intent(MainActivity.this, class_15.class);
                        startActivity(intent15);
                        break;

                    case 16:
                        Intent intent16 = new Intent(MainActivity.this, class_16.class);
                        startActivity(intent16);
                        break;


                    case 17:
                        Intent intent17 = new Intent(MainActivity.this, class_17.class);
                        startActivity(intent17);
                        break;

                    case 18:
                        Intent intent18 = new Intent(MainActivity.this, class_18.class);
                        startActivity(intent18);
                        break;

                    case 19:
                        Intent intent19 = new Intent(MainActivity.this, class_19.class);
                        startActivity(intent19);
                        break;


                    case 20:
                        Intent intent20 = new Intent(MainActivity.this, class_20.class);
                        startActivity(intent20);
                        break;


                    case 21:
                        Intent intent21 = new Intent(MainActivity.this, class_21.class);
                        startActivity(intent21);
                        break;


                    case 22:
                        Intent intent22 = new Intent(MainActivity.this, class_22.class);
                        startActivity(intent22);
                        break;


                    case 23:
                        Intent intent23 = new Intent(MainActivity.this, class_23.class);
                        startActivity(intent23);
                        break;


                    case 24:
                        Intent intent24 = new Intent(MainActivity.this, class_24.class);
                        startActivity(intent24);
                        break;


                    case 25:
                        Intent intent25 = new Intent(MainActivity.this, class_25.class);
                        startActivity(intent25);
                        break;


                    case 26:
                        Intent intent26 = new Intent(MainActivity.this, class_26.class);
                        startActivity(intent26);
                        break;


                    case 27:
                        Intent intent27 = new Intent(MainActivity.this, class_27.class);
                        startActivity(intent27);
                        break;

                    case 28:
                        Intent intent28 = new Intent(MainActivity.this, class_28.class);
                        startActivity(intent28);
                        break;


                    case 29:
                        Intent intent29 = new Intent(MainActivity.this, class_29.class);
                        startActivity(intent29);
                        break;


                    case 30:
                        Intent intent30 = new Intent(MainActivity.this, class_30.class);
                        startActivity(intent30);
                        break;




                    default:
                }

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }
        ));

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.info) {

            Intent intent = new Intent(MainActivity.this, info.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://play.google.com/store/apps/details?id=com.rubi.baro_maser_amol";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "PLZ RETING THIS APPS");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        } else if (item.getItemId() == R.id.more) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Rubi+Apps+BD"));
            startActivity(intent);

        } else if (item.getItemId() == R.id.exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("EXIT..?");
            builder.setMessage("আ্যাপ থেকে বের হতে চান..?\nযদি আমাদের অ্যাপটি ভালো লাগে\n তাহলে অবশ্যই রেটিং দিয়ে \n আমাদের উৎসাহিত করবেন \n ধন্যবাদ")
                    .setCancelable(false)
                    .setPositiveButton("হ্যা", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.super.onBackPressed();
                        }
                    })


                    .setNegativeButton("না", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            builder.setNeutralButton("MORE APPS", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=Rubi+Apps+BD" + getApplicationContext().getPackageName());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplicationContext(), "বিসমিল্লাহির রাহমানির রাহীম", Toast.LENGTH_LONG);
                    toast.show();

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://play.google.com/store/apps/details?id=com.rubi.baro_maser_amol";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "PLZ RETING THIS APPS");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        } else if (id == R.id.update) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.rubi.baro_maser_amol"));
            startActivity(intent);

        } else if (id == R.id.more) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Rubi+Apps+BD"));
            startActivity(intent);

        } else if (id == R.id.rate) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.rubi.baro_maser_amol"));
            startActivity(intent);

        } else if (id == R.id.exit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("EXIT..?");
            builder.setMessage("আ্যাপ থেকে বের হতে চান..?\nযদি আমাদের অ্যাপটি ভালো লাগে\n তাহলে অবশ্যই রেটিং দিয়ে \n আমাদের উৎসাহিত করবেন \n ধন্যবাদ")
                    .setCancelable(false)
                    .setPositiveButton("হ্যা", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.super.onBackPressed();
                        }
                    })


                    .setNegativeButton("না", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            builder.setNeutralButton("MORE APPS", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=Rubi+Apps+BD" + getApplicationContext().getPackageName());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplicationContext(), "বিসমিল্লাহির রাহমানির রাহীম", Toast.LENGTH_LONG);
                    toast.show();

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        return true;

    }

}

