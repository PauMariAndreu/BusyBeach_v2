package pau.mari.andreu.TFG.Busy.Beach.com;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by PAU on 13/05/2016.
 */

/*
TRABAJO FINAL DE GRADO DE PAU MARI ANDREU

UNIVERSIDAD INTERNACIONAL DE LA RIOJA

UNIR

 */

/*
Cifrado del oleaje

Oleaje de toda la costa mediterranea

http://www.aemet.es/xml/maritima/FQMQ42MM.xml

Nombre Altura en metros
Calma o llana 0 1
Rizada 0 a 0,1 2
Marejadilla 0,1 a 0,5 3
Marejada  0,5 a 1,25 4
Fuerte Marejada 1,25 a 2,5 5
Gruesa  2,5 a 4 6
Muy Gruesa  4 a 6 7
Arbolada 6 a 9 8
Montañosa 9 a 14 9
Enorme Más de 14
*/

public class ParsearOleaje {

    private String playa="playa";

    public String Pau ="pruebaBucle";

    private String urlString =null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete=true;

    public ParsearOleaje(String url){
        this.urlString=url;
    }



    public String getPlaya() {
        return playa;
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

                        Pau=myParser.getInputEncoding();
                        //System.out.println(Pau);
                        //Pau=myParser.getText();
                        Pau=myParser.getPositionDescription();
                        System.out.println(Pau);

                        Pau=myParser.getNamespaceUri(1);
                        //System.out.println(Pau);
                        //Log.d("Estamos en el switch1", Pau);
                        break;
                    case XmlPullParser.TEXT:
                        text=myParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        //estamos al final de una etiqueta y queremos su valor
                        //pero no queremos copiar cuando haya \n o algo vacio
                        Pau=myParser.getPositionDescription();
                        System.out.println(Pau);
                        if (name.equals("nombre")){
                            //origen no lo queremos copiar, el resto si
                            //origen=text;
                            Pau=myParser.getText();
                            //System.out.println(Pau);
                        }else if (name.equals("texto")){
                            //productor=myParser.getAttributeValue(null,"value");
                            //productor=myParser.getText();
                            if((text==null)||(text.isEmpty())||(text.length()==0)||(text.equals(""))||(text.equals(null))||(text=="\n")){
                                //nada
                            }else {
                                if(true) {
                                    //System.out.println(text);
                                }
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


