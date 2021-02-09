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
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    public int main_name; // Переменная для заставки
    Array array = new Array(); // Создали новый объект класса Array
    Random random = new Random(); // Для генерации случайных чисел
    private ImageView image;
    private Animation a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.main_name_game);

        // Подключаем анимацию - начало
        a = AnimationUtils.loadAnimation(this, R.anim.myalpha_1);
        // Подключаем анимацию - конец

        main_name = random.nextInt(3); // Генерируем случайное число
        image.setImageResource(array.main_name_view[main_name]); // Достаем из массива картинку

        image.startAnimation(a);

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
    // Системначя кнопка "Назад" - конец
}