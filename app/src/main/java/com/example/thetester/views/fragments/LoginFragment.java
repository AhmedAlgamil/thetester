package com.example.thetester.views.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.thetester.R;
import com.example.thetester.data.local.SharedPreferencesManger;
import com.example.thetester.data.local.TinyDB;
import com.example.thetester.helper.GeneralRequest;
import com.example.thetester.helper.HelperMethod;
import com.example.thetester.views.activities.AuthActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.thetester.data.api.ApiClient.getApiClient;
import static com.example.thetester.data.local.SharedPreferencesManger.REMEMBER_ME;
import static com.example.thetester.helper.Constant.LOGIN;

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
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_teacher)
    AppCompatButton btnTeacher;
    @BindView(R.id.btn_student)
    AppCompatButton btnStudent;
    @BindView(R.id.tx_password_login_layout)
    TextInputLayout txPasswordLoginLayout;

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
        if (HelperMethod.checkEmpty(phone) || HelperMethod.checkEmpty(password)) {
            HelperMethod.showError(txLayoutPhone, HelperMethod.getStringFromXML(getActivity(), R.string.required));
        }
        else if(HelperMethod.checkEmpty(password))
        {
            HelperMethod.showError(txPasswordLoginLayout, HelperMethod.getStringFromXML(getActivity(), R.string.required));
        }
        else {
            if (HelperMethod.checkPhone(phone)) {
                HelperMethod.showError(txLayoutPhone, HelperMethod.getStringFromXML(getActivity(), R.string.phone_valid));
            } else if (HelperMethod.checkPassword(password)) {
                HelperMethod.showError(txPasswordLoginLayout, HelperMethod.getStringFromXML(getActivity(), R.string.password_valid));
            } else {
                HelperMethod.showError(txPasswordLoginLayout, null);
                HelperMethod.showError(txLayoutPhone, null);
                GeneralRequest.onAuth(getApiClient().login(phone, password), phone, password, checked, getActivity(), LOGIN);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void makeFabRegistraion() {
        if(fabRegisterLogin.getTooltipText().toString() == HelperMethod.getStringFromXML(getActivity(),R.string.student_register))
        {
            HelperMethod.showToast(getActivity(),"student");
        }
        else if(fabRegisterLogin.getTooltipText().toString() == HelperMethod.getStringFromXML(getActivity(),R.string.teacher_register))
        {
            HelperMethod.showToast(getActivity(),"teacher");
            HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.frame_container, new SignUpFragment());
        }

    }

    public void makeforeget() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void btn_teacher() {
        txLayoutPhone.setHint(HelperMethod.getStringFromXML(getActivity(), R.string.phoneteacher));
        fabRegisterLogin.setImageResource(R.drawable.add_user);
        fabRegisterLogin.setTooltipText(HelperMethod.getStringFromXML(getActivity(),R.string.teacher_register));
        tvTitle.setText(HelperMethod.getStringFromXML(getActivity(),R.string.teacher));
        btnTeacher.setBackground(HelperMethod.getDrawableFromXML(getActivity(),R.drawable.pressed_shape));
        btnTeacher.setTextColor(HelperMethod.getColorFromXML(getActivity(),R.color.fab_background));
        btnStudent.setBackground(HelperMethod.getDrawableFromXML(getActivity(),R.drawable.shape));
        btnStudent.setTextColor(HelperMethod.getColorFromXML(getActivity(),R.color.white));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void btn_student() {
        txLayoutPhone.setHint(HelperMethod.getStringFromXML(getActivity(), R.string.phonestudent));
        fabRegisterLogin.setImageResource(R.drawable.add_student);
        tvTitle.setText(HelperMethod.getStringFromXML(getActivity(),R.string.student));
        fabRegisterLogin.setTooltipText(HelperMethod.getStringFromXML(getActivity(),R.string.student_register));
        btnStudent.setBackground(HelperMethod.getDrawableFromXML(getActivity(),R.drawable.pressed_shape));
        btnStudent.setTextColor(HelperMethod.getColorFromXML(getActivity(),R.color.fab_background));
        btnTeacher.setBackground(HelperMethod.getDrawableFromXML(getActivity(),R.drawable.shape));
        btnTeacher.setTextColor(HelperMethod.getColorFromXML(getActivity(),R.color.white));
    }
}
