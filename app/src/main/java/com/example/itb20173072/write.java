package com.example.itb20173072;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;

public class write extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;

    EditText jinputMessage;
    TextView jinputCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        jinputMessage = findViewById(R.id.xinputMessage);
        jinputCount = findViewById(R.id.xinputCount);

        Button jsendButton = findViewById(R.id.xsendButton);
        jsendButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String message = jinputMessage.getText().toString();
                Toast.makeText(getApplicationContext(), "메시지 보낼 연락처\n\n" + message,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), phone.class);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });

        Button jcloseButton = findViewById(R.id.xcloseButton);
        jcloseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

        TextWatcher watcher = new TextWatcher() {
            public void onTextChanged(CharSequence str, int start, int before, int count) {
                byte[] bytes = null;
                try {
                    bytes = str.toString().getBytes("KSC5601");
                    int strCount = bytes.length;
                    jinputCount.setText(strCount + " / 80바이트");

                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            public void afterTextChanged(Editable strEditable) {
                String str = strEditable.toString();
                try {
                    byte[] strBytes = str.getBytes("KSC5601");
                    if (strBytes.length > 80) {
                        strEditable.delete(strEditable.length() - 2, strEditable.length() - 1);
                    }
                }   catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        };
        jinputMessage.addTextChangedListener(watcher);
    }
}
