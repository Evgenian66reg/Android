package ru.topacademy.sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.topacademy.sqlite2.models.Book;
import ru.topacademy.sqlite2.utils.DBHelper;

public class GetByIdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_by_id);

        EditText editText = findViewById(R.id.edit_text);
        Button btn_get = findViewById(R.id.btn_getById);
        Button btn_list = findViewById(R.id.btn_list);
        TextView text_one_book = findViewById(R.id.textView_get);

        btn_get.setOnClickListener(view -> {
            int id = Integer.parseInt(editText.getText().toString());
            DBHelper helper = new DBHelper(this);
            helper.getById(id);
            editText.setText(null);
            text_one_book.setText(helper.getById(id).showBook());
        });

        btn_list.setOnClickListener(view -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }
}