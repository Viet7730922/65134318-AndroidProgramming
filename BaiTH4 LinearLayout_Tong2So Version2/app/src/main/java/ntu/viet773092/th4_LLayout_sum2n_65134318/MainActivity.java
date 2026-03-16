package ntu.viet773092.th4_LLayout_sum2n_65134318;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Khai bao cac doi tuong dieu khien
    EditText editTextNum1, editTextNum2, editTextResult;
    Button btnCong, btnTru, btnNhan, btnChia;

    void TimDieuKien() {
        editTextNum1 = (EditText) findViewById(R.id.edtNum1);
        editTextNum2 = (EditText) findViewById(R.id.edtNum2);
        editTextResult = (EditText) findViewById(R.id.edtResult);
        btnCong = (Button) findViewById(R.id.btnPlus);
        btnTru = (Button) findViewById(R.id.btnMinus);
        btnNhan = (Button) findViewById(R.id.btnMulti);
        btnChia = (Button) findViewById(R.id.btnDivide);
    }

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
        TimDieuKien();
    }

    public void XuLyCong(View v) {
        try {
            String strA = editTextNum1.getText().toString();
            String strB = editTextNum2.getText().toString();

            float num_a = Float.parseFloat(strA);
            float num_b = Float.parseFloat(strB);

            // Sum a & b
            float sum = num_a + num_b; // Tong cua 2 so Nguyen

            String strSum = String.valueOf(sum);
            // Display
            editTextResult.setText(strSum);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số nguyên hợp lệ", Toast.LENGTH_SHORT).show();
            editTextResult.setText("Lỗi dữ liệu");
        }
    }

    public void XuLyTru(View v) {
        try {
            String strA = editTextNum1.getText().toString();
            String strB = editTextNum2.getText().toString();

            float num_a = Float.parseFloat(strA);
            float num_b = Float.parseFloat(strB);

            // Sub a & b
            float sub = num_a - num_b; // Tong cua 2 so Nguyen

            String strSub = String.valueOf(sub);
            // Display
            editTextResult.setText(strSub);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số nguyên hợp lệ", Toast.LENGTH_SHORT).show();
            editTextResult.setText("Lỗi dữ liệu");
        }
    }

    public void XuLyNhan(View v) {
        try {
            String strA = editTextNum1.getText().toString();
            String strB = editTextNum2.getText().toString();

            float num_a = Float.parseFloat(strA);
            float num_b = Float.parseFloat(strB);

            // Multiple a & b
            float multipe = num_a * num_b; // Tong cua 2 so Nguyen

            String strMulti = String.valueOf(multipe);
            // Display
            editTextResult.setText(strMulti);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số nguyên hợp lệ", Toast.LENGTH_SHORT).show();
            editTextResult.setText("Lỗi dữ liệu");
        }
    }

    public void XuLyChia(View v) {
        try {
            String strA = editTextNum1.getText().toString();
            String strB = editTextNum2.getText().toString();

            float num_a = Float.parseFloat(strA);
            float num_b = Float.parseFloat(strB);
            // Case num_b = 0
            if (num_b == 0) {
                Toast.makeText(this,"Không thể thực hiện phép chia cho 0!",Toast.LENGTH_LONG).show();
                editTextResult.setText("Lỗi vì số chia bằng 0.");
                return;
            }
            // Divide a & b
            float divide = num_a / num_b; // Tong cua 2 so Nguyen

            String strDiv = String.valueOf(divide);
            // Display
            editTextResult.setText(strDiv);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số nguyên hợp lệ", Toast.LENGTH_SHORT).show();
            editTextResult.setText("Lỗi dữ liệu");
        }
    }
}