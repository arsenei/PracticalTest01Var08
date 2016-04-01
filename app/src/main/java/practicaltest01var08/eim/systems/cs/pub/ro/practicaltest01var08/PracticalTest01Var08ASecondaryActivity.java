package practicaltest01var08.eim.systems.cs.pub.ro.practicaltest01var08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var08ASecondaryActivity extends AppCompatActivity {

    private Button verifyButton, cancelButton;
    private TextView command;

    private int numberOfSuccess = 0;
    private int numberOfFailure = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            Intent intent = getIntent();

            switch (view.getId()) {
                case R.id.verify_button:
                    if (intent != null && intent.getExtras().containsKey("numberOfSuccess")) {
                        numberOfSuccess = intent.getExtras().getInt("numberOfSuccess");
                        numberOfSuccess++;
                    }
                    intent.putExtra("numberOfSucsess", numberOfSuccess);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                    break;
                case R.id.cancel_button:
                    if (intent != null && intent.getExtras().containsKey("numberOfFailure")) {
                        numberOfFailure = intent.getExtras().getInt("numberOfFailure");
                        numberOfFailure++;
                    }
                    intent.putExtra("numberOfFailure", numberOfFailure);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_asecondary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        command = (TextView)findViewById(R.id.text_view2);

        Intent intent = getIntent();

        if (intent != null && intent.getExtras().containsKey("command")) {
            command.setText(intent.getExtras().getString("command"));
        }

        verifyButton = (Button)findViewById(R.id.verify_button);
        verifyButton.setOnClickListener(buttonClickListener);

        cancelButton = (Button)findViewById(R.id.bottom_right_button);
        cancelButton.setOnClickListener(buttonClickListener);

    }

}
