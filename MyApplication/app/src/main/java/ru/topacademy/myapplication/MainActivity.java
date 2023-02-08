package ru.topacademy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void jsClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),R.string.JavaScript,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView jsImage = new ImageView(getApplicationContext());
        jsImage.setImageResource(R.drawable.javascript_logo);
        toastContainer.addView(jsImage,0);
        toast.show();
    }

    public void javaClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),R.string.Jv,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView jImage = new ImageView(getApplicationContext());
        jImage.setImageResource(R.drawable.j_logo);
        toastContainer.addView(jImage,0);
        toast.show();
    }

    public void androidClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),R.string.Android,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView roboImage = new ImageView(getApplicationContext());
        roboImage.setImageResource(R.drawable.robot_logo);
        toastContainer.addView(roboImage,0);
        toast.show();
    }
}