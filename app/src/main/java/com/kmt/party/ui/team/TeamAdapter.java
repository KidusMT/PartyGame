package com.kmt.party.ui.team;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
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

public class TeamAdapter extends RecyclerView.Adapter<BaseViewHolder>  {

    private List<Player> filteredCrew;
    private Context context;
    private TeamCallback mTeamCallback;

    public TeamAdapter(Context context, ArrayList<Player> crews) {
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
        filteredCrew.clear();
        filteredCrew.addAll(crews);
        notifyDataSetChanged();
    }

    public void addItem(Player crews) {
        filteredCrew.add(crews);
        notifyDataSetChanged();
    }

    public void removeItem(Player player){
        filteredCrew.remove(player);
        notifyDataSetChanged();
    }

    public void setTeamCallback(TeamCallback callback) {
        mTeamCallback = callback;
    }

    public interface TeamCallback {
        void onItemClearClicked(Player crew);
    }

    public class AssignedTasksViewHolder extends BaseViewHolder {

        @BindView(R.id.player_name)
        TextView tvPlayerName;

        @BindView(R.id.player_clear)
        ImageView ivClearPlayer;

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
                ivClearPlayer.setOnClickListener(v -> mTeamCallback.onItemClearClicked(player));
            }
        }
    }
}