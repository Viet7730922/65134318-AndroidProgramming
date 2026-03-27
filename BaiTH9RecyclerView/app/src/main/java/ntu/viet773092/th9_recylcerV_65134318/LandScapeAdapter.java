package ntu.viet773092.th9_recylcerV_65134318;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandViewHolder> {
    Context context;
    ArrayList<LandScape> datas;
    public LandScapeAdapter(Context _context, ArrayList<LandScape> _datas) {
        this.context = _context;
        this.datas = _datas;
    }

    @NonNull
    @Override
    public ItemLandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewItem = layoutInflater.inflate(R.layout.item_land,parent,false);
        ItemLandViewHolder viewHolderCreated = new ItemLandViewHolder(viewItem);
        return viewHolderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandViewHolder holder, int position) {
        // Lay doi tuong hien thi
        LandScape landScapeDisplay = datas.get(position);
        // Trich thong tin
        String caption = landScapeDisplay.getLandCaption();
        String imgName = landScapeDisplay.getLandImageFileName();
        //
        holder.tvCaption.setText(caption);
        String packageName = holder.itemView.getContext().getPackageName();
        int imgID = holder.itemView.getResources().getIdentifier(imgName, "mipmap", packageName);
        holder.imageViewLand.setImageResource(imgID) ;


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static final class ItemLandViewHolder extends RecyclerView.ViewHolder {
        TextView tvCaption;
        ImageView imageViewLand;
        public ItemLandViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCaption);
            imageViewLand = itemView.findViewById(R.id.imageViewLand);
        }
    }
}
