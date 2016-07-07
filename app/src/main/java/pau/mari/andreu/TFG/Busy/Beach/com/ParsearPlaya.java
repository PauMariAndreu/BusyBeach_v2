package pau.mari.andreu.TFG.Busy.Beach.com;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by PAU on 20/04/2016.
 */


/*
TRABAJO FINAL DE GRADO DE PAU MARI ANDREU

UNIVERSIDAD INTERNACIONAL DE LA RIOJA

UNIR

 */


public class ParsearPlaya {


    private String playa="playa";
    private String nombre="nombre";
    private String costa="costa";
    private String coches="coches";
    private String capacidad="capacidad";

    public String Pau ="pruebaBucle";

    private String urlString =null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete=true;

    public ParsearPlaya(String url){
        this.urlString=url;
    }

    public String getPlaya() {
        return playa;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCosta() {
        return costa;
    }

    public String getCoches() {
        return coches;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public String getPau(){ return Pau;}



    public void parseXMLandStorelt(XmlPullParser myParser) {
        int event;
        String text="";
        try {
            //para saltar el fallo del UTF
            event=myParser.nextToken();

            event=myParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT){
                String name=myParser.getName();
                switch (event){
                    case XmlPullParser.START_TAG:
                        Pau=myParser.getName();
                        //Pau=myParser.getText();
                        //Log.d("Estamos en el switch1", Pau);
                        break;
                    case XmlPullParser.TEXT:
                        text=myParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        //estamos al final de una etiqueta y queremos su valor
                        //pero no queremos copiar cuando haya \n o algo vacio
                        if (name.equals("playa")){
                            //origen no lo queremos copiar, el resto si
                            //origen=text;
                        }else if (name.equals("nombre")){
                            //productor=myParser.getAttributeValue(null,"value");
                            //productor=myParser.getText();
                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                System.out.println(text);
                                nombre=text;

                                //Toast toast1 = Toast.makeText(context, text, duration);
                                //toast1.setGravity(Gravity.CENTER, offsetX, offsetY);
                                //toast1.show();
                            }
                        }else if (name.equals("costa")){
                            //web=myParser.getAttributeValue(null,"value");

                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                System.out.println(text);
                                costa=text;
                            }
                        }else if (name.equals("coches")) {
                            //enlace= myParser.getAttributeValue(null, "value");

                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                System.out.println(text);
                                coches=text;
                            }
                        }else if (name.equals("capacidad")){
                            //language=myParser.getAttributeValue(null,"value");

                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                System.out.println(text);
                                capacidad=text;
                            }

                        }else if (name.equals("pau")){

                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                System.out.println(text);
                                Pau=text;
                            }
                        }else {}
                        break;
                }
                event=myParser.next();
            }
            parsingComplete=false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void fetchXML(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    URL url=new URL(urlString);
                    HttpURLConnection connect=(HttpURLConnection)url.openConnection();
                    //HttpURLConnection connect=(HttpsURLConnection)url.openConnection();
                    connect.setReadTimeout(10000);
                    connect.setConnectTimeout(15000);
                    connect.setRequestMethod("GET");
                    connect.setDoInput(true);
                    connect.connect();
                    /*
                    //prueba con StackOverflow
                    URL url=new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(10000);
                    conn.setUseCaches(true);
                    conn.addRequestProperty("Content-Type", "text/xml; charset=utf-8");
                    InputStreamReader is = new InputStreamReader(new BOMInputStream(conn.getInputStream(), false, ByteOrderMark.UTF_8));
                    */
                    InputStream stream=connect.getInputStream();
                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myparser=xmlFactoryObject.newPullParser();
                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myparser.setInput(stream, null);

                    parseXMLandStorelt(myparser);
                    stream.close();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
