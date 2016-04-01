package practicaltest01var08.eim.systems.cs.pub.ro.practicaltest01var08;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    private Button navigateButton, topLeftButton, topRightButton, centerButton, bottomLeftButton, bottomRightButton;
    private TextView command;

    private int numberOfTries = 1;
    private int numberOfSuccess = 2;
    private int numberOfFailure = 3;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String oldText = "";
            String newText = "";

            switch (view.getId()) {
                case R.id.navigate_button:
                    numberOfTries++;
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08ASecondaryActivity.class);
                    intent.putExtra("command", command.getText().toString());
                    intent.putExtra("numberOfSuccess", numberOfSuccess);
                    intent.putExtra("numberOfFailure", numberOfFailure);
                    startActivityForResult(intent, RESULT_OK);
                    break;
                case R.id.top_left_button:
                    oldText = command.getText().toString();
                    newText = topLeftButton.getText().toString();
                    command.setText(oldText + ", " + newText);
                    break;
                case R.id.top_right_button:
                    oldText = command.getText().toString();
                    newText = topRightButton.getText().toString();
                    command.setText(oldText + ", " + newText);
                    break;
                case R.id.center_button:
                    oldText = command.getText().toString();
                    newText = centerButton.getText().toString();
                    command.setText(oldText + ", " + newText);
                    break;
                case R.id.bottom_left_button:
                    oldText = command.getText().toString();
                    newText = bottomLeftButton.getText().toString();
                    command.setText(oldText + ", " + newText);
                    break;
                case R.id.bottom_right_button:
                    oldText = command.getText().toString();
                    newText = bottomRightButton.getText().toString();
                    command.setText(oldText + ", " + newText);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(getApplicationContext(), "Values are (tries, success, failure): " + numberOfTries + " " + numberOfSuccess + " " + numberOfFailure ,Toast.LENGTH_LONG).show();

        command = (TextView)findViewById(R.id.text_view);

        navigateButton = (Button)findViewById(R.id.navigate_button);
        navigateButton.setOnClickListener(buttonClickListener);

        topLeftButton = (Button)findViewById(R.id.top_left_button);
        topLeftButton.setOnClickListener(buttonClickListener);

        topRightButton = (Button)findViewById(R.id.top_right_button);
        topRightButton.setOnClickListener(buttonClickListener);

        centerButton = (Button)findViewById(R.id.center_button);
        topRightButton.setOnClickListener(buttonClickListener);

        bottomLeftButton = (Button)findViewById(R.id.bottom_left_button);
        bottomLeftButton.setOnClickListener(buttonClickListener);

        bottomRightButton = (Button)findViewById(R.id.bottom_right_button);
        bottomRightButton.setOnClickListener(buttonClickListener);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("numberOftries", numberOfTries);
        savedInstanceState.putInt("numberOfSucces", numberOfSuccess);
        savedInstanceState.putInt("numberOfFailures", numberOfFailure);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("numberOfTries")) {
            numberOfTries = savedInstanceState.getInt("numberOfTries");
        } else {
            numberOfTries = 0;
        }
        if (savedInstanceState.containsKey("numberOfSucces")) {
           numberOfSuccess = savedInstanceState.getInt("numberOfSucces");
        } else {
            numberOfSuccess = 0;
        }
        if (savedInstanceState.containsKey("numberOfFailures")) {
            numberOfFailure = savedInstanceState.getInt("numberOfFailures");
        } else {
            numberOfFailure = 0;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        numberOfSuccess = data.getIntExtra("numberOfSuccess", -1);
        numberOfFailure = data.getIntExtra("numberOfFailure", -1);

        Toast.makeText(getApplicationContext(), "Result is (succes, failure) : " + numberOfSuccess + " " + numberOfFailure, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var08_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
