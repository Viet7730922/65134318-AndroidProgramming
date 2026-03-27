package ntu.viet773092.th9_recylcerV_65134318;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //1
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerViewLandScape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //3
        recyclerViewDatas = getDataForRecyclerView();
        //4
        recyclerViewLandScape = findViewById(R.id.recyclerLand);
        //5
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layoutLinear);
        //6
        landScapeAdapter = new LandScapeAdapter(this, recyclerViewDatas);
        //7
        recyclerViewLandScape.setAdapter(landScapeAdapter);
    }

    //2
    ArrayList<LandScape> getDataForRecyclerView() {
        ArrayList<LandScape> listData = new ArrayList<LandScape>();
        listData.add( new LandScape("hanoi_flag_tower","Cột cờ Hà Nội"));
        listData.add( new LandScape("eiffel_tower","Tháp Eiffel"));
        listData.add( new LandScape("buckingham_palace","Cung điện Buckingham"));
        listData.add( new LandScape("liberty_statue","Tượng Nữ Thần Tự Do"));

        return listData;
    }
}