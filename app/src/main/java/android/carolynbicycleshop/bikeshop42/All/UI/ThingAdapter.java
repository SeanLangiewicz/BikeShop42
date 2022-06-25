package android.carolynbicycleshop.bikeshop42.All.UI;

import android.carolynbicycleshop.bikeshop42.All.Entities.Thing;
import android.carolynbicycleshop.bikeshop42.R;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Project: BikeShop42
 * Package: android.carolynbicycleshop.bikeshop42.All.UI
 * <p>
 * User: carolyn.sher
 * Date: 7/1/2021
 * Time: 2:19 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
public class ThingAdapter extends RecyclerView.Adapter<ThingAdapter.ThingViewHolder>{

    class ThingViewHolder extends RecyclerView.ViewHolder{
        private final TextView thingItemView;
        private final TextView thingItemView2;
        private ThingViewHolder(View itemView){
            super (itemView);
            thingItemView=itemView.findViewById(R.id.textView);
            thingItemView2=itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    final Thing current=mThings.get(position);
                    Intent intent= new Intent(context, PartsList.class);
                    intent.putExtra("id", current.getThingID());
                    intent.putExtra("name", current.getThingName());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<Thing> mThings;
    private final Context context;
    private final LayoutInflater mInflater;

    public ThingAdapter(Context context){
        mInflater=LayoutInflater.from(context);
        this.context=context;
    }
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ThingAdapter.ThingViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View itemView=mInflater.inflate(R.layout.list_item,parent,false);

        return new ThingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ThingAdapter.ThingViewHolder holder, int position) {
        if(mThings!=null){
            Thing current=mThings.get(position);
            int id=current.getThingID();
            holder.thingItemView.setText(current.getThingName());
            holder.thingItemView2.setText(Integer.toString(current.getThingID()));
        }
        else{
            holder.thingItemView.setText("No Thing Name");
            holder.thingItemView.setText("No Thing ID");
        }
    }
    public void setThings(List<Thing> things){
        mThings=things;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mThings.size();
    }
}
