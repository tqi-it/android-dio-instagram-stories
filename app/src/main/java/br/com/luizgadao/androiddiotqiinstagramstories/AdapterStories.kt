package br.com.luizgadao.androiddiotqiinstagramstories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView

class AdapterStories : RecyclerView.Adapter<AdapterStories.ImageViewHolder>() {

    val backgrounds = listOf(
        R.drawable.wallpaper1,
        R.drawable.wallpaper2,
        R.drawable.wallpaper3,
        R.drawable.wallpaper4,
        R.drawable.wallpaper5,
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_picture, parent, false)

        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = backgrounds.size

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val picture: AppCompatImageView by lazy {
            itemView.findViewById(R.id.iv_picture)
        }

        fun onBind(position: Int) {


            picture.setImageResource(backgrounds[position])
        }
    }
}