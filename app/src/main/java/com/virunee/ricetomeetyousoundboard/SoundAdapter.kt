package com.virunee.ricetomeetyousoundboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.sound_item.view.*


class SoundAdapter(context: Context, sounds: ArrayList<Sound>, colourResource: Int) : ArrayAdapter<Sound>(context, colourResource, sounds) {

    /** Resource ID for the background color for this list of words  */
    private var mColorResourceId = colourResource

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

        // get and set the description
        val descriptionTextView =
            soundItemView?.sound_item_description_text_view as TextView
        descriptionTextView.setText(currentSound?.getDescription())

        // Set the theme color for the list item
        val textContainer =
            soundItemView!!.sound_item_container
        // Find the color that the resource ID maps to
        val color = context.resources.getColor(mColorResourceId)
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color)


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return soundItemView!!

    }
}