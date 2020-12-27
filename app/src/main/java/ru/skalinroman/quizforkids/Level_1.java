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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Level_1 extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        final ImageView img_left = (ImageView) findViewById(R.id.amg_left);
        img_left.setClipToOutline(true);   // Код, который скругляет углы левой картинки

        final ImageView img_right = (ImageView) findViewById(R.id.amg_right);
        img_right.setClipToOutline(true);   // Код, который скругляет углы правой картинки

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