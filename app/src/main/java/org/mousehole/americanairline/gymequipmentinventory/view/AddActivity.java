package org.mousehole.americanairline.gymequipmentinventory.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import org.mousehole.americanairline.gymequipmentinventory.R;
import org.mousehole.americanairline.gymequipmentinventory.model.GymEquipment;
import org.mousehole.americanairline.gymequipmentinventory.model.database.GymDatabaseHelper;

public class AddActivity extends AppCompatActivity {

    private EditText nameEditText, quantityEditText, priceEditText, urlEditText, descriptionEditText;
    private Button saveButton;

    GymDatabaseHelper gymDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        gymDatabaseHelper = new GymDatabaseHelper(this);

        Log.e("onCreate", "Creating");

        // bindings
        saveButton = findViewById(R.id.save_button);
        nameEditText = findViewById(R.id.name_edittext);
        urlEditText = findViewById(R.id.url_edittext);
        quantityEditText = findViewById(R.id.quantity_edittext);
        priceEditText = findViewById(R.id.price_edittext);
        descriptionEditText = findViewById(R.id.description_edittext);

        saveButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String url = urlEditText.getText().toString();
            int quantity = Integer.parseInt(quantityEditText.getText().toString());
            Double price = Double.parseDouble(priceEditText.getText().toString());
            String description = descriptionEditText.getText().toString();

            GymEquipment gymEquipment = new GymEquipment(name,quantity,price,description,url);

            Intent result = new Intent();
            result.putExtra(GymListActivity.ADD_EQUIPMENT, gymEquipment);

            setResult(RESULT_OK, result);

            finish();
        });
    }
}