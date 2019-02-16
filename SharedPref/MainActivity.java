import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEmailView;
    private EditText mPasswordView;
    private CheckBox checkBoxRememberMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmailView = findViewById(R.id.email);
        mPasswordView= findViewById(R.id.password);
        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);
        Button mEmailSignInButton =findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(checkBoxRememberMe.isChecked())
               {
                   String email = mEmailView.getText().toString();
                   String password = mPasswordView.getText().toString();
                   saveLogInDetails(email,password);

               }
                startHomeActivity();
            }
        });

        //Here we will validate saved preferences
        if (!isUserLogedOut()) {

            //user's email and password both are saved in preferences
           startHomeActivity();
        }



    }

    private boolean isUserLogedOut() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("LoginDetails", this.MODE_PRIVATE);
        boolean isEmailEmpty = sharedPreferences.getString("Email", "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("Password", "").isEmpty();
        return isEmailEmpty || isPasswordEmpty;
    }

    private void saveLogInDetails(String email, String password) {
        SharedPreferences sharedPreferences = this.getSharedPreferences("LoginDetails",this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email",email);
        editor.putString("Password",password);
        editor.commit();
    }
    private void startHomeActivity() {

        Intent intent = new Intent(this,HomeActivity.class);
        if(!checkBoxRememberMe.isChecked())
        {
            intent.putExtra("Email",mEmailView.getText().toString());
        }
        startActivity(intent);
        finish();
    }

}