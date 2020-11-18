package com.kmt.party.ui.team;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kmt.party.R;
import com.kmt.party.data.model.Player;
import com.kmt.party.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamAdapter extends RecyclerView.Adapter<BaseViewHolder> implements Filterable {

    private List<Player> crews;
    private List<Player> filteredCrew;
    private Context context;
    private PrintCallback mPrintCallback;

    public TeamAdapter(Context context, ArrayList<Player> crews) {
        this.crews = crews;
        this.context = context;
        filteredCrew = new ArrayList<>();
        filteredCrew.addAll(crews);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemEvents = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_player, viewGroup, false);
        return new AssignedTasksViewHolder(itemEvents);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        return filteredCrew == null ? 0 : filteredCrew.size();
    }

    public void addItems(List<Player> crews) {
        this.crews.clear();
        this.crews.addAll(crews);

        filteredCrew.clear();
        filteredCrew.addAll(crews);
        notifyDataSetChanged();
    }

    public void setPrintCallback(PrintCallback callback) {
        mPrintCallback = callback;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredCrew = crews;
                } else {
                    List<Player> filteredList = new ArrayList<>();
                    for (Player row : crews) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row != null && row.getName() != null)
                            if (row.getName().toLowerCase().contains(charString.toLowerCase())) {// || row.getType().toLowerCase().contains(charSequence)) {
                                filteredList.add(row);
                            }
                    }

                    filteredCrew = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredCrew;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredCrew = (List<Player>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface PrintCallback {
        void onItemPrintClicked(Player crew);
    }

    public class AssignedTasksViewHolder extends BaseViewHolder {

        @BindView(R.id.player_name)
        TextView tvPlayerName;

        Player player;

        public AssignedTasksViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        protected void clear() {
            tvPlayerName.setText("");
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            player = filteredCrew.get(position);
            if (player != null) {
                tvPlayerName.setText(player.getName());
            }
        }
    }
}