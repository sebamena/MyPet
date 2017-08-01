package cl.sebastian.mypet;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent(MainActivity.this,TabsActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);


    }
}
