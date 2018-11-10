package com.androiddesdecero.startactivitybyresult;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.androiddesdecero.startactivitybyresult.MainActivity.MESSAGE;

public class EscribirMensajeActivity extends AppCompatActivity {

    private Button btActivity2;
    private EditText etActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escribir_mensaje);

        etActivity2 = findViewById(R.id.etActivity2);
        btActivity2 = findViewById(R.id.btActivity2);
        btActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String mensaje = etActivity2.getText().toString();
                intent.putExtra(MESSAGE, mensaje);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
