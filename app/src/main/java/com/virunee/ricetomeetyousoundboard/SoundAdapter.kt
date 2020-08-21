package com.virunee.ricetomeetyousoundboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.sound_item.view.*


class SoundAdapter(context: FragmentActivity?, sounds: ArrayList<Sound>, colourResource: Int) : ArrayAdapter<Sound>(
    context!!, colourResource, sounds) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Check if an existing view is being reused, otherwise inflate the view

        // Check if an existing view is being reused, otherwise inflate the view
        var soundItemView = convertView
        if (soundItemView == null) {
            soundItemView = LayoutInflater.from(context).inflate(
                R.layout.sound_item, parent, false
            )
        }

        val currentSound: Sound? = getItem(position)

        // get and set the title
        val titleTextView =
            soundItemView?.sound_item_title_text_view as TextView
        titleTextView.setText(currentSound?.getTitle())

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return soundItemView!!

    }
}