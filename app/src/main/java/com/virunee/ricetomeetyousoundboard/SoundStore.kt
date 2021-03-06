package com.virunee.ricetomeetyousoundboard

import android.content.Context
import android.util.Log


object SoundStore {
    fun getAllSounds(context: Context): ArrayList<Sound> {

        val sounds: ArrayList<Sound> = ArrayList()

        var soundResources = context.resources
        var labels = soundResources.obtainTypedArray(R.array.labels)
        var resourceIds = soundResources.obtainTypedArray(R.array.ids)
        var category = soundResources.obtainTypedArray(R.array.category)

        for (i in 0 until labels.length()) {
            sounds.add(Sound(labels.getString(i)!!, category.getString(i)!!, resourceIds.getResourceId(i, -1)))
        }

        labels.recycle()
        resourceIds.recycle()

        return sounds
    }

//    fun getFavoriteSounds(context: Context): ArrayList<Sound> {
//        val res: Resources = context.applicationContext.resources
//        val labels: TypedArray = res.obtainTypedArray(R.array.labels)
//        val ids: TypedArray = res.obtainTypedArray(R.array.ids)
//        val sounds: ArrayList<Sound> = ArrayList()
//        for (i in 0 until labels.length()) {
//            val sound = Sound(labels.getString(i)!!, ids.getResourceId(i, -1))
//            if (sound.getFavorite()) {
//                sounds.add(sound)
//            }
//        }
//        labels.recycle()
//        ids.recycle()
//        return sounds
//    }
}