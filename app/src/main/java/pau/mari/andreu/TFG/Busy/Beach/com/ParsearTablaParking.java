package pau.mari.andreu.TFG.Busy.Beach.com;


//  Created by PAU on 06/04/2016.


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

    public String Pau ="pruebaBucle";

    private String urlString =null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete=true;

    public ParsearTablaParking(String url){
        this.urlString=url;
    }

    public String getOrigen() {
        return origen;
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



    public void parseXMLandStorelt(XmlPullParser myParser) {
        int event;
        String text="";
        try {
            event=myParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT){
                String name=myParser.getName();
                switch (event){
                    case XmlPullParser.START_TAG:
                        //si pongo que saque por pantalla myParser.getText() no va
                        //si pongo variable privada si va!! ojo!!
                        //Log.d("Estamos en el switch1", myParser.getText());
                        //el getname si funciona, es el getText el que falla nen
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

                                //Toast toast1 = Toast.makeText(context, text, duration);
                                //toast1.setGravity(Gravity.CENTER, offsetX, offsetY);
                                //toast1.show();
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