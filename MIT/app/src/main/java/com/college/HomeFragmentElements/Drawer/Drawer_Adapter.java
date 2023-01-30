package com.college.HomeFragmentElements.Drawer;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drawer_Adapter extends RecyclerView.Adapter<Drawer_Adapter.ViewHolder> {

    private List<DrawerItem> items;
    private Map<Class<? extends DrawerItem>, Integer> viewTypes;

    private SparseArray<DrawerItem> holderFactories;

    private OnItemSelectedListener listener;

    public Drawer_Adapter(List<DrawerItem> items) {
        this.items = items;
        this.viewTypes = new HashMap<>();
        this.holderFactories = new SparseArray<>();
        processViewTypes();
    }

    private void processViewTypes() {
        int type = 0;
        for (DrawerItem item : items) {
            if (!viewTypes.containsKey(item.getClass())) {
                viewTypes.put(item.getClass(), type);
                holderFactories.put(type, item);
                type++;
            }
        }
    }

    @NonNull
    @Override
    public Drawer_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder = holderFactories.get(viewType).createViewHolder(parent);
        holder.drawer_adapter = this;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        items.get(position).bindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypes.get(items.get(position).getClass());
    }
//------------------

    public void setSelected(int position) {

        DrawerItem newChecked = items.get(position);
        if (!newChecked.isSelectable()) {
            return;
        }

        for (int i = 0; i <= items.size(); i++) {
            DrawerItem item = items.get(i);
            if (item.isChecked()) {
                item.setChecked(false);
                notifyItemChanged(i);
                break;
            }
        }
        newChecked.setChecked(true);
        notifyItemChanged(position);

        if (listener != null) {
            listener.onItemSelected(position);
        }

    }

    public void setListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }



    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }

//-----------------------------------------------------
    static abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Drawer_Adapter drawer_adapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

        }

        public void onClick(View v) {
            drawer_adapter.setSelected(getAdapterPosition());
        }
    }


}
