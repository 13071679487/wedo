package wedo.job.fragment.third.child;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import me.yokeyword.fragmentation.SupportActivity;
import wedo.job.R;


public class EditActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initData();
    }

    public void initData() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add
                (R.id.container, FragmentEdit.newInstance());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressedSupport() {
        this.finish();
        super.onBackPressedSupport();
    }
}
