package org.mousehole.americanairline.gymequipmentinventory.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.mousehole.americanairline.gymequipmentinventory.R;
import org.mousehole.americanairline.gymequipmentinventory.model.GymEquipment;
import org.mousehole.americanairline.gymequipmentinventory.model.database.GymAdapter;
import org.mousehole.americanairline.gymequipmentinventory.model.database.GymDatabaseHelper;
import org.w3c.dom.Text;

import java.util.List;

public class GymListActivity extends AppCompatActivity implements GymAdapter.StartDelegate {

    public static final String ADD_EQUIPMENT = "add_equipment";
    private GymDatabaseHelper gymDatabaseHelper;
    private ListView gymList;
    private GymAdapter gymAdapter;
    private TextView totalTextView;
    private Button addEquipmentButton;

    public static final int REQUEST_CODE = 707;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_list);

        gymDatabaseHelper = new GymDatabaseHelper(this);

        gymList = findViewById(R.id.gym_listview);
        totalTextView = findViewById(R.id.total_textview);

        loadData();

        addEquipmentButton = findViewById(R.id.add_button);

        addEquipmentButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });

    }

    private void loadData() {
        List<GymEquipment> gymEquipmentList = gymDatabaseHelper.getAllEquipment();
        gymAdapter = new GymAdapter(gymEquipmentList, this);
        gymList.setAdapter(gymAdapter);
        totalTextView.setText(getResources().getString(R.string.totalCost, gymDatabaseHelper.getTotal()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            GymEquipment gymEquipment = data.getParcelableExtra(ADD_EQUIPMENT);
            gymDatabaseHelper.saveGymEquipment(gymEquipment);
        }
    }

    public void showDetails(GymEquipment gymEquipment) {
        Intent details = new Intent(this, DetailActivity.class);
        details.putExtra(DetailActivity.GET_DETAILS, gymEquipment);
        Log.e("click listener adapter", "Is this clicking?");
        try {
            startActivity(details);
        } catch (Exception e) {
            Log.e("INTENT ERROR", e.getMessage(), e);
        }
    }
}