package com.algamil.thetester.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.algamil.thetester.R;
import com.algamil.thetester.data.local.SharedPreferencesManger;
import com.algamil.thetester.helper.GeneralRequest;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.algamil.thetester.data.api.ApiClient.getApiClient;
import static com.algamil.thetester.data.local.SharedPreferencesManger.USER_EMAIL;
import static com.algamil.thetester.data.local.SharedPreferencesManger.USER_NAME;
import static com.algamil.thetester.data.local.SharedPreferencesManger.USER_PASSWORD;
import static com.algamil.thetester.data.local.SharedPreferencesManger.USER_PHONE;
import static com.algamil.thetester.helper.Constant.REGISTER;

public class SignUpFragment extends Fragment {

    @BindView(R.id.select_photo)
    CircleImageView selectPhoto;
    @BindView(R.id.tx_register_name)
    TextInputEditText txRegisterName;
    @BindView(R.id.tx_register_email)
    TextInputEditText txRegisterEmail;
    @BindView(R.id.tx_register_phone)
    TextInputEditText txRegisterPhone;
    @BindView(R.id.tx_register_password)
    TextInputEditText txRegisterPassword;
    @BindView(R.id.btn_next)
    Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.select_photo, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.select_photo:
                break;
            case R.id.btn_next:
                makeSignUp(txRegisterName.getText().toString(),
                        txRegisterEmail.getText().toString(),
                        txRegisterPhone.getText().toString(),
                        txRegisterPassword.getText().toString(),
                        "any");
                break;
        }
    }

    public void makeSignUp(String name,String email,String phone,String password,String image_url)
    {
        SharedPreferencesManger.saveData(getActivity(),USER_NAME,txRegisterName.getText().toString());
        SharedPreferencesManger.saveData(getActivity(),USER_EMAIL,txRegisterEmail.getText().toString());
        SharedPreferencesManger.saveData(getActivity(),USER_PHONE,txRegisterPhone.getText().toString());
        SharedPreferencesManger.saveData(getActivity(),USER_PASSWORD,txRegisterPassword.getText().toString());
        GeneralRequest.makeSignUp(getApiClient().signUp(name,email,phone,password,image_url),getActivity()
                ,getActivity().getSupportFragmentManager()
                ,REGISTER);

    }


}
