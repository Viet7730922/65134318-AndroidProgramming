package ntu.viet773092.aR_Bottom_Navigation_65134318;

import android.os.Bundle;
import android.view.MenuItem;

// Sử dụng các thư viện chuẩn AndroidX thay vì thư viện Support cũ
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

// Cập nhật đường dẫn import Fragment theo package mới của bạn
import ntu.viet773092.aR_Bottom_Navigation_65134318.fragment.CartFragment;
import ntu.viet773092.aR_Bottom_Navigation_65134318.fragment.GiftsFragment;
import ntu.viet773092.aR_Bottom_Navigation_65134318.fragment.ProfileFragment;
import ntu.viet773092.aR_Bottom_Navigation_65134318.fragment.StoreFragment;
import ntu.viet773092.aR_Bottom_Navigation_65134318.helpers.BottomNavigationBehavior;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        // Khởi tạo BottomNavigationView và gắn sự kiện lắng nghe
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnItemSelectedListener(mOnItemSelectedListener);

//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
//        layoutParams.setBehavior(new BottomNavigationBehavior());

        // Tải StoreFragment làm mặc định khi mở app
        if (toolbar != null) {
            toolbar.setTitle("Shop");
        }
        loadFragment(new StoreFragment());
    }

    // Sử dụng NavigationBarView.OnItemSelectedListener chuẩn mới
    private NavigationBarView.OnItemSelectedListener mOnItemSelectedListener
            = new NavigationBarView.OnItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            int itemId = item.getItemId();

            // Dùng if-else thay vì switch-case để tránh lỗi Constant expression required
            if (itemId == R.id.navigation_shop) {
                if (toolbar != null) toolbar.setTitle("Shop");
                fragment = new StoreFragment();
                loadFragment(fragment);
                return true;
            } else if (itemId == R.id.navigation_gifts) {
                if (toolbar != null) toolbar.setTitle("My Gifts");
                fragment = new GiftsFragment();
                loadFragment(fragment);
                return true;
            } else if (itemId == R.id.navigation_cart) {
                if (toolbar != null) toolbar.setTitle("Cart");
                fragment = new CartFragment();
                loadFragment(fragment);
                return true;
            } else if (itemId == R.id.navigation_profile) {
                if (toolbar != null) toolbar.setTitle("Profile");
                fragment = new ProfileFragment();
                loadFragment(fragment);
                return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // Tải fragment vào FrameLayout chứa nó
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}