package com.example.gsb_visites.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gsb_visites.Praticien;
import com.example.gsb_visites.R;

import java.util.List;

public class RecyclerViewAdapterPraticiens extends RecyclerView.Adapter<RecyclerViewAdapterPraticiens.RecyclerViewHolder> {
    private List<Praticien> dataModelList;
    private String _token;
    public RecyclerViewAdapterPraticiens(List<Praticien> dataModelList)
    {
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_praticiens, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.tvlistNom.setText(String.valueOf(dataModelList.get(position).getPra_nom()));
        holder.tvlistPrenom.setText(String.valueOf(dataModelList.get(position).getPra_prenom()));

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvlistNom;
        TextView tvlistPrenom;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvlistNom = itemView.findViewById(R.id.tvListeNom);
            tvlistPrenom = itemView.findViewById(R.id.tvListePrenom);

        }


    }
}
