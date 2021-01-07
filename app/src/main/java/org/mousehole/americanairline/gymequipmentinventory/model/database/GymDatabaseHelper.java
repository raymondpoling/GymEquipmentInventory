package org.mousehole.americanairline.gymequipmentinventory.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.mousehole.americanairline.gymequipmentinventory.model.GymEquipment;

import java.util.ArrayList;
import java.util.List;

public class GymDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "gym_db";
    public static final String TABLE_NAME = "equipment_table";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_DESCRIPTION = "description";

    public static int DATABASE_VERSION = 1;

    public GymDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = String.format(
                "CREATE TABLE %s ( " +
                        "%s INT PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT, " +
                        "%s INT, " +
                        "%s TEXT, " +
                        "%s TEXT)",
                COLUMN_ID,
                COLUMN_NAME,
                COLUMN_QUANTITY,
                COLUMN_PRICE,
                COLUMN_DESCRIPTION);
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
        DATABASE_VERSION = i1;
    }

    public List<GymEquipment> getAllEquipment() {
        String getAllQuery = "SELECT * FROM " + TABLE_NAME;

        List<GymEquipment> gymEquipments = new ArrayList<>();

        Cursor cursor = getReadableDatabase().rawQuery(getAllQuery, null);
        cursor.move(-1);
        while(cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            int quantity = cursor.getInt(cursor.getColumnIndex(COLUMN_QUANTITY));
            double price = Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
            String description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));

            GymEquipment gymEquipment = new GymEquipment(name, quantity, price,description, id);

            gymEquipments.add(gymEquipment);
        }
        return gymEquipments;
    }

    void insertGymEquipment(GymEquipment gymEquipment) {
        ContentValues content = new ContentValues();
        content.put(COLUMN_NAME, gymEquipment.getName());
        content.put(COLUMN_QUANTITY, gymEquipment.getQuantity());
        content.put(COLUMN_PRICE, Double.toString(gymEquipment.getPrice()));
        content.put(COLUMN_DESCRIPTION, gymEquipment.getDescription());

        getWritableDatabase().insert(TABLE_NAME,null, content);
    }

    void deleteGymEquipment(GymEquipment gymEquipment) {
        getWritableDatabase().delete(TABLE_NAME, "id = ?", new String[]{gymEquipment.getId()+""});
    }
}
