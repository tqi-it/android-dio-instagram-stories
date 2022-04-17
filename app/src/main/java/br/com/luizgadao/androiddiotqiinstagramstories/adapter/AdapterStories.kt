package br.com.luizgadao.androiddiotqiinstagramstories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.luizgadao.androiddiotqiinstagramstories.R
import br.com.luizgadao.androiddiotqiinstagramstories.data.Backgrounds

class AdapterStories : RecyclerView.Adapter<AdapterStories.ImageViewHolder>() {

    private val stories: List<Int> = Backgrounds().getListStories()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_picture, parent, false)

        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = stories.size

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val picture: AppCompatImageView by lazy {
            itemView.findViewById(R.id.iv_picture)
        }

        fun onBind(position: Int) {
            picture.setImageResource(stories[position])
        }
    }
}