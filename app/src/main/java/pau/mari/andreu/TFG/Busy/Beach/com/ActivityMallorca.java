package pau.mari.andreu.TFG.Busy.Beach.com;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Canvas;
        import android.net.Uri;
        import android.os.Bundle;
        import android.os.Environment;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.appindexing.Action;
        import com.google.android.gms.appindexing.AppIndex;
        import com.google.android.gms.common.api.GoogleApiClient;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.InputStream;
        import java.io.InputStreamReader;


/*
TRABAJO FINAL DE GRADO DE PAU MARI ANDREU

UNIVERSIDAD INTERNACIONAL DE LA RIOJA

UNIR

 */

public class ActivityMallorca extends AppCompatActivity {

    //test1
    ImageView imageView3, imageView4, imageView5, imageView7,imageView8;
    ImageView imageView6, imageView2, imageView12, imageView10;
    ImageView imageView11, imageView9;
    CheckBox checkboxMedusas, checkboxViento, checkboxMareas;
    CheckBox checkboxParking, checkboxNopescar;
    TextView textView3,textView4,textView5, textView6;
    TextView textView13, textView9, textView8;
    TextView textView7, textView10, textView11, textView12;
    float valor_parking;
    float valor_parking2;
    float valor_parking3;
    public String vent1;


    //Canvas canvas;
    //Bitmap medusa;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_mallorca);
        //setContentView(R.drawable.isla_menorca_web2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //declaramos url y parseo
        //prueba pagina aemet
        String url = "http://www.aemet.es/xml/municipios/localidad_07040.xml";
        //String url = "https://www.dropbox.com/s/5zbes5mdlh5fvhn/tabla_parking.xml?dl=0";
        //ojo con poner el https o el http, y con el codigo html o xml
        //String url="http://www.dropbox.com/s/z0ots93nz7m0mq2/playa1.xml?dl=0";

        ParsearTablaParking obj;
        ParsearPlaya obj2;
        ParsearPlaya obj3;
        ParsearPlaya obj4;
        ParsearOleaje obj5;


        //imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView7=(ImageView) findViewById(R.id.imageView7);
        imageView8=(ImageView) findViewById(R.id.imageView8);

        imageView6=(ImageView) findViewById(R.id.imageView6);
        imageView2=(ImageView) findViewById(R.id.imageView2);
        imageView12=(ImageView) findViewById(R.id.imageView12);
        imageView10=(ImageView) findViewById(R.id.imageView10);
        imageView11=(ImageView) findViewById(R.id.imageView11);
        imageView9=(ImageView) findViewById(R.id.imageView9);

        //textos referenciados
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView13 = (TextView) findViewById(R.id.textView13);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);

        //funcion de setVisibility para aparecer o desaparecer iconos
        //VISIBLE INVISIBLE GONE con valores de 0,4,8 o HEXA 0x00000000 , etc.
        imageView3.setVisibility(View.INVISIBLE);
        imageView4.setVisibility(View.INVISIBLE);
        imageView5.setVisibility(View.INVISIBLE);
        imageView7.setVisibility(View.INVISIBLE);
        imageView8.setVisibility(View.INVISIBLE);
        imageView6.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView12.setVisibility(View.INVISIBLE);
        imageView10.setVisibility(View.INVISIBLE);
        imageView11.setVisibility(View.INVISIBLE);
        imageView9.setVisibility(View.INVISIBLE);

        //hacemos invisible los TextView hasta tener valores de los XML
        textView5.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        textView13.setVisibility(View.INVISIBLE);
        textView9.setVisibility(View.INVISIBLE);
        textView8.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        textView10.setVisibility(View.INVISIBLE);
        textView11.setVisibility(View.INVISIBLE);
        textView12.setVisibility(View.INVISIBLE);




        checkboxMedusas = (CheckBox) findViewById(R.id.medusa);
        checkboxViento = (CheckBox) findViewById(R.id.viento);
        checkboxMareas = (CheckBox) findViewById(R.id.marea);
        checkboxParking=(CheckBox)findViewById(R.id.parking);
        checkboxNopescar=(CheckBox) findViewById(R.id.no_pesca);

        //buscando error
        int offsetX = 50;
        int offsetY = 25;
        Context context = getApplicationContext();
        CharSequence text = "url:";
        int duration = Toast.LENGTH_LONG;


        obj = new ParsearTablaParking(url);
        obj.fetchXML();
        while (obj.parsingComplete);


        //String url2 = "http://dl.dropboxusercontent.com/s/go5rnspqoviqaso/tabla_parking_3playas.xml?dl=0";
        //String url2 ="http://dl.dropboxusercontent.com/s/ea4itzckaffv1y2/playa1_MODIFICADO.xml?dl=0";
        //https://www.dropbox.com/s/052f7pyhkgjltdn/playas_norte_sur.xml?dl=0
        //http://dl.dropboxusercontent.com/s/052f7pyhkgjltdn/playas_norte_sur.xml?dl=0
        //https://www.dropbox.com/home/BusyBeach?preview=playas_norte_sur.xml
        // funciona: dl.dropboxusercontent.com/s/go5rnspqoviqaso/tabla_parking_3playas.xml?dl=0
        //String url2="http://dl.dropboxusercontent.com/s/052f7pyhkgjltdn/playas_norte_sur.xml?dl=0";
        String url2="https://dl.dropboxusercontent.com/s/7bplxoh7kdm1nq0/playas_norte_editadas2.xml?dl=0";
        //http://dl.dropboxusercontent.com/s/7bplxoh7kdm1nq0/playas_norte_editadas2.xml?dl=0
        //https://www.dropbox.com/s/uqavxjlgujyipac/playas_norte_editadas.xml?dl=0
        //http://dl.dropboxusercontent.com/s/uqavxjlgujyipac/playas_norte_editadas.xml?dl=0
        obj2=new ParsearPlaya(url2);
        obj2.fetchXML();
        while (obj2.parsingComplete);

        int prueba=0;
        String cadena=obj2.getCoches();
        prueba=Integer.parseInt(cadena);
        System.out.println(prueba);

        int prueba2=0;
        String cadena2=obj2.getCapacidad();
        prueba2 = Integer.parseInt(cadena2);
        System.out.println(prueba2);

        float salida=0;
        salida=(((float)prueba)/prueba2)*100;
        System.out.println(salida);
        valor_parking=salida;

        //playas sur editadas MITJANA
        //https://www.dropbox.com/s/l0vlnjqe9ohnea8/playas_sur_editadas.xml?dl=0
        //https://www.dropbox.com/s/l0vlnjqe9ohnea8/playas_sur_editadas.xml?dl=0
        String url3="https://dl.dropboxusercontent.com/s/l0vlnjqe9ohnea8/playas_sur_editadas.xml?dl=0";
        obj3=new ParsearPlaya(url3);
        obj3.fetchXML();
        while (obj3.parsingComplete);

        prueba=0;
        cadena=obj3.getCoches();
        prueba=Integer.parseInt(cadena);
        System.out.println(prueba);

        prueba2=0;
        cadena2=obj3.getCapacidad();
        prueba2 = Integer.parseInt(cadena2);
        System.out.println(prueba2);

        salida=0;
        salida=(((float)prueba)/prueba2)*100;
        System.out.println(salida);
        valor_parking2=salida;


        //playas sur editadas SON BOU
        //https://www.dropbox.com/s/0n7ehrvn6rg9g9v/playas_sur_editadas2.xml?dl=0
        String url4="https://dl.dropboxusercontent.com/s/0n7ehrvn6rg9g9v/playas_sur_editadas2.xml?dl=0";
        obj4=new ParsearPlaya(url4);
        obj4.fetchXML();
        while (obj4.parsingComplete);

        prueba=0;
        cadena=obj4.getCoches();
        prueba=Integer.parseInt(cadena);
        System.out.println(prueba);

        prueba2=0;
        cadena2=obj4.getCapacidad();
        prueba2 = Integer.parseInt(cadena2);
        System.out.println(prueba2);

        salida=0;
        salida=(((float)prueba)/prueba2)*100;
        System.out.println(salida);
        valor_parking3=salida;




        //OLEAJE
        String url5="http://www.aemet.es/xml/maritima/FQMQ42MM.xml";
        obj5=new ParsearOleaje(url5);
        obj5.fetchXML();
        while (obj5.parsingComplete);

        checkboxNopescar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkboxNopescar.isChecked()) {
                    //funcion de setVisibility para aparecer o desaparecer iconos
                    //VISIBLE INVISIBLE GONE con valores de 0,4,8 o HEXA 0x00000000 , etc.
                    imageView8.setVisibility(View.VISIBLE);
                    textView13.setVisibility(View.VISIBLE);
                }
                if (!(checkboxNopescar.isChecked())) {
                    imageView8.setVisibility(View.INVISIBLE);
                    textView13.setVisibility(View.INVISIBLE);
                }

            }
        });


        checkboxParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkboxParking.isChecked()) {
                    //funcion de setVisibility para aparecer o desaparecer iconos
                    //VISIBLE INVISIBLE GONE con valores de 0,4,8 o HEXA 0x00000000 , etc.
                    imageView7.setVisibility(View.VISIBLE);
                    imageView6.setVisibility(View.VISIBLE);
                    imageView11.setVisibility(View.VISIBLE);
                    //con sus textos
                    textView5.setVisibility(View.VISIBLE);
                    textView7.setVisibility(View.VISIBLE);
                    textView10.setVisibility(View.VISIBLE);
                    CharSequence coches="Fuerte";
                    textView3=(TextView) findViewById(R.id.textView3);
                    textView3.setText(coches);



                    int temp1=0;
                    temp1=(int)valor_parking;
                    //String s=Float.toString(valor_parking);
                    String s=Integer.toString(temp1);
                    String s2="%";
                    String s3=s+s2;

                    textView5.setText(s3);


                    temp1=0;
                    temp1=(int)valor_parking2;
                    //String s=Float.toString(valor_parking);
                    s=Integer.toString(temp1);
                    s2="%";
                    s3=s+s2;

                    textView7.setText(s3);

                    temp1=0;
                    temp1=(int)valor_parking3;
                    //String s=Float.toString(valor_parking);
                    s=Integer.toString(temp1);
                    s2="%";
                    s3=s+s2;

                    textView10.setText(s3);
                }
                if (!(checkboxParking.isChecked())) {
                    imageView7.setVisibility(View.INVISIBLE);
                    imageView11.setVisibility(View.INVISIBLE);
                    imageView6.setVisibility(View.INVISIBLE);
                    //textView3.setText("");
                    textView5.setVisibility(View.INVISIBLE);
                    textView7.setVisibility(View.INVISIBLE);
                    textView10.setVisibility(View.INVISIBLE);
                }

            }
        });
        checkboxMareas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkboxMareas.isChecked()) {
                    //funcion de setVisibility para aparecer o desaparecer iconos
                    //VISIBLE INVISIBLE GONE con valores de 0,4,8 o HEXA 0x00000000 , etc.
                    imageView5.setVisibility(View.VISIBLE);
                    imageView9.setVisibility(View.VISIBLE);
                    imageView12.setVisibility(View.VISIBLE);

                    //textos asociados
                    textView3.setVisibility(View.VISIBLE);
                    textView9.setVisibility(View.VISIBLE);
                    textView12.setVisibility(View.VISIBLE);
                }
                if (!(checkboxMareas.isChecked())) {
                    imageView5.setVisibility(View.INVISIBLE);
                    imageView9.setVisibility(View.INVISIBLE);
                    imageView12.setVisibility(View.INVISIBLE);

                    //textos asociados
                    textView3.setVisibility(View.INVISIBLE);
                    textView9.setVisibility(View.INVISIBLE);
                    textView12.setVisibility(View.INVISIBLE);

                }
            }
        });

        String vent="Suave";
        vent=obj.getViento();
        final CharSequence finalVent = vent;

        if(obj.getVelocidadEste()=="00"){

        }else{
            vent=obj.getVelocidadEste();
            vent1=vent;
        }

        if(obj.getVelocidadNorte()=="00"){

        }else {
            vent=obj.getVelocidadNorte();
            vent1=vent;
        }
        if(obj.getVelocidadOeste()=="00"){

        }else {
            vent=obj.getVelocidadOeste();
            vent1=vent;
        }
        if(obj.getVelocidadSur()=="00"){

        }else {
            vent=obj.getVelocidadSur();
            vent1=vent;
        }



        checkboxViento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkboxViento.isChecked()) {
                    //funcion de setVisibility para aparecer o desaparecer iconos
                    //VISIBLE INVISIBLE GONE con valores de 0,4,8 o HEXA 0x00000000 , etc.
                    imageView4.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                    imageView10.setVisibility(View.VISIBLE);

                    //textos

                    textView6.setVisibility(View.VISIBLE);
                    textView11.setVisibility(View.VISIBLE);
                    textView8.setVisibility(View.VISIBLE);


                    textView6=(TextView) findViewById(R.id.textView6);
                    String km=" km/h";
                    String finalKm=vent1+km;
                    textView6.setText(finalKm);
                    textView11.setText(finalKm);
                    textView8.setText(finalKm);


                    /*
                    private String url1="http://api.openweathermap.org/data/2.5/weather?q=";
                    private String url2="&mode=xml";
                    String finalUrl=url1+url+url2;
                    txt2.setText(finalUrl);

                    if(finalVent=="20"){
                        textView4.setText("Suave");
                    }
                    */
                }
                if (!(checkboxViento.isChecked())) {
                    //imageView4.setVisibility(View.INVISIBLE);
                    //textView4.setText("");
                    //VISIBLE INVISIBLE GONE con valores de 0,4,8 o HEXA 0x00000000 , etc.
                    imageView4.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                    imageView10.setVisibility(View.INVISIBLE);

                    //textos

                    textView6.setVisibility(View.INVISIBLE);
                    textView11.setVisibility(View.INVISIBLE);
                    textView8.setVisibility(View.INVISIBLE);
                }
            }
        });

        checkboxMedusas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkboxMedusas.isChecked()) {
                    //funcion de setVisibility para aparecer o desaparecer iconos
                    //VISIBLE INVISIBLE GONE con valores de 0,4,8 o HEXA 0x00000000 , etc.
                    imageView3.setVisibility(View.VISIBLE);

                    //texto
                    textView4.setVisibility(View.VISIBLE);
                }
                if (!(checkboxMedusas.isChecked())) {
                    imageView3.setVisibility(View.INVISIBLE);

                    textView4.setVisibility(View.INVISIBLE);
                }
            }
        });


        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ActivityBuscarPlayas Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://pau.mari.andreu.TFG.Busy.Beach.com/http/host/path")
        );
        AppIndex.AppIndexApi.start(client2, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ActivityBuscarPlayas Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://pau.mari.andreu.TFG.Busy.Beach.com/http/host/path")
        );
        AppIndex.AppIndexApi.end(client2, viewAction);
        client2.disconnect();
    }
}
