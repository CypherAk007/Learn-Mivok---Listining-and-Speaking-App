package com.example.myapplication;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class PhrasesFragment extends Fragment {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        releaseMediaPlayer();
//    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private MediaPlayer mMediaPlayer;
//    private AudioManager mAudioManager;

    //    private MediaPlayer.OnCompletionListener mCompletionListner = new MediaPlayer.OnCompletionListener() {
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            releaseMediaPlayer();
//        }
//    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public PhrasesFragment(){
        // require empty constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_numbers);
        final ArrayList<Word> words = new ArrayList<Word>();//final is used to call in onclicklistner
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
        words.add(new Word("Where are you going?", "Nīvu ellige hōguttiddīrā?",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "Ninna hesarēnu?",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "Nanna hesaru...",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "Nīvu hēge bhāvisuttiddīri?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "Nanage oḷḷeyadāgide.",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "Nīvu baruvirā?",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "Haudu, nānu baruttiddēne",R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "Nānu baruttiddēne.",R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "Hōgōṇa.",R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "Illi bā.",R.raw.phrase_come_here));

//        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);//context,layout file,list of objects

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_phrases);//context,layout file,list of objects
        ListView listView = (ListView)
                rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(NumbersActivity.this,"ListItem Clicked",Toast.LENGTH_SHORT).show();
                Word word = words.get(position);
                // Release the media player if it currnetly exists because we are about to
                //play a diffrent sound file.
                releaseMediaPlayer();

//                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                mMediaPlayer.start();

            }
        });
        return rootView;
    }

//        @Override
//        protected void onStop () {
//            super.onStop();
////        when the activity is stopped , release  the media player resources because we wont
////                be playing any more sounds.
//            releaseMediaPlayer();

//            Word word = words.get(position);
    /**
     * Clean up the media player by releasing its resources.
     */

    @Override
    public void onStop () {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer () {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

//            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }




//    public NumbersFragment() {
//            // Required empty public constructor
//        }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumbersFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static NumbersFragment newInstance(String param1, String param2) {
//        NumbersFragment fragment = new NumbersFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_numbers, container, false);

}
