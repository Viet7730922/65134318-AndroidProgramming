package ntu.viet773092.baiTh7_listView1_65314318;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Tạo mảng chứa các tên Tỉnh Thành Việt Nam
        ArrayList<String> dsTenTinhThanhVN;
        dsTenTinhThanhVN = new ArrayList<String>();
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành phố Hồ Chí Minh");
        dsTenTinhThanhVN.add("Đồng Nai");
        dsTenTinhThanhVN.add("Bình Thuận");
        dsTenTinhThanhVN.add("Ninh Thuận");
        dsTenTinhThanhVN.add("Khánh Hòa");
        dsTenTinhThanhVN.add("Lai Châu");
        dsTenTinhThanhVN.add("Kiên Giang");
        dsTenTinhThanhVN.add("Thành phố Cần Thơ");
        dsTenTinhThanhVN.add("Quảng Ngãi");

        // 2. Tạo Adapter
        ArrayAdapter<String> adapterTinhThanh;
        adapterTinhThanh = new ArrayAdapter<String>(this,
                                        android.R.layout.simple_list_item_1,
                                        dsTenTinhThanhVN);
        // 3. Tìm
        ListView lvTenTinhThanh = findViewById(R.id.lvDanhSachTT);
        // 4. Gắn vào ListView
        lvTenTinhThanh.setAdapter(adapterTinhThanh);

    }
}