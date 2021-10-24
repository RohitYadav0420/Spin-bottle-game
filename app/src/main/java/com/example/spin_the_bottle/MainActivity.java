package com.example.spin_the_bottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bottle;
    int lastDir;
    Random random= new Random();
    boolean IsSpinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle= findViewById(R.id.bottle);

        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!IsSpinning)
                {
                    int newDir= random.nextInt(3600);
                    float pivotX= bottle.getWidth()/2;
                    float pivotY= bottle.getHeight()/2;

                    Animation rotate= new RotateAnimation(lastDir, newDir, pivotX, pivotY);
                    rotate.setDuration(3500);
                    rotate.setFillAfter(true);


                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            IsSpinning=true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            IsSpinning=false;

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }

                    });

                    lastDir= newDir;
                    bottle.startAnimation(rotate);

                }
            }
        });
    }
}