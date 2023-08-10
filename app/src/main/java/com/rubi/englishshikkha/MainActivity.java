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

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout layout_1, layout_2, layout_3, layout_4, layout_5, layout_6, layout_7, layout_8, layout_9, layout_10, layout_11;
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


        adView = new AdView(this, "..............................", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.loadAd();


        interstitialAd = new InterstitialAd(this, "..............................");
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


        layout_1 = (LinearLayout) findViewById(R.id.btn_1);
        layout_2 = (LinearLayout) findViewById(R.id.btn_2);
        layout_3 = (LinearLayout) findViewById(R.id.btn_3);
        layout_4 = (LinearLayout) findViewById(R.id.btn_4);
        layout_5 = (LinearLayout) findViewById(R.id.btn_5);
        layout_6 = (LinearLayout) findViewById(R.id.btn_6);
        layout_7 = (LinearLayout) findViewById(R.id.btn_7);
        layout_8 = (LinearLayout) findViewById(R.id.btn_8);
        layout_9 = (LinearLayout) findViewById(R.id.btn_9);
        layout_10 = (LinearLayout) findViewById(R.id.btn_10);
        layout_11 = (LinearLayout) findViewById(R.id.btn_11);


        layout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Fast_Activity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        layout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        layout_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        layout_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        layout_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        layout_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        layout_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        layout_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        layout_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        layout_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        layout_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), "please wait...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


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

