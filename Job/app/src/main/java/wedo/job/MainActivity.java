package wedo.job;

import android.support.annotation.IdRes;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;
import wedo.job.fragment.first.FragmentOne;
import wedo.job.fragment.second.FragmentTwo;
import wedo.job.fragment.third.FragmentThree;
import wedo.job.ui.BaseMainFragment;


public class MainActivity extends SupportActivity implements BaseMainFragment.OnBackToFirstListener{
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;

    private BottomBar bottomBar;
    private int prePosition;
    private SupportFragment[] mFragments = new SupportFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar= (BottomBar) findViewById(R.id.bottomBar);
        if(savedInstanceState == null) {
            mFragments[FIRST] = FragmentOne.newInstance();
            mFragments[SECOND] = FragmentTwo.newInstance();
            mFragments[THIRD] = FragmentThree.newInstance();

            loadMultipleRootFragment(R.id.contentContainer,FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD]);
        }else {
            mFragments[FIRST] = findFragment(FragmentOne.class);
            mFragments[SECOND] = findFragment(FragmentTwo.class);
            mFragments[THIRD] = findFragment(FragmentThree.class);
        }
        initBottomBar();
    }

    @Override
    public void onBackToFirstFragment() {
        bottomBar.selectTabAtPosition(0);
    }
    private void initBottomBar() {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_recents:
                        showHideFragment(mFragments[0], mFragments[prePosition]);
                        prePosition = 0;
                        invalidateOptionsMenu();
                        break;
                    case R.id.tab_favorites:
                        showHideFragment(mFragments[1], mFragments[prePosition]);
                        prePosition = 1;
                        invalidateOptionsMenu();
                        break;
                    case R.id.tab_me:
                        showHideFragment(mFragments[2], mFragments[prePosition]);
                        prePosition = 2;
                        invalidateOptionsMenu();
                        break;
                }
            }
        });
    }
}
