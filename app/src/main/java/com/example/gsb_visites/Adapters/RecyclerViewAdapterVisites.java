package com.example.gsb_visites.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gsb_visites.Praticien;
import com.example.gsb_visites.R;
import com.example.gsb_visites.Visite;

import java.util.List;

public class RecyclerViewAdapterVisites extends RecyclerView.Adapter<RecyclerViewAdapterVisites.RecyclerViewHolder> {
    private List<Visite> dataModelList;
    private String _token;
    public RecyclerViewAdapterVisites(List<Visite> dataModelList)
    {
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_visites, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.tvlistDate.setText(SetDateFormat(String.valueOf(dataModelList.get(position).getDateVisite())));
        holder.tvlistCommentaire.setText(String.valueOf(dataModelList.get(position).getCommentaire()));

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public String SetDateFormat(String dateString){
        String result = "";
        switch (dateString.substring(0,3)){
            case "Mon" :
                result += "Lundi";
                break;
            case "Tue" :
                result += "Mardi";
                break;
            case "Wed" :
                result += "Mercredi";
                break;
            case "Thu" :
                result += "Jeudi";
                break;
            case "Fri" :
                result += "Vendredi";
                break;
            case "Sat" :
                result += "Samedi";
                break;
            case "Sun" :
                result += "Dimanche";
                break;
        }
        result += " "+dateString.substring(8,10)+" ";
        switch (dateString.substring(4,7)){
            case "Jan" :
                result += "Janvier";
                break;
            case "Feb" :
                result += "Février";
                break;
            case "Mar" :
                result += "Mars";
                break;
            case "Apr" :
                result += "Avril";
                break;
            case "May" :
                result += "Mai";
                break;
            case "Jun" :
                result += "Juin";
                break;
            case "Jul" :
                result += "Juillet";
                break;
            case "Aug" :
                result += "Août";
                break;
            case "Sep" :
                result += "Septembre";
                break;
            case "Oct" :
                result += "Octobre";
                break;
            case "Nov" :
                result += "Novembre";
                break;
            case "Dec" :
                result += "Décembre";
                break;
        }
        result += " "+dateString.substring(23);
        result += " "+dateString.substring(10,19);
        return result;
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvlistDate;
        TextView tvlistCommentaire;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvlistDate = itemView.findViewById(R.id.tvDate);
            tvlistCommentaire = itemView.findViewById(R.id.tvCommentaire);

        }


    }
}