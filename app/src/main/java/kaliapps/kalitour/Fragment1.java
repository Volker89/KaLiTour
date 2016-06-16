package kaliapps.kalitour;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag1, container,false);

        Context thiscontext;
        List<Station> stationen;
        Station momentaneStation;

        thiscontext = getActivity();
        stationen = new ArrayList<Station>();

        Bundle bundle = getArguments();
        String text = bundle.getString("FRAGMENT_KEY");

        try {
            stationen = StationenXmlPullParser.getStationenFromXml(thiscontext);
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (text) {
            case "Start":
                momentaneStation = stationen.get(0);
                break;
            case "Kneipe":
                momentaneStation = stationen.get(1);
                break;
            case "Kiosk":
                momentaneStation = stationen.get(2);
                break;
            default:
                momentaneStation = stationen.get(0);
        }

        TextView stationName = (TextView) rootView.findViewById(R.id.textView_stationName);
        TextView stationBeschreibung = (TextView) rootView.findViewById(R.id.textView_stationBeschreibung);

        stationName.setText(momentaneStation.getName());
        stationBeschreibung.setText(momentaneStation.getBeschreibung());

        return rootView;
    }
}
