package ru.topacademy.sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.topacademy.sqlite2.models.Book;
import ru.topacademy.sqlite2.utils.DBHelper;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EditText name = findViewById(R.id.edit_bookName);
        EditText author = findViewById(R.id.edit_bookAuthor);
        EditText year = findViewById(R.id.edit_bookYearPublic);
        Button add = findViewById(R.id.btn_bookAdd);
        Button list2 = findViewById(R.id.btn_list2);

        add.setOnClickListener(view -> {
            String n_book = name.getText().toString();
            String a_book = author.getText().toString();
            int y_publ = Integer.parseInt(year.getText().toString());
            DBHelper helper = new DBHelper(this);
            helper.addBook(new Book(n_book, a_book, y_publ));
            name.setText(null);
            author.setText(null);
            year.setText(null);
            Toast toast = Toast.makeText(this, "Книга добавлена", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        });

        list2.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}