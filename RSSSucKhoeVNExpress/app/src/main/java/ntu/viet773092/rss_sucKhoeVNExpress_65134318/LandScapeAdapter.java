package ntu.viet773092.rss_sucKhoeVNExpress_65134318;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide; // Thu vien tai anh tu URL

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
        View viewItem = layoutInflater.inflate(R.layout.item_land, parent, false);
        return new ItemLandViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandViewHolder holder, int position) {
        // Lay doi tuong LandScape hien tai
        LandScape landScapeDisplay = datas.get(position);

        // Trich xuat info
        String title = landScapeDisplay.getTitle();
        String summary = landScapeDisplay.getSummary();
        String imageUrl = landScapeDisplay.getImageUrl();

        // Gan du lieu vao TextView
        holder.tvTitle.setText(title);
        holder.tvSummary.setText(summary);

        // Tai hinh anh tu URL bang Glide
        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.place_holder) // Placeholder khi hình ảnh chưa tải xong
                .error(R.drawable.error_img)
                .into(holder.imageViewLand);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ItemLandViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle, tvSummary;
        ImageView imageViewLand;

        public ItemLandViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textViewTitle);
            tvSummary = itemView.findViewById(R.id.textViewSummary);
            imageViewLand = itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickPos = getAdapterPosition();
            LandScape clickedElement = datas.get(clickPos);
            String title = clickedElement.getTitle();
            String clickNotify = "Bạn vừa click vào: " + title;
            Toast.makeText(v.getContext(), clickNotify, Toast.LENGTH_SHORT).show();
        }
    }
}