package bd.com.expresshub.infonetassesment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import bd.com.expresshub.infonetassesment.room.UserRoomDatabase;

public class InfoListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private List<UserModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);

        recyclerView = findViewById(R.id.recyclerId);
    }

    private void getData() {

        list = new ArrayList<>();
        list = UserRoomDatabase.getDatabase(getApplicationContext()).userDao().getAll();
        recyclerView.setAdapter(new InfoListAdapter(getApplicationContext(), list));
    }
}