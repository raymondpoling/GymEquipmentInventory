package org.mousehole.americanairline.gymequipmentinventory.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mousehole.americanairline.gymequipmentinventory.R;
import org.mousehole.americanairline.gymequipmentinventory.model.GymEquipment;
import org.mousehole.americanairline.gymequipmentinventory.model.database.GymAdapter;
import org.mousehole.americanairline.gymequipmentinventory.model.database.GymDatabaseHelper;
import org.w3c.dom.Text;

import java.util.List;

public class GymListActivity extends AppCompatActivity implements GymAdapter.GymEquipmentDelegate {

    private GymDatabaseHelper gymDatabaseHelper;
    private ListView gymList;
    private GymAdapter gymAdapter;
    private TextView totalTextView;
    private Button addEquipmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_list);

        gymDatabaseHelper = new GymDatabaseHelper(this);

        List<GymEquipment> gymEquipmentList = gymDatabaseHelper.getAllEquipment();

        gymAdapter = new GymAdapter(gymEquipmentList, this);
        gymList = findViewById(R.id.gym_listview);
        totalTextView = findViewById(R.id.total_textview);

        totalTextView.setText(getResources().getString(R.string.totalCost, gymDatabaseHelper.getTotal()));

        addEquipmentButton = findViewById(R.id.add_button);

        addEquipmentButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
        });

        gymList.setAdapter(gymAdapter);

    }

    @Override
    public void selectEquipment(GymEquipment gymEquipment) {
        // nop
    }
}