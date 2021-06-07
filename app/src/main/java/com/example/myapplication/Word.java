package com.example.myapplication;

import android.content.Context;
import android.view.View;

import java.lang.reflect.Constructor;

/**
 * Displays text to the user.
 */
public class Word{
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

//    Constructor is used and should be named same as class name and has no return type
//   This constructor is used for phrases
    public Word(String defaultTranslation,String miwokTranslation,int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;

    }
//    This overloaded constructor is used for remainig.
    public Word(String defaultTranslation,String miwokTranslation,int imageResourceId,int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;

    }



//    Get the default  translation of the word
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    //    Get the Miwok  translation of the word
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

//    Retruns whether or not there is an image for this word.
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
// Retruns the audio resource Id of the word.
    public int getAudioResourceId(){return mAudioResourceId;};
}
