package com.example.week3weekendhwapi.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week3weekendhwapi.R;
import com.example.week3weekendhwapi.Repository;

import java.util.ArrayList;

public class RepoRVAdapter extends RecyclerView.Adapter<RepoRVAdapter.ViewHolder> {

    public static final String TAG = "TAG_AnimalRVAdapter";
    private ArrayList<Repository> repositories;

    //Set up the constructor
    public RepoRVAdapter(ArrayList<Repository> repos){
        this.repositories = repos;
    }
    @NonNull
    @Override
    public RepoRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedItem  = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.repo_item_layout, parent, false);
        return new ViewHolder(inflatedItem);
    }
    @Override
    public void onBindViewHolder(@NonNull RepoRVAdapter.ViewHolder holder, int position) {
        Repository currentRepo = repositories.get(position);
        holder.populateValues(currentRepo);
    }
    @Override
    public int getItemCount() {
        return repositories.size();
    }
    //fix this shit up boy
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView repoTitle;
        TextView repoLang;
        TextView repoSize;
        TextView repoDate;
        Repository repoItem;

        public ViewHolder(View itemView){
            super(itemView);

            repoTitle = itemView.findViewById(R.id.tvRepoTitle);
            repoLang = itemView.findViewById(R.id.tvRepoLanguage);
            repoSize = itemView.findViewById(R.id.repoSize);
            repoDate = itemView.findViewById(R.id.tvRepoDate);

            //Bind using the the ItemView instead of directly
            //itemText = itemView.findViewById(R.id.animalListItem);
            itemView.setOnClickListener(this);
        }
        public void setRepoItem(Repository repoItem) {
            this.repoItem = repoItem;
        }

        public void populateValues(Repository repository){
            //Set everything
            repoTitle.setText(repository.getName());
            repoLang.setText(repository.getLanguage());
            repoSize.setText("Size of Repo: " +repository.getSize());
            repoDate.setText(repository.getCreatedAt().substring(0,10));
            setRepoItem(repository);
        }
        @Override
        public void onClick(View view){
//            Intent detailsIntent = new Intent(view.getContext(), DetailsActivity.class);
//            Bundle bundle = new Bundle();
//            bundle.putParcelable("car", itemCar);
//            detailsIntent.putExtras(bundle);
//
//            view.getContext().startActivity(detailsIntent);
        }
    }
}
