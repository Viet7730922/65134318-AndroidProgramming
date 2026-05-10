package ntu.viet773092.bonusViecCanLam4_65134318;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ThemTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_task);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lay du lieu
                EditText editTextName = findViewById(R.id.editTextTenCV);
                EditText editTextMessage = findViewById(R.id.editTextMessage);
                EditText editTextPriority = findViewById(R.id.editTextPriority);
                EditText editTextDate = findViewById(R.id.editTextDate);

                String tenCV = editTextName.getText().toString();
                String mess  = editTextMessage.getText().toString();
                String dat   = editTextDate.getText().toString();
                String pri   = editTextPriority.getText().toString();
                // Gan doi tuong TASK
                TASKS task = new TASKS(tenCV, dat, mess, pri);
                // Ket noi DB, va them
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("TASKS");

                String key = databaseReference.push().getKey();

                HashMap<String, Object> item = new HashMap<String, Object>();
                item.put(key, task.toFirebaseObject());

                databaseReference.updateChildren(item, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if(error == null) finish();
                    }
                });
            }
        });
    }
}