package com.algamil.thetester.views.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.algamil.thetester.R;
import com.algamil.thetester.helper.GeneralRequest;
import com.algamil.thetester.helper.HelperMethod;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.algamil.thetester.data.api.ApiClient.getApiClient;
import static com.algamil.thetester.helper.Constant.LOGIN;

public class QuestionTypeFragment extends Fragment {


    @BindView(R.id.tool_paste)
    TextView toolPaste;
    @BindView(R.id.tool_edit)
    TextView toolEdit;
    @BindView(R.id.tool_choose_or_not)
    TextView toolChooseOrNot;
    @BindView(R.id.tool_delete)
    TextView toolDelete;
    @BindView(R.id.tool_copy)
    TextView toolCopy;
    @BindView(R.id.fab_copy)
    FloatingActionButton fabCopy;
    @BindView(R.id.fab_delete)
    FloatingActionButton fabDelete;
    @BindView(R.id.fab_more_up)
    FloatingActionButton fabMoreUp;
    @BindView(R.id.fab_paste)
    FloatingActionButton fabPaste;
    @BindView(R.id.fab_edit)
    FloatingActionButton fabEdit;
    @BindView(R.id.fab_add_to_favourite)
    FloatingActionButton fabAddToFavourite;
    @BindView(R.id.fab_more_down)
    FloatingActionButton fabMoreDown;
    @BindView(R.id.fab_choose_or_not)
    FloatingActionButton fabChooseOrNot;
    final int pix1 = -150, pix2 = -300, pix3 = -450, delay = 200;
    final float scale1 = 0.8f, scale2 = 0f;

    int pos = 1;

    @BindView(R.id.fab_add_photo)
    FloatingActionButton fabAddPhoto;
    @BindView(R.id.tool_add_photo)
    TextView toolAddPhoto;
    @BindView(R.id.btn_add_question)
    Button btnAddQuestion;

    public QuestionTypeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questions_type, container, false);
        ButterKnife.bind(this, view);
        intialize();
        return view;
    }


    public void intialize()
    {
        toolChooseOrNot.animate().scaleX(0).scaleY(0).translationY(pix1).start();
        toolCopy.animate().scaleX(0).scaleY(0).translationY(-pix1).start();
        toolDelete.animate().scaleX(0).scaleY(0).translationY(-pix2).start();
        toolAddPhoto.animate().scaleX(0).scaleY(0).translationY(-pix3).start();
        toolEdit.animate().scaleX(0).scaleY(0).translationY(pix2).start();
        toolPaste.animate().scaleX(0).scaleY(0).translationY(pix3).start();
    }

    @OnClick(R.id.btn_add_question)
    public void onViewClicked() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void more_down() {
        fabChooseOrNot.animate().translationY(pix1).start();
        fabEdit.animate().translationY(pix2).start();
        fabPaste.animate().translationY(pix3).start();
        toolChooseOrNot.animate().scaleX(scale1).scaleY(scale1).setStartDelay(delay).start();
        toolPaste.animate().scaleX(scale1).scaleY(scale1).setStartDelay(delay).start();
        toolEdit.animate().scaleX(scale1).scaleY(scale1).setStartDelay(delay).start();
        fabMoreDown.setImageResource(HelperMethod.getImageRecourceFromXML(R.drawable.wronganswer));
        fabMoreDown.setTooltipText(HelperMethod.getStringFromXML(getActivity(), R.string.close_menus));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void more_up() {
        fabDelete.animate().translationY(-pix1).start();
        fabCopy.animate().translationY(-pix2).start();
        fabAddPhoto.animate().translationY(-pix3).start();
        toolDelete.animate().scaleX(scale1).scaleY(scale1).setStartDelay(delay).start();
        toolCopy.animate().scaleX(scale1).scaleY(scale1).setStartDelay(delay).start();
        toolAddPhoto.animate().scaleX(scale1).scaleY(scale1).setStartDelay(delay).start();
        fabMoreUp.setImageResource(HelperMethod.getImageRecourceFromXML(R.drawable.wronganswer));
        fabMoreUp.setTooltipText(HelperMethod.getStringFromXML(getActivity(), R.string.close_menus));
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    @OnClick({R.id.fab_copy, R.id.fab_delete, R.id.fab_more_up, R.id.fab_paste, R.id.fab_edit, R.id.fab_add_to_favourite, R.id.fab_more_down, R.id.fab_choose_or_not})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_copy:
                break;
            case R.id.fab_delete:
                break;
            case R.id.fab_more_up:
                if (fabMoreUp.getTooltipText().equals(HelperMethod.getStringFromXML(getActivity(), R.string.close_menus))) {
                    makeCloseMenuUp();
                } else {
                    more_up();
                }
                break;
            case R.id.fab_paste:
                break;
            case R.id.fab_edit:
                break;
            case R.id.fab_add_to_favourite:
                break;
            case R.id.fab_more_down:
                if (fabMoreDown.getTooltipText().equals(HelperMethod.getStringFromXML(getActivity(), R.string.close_menus))) {
                    makeCloseMenuDown();
                } else {
                    more_down();
                }
                break;
            case R.id.fab_choose_or_not:
//                YoYo.with(Techniques.FadeOutDown).playOn();
                break;
        }
    }

    public void hello()
    {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeCloseMenuUp() {
        toolDelete.animate().scaleX(0).scaleY(0).setStartDelay(delay).start();
        toolCopy.animate().scaleX(0).scaleY(0).setStartDelay(delay).start();
        toolAddPhoto.animate().scaleX(0).scaleY(0).setStartDelay(delay).start();
        fabDelete.animate().translationY(0).start();
        fabCopy.animate().translationY(0).start();
        fabAddPhoto.animate().translationY(0).start();
        fabMoreUp.setImageResource(HelperMethod.getImageRecourceFromXML(R.drawable.more));
        fabMoreUp.setTooltipText(HelperMethod.getStringFromXML(getActivity(), R.string.more));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeCloseMenuDown() {
        toolPaste.animate().scaleX(0).scaleY(0).setStartDelay(delay).start();
        toolEdit.animate().scaleX(0).scaleY(0).setStartDelay(delay).start();
        toolChooseOrNot.animate().scaleX(0).scaleY(0).setStartDelay(delay).start();
        fabPaste.animate().translationY(0).start();
        fabEdit.animate().translationY(0).start();
        fabChooseOrNot.animate().translationY(0).start();
        fabMoreDown.setImageResource(HelperMethod.getImageRecourceFromXML(R.drawable.more));
        fabMoreDown.setTooltipText(HelperMethod.getStringFromXML(getActivity(), R.string.more));
    }

    @OnClick(R.id.fab_add_photo)
    public void onClick() {
        makeUpload();
    }

    private void makeUpload() {
    }
}
