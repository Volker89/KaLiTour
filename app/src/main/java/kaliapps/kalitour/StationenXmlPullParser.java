package kaliapps.kalitour;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StationenXmlPullParser {

    static final String KEY_STATION = "station";
    static final String KEY_ID = "id";
    static final String KEY_NAME = "name";
    static final String KEY_BESCHREIBUNG = "beschreibung";
    static final String KEY_KOORDINATEN = "koordinaten";

    public static List<Station> getStationenFromXml(Context ctx) throws IOException {
        List<Station> stationen;
        stationen = new ArrayList<Station>();

        Station momentaneStation = null;
        String momentanerText = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();

            InputStream is = ctx.getAssets().open("stationen.xml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            xpp.setInput(reader);

            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                String tagname = xpp.getName();

                switch(eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase(KEY_STATION)) {
                            momentaneStation = new Station();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        momentanerText = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase(KEY_STATION)) {
                            stationen.add(momentaneStation);
                        } else if (tagname.equalsIgnoreCase(KEY_ID)) {
                            momentaneStation.setId(momentanerText);
                        } else if (tagname.equalsIgnoreCase(KEY_NAME)) {
                            momentaneStation.setName(momentanerText);
                        } else if (tagname.equalsIgnoreCase(KEY_BESCHREIBUNG)) {
                            momentaneStation.setBeschreibung(momentanerText);
                        } else if (tagname.equalsIgnoreCase(KEY_KOORDINATEN)) {
                            momentaneStation.setKoordinaten(momentanerText);
                        }
                        break;

                    default:
                        break;
                }

                eventType = xpp.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return stationen;
    }

}
