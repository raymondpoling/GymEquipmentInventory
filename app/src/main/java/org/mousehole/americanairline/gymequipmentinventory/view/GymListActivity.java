package org.mousehole.americanairline.gymequipmentinventory.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.mousehole.americanairline.gymequipmentinventory.R;
import org.mousehole.americanairline.gymequipmentinventory.model.GymEquipment;
import org.mousehole.americanairline.gymequipmentinventory.model.database.GymAdapter;
import org.mousehole.americanairline.gymequipmentinventory.model.database.GymDatabaseHelper;

public class GymListActivity extends AppCompatActivity implements GymAdapter.GymEquipmentDelegate {

    private GymDatabaseHelper gymDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_list);

        gymDatabaseHelper = new GymDatabaseHelper(this);

    }

    @Override
    public void selectEquipment(GymEquipment gymEquipment) {
        // nop
    }
}