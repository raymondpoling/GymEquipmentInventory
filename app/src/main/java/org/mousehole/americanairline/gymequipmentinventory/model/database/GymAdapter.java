package org.mousehole.americanairline.gymequipmentinventory.model.database;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.mousehole.americanairline.gymequipmentinventory.R;
import org.mousehole.americanairline.gymequipmentinventory.model.GymEquipment;
import org.mousehole.americanairline.gymequipmentinventory.view.DetailActivity;

import java.util.List;

public class GymAdapter extends BaseAdapter {


    private final List<GymEquipment> gymEquipmentList;
    private final StartDelegate start;

    public interface StartDelegate {
        void showDetails(GymEquipment gymEquipment);
    }

    public GymAdapter(List<GymEquipment> gymEquipmentList, StartDelegate start) {
        Log.e("TAG_X", "gym adapter constructor");
        this.gymEquipmentList = gymEquipmentList;
        this.start = start;
    }

    @Override
    public int getCount() {
        int count = gymEquipmentList.size();
        Log.e("TAG_X", "Count " + count);
        return count;
    }

    @Override
    public Object getItem(int i) {
        return gymEquipmentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return gymEquipmentList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        GymEquipment gymEquipment = gymEquipmentList.get(i);

        View mainView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gym_line_item_layout,
                        viewGroup,
                        false);


        ImageView equipmentImage = mainView.findViewById(R.id.equipment_imageview);
        TextView name = mainView.findViewById(R.id.name_textview);
        TextView quantityPerUnit = mainView.findViewById(R.id.quantity_and_per_unit_price_textview);
        TextView perUnitTotalPrice = mainView.findViewById(R.id.per_unit_total_price_textview);

        Glide.with(mainView.getContext()).load(gymEquipment.getUrl()).into(equipmentImage);
        name.setText(gymEquipment.getName());
        quantityPerUnit.setText(mainView.getResources().getString(R.string.x_at_y,gymEquipment.getQuantity(), gymEquipment.getPrice()));
        perUnitTotalPrice.setText(mainView.getResources().getString(R.string.totalCost, gymEquipment.getPrice() * gymEquipment.getQuantity()));

        mainView.setOnClickListener(view1 -> {
            start.showDetails(gymEquipment);
        });

        return mainView;
    }
}
