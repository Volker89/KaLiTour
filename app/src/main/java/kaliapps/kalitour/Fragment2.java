package kaliapps.kalitour;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag2, container,false);

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

                ImageView image0 = (ImageView) rootView.findViewById(R.id.imageView_stationBild);
                image0.setImageResource(R.drawable.bild_station1);
                break;
            case "Johannstrasse":
                momentaneStation = stationen.get(1);

                ImageView image1 = (ImageView) rootView.findViewById(R.id.imageView_stationBild);
                image1.setImageResource(R.drawable.bild_station2);
                break;
            case "Alfredstrasse":
                momentaneStation = stationen.get(2);

                ImageView image2 = (ImageView) rootView.findViewById(R.id.imageView_stationBild);
                image2.setImageResource(R.drawable.bild_station3);
                break;
            case "Georgstrasse":
                momentaneStation = stationen.get(3);

                ImageView image3 = (ImageView) rootView.findViewById(R.id.imageView_stationBild);
                image3.setImageResource(R.drawable.bild_station4);
                break;
            case "Markt":
                momentaneStation = stationen.get(4);

                ImageView image51 = (ImageView) rootView.findViewById(R.id.imageView_stationBild);
                image51.setImageResource(R.drawable.bild_station5);
                break;
            case "Antonstrasse":
                momentaneStation = stationen.get(5);

                ImageView image6 = (ImageView) rootView.findViewById(R.id.imageView_stationBild);
                image6.setImageResource(R.drawable.bild_station6);
                break;
            case "Lotharstrasse":
                momentaneStation = stationen.get(6);
                break;
            case "Barbarastrasse":
                momentaneStation = stationen.get(7);

                ImageView image7 = (ImageView) rootView.findViewById(R.id.imageView_stationBild);
                image7.setImageResource(R.drawable.bild_station8);
                break;
            case "Vinnstrasse":
                momentaneStation = stationen.get(8);

                ImageView image81 = (ImageView) rootView.findViewById(R.id.imageView_stationBild);
                image81.setImageResource(R.drawable.bild_station9);
                break;
            case "Maxstrasse":
                momentaneStation = stationen.get(9);

                ImageView image9 = (ImageView) rootView.findViewById(R.id.imageView_stationBild);
                image9.setImageResource(R.drawable.bild_station10);
                break;
            default:
                momentaneStation = stationen.get(10);
        }

        TextView stationName = (TextView) rootView.findViewById(R.id.textView_stationNameBild);
        stationName.setText(momentaneStation.getName());

        Button button = (Button) rootView.findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MapActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        return rootView;
    }
}
