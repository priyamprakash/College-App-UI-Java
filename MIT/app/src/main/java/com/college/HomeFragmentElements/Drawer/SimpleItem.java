package com.college.HomeFragmentElements.Drawer;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.college.R;

public class SimpleItem extends DrawerItem<SimpleItem.ViewHolder> {


    private int selectedItemIconTint;
    private  int selectedItemTextTint;
    private int normalItemIconTint;
    private  int normalItemTextTint;

    private Drawable icon;
    private String title;

    public SimpleItem(Drawable icon, String title){
        this.icon = icon;
        this.title = title;
    }
     @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_option , parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {
        holder.title.setText(title);
        holder.icon.setImageDrawable(icon);

//      holder.title.setText(isChecked ? selectedItemTextTint : normalItemTextTint);
        holder.icon.setColorFilter(isChecked ? selectedItemIconTint : normalItemIconTint);

    }

    public  SimpleItem withSelectedIconTint(int selectedItemIconTint){
        this.selectedItemIconTint = selectedItemIconTint;
        return  this;
    }

    public  SimpleItem withSelectedTextTint(int selectedItemTextTint){
        this.selectedItemTextTint = selectedItemTextTint;
        return  this;
    }
      public  SimpleItem withNormalIconTint(int normalItemIconTint){
        this.normalItemIconTint = normalItemIconTint;
        return  this;
    }

    public  SimpleItem withNormalTextTint(int normalItemTextTint){
        this.normalItemTextTint = normalItemTextTint;
        return  this;
    }

//------------------------------------------------------
    static  class  ViewHolder extends  Drawer_Adapter.ViewHolder{

        private ImageView icon;
        private TextView  title;

        public  ViewHolder(View itemView){
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);

        }
    }
}
