package br.com.luizgadao.androiddiotqiinstagramstories.data

import br.com.luizgadao.androiddiotqiinstagramstories.R

data class Backgrounds(
   private val backgroundStories: List<Int> = listOf(
        R.drawable.wallpaper1,
        R.drawable.wallpaper2,
        R.drawable.wallpaper3,
        R.drawable.wallpaper4,
        R.drawable.wallpaper5,
    )
) {
    fun getListStories(): List<Int>{
        return backgroundStories
    }
}
