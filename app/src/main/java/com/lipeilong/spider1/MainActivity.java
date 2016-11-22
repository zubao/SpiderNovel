package com.lipeilong.spider1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import us.codecraft.webmagic.main.QuickStarter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view   = findViewById(R.id.start);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuickStarter.start("3");
            }
        });
    }
}
