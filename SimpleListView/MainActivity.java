import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String list[]={"Coding Club","Evan","Emily","George","Brad","Robert","Alissa","James","Annie","Smith"};
        //Array to store names to be displayed in the list view
        ListAdapter listitems=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        //List Adapter to wrap the text to display in list view
        ListView listView=findViewById(R.id.list);//Find list view in activity_main.xml with ID list
        listView.setAdapter(listitems);//Setting the adapter
    }
}