package pau.mari.andreu.TFG.Busy.Beach.com;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView imageView;
    Button boton_principal;

    //Creamos el imageView principal de tipo .png
    //para el contorno de la isla.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.imageView);

        boton_principal = (Button) findViewById(R.id.button);

        //le pasamos la funcion this para decirle el contexto que queremos
        boton_principal.setOnClickListener(this);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v){
        int offsetX = 50;
        int offsetY = 25;
        Context context = getApplicationContext();
        CharSequence text = "Cargando datos...";
        int duration = Toast.LENGTH_SHORT;


        switch (v.getId()){
            case R.id.button:

                //Toast.makeText(getApplicationContext(),"Cargando datos...",Toast.LENGTH_SHORT).show();
                //Toast.setGravity(Gravity.RIGHT | Gravity.TOP, offsetX, offsetY);
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, offsetX, offsetY);
                //se puede combinar el Gravity como sigue
                //Gravity.CENTER | Gravity.TOP
                toast.show();

                Intent intent=new Intent(this,ActivityBuscarPlayas.class);
                startActivity(intent);
                break;

        }
    }
}
