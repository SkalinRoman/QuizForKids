package ru.skalinroman.quizforkids;

import android.content.Intent;
import android.content.SharedPreferences;
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

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

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
                    if (level >= 1) {
                        Intent intent = new Intent(GameLevels.this, Level_1.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // пусто
                    }
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
                    if (level >= 2) {
                        Intent intent = new Intent(GameLevels.this, Level_2.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // пусто
                    }
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
                    if (level >= 3) {
                        Intent intent = new Intent(GameLevels.this, Level_3.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // пусто
                    }
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
                    if (level >= 4) {
                        Intent intent = new Intent(GameLevels.this, Level_4.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // пусто
                    }
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 4 уровень - конец

        // Кнопка для перехода на 5 уровень - начало
        TextView textView5 = (TextView) findViewById(R.id.textView_5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 5) {
                        Intent intent = new Intent(GameLevels.this, Level_5.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // пусто
                    }
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 5 уровень - конец

        // Кнопка для перехода на 6 уровень - начало
        TextView textView6 = (TextView) findViewById(R.id.textView_6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 6) {
                        Intent intent = new Intent(GameLevels.this, Level_6.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // пусто
                    }
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 6 уровень - конец

        // Кнопка для перехода на 7 уровень - начало
        TextView textView7 = (TextView) findViewById(R.id.textView_7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 7) {
                        Intent intent = new Intent(GameLevels.this, Level_7.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // пусто
                    }
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 7 уровень - конец

        // Кнопка для перехода на 8 уровень - начало
        TextView textView8 = (TextView) findViewById(R.id.textView_8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 8) {
                        Intent intent = new Intent(GameLevels.this, Level_8.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // пусто
                    }
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 8 уровень - конец

        // Кнопка для перехода на 9 уровень - начало
        TextView textView9 = (TextView) findViewById(R.id.textView_9);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 9) {
                        Intent intent = new Intent(GameLevels.this, Level_9.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // пусто
                    }
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 9 уровень - конец

        // Кнопка для перехода на 10 уровень - начало
        TextView textView10 = (TextView) findViewById(R.id.textView_10);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 10) {
                        Intent intent = new Intent(GameLevels.this, Level_10.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // пусто
                    }
                } catch (Exception e) {
                }
            }
        });
        // Кнопка для перехода на 10 уровень - конец

        final int[] x = {
                R.id.textView_1,
                R.id.textView_2,
                R.id.textView_3,
                R.id.textView_4,
                R.id.textView_5,
                R.id.textView_6,
                R.id.textView_7,
                R.id.textView_8,
                R.id.textView_9,
                R.id.textView_10
        };

        for (int i = 1; i < level; i++) {
            TextView tv = findViewById(x[i]);
            tv.setText("" + (i + 1));
        }
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