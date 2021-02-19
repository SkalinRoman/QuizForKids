package ru.skalinroman.quizforkids;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class Level_4 extends AppCompatActivity {

    public int numberLeft; // Переменная для левой картинки + текст
    public int numberRight; // Переменная для правой картинки + текст
    public int count = 0; // Счетчик правильных ответов
    Dialog dialogEnd;
    Array array = new Array(); // Создали новый объект класса Array
    Random random = new Random(); // Для генерации случайных чисел
    public InterstitialAd interstitialAd; // реклама
    public int transition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        // реклама - начало
        MobileAds.initialize(this, "ca-app-pub-4594297867448154~6383231281");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-4594297867448154/3892799316"); // рекламный блок
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
        // реклама - конец

        // Закрытие рекламы на крестик - начало
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                try {
                    switch (transition) {
                        case 0:
                            break;
                        case 1:
                            Intent intent = new Intent(Level_4.this, Level_5.class);
                            startActivity(intent);
                            finish();
                            break;
                        case 2:
                            Intent intent1 = new Intent(Level_4.this, GameLevels.class);
                            startActivity(intent1);
                            finish();
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    // пусто
                }
            }
        });
        // Закрытие рекламы на крестик - конец

        // Создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level4);  // Установили текст

        final ImageView img_left = (ImageView) findViewById(R.id.amg_left);
        img_left.setClipToOutline(true);   // Код, который скругляет углы левой картинки

        final ImageView img_right = (ImageView) findViewById(R.id.amg_right);
        img_right.setClipToOutline(true);   // Код, который скругляет углы правой картинки

        // Путь к TextView
        final TextView text_left = findViewById(R.id.text_left);

        // Устанавливаем фон - начало
        ImageView background = (ImageView) findViewById(R.id.background);
        background.setImageResource(R.drawable.background_level_four);
        // Устанавливаем фон - конец

        // Устанавливае описание задания - начало
        TextView textDescription = (TextView) findViewById(R.id.exercise);
        textDescription.setText(R.string.level_four);
        // Устанавливае описание задания - конец

        // Вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this);  // Создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); // Скрываем заголовок
        dialogEnd.setContentView(R.layout.dialog_end); // Путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // Прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); // Окно нельзя закрыть системной кнопкой назад

        // Интересный факт - начало
        TextView textDescriptionEnd = (TextView) dialogEnd.findViewById(R.id.level_description_end);
        textDescriptionEnd.setText(R.string.level_four_end);
        // Интересный факт - конец

        // Кнопка "Продолжить" диалоговое окно - начало
        Button button_continue_2 = (Button) dialogEnd.findViewById(R.id.button_continue);
        button_continue_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isLoaded()) {
                    transition = 1;
                    interstitialAd.show(); // Показать рекламу
                } else {
                    try {
                        Intent intent = new Intent(Level_4.this, Level_5.class); // менять переход на новый уровень тут
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                    }
                    dialogEnd.dismiss(); // Закрываем диалоговое окно
                }
            }
        });
        // Кнопка "Продолжить" диалоговое окно - конец

        // Кнопка "Назад" - начало
        Button button_back = (Button) findViewById(R.id.but_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обрабатываем нажатие кнопка "Назад" - начало
                if (interstitialAd.isLoaded()) {
                    transition = 2;
                    interstitialAd.show(); // Показать рекламу
                } else {
                    try {
                        Intent intent = new Intent(Level_4.this, GameLevels.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                    }
                    // Обрабатываем нажатие кнопка "Назад" - конец
                }
            }
        });
        // Кнопка "Назад" - конец

        // Массив для прогресса игры - начало
        final int[] progress = {
                R.id.point1,
                R.id.point2,
                R.id.point3,
                R.id.point4,
                R.id.point5,
                R.id.point6,
                R.id.point7,
                R.id.point8,
                R.id.point9,
                R.id.point10,
                R.id.point11,
                R.id.point12,
                R.id.point13,
                R.id.point14,
                R.id.point15,
                R.id.point16,
                R.id.point17,
                R.id.point18,
                R.id.point19,
                R.id.point20
        };
        // Массив для прогресса игры - конец

        // Подключаем анимацию - начало
        final Animation a = AnimationUtils.loadAnimation(Level_4.this, R.anim.alpha);
        // Подключаем анимацию - конец

        numberLeft = random.nextInt(20); // Генерируем случайное число
        img_left.setImageResource(array.images4[numberLeft]); // Достаем из массива картинку

        numberRight = random.nextInt(20); // Генерируем случайное число
        // Цикл с предусловием, проверяющий равенство чисел - начало
        while (array.strong[numberLeft] == array.strong[numberRight]) {
            numberRight = random.nextInt(20);
        }
        // Цикл с предусловием, проверяющий равенство чисел - конец

        img_right.setImageResource(array.images4[numberRight]); // Достаем из массива картинку

        // Обрабатываем нажатие левой картинки - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Условие касания картинки - начало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Если коснулся картинки - начало
                    img_right.setEnabled(false); // Блокируем правую картинку
                    if (array.strong[numberLeft] > array.strong[numberRight]) {
                        img_left.setImageResource(R.drawable.img_true);
                    } else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                    // Если коснулся картинки - конец
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Если отпустил палец - начало
                    if (array.strong[numberLeft] > array.strong[numberRight]) {
                        // Если левая картинка больше
                        if (count < 20) {
                            count++;
                            TextView tv2 = findViewById(R.id.count);
                            tv2.setText(array.progressCount[count]);
                        }
                        // Закрашиваем прогресс бледно оранжевым светом - начало
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // Закрашиваем прогресс бледно оранжевым светом - конец

                        // Определяем правильные ответы и закрашиваем прогресс цветом лайм - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_lime);
                        }
                        // Определяем правильные ответы и закрашиваем прогресс цветом лайм - конец
                    } else {
                        // Если левая картинка меньше
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                                TextView tv2 = findViewById(R.id.count);
                                tv2.setText(array.progressCount[count]);
                            } else {
                                count = count - 2;
                                TextView tv2 = findViewById(R.id.count);
                                tv2.setText(array.progressCount[count]);
                            }
                        }
                        // Закрашиваем прогресс бледно оранжевым светом - начало
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // Закрашиваем прогресс бледно оранжевым светом - конец

                        // Определяем правильные ответы и закрашиваем прогресс цветом лайм - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_lime);
                        }
                        // Определяем правильные ответы и закрашиваем прогресс цветом лайм - конец
                    }
                    // Если отпустил палец - конец
                    if (count == 20) {
                        // ВЫХОД ИЗ УРОВНЯ
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);
                        if (level > 4) {
                            // пусто
                        } else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 5);
                            editor.commit();
                        }
                        dialogEnd.show();
                    } else {
                        numberLeft = random.nextInt(20); // Генерируем случайное число
                        img_left.setImageResource(array.images4[numberLeft]); // Достаем из массива картинку
                        img_left.startAnimation(a);

                        numberRight = random.nextInt(20); // Генерируем случайное число
                        // Цикл с предусловием, проверяющий равенство чисел - начало
                        while (array.strong[numberLeft] == array.strong[numberRight]) {
                            numberRight = random.nextInt(20);
                        }
                        // Цикл с предусловием, проверяющий равенство чисел - конец

                        img_right.setImageResource(array.images4[numberRight]); // Достаем из массива картинку
                        img_right.startAnimation(a);

                        img_right.setEnabled(true); // Включаем обратно правую картинку
                    }
                }
                // Условие касания картинки - конец
                return true;
            }
        });
        // Обрабатываем нажатие левой картинки - конец

        // Обрабатываем нажатие правой картинки - начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Условие касания картинки - начало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Если коснулся картинки - начало
                    img_left.setEnabled(false); // Блокируем левую картинку
                    if (array.strong[numberLeft] < array.strong[numberRight]) {
                        img_right.setImageResource(R.drawable.img_true);
                    } else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                    // Если коснулся картинки - конец
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Если отпустил палец - начало
                    if (array.strong[numberLeft] < array.strong[numberRight]) {
                        // Если правая картинка больше
                        if (count < 20) {
                            count++;
                            TextView tv2 = findViewById(R.id.count);
                            tv2.setText(array.progressCount[count]);
                        }
                        // Закрашиваем прогресс бледно оранжевым светом - начало
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // Закрашиваем прогресс бледно оранжевым светом - конец

                        // Определяем правильные ответы и закрашиваем прогресс цветом лайм - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_lime);
                        }
                        // Определяем правильные ответы и закрашиваем прогресс цветом лайм - конец
                    } else {
                        // Если правая картинка меньше
                        if (count > 0) {
                            if (count == 1) {
                                count = 0;
                                TextView tv2 = findViewById(R.id.count);
                                tv2.setText(array.progressCount[count]);
                            } else {
                                count = count - 2;
                                TextView tv2 = findViewById(R.id.count);
                                tv2.setText(array.progressCount[count]);
                            }
                        }
                        // Закрашиваем прогресс бледно оранжевым светом - начало
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // Закрашиваем прогресс бледно оранжевым светом - конец

                        // Определяем правильные ответы и закрашиваем прогресс цветом лайм - начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_lime);
                        }
                        // Определяем правильные ответы и закрашиваем прогресс цветом лайм - конец
                    }
                    // Если отпустил палец - конец
                    if (count == 20) {
                        // ВЫХОД ИЗ УРОВНЯ
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);
                        if (level > 4) {
                            // пусто
                        } else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level", 5);
                            editor.commit();
                        }
                        dialogEnd.show();
                    } else {
                        numberLeft = random.nextInt(20); // Генерируем случайное число
                        img_left.setImageResource(array.images4[numberLeft]); // Достаем из массива картинку
                        img_left.startAnimation(a);

                        numberRight = random.nextInt(20); // Генерируем случайное число
                        // Цикл с предусловием, проверяющий равенство чисел - начало
                        while (array.strong[numberLeft] == array.strong[numberRight]) {
                            numberRight = random.nextInt(20);
                        }
                        // Цикл с предусловием, проверяющий равенство чисел - конец

                        img_right.setImageResource(array.images4[numberRight]); // Достаем из массива картинку
                        img_right.startAnimation(a);

                        img_left.setEnabled(true); // Включаем обратно левую картинку
                    }
                }
                // Условие касания картинки - конец
                return true;
            }
        });
        // Обрабатываем нажатие правой картинки - конец
    }

    // Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed() {
        if (interstitialAd.isLoaded()) {
            transition = 2;
            interstitialAd.show(); // Показать рекламу
        } else {
            try {
                Intent intent = new Intent(Level_4.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
        }
    }
    // Системная кнопка "Назад" - конец
}