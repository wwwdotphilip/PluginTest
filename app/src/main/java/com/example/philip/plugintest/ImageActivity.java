package com.example.philip.plugintest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends AppCompatActivity {

    Bitmap bitmap;

    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.domopipe, options);
        image.setImageBitmap(bitmap);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            getDetails();
        }
    }

    private void getDetails(){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Drawable drawable = image.getDrawable();

                Matrix m = new Matrix();
                m.set(image.getImageMatrix());
                float[] values = new float[9];
                m.getValues(values);
                float bitmapWidth = values[Matrix.MSCALE_X]*drawable.getIntrinsicWidth(); //your bitmap's width
                float bitmapHeight = values[Matrix.MSCALE_Y]*drawable.getIntrinsicHeight(); //your the bitmap's height

                Log.e("Resolution", "Width: " + image.getWidth() + "\nHeight: " + image.getHeight() + "\nBitmap width: " +
                        bitmapWidth + "\nBitmap Height: " + bitmapHeight);
            }
        }, 4000);
    }
}
