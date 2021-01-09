package ru.skalinroman.quizforkids;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        // Кнопка для перехода на 1 уровень - начало
        TextView textView1 = (TextView) findViewById(R.id.textView_1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level_1.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 1 уровень - конец

        // Кнопка для перехода на 2 уровень - начало
        TextView textView2 = (TextView) findViewById(R.id.textView_2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level_2.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 2 уровень - конец

        // Кнопка для перехода на 3 уровень - начало
        TextView textView3 = (TextView) findViewById(R.id.textView_3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level_3.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 3 уровень - конец

        // Кнопка для перехода на 4 уровень - начало
        TextView textView4 = (TextView) findViewById(R.id.textView_4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level_4.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 4 уровень - конец
    }

    // Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }
    // Системная кнопка "Назад" - конец
}