package com.imtiaj.rush;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EditProfileAdapter extends ArrayAdapter<CustomItem> {
    public EditProfileAdapter(@NonNull Context context, @NonNull List<CustomItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.editprofile_spinner,parent,false);
        }
        CustomItem item = getItem(position);
        if(item!=null){
            TextView spinnerText = convertView.findViewById(R.id.spinnerText);
            spinnerText.setText(item.getDropdownzone());
        }
        return convertView;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mainactivity_dropdown_item,parent,false);
        }
        CustomItem item = getItem(position);
        if(item!=null){
            TextView spinnerText = convertView.findViewById(R.id.spinner_text);
            spinnerText.setText(item.getDropdownzone());
        }
        return convertView;
    }
}
