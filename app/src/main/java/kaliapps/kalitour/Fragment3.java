package kaliapps.kalitour;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment3 extends Fragment {

    MediaPlayer mp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag3, container,false);

        Button play, pause, stop;

        play = (Button) rootView.findViewById(R.id.play);
        pause = (Button) rootView.findViewById(R.id.pause);
        stop = (Button) rootView.findViewById(R.id.stop);

        final MediaPlayer sound = MediaPlayer.create(getActivity(), R.raw.hund);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.pause();
                int length = sound.getCurrentPosition();
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

        return rootView;
    }
}
