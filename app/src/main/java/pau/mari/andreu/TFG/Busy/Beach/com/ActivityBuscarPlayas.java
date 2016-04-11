package pau.mari.andreu.TFG.Busy.Beach.com;

import android.content.Context;
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
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ActivityBuscarPlayas extends AppCompatActivity {

    //test1
    ImageView imageView2;
    CheckBox checkboxMedusas, checkboxViento, checkboxMareas;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_buscar_playas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //declaramos url y parseo
        //prueba pagina aemet
        String url ="http://www.aemet.es/xml/municipios/localidad_07015.xml";
        //String url = "https://www.dropbox.com/s/5zbes5mdlh5fvhn/tabla_parking.xml?dl=0";
        //ojo con poner el https o el http, y con el codigo html o xml
        //String url="http://www.dropbox.com/s/z0ots93nz7m0mq2/playa1.xml?dl=0";

        ParsearTablaParking obj;


        imageView2 = (ImageView) findViewById(R.id.imageView2);

        checkboxMedusas = (CheckBox) findViewById(R.id.medusa);
        checkboxViento = (CheckBox) findViewById(R.id.viento);
        checkboxMareas = (CheckBox) findViewById(R.id.marea);


        //buscando error
        int offsetX = 50;
        int offsetY = 25;
        Context context = getApplicationContext();
        CharSequence text = "url:";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, url, duration);
        toast.setGravity(Gravity.CENTER, offsetX, offsetY);
        toast.show();
        //sale toast por pantalla

        obj = new ParsearTablaParking(url);
        obj.fetchXML();
        while (obj.parsingComplete);



        //4 TOAST que son los datos que queriamos del archivo XML
        String muestra=obj.getProductor();
        Toast toast1 = Toast.makeText(context, muestra, duration);
        toast1.setGravity(Gravity.CENTER, offsetX, offsetY);
        toast1.show();

        muestra=obj.getWeb();
        Toast toast2 = Toast.makeText(context, muestra, duration);
        toast2.setGravity(Gravity.CENTER, offsetX, offsetY);
        toast2.show();

        muestra=obj.getEnlace();
        Toast toast3 = Toast.makeText(context, muestra, duration);
        toast3.setGravity(Gravity.CENTER, offsetX, offsetY);
        toast3.show();

        muestra=obj.getLanguage();
        Toast toast4 = Toast.makeText(context, muestra, duration);
        toast4.setGravity(Gravity.CENTER, offsetX, offsetY);
        toast4.show();





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


    }
}