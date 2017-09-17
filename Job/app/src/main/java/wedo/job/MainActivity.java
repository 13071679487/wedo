package wedo.job;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import wedo.job.fragment.BackHandleFragment;
import wedo.job.fragment.first.FragmentOne;
import wedo.job.fragment.second.FragmentTwo;
import wedo.job.fragment.third.FragmentThree;
import wedo.job.impl.BackHandleInterface;


public class MainActivity extends AppCompatActivity implements BackHandleInterface {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;


    private  BottomBar bottomBar;
    private Fragment[] mFragments = new Fragment[3];

    private FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction ft=fragmentManager.beginTransaction();
    private BackHandleFragment mBackHandedFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        initData();
        initBottomBar();
    }

    public void initData() {
        mFragments[FIRST] = FragmentOne.newInstance();
        mFragments[SECOND] = FragmentTwo.newInstance();
        mFragments[THIRD] = FragmentThree.newInstance();
        ft.replace(R.id.contentContainer,mFragments[FIRST]);
    }


    private void initBottomBar() {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_job:
                        FragmentTransaction ft1=fragmentManager.beginTransaction();
                        ft1.replace(R.id.contentContainer,mFragments[FIRST]);
                        ft1.commit();
                        break;
                    case R.id.tab_discovery:
                        FragmentTransaction ft2=fragmentManager.beginTransaction();
                        ft2.replace(R.id.contentContainer,mFragments[SECOND]);
                        ft2.commit();
                        break;
                    case R.id.tab_me:
                        FragmentTransaction ft3=fragmentManager.beginTransaction();
                        ft3.replace(R.id.contentContainer,mFragments[THIRD]);
                        ft3.commit();
                        break;
                }
            }
        });
    }

    public void backToFirstFragment() {
        bottomBar.selectTabAtPosition(0);
    }

    @Override
    public void setSelectedFragment(BackHandleFragment fragment) {
        this.mBackHandedFragment = fragment;
    }

    @Override
    public void onBackPressed() {
        if (mBackHandedFragment == null || !mBackHandedFragment.onBackPressed()) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                super.onBackPressed();
            } else {
                getSupportFragmentManager().popBackStack();
            }
        }
    }
}
