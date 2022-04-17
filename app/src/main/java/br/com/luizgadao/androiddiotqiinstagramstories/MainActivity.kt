package br.com.luizgadao.androiddiotqiinstagramstories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import br.com.luizgadao.androiddiotqiinstagramstories.adapter.AdapterStories
import br.com.luizgadao.androiddiotqiinstagramstories.view.CubeTransformer

class MainActivity : AppCompatActivity() {

    private val viewPager : ViewPager2 by lazy {
        findViewById(R.id.view_pager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        viewPager.adapter = AdapterStories()
        viewPager.setPageTransformer(CubeTransformer())
    }
}