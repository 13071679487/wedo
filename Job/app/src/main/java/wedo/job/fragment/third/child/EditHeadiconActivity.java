package wedo.job.fragment.third.child;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;

import java.io.File;
import java.util.ArrayList;

import wedo.job.R;
import wedo.job.activity.TakePhotoActivity;
import wedo.job.util.PreferenceUtils;

public class EditHeadiconActivity extends TakePhotoActivity {
    private ImageView head_iv;
    private Button btn_select, btn_camera;

    private TakePhoto takePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_headicon);
        initView();
        initEvent();
    }

    public void initView() {
        head_iv = (ImageView) findViewById(R.id.head_iv);
        btn_select = (Button) findViewById(R.id.btn_select);
        btn_camera = (Button) findViewById(R.id.btn_camera);
    }

    public void initEvent() {
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                configCompress(takePhoto);
                takePhoto.onPickMultipleWithCrop(1, getCropOptions());
            }
        });
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                configCompress(takePhoto);
                File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
                if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
                Uri imageUri = Uri.fromFile(file);
                takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions());
            }
        });
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        showImage(result.getImages());
    }
    public void showImage(ArrayList<TImage> imgs){
        //生成File对象
        String path=imgs.get(imgs.size() - 1).getPath();
        File image = new File(path);
        //显示头像
        Glide.with(this).load(image).into(head_iv);
        PreferenceUtils.write(getApplication(),"userConfig","headIcon",path);
        Toast.makeText(this,"保存成功----------"+path,Toast.LENGTH_SHORT).show();
    }

    public TakePhoto getTakePhoto(){
        if (takePhoto==null){
            takePhoto= (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this,this));
        }
        return takePhoto;
    }

    /**
     * 配置压缩属性
     * @param takePhoto
     */
    private void configCompress(TakePhoto takePhoto) {
        int maxSize = 102400;        //压缩后最大大小
        int maxPixel = 800;          //压缩后长宽不超过...px
        CompressConfig config = new CompressConfig.Builder().setMaxSize(maxSize).setMaxPixel(maxPixel).create();
        takePhoto.onEnableCompress(config, true);
    }

    private CropOptions getCropOptions() {
        CropOptions.Builder builder = new CropOptions.Builder();

        //设置裁剪后的长宽
        builder.setOutputX(800).setOutputY(800);
        builder.setWithOwnCrop(true);
        return builder.create();
    }
}
