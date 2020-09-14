package com.algamil.thetester.views.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.algamil.thetester.R;
import com.algamil.thetester.data.local.SharedPreferencesManger;
import com.algamil.thetester.data.local.TinyDB;
import com.algamil.thetester.helper.GeneralRequest;
import com.algamil.thetester.helper.HelperMethod;
import com.algamil.thetester.views.activities.AuthActivity;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.algamil.thetester.data.api.ApiClient.getApiClient;
import static com.algamil.thetester.data.local.SharedPreferencesManger.REMEMBER_ME;
import static com.algamil.thetester.helper.Constant.LOGIN;


public class LoginFragment extends Fragment {

    @BindView(R.id.tx_phone_login)
    TextInputEditText txPhoneLogin;
    @BindView(R.id.tx_layout_phone)
    TextInputLayout txLayoutPhone;
    @BindView(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @BindView(R.id.ch_remember_me)
    CheckBox chRememberMe;
    @BindView(R.id.linear_layout)
    LinearLayout linearLayout;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.fab_register_login)
    FloatingActionButton fabRegisterLogin;
    @BindView(R.id.tx_password_login)
    TextInputEditText txPasswordLogin;
    @BindView(R.id.tx_password_login_layout)
    TextInputLayout txPasswordLoginLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.btn_teacher)
    AppCompatButton btnTeacher;
    @BindView(R.id.btn_student)
    AppCompatButton btnStudent;
    @BindView(R.id.ll_teacher_student)
    LinearLayout llTeacherStudent;
    @BindView(R.id.scroll_view_login)
    ScrollView scrollViewLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (SharedPreferencesManger.loadBoolean(getActivity(), REMEMBER_ME)) {
            Intent intent = new Intent(getActivity(), AuthActivity.class);
            getActivity().startActivity(intent);
        }
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        TinyDB tinyDB = new TinyDB(getActivity());
        if (tinyDB.getBoolean(REMEMBER_ME)) {
            Intent intent = new Intent(getActivity(), AuthActivity.class);
            startActivity(intent);
        }
        txPasswordLoginLayout.setBoxBackgroundMode ( TextInputLayout.BOX_BACKGROUND_OUTLINE );
        txPasswordLoginLayout.setBoxStrokeColor ( getActivity ().getResources ().getColor ( R.color.white ) );

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @OnClick({R.id.tv_forget_password, R.id.btn_login, R.id.fab_register_login, R.id.btn_teacher, R.id.btn_student})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_forget_password:
                makeforeget();
                break;
            case R.id.btn_login:
                makeLogin(txPhoneLogin.getText().toString(), txPasswordLogin.getText().toString(), chRememberMe.isChecked());
                break;
            case R.id.fab_register_login:
                makeFabRegistraion();
                break;
            case R.id.btn_teacher:
                btn_teacher();
                break;
            case R.id.btn_student:
                btn_student();
                break;
        }
    }

    public void makeLogin(String phone, String password, boolean checked) {
        if (HelperMethod.checkEmpty(txPhoneLogin) || HelperMethod.checkEmpty(txPasswordLogin)) {
            HelperMethod.showError(txLayoutPhone, HelperMethod.getStringFromXML(getActivity(), R.string.required));
            HelperMethod.showError(txPasswordLoginLayout, HelperMethod.getStringFromXML(getActivity(), R.string.required));
            YoYo.with(Techniques.Shake).duration(500).playOn(txLayoutPhone);
            YoYo.with(Techniques.Shake).duration(500).playOn(txPasswordLoginLayout);
        }  else {
            if (HelperMethod.checkPhone(phone)) {
                HelperMethod.showError(txLayoutPhone, HelperMethod.getStringFromXML(getActivity(), R.string.phone_valid));
                YoYo.with(Techniques.Shake).duration(500).playOn(txLayoutPhone);
            } else if (HelperMethod.checkPassword(password)) {
                HelperMethod.showError(txPasswordLoginLayout, HelperMethod.getStringFromXML(getActivity(), R.string.password_valid));
                YoYo.with(Techniques.Shake).duration(500).playOn(txPasswordLoginLayout);
            } else {
                HelperMethod.showError(txPasswordLoginLayout, null);
                HelperMethod.showError(txLayoutPhone, null);
                GeneralRequest.onAuth(getApiClient().login(phone, password), phone, password, checked, getActivity(), LOGIN);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void makeFabRegistraion() {

    }

    public void makeforeget() {
        YoYo.with(Techniques.Bounce).duration(500).playOn(txLayoutPhone);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void btn_teacher() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void btn_student() {
        YoYo.with(Techniques.SlideInUp).duration(500).playOn(txLayoutPhone);
    }
}
