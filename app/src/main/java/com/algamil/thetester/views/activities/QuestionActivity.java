package com.algamil.thetester.views.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.algamil.thetester.R;
import com.algamil.thetester.adapter.SliderAdapter;
import com.algamil.thetester.helper.HelperMethod;
import com.algamil.thetester.views.fragments.QuestionTypeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuestionActivity extends AppCompatActivity {

    SliderAdapter sliderAdapter;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp_quetsion)
    ViewPager vpQuetsion;
    @BindView(R.id.fab_next)
    FloatingActionButton fabNext;
    @BindView(R.id.fab_previous)
    FloatingActionButton fabPrevious;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        ButterKnife.bind(this);
        Intialize();
    }

    public void Intialize() {
        sliderAdapter = new SliderAdapter(this.getSupportFragmentManager());
        for (int i = 1; i <= 30; i++)
        {
            sliderAdapter.addFrag(new QuestionTypeFragment(), HelperMethod.getStringFromXML(this, R.string.question_number) + i + "");
        }
        vpQuetsion.setAdapter(sliderAdapter);
        vpQuetsion.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabs.setupWithViewPager(vpQuetsion);
    }

    @OnClick({R.id.fab_next, R.id.fab_previous})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_next:
                if(pos == 29)
                {
                    Toast.makeText(this, "position" + pos, Toast.LENGTH_SHORT).show();
                    vpQuetsion.setCurrentItem(pos);
                }
                else
                {
                    Toast.makeText(this, "position" + pos, Toast.LENGTH_SHORT).show();
                    vpQuetsion.setCurrentItem(++pos);
                }
                break;
            case R.id.fab_previous:
                if(pos == 0)
                {
                    Toast.makeText(this, "position" + pos, Toast.LENGTH_SHORT).show();
                    vpQuetsion.setCurrentItem(pos);
                }
                else
                {
                    Toast.makeText(this, "position" + pos, Toast.LENGTH_SHORT).show();
                    vpQuetsion.setCurrentItem(--pos);
                }
                break;
        }
    }
}
