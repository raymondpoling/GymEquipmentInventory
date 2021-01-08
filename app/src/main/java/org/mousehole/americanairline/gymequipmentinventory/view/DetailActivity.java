package org.mousehole.americanairline.gymequipmentinventory.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.mousehole.americanairline.gymequipmentinventory.R;
import org.mousehole.americanairline.gymequipmentinventory.model.GymEquipment;

public class DetailActivity extends AppCompatActivity {

    public static final String GET_DETAILS = "get_details";
    ImageView equipmentImage;

    TextView nameTextView,quantityPerUnitTextView, perUnitTotalPriceTextView, descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        Log.e("START CHECK", "Did this start?");

        //binding
        equipmentImage = findViewById(R.id.equipment_imageview);
        nameTextView = findViewById(R.id.name_textview);
        quantityPerUnitTextView = findViewById(R.id.quantity_and_per_unit_price_textview);
        perUnitTotalPriceTextView = findViewById(R.id.per_unit_total_price_textview);
        descriptionTextView = findViewById(R.id.description);
        View view = findViewById(R.id.detail_view);

        Intent intent = getIntent();
        if (intent != null) {
            GymEquipment gymEquipment = intent.getParcelableExtra(GET_DETAILS);

            Glide.with(this).load(gymEquipment.getUrl()).into(equipmentImage);
            nameTextView.setText(gymEquipment.getName());
            quantityPerUnitTextView.setText(getResources().getString(R.string.x_at_y, gymEquipment.getQuantity(), gymEquipment.getPrice()));
            perUnitTotalPriceTextView.setText(getResources().getString(R.string.totalCost, gymEquipment.getPrice() * gymEquipment.getQuantity()));
            descriptionTextView.setText(gymEquipment.getDescription());

            view.setOnClickListener(v -> {
                finish();
            });
        }
    }
}