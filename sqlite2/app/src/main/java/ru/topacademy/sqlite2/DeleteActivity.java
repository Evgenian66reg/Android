package ru.topacademy.sqlite2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.topacademy.sqlite2.models.Book;
import ru.topacademy.sqlite2.utils.DBHelper;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Button btn_delete = findViewById(R.id.btn_delete2);
        Button btn_list4 = findViewById(R.id.btn_list4);
        EditText text = findViewById(R.id.edit_text2);

        btn_delete.setOnClickListener(view -> {
            int id = Integer.parseInt(text.getText().toString());
            Book book = new Book(id);
            DBHelper helper = new DBHelper(this);
            helper.deleteBook(book);
            text.setText(null);
            Toast toast = Toast.makeText(this,"Книга удалена",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        });

        btn_list4.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });




    }

}