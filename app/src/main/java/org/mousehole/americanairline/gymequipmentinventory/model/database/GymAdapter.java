package org.mousehole.americanairline.gymequipmentinventory.model.database;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.mousehole.americanairline.gymequipmentinventory.model.GymEquipment;

import java.util.List;

public class GymAdapter extends BaseAdapter {


    private final List<GymEquipment> gymEquipmentList;
    private final GymEquipmentDelegate gymEquipmentDelegate;

    public interface GymEquipmentDelegate {
        void selectEquipment(GymEquipment gymEquipment);
    }

    public GymAdapter(List<GymEquipment> gymEquipmentList, GymEquipmentDelegate gymEquipmentDelegate) {
        super();
        this.gymEquipmentList = gymEquipmentList;
        this.gymEquipmentDelegate = gymEquipmentDelegate;

    }


    @Override
    public int getCount() {
        return gymEquipmentList.size();
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

        return null;
    }
}
