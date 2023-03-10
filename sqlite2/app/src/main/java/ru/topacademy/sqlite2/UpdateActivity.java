package ru.topacademy.sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.topacademy.sqlite2.models.Book;
import ru.topacademy.sqlite2.utils.DBHelper;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        EditText b_id = findViewById(R.id.edit_book_id);
        EditText name2 = findViewById(R.id.edit_bookName2);
        EditText author2 = findViewById(R.id.edit_bookAuthor2);
        EditText year2 = findViewById(R.id.edit_bookYearPublic2);
        Button btn_update = findViewById(R.id.btn_bookUpdateAdd);
        Button list3 = findViewById(R.id.btn_list3);

        btn_update.setOnClickListener(view -> {
            int book_id = Integer.parseInt(b_id.getText().toString());
            String n_book = name2.getText().toString();
            String a_book = author2.getText().toString();
            int y_publ = Integer.parseInt(year2.getText().toString());
            Book book = new Book(book_id,n_book,a_book,y_publ);
            DBHelper helper = new DBHelper(this);
            helper.updateBook(book);
            b_id.setText(null);
            name2.setText(null);
            author2.setText(null);
            year2.setText(null);
            Toast toast = Toast.makeText(this, "Книга обновлена", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        });

        list3.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}