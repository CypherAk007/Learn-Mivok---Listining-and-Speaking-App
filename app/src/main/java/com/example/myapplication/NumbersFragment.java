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


public class NumbersFragment extends Fragment {
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

        public NumbersFragment(){
        // require empty constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_numbers);
            final ArrayList<Word> words = new ArrayList<Word>();//final is used to call in onclicklistner
            View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
            words.add(new Word("One", "???????????? - Ondu", R.drawable.number_one, R.raw.number_one));
            words.add(new Word("Two", "???????????? - Eradu", R.drawable.number_two, R.raw.number_two));
            words.add(new Word("Three", "???????????? - M??ru", R.drawable.number_three, R.raw.number_three));
            words.add(new Word("Four", "?????????????????? - N??lku", R.drawable.number_four, R.raw.number_four));
            words.add(new Word("Five", "????????? - Aidu", R.drawable.number_five, R.raw.number_five));
            words.add(new Word("Six", "????????? - ??ru", R.drawable.number_six, R.raw.number_six));
            words.add(new Word("Seven", "????????? - ??lu ", R.drawable.number_seven, R.raw.number_seven));
            words.add(new Word("Eight", "???????????? - E??????u ", R.drawable.number_eight, R.raw.number_eight));
            words.add(new Word("Nine", "????????????????????? - Ombattu", R.drawable.number_nine, R.raw.number_nine));
            words.add(new Word("Ten", "??????????????? - Hattu", R.drawable.number_ten, R.raw.number_ten));


//        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);//context,layout file,list of objects

            WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);//context,layout file,list of objects
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
