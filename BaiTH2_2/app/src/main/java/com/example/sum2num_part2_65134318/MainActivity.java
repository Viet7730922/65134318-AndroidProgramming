package com.example.sum2num_part2_65134318;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }

    public void XuLyCong(View view) {
        EditText editTextNumA = findViewById(R.id.edtA);
        EditText editTextNumB = findViewById(R.id.edtB);
        EditText editTextNumKQ = findViewById(R.id.edtKQ);

        // Error Catch
        try {
            String strA = editTextNumA.getText().toString();
            String strB = editTextNumB.getText().toString();

            int num_a = Integer.parseInt(strA);
            int num_b = Integer.parseInt(strB);

            // Sum a & b
            int sum = num_a + num_b; // Tong cua 2 so Nguyen

            String strSum = String.valueOf(sum);
            // Display
            editTextNumKQ.setText(strSum);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số nguyên hợp lệ", Toast.LENGTH_SHORT).show();
            editTextNumKQ.setText("Lỗi dữ liệu");
        }
    }
}