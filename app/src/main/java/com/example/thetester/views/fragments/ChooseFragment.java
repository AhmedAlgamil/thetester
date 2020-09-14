package com.example.thetester.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.thetester.R;
import com.example.thetester.data.local.SharedPreferencesManger;
import com.example.thetester.helper.GeneralRequest;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.thetester.data.api.ApiClient.getApiClient;
import static com.example.thetester.data.local.SharedPreferencesManger.USER_EMAIL;
import static com.example.thetester.data.local.SharedPreferencesManger.USER_NAME;
import static com.example.thetester.data.local.SharedPreferencesManger.USER_PASSWORD;
import static com.example.thetester.data.local.SharedPreferencesManger.USER_PHONE;
import static com.example.thetester.helper.Constant.REGISTER;

public class ChooseFragment extends Fragment {

    public ChooseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choose, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


}
