package wedo.job;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.IdRes;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import wedo.job.fragment.first.FragmentOne;
import wedo.job.fragment.second.FragmentTwo;
import wedo.job.fragment.third.FragmentThree;


public class MainActivity extends AppCompatActivity {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;

    private BottomBar bottomBar;
    private int prePosition = 0;
    private Fragment[] mFragments = new Fragment[3];

    private FragmentManager fragmentManager=getFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        initData();
        initBottomBar();
    }
    public void initData(){
        mFragments[FIRST] = FragmentOne.newInstance();
        mFragments[SECOND] = FragmentTwo.newInstance();
        mFragments[THIRD] = FragmentThree.newInstance();
        fragmentManager.beginTransaction().add(R.id.contentContainer,mFragments[FIRST]).commit();
        fragmentManager.beginTransaction().add(R.id.contentContainer,mFragments[SECOND]).commit();
        fragmentManager.beginTransaction().add(R.id.contentContainer,mFragments[THIRD]).commit();
        fragmentManager.beginTransaction().show(mFragments[FIRST]).commit();
        fragmentManager.beginTransaction().hide(mFragments[SECOND]).commit();
        fragmentManager.beginTransaction().hide(mFragments[THIRD]).commit();
    }


    private void initBottomBar() {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_recents:
                        replaceFragmentToContainer(0,mFragments[FIRST]);
                        prePosition = 0;
                        break;
                    case R.id.tab_favorites:
                        replaceFragmentToContainer(1,mFragments[SECOND]);
                        prePosition = 1;
                        break;
                    case R.id.tab_me:
                        replaceFragmentToContainer(2,mFragments[THIRD]);
                        prePosition = 2;
                        break;
                }
            }
        });
    }

    public  void replaceFragmentToContainer(int pos,Fragment frag) {
        if(pos!=prePosition)
            getFragmentManager().beginTransaction().show(frag).commit();
        for(int i=0;i<mFragments.length;i++){
            if(i!=pos){
                getFragmentManager().beginTransaction().hide(mFragments[i]).commit();
            }
        }
    }

}
