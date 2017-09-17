package wedo.job.fragment.third.child;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import wedo.job.R;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        findViewById(R.id.btn_callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutActivity.this.finish();
            }
        });
    }
}
