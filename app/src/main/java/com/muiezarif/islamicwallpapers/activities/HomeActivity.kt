package com.muiezarif.islamicwallpapers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.muiezarif.islamicwallpapers.R
import com.muiezarif.islamicwallpapers.adapters.StaggeredRecyclerAdapter
import com.muiezarif.islamicwallpapers.databinding.ActivityHomeBinding
import com.muiezarif.islamicwallpapers.utils.AdHelper

class HomeActivity : AppCompatActivity(), StaggeredRecyclerAdapter.WallpaperViewClickListener {
    private lateinit var binding:ActivityHomeBinding
    private lateinit var adapter: StaggeredRecyclerAdapter
    private var layoutManager: StaggeredGridLayoutManager? = null
    private var imageList= arrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12,R.drawable.img13,R.drawable.img14,R.drawable.img15)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home)
        layoutManager= StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        adapter= StaggeredRecyclerAdapter(this,imageList,this)
        binding.rvWallpapers.layoutManager=layoutManager
        binding.rvWallpapers.adapter=adapter
        AdHelper.loadBannerAd(binding.adView)
        AdHelper.loadInterstitialAd(this,"ca-app-pub-7701765309854052/2901061862")
    }

    override fun onClick(view: View?, position: Int, data: Int) {
        var intent= Intent(this@HomeActivity,ImageDisplayActivity::class.java)
        intent.putExtra("imageData",data)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onResume() {
        super.onResume()
        AdHelper.showInterstitialAd()
    }

    override fun onStop() {
        super.onStop()
        AdHelper.reloadInterstitialAd()
    }
}
