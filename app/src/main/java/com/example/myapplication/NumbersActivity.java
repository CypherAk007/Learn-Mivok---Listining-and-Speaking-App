package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//public class NumbersActivity extends AppCompatActivity {
//
//    private MediaPlayer mMediaPlayer;
////    private AudioManager mAudioManager;
//
//    private MediaPlayer.OnCompletionListener mCompletionListner = new MediaPlayer.OnCompletionListener() {
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            releaseMediaPlayer();
//        }
//    };
//
//    /**
//     * This listener gets triggered whenever the audio focus changes
//     * (i.e., we gain or lose audio focus because of another app or device).
//     */
////    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
////            new AudioManager.OnAudioFocusChangeListener() {
////        @Override
////        public void onAudioFocusChange(int focusChange) {
////
////            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
////                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
////
//////            I see that we we play the audio in one of the activity and move to another activity and start playing the audio,
//////            the app crashes due to null pointer exception with the pause method of the OnAudioFocusChangeListener in the first activity.
//////            The question is why is the focus change value set as AUDIOFOCUS_LOSS_TRANSIENT and not AUDIOFOCUS_LOSS
//////                    if ((focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
//////                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) && mAudioManager!= null)
////                            {
////                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
////                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
////                // our app is allowed to continue playing sound but at a lower volume. We'll treat
////                // both cases the same way because our app is playing short sound files.
////
////                // Pause playback and reset player to the start of the file. That way, we can
////                // play the word from the beginning when we resume playback.
////                mMediaPlayer.pause();
////                mMediaPlayer.seekTo(0);
////            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
////                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
////                mMediaPlayer.start();
////            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
////                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
////                // Stop playback and clean up resources
////                releaseMediaPlayer();
////            }
////        }
////    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_numbers);
//
//        //array of number strings
//        //String [] words = new String [] {"one","two","three","four","five","six","seven","eight","nine","ten"}; OR
////        String [] words = new String[10];
////        words[0] = "one";
////        words[1] = "two";
////        words[2] = "three";
////        words[3] = "four";
////        words[4] = "five";
////        words[5] = "six";
////        words[6] = "seven";
////        words[7] = "eight";
////        words[8] = "nine";
////        words[9] = "ten";
//
////        logging
////            Log.v("MainActivity","Word at index 0 :"+ words[0]);
////        for(int i=0;i<words.length;i++)
////        {
////            Log.v("MainActivity","Word at index "+i+":"+ words[i]);
////        }
//
////        Creating arrayList instad of array
//
//        final ArrayList<Word> words = new ArrayList<Word>();//final is used to call in onclicklistner
//        //words.add(0,"one");
//
//        // adding word object to Word class
////        Word w = new Word("One","lutti");
////        words.add(w);
//        //One liner for above code
//        words.add(new Word("One","Lutti",R.drawable.number_one,R.raw.number_one));
//        words.add(new Word("Two","Otiiko",R.drawable.number_two,R.raw.number_two));
//        words.add(new Word("Three","Tolookosu",R.drawable.number_three,R.raw.number_three));
//        words.add(new Word("Four","Oyyisa",R.drawable.number_four,R.raw.number_four));
//        words.add(new Word("Five","Massokka",R.drawable.number_five,R.raw.number_five));
//        words.add(new Word("Six","Temmokka",R.drawable.number_six,R.raw.number_six));
//        words.add(new Word("Seven","Kenekaku",R.drawable.number_seven,R.raw.number_seven));
//        words.add(new Word("Eight","Kawinta",R.drawable.number_eight,R.raw.number_eight));
//        words.add(new Word("Nine","Wo'e",R.drawable.number_nine,R.raw.number_nine));
//        words.add(new Word("Ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));
//
//
//
//
//        //        logging
////            Log.v("MainActivity","Word at index 0 :"+ words.get(0) );
////        for(int i=0;i<words.size();i++)
////        {
////            Log.v("MainActivity","Word at index "+i+":"+ words.get(i));
////        }
//
////        LinearLayout rootView =(LinearLayout) findViewById(R.id.rootView);//helps to find linear layout rootview
////        int index = 0;
////
////        TextView wordView1= new TextView(this);//text view abject is created and stored in wordview.
////        wordView1.setText(words.get(index));//word is set at 0 index
////        rootView.addView(wordView1);
////        index++;
////        TextView wordView2 = new TextView(this);//text view abject is created and stored in wordview.
////        wordView2.setText(words.get(index));//word is set at 0 index
////        rootView.addView(wordView2);//root view is parent view  and word view is added as child
//        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
//        // adapter knows how to create layouts for each item in the list, using the
//        // simple_list_item_1.xml layout resource defined in the Android framework.
//        // This list item layout contains a single {@link TextView}, which the adapter will set to
//        // display a single word.
//        WordAdapter adapter = new WordAdapter(this, words,R.color.category_numbers);//context,layout file,list of objects
//                // android.R.layout.simple_list_item_1 -Android pre defiend xml layout
//
//        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
//        // There should be a {@link ListView} with the view ID called list, which is declared in the
//        // activity_numbers.xml layout file.
//        ListView listView = (ListView) findViewById(R.id.list);
////        GridView gridView = (GridView) findViewById(R.id.grid);
//        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
//        // {@link ListView} will display list items for each word in the list of words.
//        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
//        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
//        listView.setAdapter(adapter);//Binds our word adapter to list view.
////        gridView.setAdapter(itemsAdapter);
//
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Toast.makeText(NumbersActivity.this,"ListItem Clicked",Toast.LENGTH_SHORT).show();
//                Word word = words.get(position);
//                // Release the media player if it currnetly exists because we are about to
//                //play a diffrent sound file.
//                releaseMediaPlayer();
//
//                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getAudioResourceId());
//                mMediaPlayer.start();
//
//            }
//        });
//
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//////                Toast.makeText(NumbersActivity.this,"ListItem Clicked",Toast.LENGTH_SHORT).show();
////                Word word = words.get(position);
////                // Release the media player if it currnetly exists because we are about to
////                //play a diffrent sound file.
////                releaseMediaPlayer();
////
////                // Request audio focus for playback
////                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
////                        // Use the music stream.
////                        AudioManager.STREAM_MUSIC,
////                        // Request permanent focus.
////                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);//short period of time
////
////                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
////
////                    // we have audio focus now
////
////
////                    // create and setup the media player for the audio resource assoiciated
////                    // with the current word.
////                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
////                    mMediaPlayer.start();
////
////                    // setup a listner on the media player, so that we can stop and release the
////                    // media player once the sound has finished playing.
////                    mMediaPlayer.setOnCompletionListener(mCompletionListner);
////                }
////            }
////
////        });
//    }
//
//    @Override
//    protected void onStop(){
//        super.onStop();
////        when the activity is stopped , release  the media player resources because we wont
////                be playing any more sounds.
//        releaseMediaPlayer();
//    }
//    /**
//     * Clean up the media player by releasing its resources.
//     */
//    private void releaseMediaPlayer() {
//        // If the media player is not null, then it may be currently playing a sound.
//        if (mMediaPlayer != null) {
//            // Regardless of the current state of the media player, release its resources
//            // because we no longer need it.
//            mMediaPlayer.release();
//
//            // Set the media player back to null. For our code, we've decided that
//            // setting the media player to null is an easy way to tell that the media player
//            // is not configured to play an audio file at the moment.
//            mMediaPlayer = null;
//
////            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
//        }
//    }
//}


//REPLACING FOR FRAGMENTS


public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new NumbersFragment())
                .commit();
    }
}