package com.example.webuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MagasinAdapter extends BaseAdapter {

    private Data datas;
    private ArrayList<Magasin> magasins;
    Context Magasin_activity;
    View itemView;

    public MagasinAdapter(ArrayList<Magasin> magasins, Context Magasin_activity) {
        this.magasins = magasins;
        this.Magasin_activity = Magasin_activity;
    }

    @Override
    public int getCount() {
        return magasins.size();
    }

    @Override
    public Object getItem(int arg0) {
        return magasins.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)    Magasin_activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.content_magasin, null);
        }
/*

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(planetes.get(position));

        //  installer l'adaptateur pour la liste déroulante (spinner)
        datas = new Data();
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(MainActivity, android.R.layout.simple_spinner_item, datas.getPlanetesSize());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout parent = (LinearLayout) checkBox.getParent().getParent().getParent();
                ListView listView = parent.findViewById(R.id.listView);
                Button button = parent.findViewById(R.id.verifier_btn);
                if (checkBox.isChecked()) {
                    boolean isEnabled = true;
                    for (int i = 0; i < planetes.size(); i++) {
                        View item = listView.getChildAt(i);
                        CheckBox checkBox = item.findViewById(R.id.checkbox);
                        if (!checkBox.isChecked()) isEnabled = false;
                    }
                    if (isEnabled) button.setEnabled(true);
                } else button.setEnabled(false);
            }
        });*/

        return itemView;
    }
}
