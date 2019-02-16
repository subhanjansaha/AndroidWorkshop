import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	//This is the activity lifecycle method that is called when the activity is instantiated 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		//this line decides what the screen is going to look like and defines the layout accoring to activity_main.xml
        setContentView(R.layout.activity_main);
		//this is the data that we want to display as a list on the screen as a ListView
        String list[]={"Coding Club","Evan","Emily","George","Brad","Robert","Alissa","James","Annie","Smith"};
        //List Adapter to wrap the text to display in list view
        ListAdapter listitems=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        ListView listView=findViewById(R.id.list);//Find list view in activity_main.xml with ID list
		//This allows the data to be presented in the form of a list on the screen. 
		//We didn't manually have to set the words on the screen one by one because ListView is an Android component that takes care of all the details
		//So I can just focus on the data that is to be displayed. This is a classic example of abstraction.
        listView.setAdapter(listitems); //Setting the adapter
    }
}