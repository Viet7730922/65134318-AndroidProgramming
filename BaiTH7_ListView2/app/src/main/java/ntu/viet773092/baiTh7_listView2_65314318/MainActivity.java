package ntu.viet773092.baiTh7_listView2_65314318;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Tạo mảng chứa các tên Tỉnh Thành Việt Nam
        ArrayList<String> dsTenTinhThanhVN = new ArrayList<>(Arrays.asList(
                "Hà Nội", "Thành phố Hồ Chí Minh", "Hải Phòng", "Đà Nẵng", "Cần Thơ", "Huế",
                "An Giang", "Bắc Ninh", "Cà Mau", "Cao Bằng", "Đắk Lắk", "Điện Biên",
                "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Tĩnh", "Hưng Yên", "Khánh Hòa",
                "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng", "Nghệ An", "Ninh Bình",
                "Phú Thọ", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sơn La", "Tây Ninh",
                "Thanh Hóa", "Thái Nguyên", "Tuyên Quang", "Vĩnh Long"
        ));
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