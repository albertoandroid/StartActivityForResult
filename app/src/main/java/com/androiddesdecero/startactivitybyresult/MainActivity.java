package com.androiddesdecero.startactivitybyresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button btActivity1;
    private TextView tvActivity1;
    private static final int REQUEST_CODE = 222;
    public static final String MESSAGE = "mensaje";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btActivity1 = findViewById(R.id.btActivity1);
        tvActivity1 = findViewById(R.id.tvActivity1);
        btActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), EscribirMensajeActivity.class), REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Log.d("TAG1", "result_ok");
                tvActivity1.setText(data.getStringExtra(MESSAGE));
            } else if(resultCode == RESULT_CANCELED){
                Log.d("TAG1", "result_canceled");
                tvActivity1.setText("Se ha cancelado");
            }
        }
    }
}
