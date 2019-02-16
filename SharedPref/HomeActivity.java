import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView textView ;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails",this.MODE_PRIVATE);
        String email= sharedPreferences.getString("Email",null);
        textView = findViewById(R.id.textview);
        logout = findViewById(R.id.logout);
        if(email!=null)
        textView.setText("WELCOME "+email);
        else
            textView.setText("WELCOME " + getIntent().getExtras().getString("Email"));

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             SharedPreferences.Editor editor =   sharedPreferences.edit();
             editor.clear();
             editor.commit();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
    }
}