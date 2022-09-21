package com.example.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.ims.ImsMmTelManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvItem;
    ArrayList<Item> itemArrayList;
    ItemAdapter adapter;
    int viTri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem = (ListView) findViewById(R.id.listViewIItem);
        itemArrayList = new ArrayList<>();

        itemArrayList.add(new Item(R.drawable.mon1,"Món 1","Thông tin chi tiết của món ăn","8$"));
        itemArrayList.add(new Item(R.drawable.mon2,"Món 2","Thông tin chi tiết của món ăn","8$"));
        itemArrayList.add(new Item(R.drawable.mon3,"Món 3","Thông tin chi tiết của món ăn","8$"));
        itemArrayList.add(new Item(R.drawable.mon4,"Món 4","Thông tin chi tiết của món ăn","8$"));
        itemArrayList.add(new Item(R.drawable.mon5,"Món 5","Thông tin chi tiết của món ăn","8$"));
        itemArrayList.add(new Item(R.drawable.mon6,"Món 6","Thông tin chi tiết của món ăn","8$"));

        adapter = new ItemAdapter(this,R.layout.item, itemArrayList);
        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, detail4.class);
                startActivity(intent);
                viTri = i;
            }
        });

        lvItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Xóa Item?");
                alertDialog.setMessage("Bạn chắc chắn muốn xóa?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        itemArrayList.remove(viTri);
                        adapter.notifyDataSetChanged();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
                return false;
            }
        });
    }
}