package com.ahmetmatematikci.sms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Button bt1, bt2, bt3,bt4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimlarr();
    }

    private void tanimlarr() {
        bt1 = (Button)findViewById(R.id.button);
        bt2 = (Button)findViewById(R.id.button2);
        bt3 = (Button)findViewById(R.id.button3);
        bt4 = (Button)findViewById(R.id.button4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case  R.id.button:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:03223243065"));
                startActivity(i);


                break;

            case  R.id.button2:
                String telNo ="05534491547";
                String msj = "Deneme mesajıdır";
                Intent msjgonder = new Intent(Intent.ACTION_VIEW);
                msjgonder.setData(Uri.parse("sms:"+telNo ));
                msjgonder.putExtra("sms_body", msj);
                startActivity(msjgonder);

                break;


            case  R.id.button3:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "kONU");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bu meil e kitapdan yollanmıştır");
                startActivity(Intent.createChooser(emailIntent,"Mail göndermek içn seçiniz"));
                String emailList[] = {"imdahmetkilic@gmail.com"};
                emailIntent.putExtra(Intent.EXTRA_EMAIL, emailList);
                startActivity(emailIntent);


                break;


            case  R.id.button4:
                String url = "http://www.google.com.tr";
                Intent in = new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse(url));
                startActivity(in);

                break;
        }

    }
}
