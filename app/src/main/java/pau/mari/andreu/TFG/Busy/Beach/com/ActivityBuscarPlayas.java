package pau.mari.andreu.TFG.Busy.Beach.com;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class ActivityBuscarPlayas extends AppCompatActivity {

    ImageView imageView2;

    CheckBox checkboxMedusas, checkboxViento,checkboxMareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_buscar_playas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView2 = (ImageView) findViewById(R.id.imageView2);

        checkboxMedusas= (CheckBox) findViewById(R.id.medusa);
        checkboxViento= (CheckBox) findViewById(R.id.viento);
        checkboxMareas= (CheckBox) findViewById(R.id.marea);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
