package ntu.viet773092.rss_sucKhoeVNExpress_65134318;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LandScapeAdapter adapter;
    ArrayList<LandScape> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerLand);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();
        adapter = new LandScapeAdapter(this, dataList);
        recyclerView.setAdapter(adapter);

        loadRssFeed();
    }

    private void loadRssFeed() {
        new Thread(() -> {
            // 1. URL RSS feed cua VNExpress
            String rssUrl = "https://vnexpress.net/rss/suc-khoe.rss";

            // 2. Goi class GetDataFromRSS de phan tich du lieu o Background Thread
            ArrayList<LandScape> parsedList = GetDataFromRSS.parseRSS(rssUrl);

            // 3. Cập nhật giao diện trên Main Thread
            runOnUiThread(() -> {
                dataList.clear(); // Xoa du lieu cu (neu co)
                dataList.addAll(parsedList); // Them cac du lieu moi
                adapter.notifyDataSetChanged(); // Bao cho RecyclerView ve lai
            });
        }).start();
    }
}