package ru.skalinroman.quizforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    private ImageView image_1;
    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            image_1.startAnimation(a_2);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub
        }
    };
    private Animation a_1, a_2;
    // Системная кнопка "Назад" - начало

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    Animation.AnimationListener animationFadeOutListener = new Animation.AnimationListener() {

        @Override
        public void onAnimationEnd(Animation animation) {
            image_1.startAnimation(a_1);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_1 = (ImageView) findViewById(R.id.main_name_game);

        // Подключаем анимацию - начало
        a_1 = AnimationUtils.loadAnimation(this, R.anim.myalpha_1);
        a_2 = AnimationUtils.loadAnimation(this, R.anim.myalpha_2);
        a_1.setAnimationListener(animationFadeInListener);
        a_2.setAnimationListener(animationFadeOutListener);
        // Подключаем анимацию - конец

        image_1.startAnimation(a_1);

        Button buttonStart = (Button) findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onPause() {
        super.onPause();
        image_1.clearAnimation();
    }
    // Системначя кнопка "Назад" - конец
}