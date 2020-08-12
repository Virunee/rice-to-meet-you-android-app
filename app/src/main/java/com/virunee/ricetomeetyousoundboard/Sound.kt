package com.virunee.ricetomeetyousoundboard;

/**
 * {@link Sound} represents a sound bite
 * It contains the title of the sound bite and a description
 */
public class Sound(title: String, description: String, audioResourceId: Int) {

    /** title for the sound */
    private var mTitle: String = title

    /** description of the sound */
    private var mDescription: String = description

    private var mAudioFile: Int = audioResourceId

//    fun Sound(title: String, description: String) {
//        mTitle = title
//        mDescription = description
//    }

    fun getTitle() : String {
        return mTitle
    }

    fun getDescription() : String {
        return mDescription
    }

    fun getAudioResource(): Int {
        return mAudioFile
    }


}
