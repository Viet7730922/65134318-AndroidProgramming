package ntu.viet773092.baiTh8_TuyChinhLV_65134318;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter  {
    //
    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;

    public MonAnAdapter(Context _context,ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return dsMonAn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //View item Hien Hanh
        View viewHienHanh = view;
        //Check
        if(viewHienHanh == null) {
            viewHienHanh = layoutInflater.inflate(R.layout.item_monan,null);
        }
        //Import Data
        MonAn monAnHienTai = dsMonAn.get(i);
        //Gan len cac dieu khien

        //Tim dieu khien (Controller)
        TextView textView_TenMon = (TextView) viewHienHanh.findViewById(R.id.tvTenMonAn);
        TextView textView_DonGia = (TextView) viewHienHanh.findViewById(R.id.tvDonGia);
        TextView textView_MoTa = (TextView) viewHienHanh.findViewById(R.id.tvMoTa);
        ImageView imageView_Anh = (ImageView) viewHienHanh.findViewById(R.id.imgAnhDaiDien);

        //Set info
        textView_TenMon.setText(monAnHienTai.getTenMonAn());
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String donGiaFormatted = decimalFormat.format(monAnHienTai.getDonGia()) + " đ";
        textView_DonGia.setText(donGiaFormatted);
        textView_MoTa.setText(monAnHienTai.getMoTa());
        imageView_Anh.setImageResource(monAnHienTai.getIdAnhMinhHoa());

        return viewHienHanh;
    }
}
