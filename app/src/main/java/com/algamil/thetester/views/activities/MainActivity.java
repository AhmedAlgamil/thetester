package com.algamil.thetester.views.activities;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.algamil.thetester.R;
import com.algamil.thetester.helper.HelperMethod;
import com.algamil.thetester.helper.InternetState;
import com.algamil.thetester.views.fragments.LoginFragment;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

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
            HelperMethod.showSnackBar(frameContainer,HelperMethod.getStringFromXML(this,R.string.check_your_internet));
        }


    }


}
