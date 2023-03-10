package ru.topacademy.sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.topacademy.sqlite2.models.Book;
import ru.topacademy.sqlite2.utils.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_add = findViewById(R.id.btn_add);
        Button btn_getById = findViewById(R.id.btn_getById);
        Button btn_update = findViewById(R.id.btn_update);
        Button btn_delete = findViewById(R.id.btn_delete);

        btn_add.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
        });

        btn_getById.setOnClickListener(view -> {
            Intent intent = new Intent(this, GetByIdActivity.class);
            startActivity(intent);
        });

        btn_update.setOnClickListener(view -> {
            Intent intent = new Intent(this, UpdateActivity.class);
            startActivity(intent);
        });

        btn_delete.setOnClickListener(view -> {
            Intent intent = new Intent(this, DeleteActivity.class);
            startActivity(intent);
        });

        DBHelper dbHelper = new DBHelper(this);
       /* dbHelper.addBook(new Book("Железная пята","Джек Лондон",1908));
        dbHelper.addBook(new Book("Процесс","Франц Кафка",1925));
        dbHelper.addBook(new Book("Цвет из иных миров","Говард Лавкрафт",1927));
        dbHelper.addBook(new Book("По ком звонит колокол","Эрнест Хемингуэй",1940));
        dbHelper.addBook(new Book("Час Быка","Иван Ефремов",1965));*/

        List<Book> list = dbHelper.getAll();
        List<String> listStr = new ArrayList<>();
        list.stream().forEach(item->listStr.add(item.toString()));

        ListView listView = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listStr);
        listView.setAdapter(adapter);

    }
}