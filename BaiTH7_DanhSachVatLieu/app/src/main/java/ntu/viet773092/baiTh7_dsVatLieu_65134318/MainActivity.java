package ntu.viet773092.baiTh7_dsVatLieu_65134318;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvVatLieu;
    ArrayList<String> dsVatLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Anh xa ListView tu XML
        lvVatLieu = findViewById(R.id.lvVatLieu);

        // 2. Khoi tao danh sach Vat Lieu
        dsVatLieu = new ArrayList<>();
        dsVatLieu.add("Xi măng");
        dsVatLieu.add("Gạch");
        dsVatLieu.add("Đá ốp lát");
        dsVatLieu.add("Ống nhựa");
        dsVatLieu.add("Sơn chống thấm");

        // 3. Tao Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.item_vat_lieu, // i. Tro den layout
                R.id.tvTenVatLieu,      // ii. Tro den ID
                dsVatLieu               // iii. Nguon
        );

        // 4. Gan Adapter
        lvVatLieu.setAdapter(adapter);
    }
}