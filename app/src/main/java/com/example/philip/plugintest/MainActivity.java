package com.example.philip.plugintest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;
import com.flaviofaria.kenburnsview.TransitionGenerator;

public class MainActivity extends AppCompatActivity {
    private int[] pic = {R.drawable.domopipe, R.drawable.domocloseup};
    private int index = 0;
    private KenBurnsView kenBurnsView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kenBurnsView = (KenBurnsView) findViewById(R.id.image);
//        TransitionGenerator generator = new TransitionGenerator() {
//            @Override
//            public Transition generateNextTransition(RectF drawableBounds, RectF viewport) {
//                RectF source = new RectF(), dest = new RectF();
////                int dH = (int) (drawableBounds.height() - bitmap.getHeight());
////                int dW = (int) (drawableBounds.width() - bitmap.getWidth());
////                if (viewport.width() == drawableBounds.width() - dW){
//                    source.set(0.0f, 0.0f, drawableBounds.right, viewport.bottom);
//                    dest.set(0.0f, bitmap.getHeight()-viewport.height(), drawableBounds.right, bitmap.getHeight());
////                } else if(viewport.height() == drawableBounds.height() - dH) {
////                    source.set(0.0f, 0.0f, drawableBounds.right, viewport.bottom);
////                    dest.set(bitmap.getWidth()-viewport.width(), 0.0f, bitmap.getWidth(), drawableBounds.bottom);
////                } else {
////                    source = drawableBounds;
////                    dest = drawableBounds;
////                }
//                return new Transition(source, dest, 3000, new LinearInterpolator());
//            }
//        };
        kenBurnsView.pause();
//        kenBurnsView.setTransitionGenerator(generator);
        kenBurnsView.setTransitionListener(new KenBurnsView.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                kenBurnsView.pause();
            }
        });
    }

    public void cyclePhoto(View view) {
//        changePhoto();
    }

    private void changePhoto(){
        if (index >= pic.length){
            index = 0;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        bitmap = BitmapFactory.decodeResource(this.getResources(), pic[index], options);
        kenBurnsView.setImageBitmap(bitmap);
        index++;
    }
}
