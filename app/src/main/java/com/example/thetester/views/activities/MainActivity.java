package com.example.thetester.views.activities;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thetester.R;
import com.example.thetester.helper.HelperMethod;
import com.example.thetester.helper.InternetState;
import com.example.thetester.views.fragments.LoginFragment;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
       @BindView(R.id.frame_container)
       FrameLayout frameContainer;
       WifiManager wifiManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        HelperMethod.replaceFragment(getSupportFragmentManager(),R.id.frame_container,new LoginFragment());
        if(InternetState.isConnected(this))
        {

        }
        else {
            Snackbar.make(frameContainer,"No connection", Snackbar.LENGTH_LONG).setAction("open wifi", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wifiManager.setWifiEnabled(true);
                }
            }).show();
        }


    }


}
