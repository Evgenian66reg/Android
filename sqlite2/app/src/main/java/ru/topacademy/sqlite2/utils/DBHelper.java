package ru.topacademy.sqlite2.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ru.topacademy.sqlite2.models.Book;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyLibrary";
    private static final String TABLE_BOOKS = "Books";
    private static final String COLUMN_ID = "Id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_YEAR_PUBLICATION = "year_publication";

    private final String CREATE_BOOKS_TABLE_SCRIPT = "CREATE TABLE " + TABLE_BOOKS
            + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL, "
            + COLUMN_AUTHOR + " TEXT NOT NULL, "
            + COLUMN_YEAR_PUBLICATION + " INTEGER NOT NULL)";


    public DBHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOKS_TABLE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old_version, int new_version) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(sqLiteDatabase);
    }

    public void addBook(Book book){
        try(SQLiteDatabase sqLiteDatabase = this.getWritableDatabase()){
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME,book.getName());
            values.put(COLUMN_AUTHOR,book.getAuthor());
            values.put(COLUMN_YEAR_PUBLICATION,book.getYearPublication());
            sqLiteDatabase.insert(TABLE_BOOKS, null,values);
        }
    }

    public int updateBook(Book book){
        try{
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME,book.getName());
            values.put(COLUMN_AUTHOR,book.getAuthor());
            values.put(COLUMN_YEAR_PUBLICATION,book.getYearPublication());
            int result = sqLiteDatabase.update(TABLE_BOOKS, values,COLUMN_ID + " = ?", new String[]{String.valueOf(book.getId())});
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public void deleteBook(Book book){
        try{
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            sqLiteDatabase.delete(TABLE_BOOKS,COLUMN_ID + " = ?", new String[]{String.valueOf(book.getId())});
            sqLiteDatabase.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Book getById(int id){
        try{
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.query(TABLE_BOOKS,
                    new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_AUTHOR, COLUMN_YEAR_PUBLICATION},
                    COLUMN_ID + " = ?",
                    new String[]{String.valueOf(id)},
                    null,
                    null,
                    null);

            if (cursor != null){
                cursor.moveToFirst();
            }

            Book book = new Book(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3)
            );

            sqLiteDatabase.close();
            return book;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getAll(){
        List<Book> list = new ArrayList<>();
        try{
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_BOOKS,null);

            if (cursor != null){
                cursor.moveToFirst();
                do {
                    Book book = new Book(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getInt(3)
                    );
                    list.add(book);
                }while (cursor.moveToNext());
                sqLiteDatabase.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
