package kaliapps.kalitour;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends Fragment {

    MediaPlayer mp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag3, container,false);

        final MediaPlayer sound = MediaPlayer.create(getActivity(), R.raw.hund);

        Button play, pause, stop;

        play = (Button) rootView.findViewById(R.id.play);
        stop = (Button) rootView.findViewById(R.id.stop);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.pause();
            }
        });

        Button button = (Button) rootView.findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MapActivity.class);
                startActivity(i);
            }
        });

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
            case "Altes Rathaus":
                momentaneStation = stationen.get(0);
                break;
            case "Johannstrasse":
                momentaneStation = stationen.get(1);
                break;
            case "Alfredstrasse":
                momentaneStation = stationen.get(2);
                break;
            case "Georgstrasse":
                momentaneStation = stationen.get(3);
                break;
            case "Markt":
                momentaneStation = stationen.get(4);
                break;
            case "Antonstrasse":
                momentaneStation = stationen.get(5);
                break;
            case "Lotharstrasse":
                momentaneStation = stationen.get(6);
                break;
            case "Barbarastrasse":
                momentaneStation = stationen.get(7);
                break;
            case "Vinnstrasse":
                momentaneStation = stationen.get(8);
                break;
            case "Maxstrasse":
                momentaneStation = stationen.get(9);
                break;
            default:
                momentaneStation = stationen.get(10);
        }

        TextView stationName = (TextView) rootView.findViewById(R.id.textView_stationNameAudio);
        stationName.setText(momentaneStation.getName());

        return rootView;
    }
}
