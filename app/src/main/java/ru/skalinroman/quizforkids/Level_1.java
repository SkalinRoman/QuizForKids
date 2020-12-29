package ru.skalinroman.quizforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level_1 extends AppCompatActivity {

    Dialog dialog;

    public int numberLeft; // Переменная для левой картинки + текст
    public int numberRight; // Переменная для правой картинки + текст
    public int count = 0; // Счетчик правильных ответов
    Array array = new Array(); // Создали новый объект класса Array
    Random random = new Random(); // Для генерации случайных чисел

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        // Создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);  // Установили текст

        final ImageView img_left = (ImageView) findViewById(R.id.amg_left);
        img_left.setClipToOutline(true);   // Код, который скругляет углы левой картинки

        final ImageView img_right = (ImageView) findViewById(R.id.amg_right);
        img_right.setClipToOutline(true);   // Код, который скругляет углы правой картинки

        // Путь к левой TextView
        final TextView text_left = findViewById(R.id.text_left);
        // Путь к правой TextView
        final TextView text_right = findViewById(R.id.text_right);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Вызов диалогового окна в начале игры
        dialog = new Dialog(this);  // Создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // Скрываем заголовок
        dialog.setContentView(R.layout.preview_dialog); // Путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // Прозрачный фон диалогового окна
        dialog.setCancelable(false); // Окно нельзя закрыть системной кнопкой назад

        // Кнопка которая закрывает диалоговое окно - начало
        TextView button_close = (TextView) dialog.findViewById(R.id.button_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обрабатываем нажатие кнопки - начало
                try {
                    // Вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(Level_1.this, GameLevels.class); // Создаем намерение для перехода
                    startActivity(intent); // Старт намерения
                    finish(); // Закрываем этот класс
                    // Вернуться назад к выбору уровня - конец
                } catch (Exception e) {
                }
                dialog.dismiss(); // Закрываем диалоговое окно
                // Обрабатываем нажатие кнопки - конец
            }
        });
        // Кнопка которая закрывает диалоговое окно - конец

        // Кнопка "Продолжить - начало
        Button button_continue = (Button) dialog.findViewById(R.id.button_continue);
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // Закрываем диалоговое окно
            }
        });
        // Кнопка "Продолжить - конец

        dialog.show(); // Показать диалоговое окно

        // Кнопка "Назад" - начало
        Button button_back = (Button) findViewById(R.id.but_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обрабатываем нажатие кнопка "Назад" - начало
                try {
                    Intent intent = new Intent(Level_1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                // Обрабатываем нажатие кнопка "Назад" - конец
            }
        });
        // Кнопка "Назад" - конец

        // Подключаем анимацию - начало
        final Animation a = AnimationUtils.loadAnimation(Level_1.this, R.anim.alpha);
        // Подключаем анимацию - конец

        numberLeft = random.nextInt(10); // Генерируем случайное число от 0 до 9
        img_left.setImageResource(array.images1[numberLeft]); // Достаем из массива картинку
        text_left.setText(array.texts1[numberLeft]); // Достаем из массива текст

        numberRight = random.nextInt(10); // Генерируем случайное число от 0 до 9
        // Цикл с предусловием, проверяющий равенство чисел - начало
        while (numberLeft == numberRight) {
            numberRight = random.nextInt(10);
        }
        // Цикл с предусловием, проверяющий равенство чисел - конец

        img_right.setImageResource(array.images1[numberRight]); // Достаем из массива картинку
        text_right.setText(array.texts1[numberRight]); // Достаем из массива текст
    }

    // Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level_1.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }
    // Системная кнопка "Назад" - конец
}