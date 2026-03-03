package com.example.sum2Nums_65134318;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

        EditText editSo1 = findViewById(R.id.edit_number1);
        EditText editSo2 = findViewById(R.id.edit_number2);
        Button btnTinhTong = findViewById(R.id.button_calculate);
        TextView txtKetQua = findViewById(R.id.text_result);

        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // String input
                String str1 = editSo1.getText().toString();
                String str2 = editSo2.getText().toString();

                if (!str1.isEmpty() && !str2.isEmpty()) {
                    try {
                        // Real number convert
                        double n1 = Double.parseDouble(str1);
                        double n2 = Double.parseDouble(str2);
                        double tong = n1 + n2;

                        // Display
                        txtKetQua.setText("Kết quả: " + tong);
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    txtKetQua.setText("Lỗi: Hãy nhập đủ 2 số!");
                }
            }
        });
    }
}