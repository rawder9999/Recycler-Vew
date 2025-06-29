package com.example.recyclervew;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    private List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        foodList = new ArrayList<>();

        // Thêm dữ liệu món ăn
        foodList.add(new Food("Phở", R.drawable.pho));
        foodList.add(new Food("Bún chả", R.drawable.buncha));
        foodList.add(new Food("Bánh mì", R.drawable.banhmi));
        foodList.add(new Food("Cơm tấm", R.drawable.comtam));
        foodList.add(new Food("Gỏi cuốn", R.drawable.goicuon));

        foodAdapter = new FoodAdapter(foodList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(foodAdapter);

        // Vuốt để xóa
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        foodAdapter.removeItem(viewHolder.getAdapterPosition());
                    }
                });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
