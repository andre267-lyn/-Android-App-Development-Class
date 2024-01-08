package com.example.appdia4

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import kotlin.arrayOf as arrayOf1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        val SPLASH_SCREEN: Long = 5000

        val topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        val iv1: ImageView = findViewById(R.id.iv_1)
        val tv1: TextView = findViewById(R.id.tv_1)
        val tv2: TextView = findViewById(R.id.tv_2)


        val scaleX = ObjectAnimator.ofFloat(iv1, View.SCALE_X, 1.0f, 0.6f)
        val scaleY = ObjectAnimator.ofFloat(iv1, View.SCALE_Y, 1.0f, 0.6f)

        val fadeIn = ObjectAnimator.ofFloat(iv1, View.ALPHA, 0f, 1f)
        fadeIn.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleX, scaleY, fadeIn)
        animatorSet.startDelay = 100 // Delay sebelum memulai animasi
        animatorSet.duration = 1500 // Durasi keseluruhan animasi

        animatorSet.start()

        iv1.startAnimation(topAnim)
        tv1.startAnimation(bottomAnim)
        tv2.startAnimation(bottomAnim)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, LoginActivity::class.java)

            val pairs = arrayOf1(
                android.util.Pair<View, String>(iv1, "logo_image"),
                android.util.Pair<View, String>(tv1, "logo_text")
            )

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                val options = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity, *pairs)
                startActivity(intent, options.toBundle())
            } else {
                startActivity(intent)
            }
            finish()
        }, SPLASH_SCREEN)

    }
}