package pau.mari.andreu.TFG.Busy.Beach.com;


//  Created by PAU on 06/04/2016.

/*
TRABAJO FINAL DE GRADO DE PAU MARI ANDREU

UNIVERSIDAD INTERNACIONAL DE LA RIOJA

UNIR

 */


import android.util.Log;
import android.util.Xml;
import android.view.Gravity;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Struct;
import java.sql.Time;
import java.util.Calendar;
import java.util.LinkedList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;



public class ParsearTablaParking{

    private String origen="origen";
    private String productor="productor";
    private String web="web";
    private String enlace="enlace";
    private String language="language";

    private String viento="viento";

    public String Pau ="pruebaBucle";

    private String urlString =null;


    private String viento00_06="00-06";
    private String viento06_12="06-12";
    private String viento12_18="12-18";
    private String viento18_24="18-24";
    private String velocidadNorte="00";
    private String velocidadSur="00";
    private String velocidadEste="00";
    private String velocidadOeste="00";




    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete=true;

    public ParsearTablaParking(String url){
        this.urlString=url;
    }

    public String getOrigen() {
        return origen;
    }

    public String getViento(){
        return viento;
    }

    public String getProductor() {
        return productor;
    }

    public String getWeb() {
        return web;
    }

    public String getEnlace() {
        return enlace;
    }

    public String getLanguage(){ return language;}

    public String getVelocidadNorte(){return velocidadNorte;}
    public String getVelocidadSur() {return velocidadSur;}
    public String getVelocidadEste(){return velocidadEste;}
    public String getVelocidadOeste(){return velocidadOeste;}



    public void parseXMLandStorelt(XmlPullParser myParser) {
        int event;
        int tempo;
        String text="";
        int times=0;
        //tenemos el valor entero solo de la hora, no de los minutos pues no
        //nos interesa
        int hours= Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        try {
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
                        if (name.equals("origen")){
                            //origen no lo queremos copiar, el resto si
                            //origen=text;
                        }else if (name.equals("productor")){
                            //productor=myParser.getAttributeValue(null,"value");
                            //productor=myParser.getText();
                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                System.out.println(text);
                                productor=text;
                            }
                        }else if (name.equals("web")){
                            //web=myParser.getAttributeValue(null,"value");

                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                System.out.println(text);
                                web=text;
                            }
                        }else if (name.equals("enlace")) {
                            //enlace= myParser.getAttributeValue(null, "value");

                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                System.out.println(text);
                                enlace=text;
                            }
                        }else if (name.equals("language")){
                            //language=myParser.getAttributeValue(null,"value");

                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                System.out.println(text);
                                language=text;
                            }

                        }else if (name.equals("velocidad")){

                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                //el XML de la AEMET desecha las 3 primeras velocidades

                                times++;
                                if(times==4){
                                    //copia de velocidades
                                    viento00_06=text;
                                }
                                if(times==5){
                                    //copia de velocidades
                                    viento06_12=text;
                                }
                                if(times==6){
                                    //copia de velocidades
                                    viento12_18=text;
                                }
                                if(times==7){
                                    //copia de velocidades
                                    viento18_24=text;
                                }


                                if((hours>=0)&&(hours<=6)&&(times==4)){
                                 //sacamos la primera velocidad del viento
                                    velocidadEste=viento00_06;
                                    System.out.println(viento00_06);
                                }
                                if((hours>6)&&(hours<=12)&&(times==5)){
                                    //sacamos la segunda velocidad del viento
                                    velocidadNorte=viento06_12;
                                    System.out.println(viento06_12);
                                }
                                if((hours>12)&&(hours<=18)&&(times==6)){
                                    //sacamos la tercera velocidad del viento
                                    velocidadOeste=viento12_18;
                                    System.out.println(viento12_18);
                                }
                                if((hours>18)&&(hours<=24)&&(times==7)){
                                    //sacamos la cuarta velocidad del viento
                                    velocidadSur=viento18_24;
                                    System.out.println(viento18_24);
                                }


                                //System.out.println(hours);
                                viento=text;
                            }
                        }else if (name.equals("viento")) {

                            if ((text == null) || (text.isEmpty()) || (text.length() == 0) || (text.equals("")) || (text.equals(null)) || (text == "\n")) {
                                //nada
                            } else {
                                //if(text=="00-06") {
                                    //System.out.println(text);
                                    //velocidadEste = text;
                                //}
                            }

                        }else{}
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