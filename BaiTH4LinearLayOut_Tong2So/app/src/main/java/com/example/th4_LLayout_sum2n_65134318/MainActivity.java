package com.example.th4_LLayout_sum2n_65134318;

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
    EditText edtA, edtB, edtResult; // 3 variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Radition just 1 time
        edtA = findViewById(R.id.edtNum1);
        edtB = findViewById(R.id.edtNum2);
        edtResult = findViewById(R.id.edtResult);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // XML call
    // Vì khi nhấn nút thì đã thực hiện gọi hàm không cần gọi lại "Biến của từng nút" - Đã test JavaFX
    public void XuLyCong(View v) { tinhToan('+'); }
    public void XuLyTru(View v)  { tinhToan('-'); }
    public void XuLyNhan(View v) { tinhToan('*'); }
    public void XuLyChia(View v) { tinhToan('/'); }

    // Function
    private void tinhToan(char phepTinh) {
        try {
            float a = Float.parseFloat(edtA.getText().toString());
            float b = Float.parseFloat(edtB.getText().toString());
            float result = 0;

            switch (phepTinh) {
                case '+': result = a + b; break;
                case '-': result = a - b; break;
                case '*': result = a * b; break;
                case '/':
                    if (b == 0) {
                        edtResult.setText("Lỗi: Không thể Chia cho 0"); // Hiển thị dòng text định sẵn
                        Toast.makeText(this, "Số chia phải khác 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = a / b;
                    break;
            }
            edtResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
            edtResult.setText("Lỗi dữ liệu");
        }
    }
}