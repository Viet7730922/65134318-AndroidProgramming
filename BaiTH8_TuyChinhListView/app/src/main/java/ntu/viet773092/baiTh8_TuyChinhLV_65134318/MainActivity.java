package ntu.viet773092.baiTh8_TuyChinhLV_65134318;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Tim listView
        ListView lvDSMonAn = (ListView) findViewById(R.id.lvDSMonAn);

        //Chuan bi du lieu
        ArrayList<MonAn> dsMonAn = new ArrayList<>();
        dsMonAn.add(new MonAn("Cơm tấm sườn", 25000, "Cơm tấm thơm ngon kèm miếng sườn nướng đậm đà, hấp dẫn.", R.drawable.comsuontam));
        dsMonAn.add(new MonAn("Cơm sườn trứng", 27000, "Cơm tấm kết hợp sườn nướng và trứng chiên vàng ươm, bổ dưỡng.", R.drawable.comsuontrung));
        dsMonAn.add(new MonAn("Gà xối mỡ", 30000, "Đùi gà được chế biến theo công thức đặc biệt, giòn rụm bên ngoài và mềm mịn bên trong.", R.drawable.comgaxoimo));
        dsMonAn.add(new MonAn("Sườn bì chả", 32000, "Combo cơm tấm đầy đủ với sườn nướng, bì giòn và chả lụa truyền thống.", R.drawable.comsuonbicha));
        dsMonAn.add(new MonAn("Đặc biệt", 35000, "Set cơm tấm cao cấp với đầy đủ sườn, gà, chả, bì và các món phụ đi kèm.", R.drawable.comtam_dacbiet));
        //Gan Adapter
        MonAnAdapter adapter = new MonAnAdapter(this,dsMonAn);
        lvDSMonAn.setAdapter(adapter);

        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long k) {
                MonAn monAnDaChon = dsMonAn.get(i);
                Toast.makeText(MainActivity.this,monAnDaChon.getTenMonAn(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}