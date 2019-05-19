package com.example.vickyyang.testdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.vickyyang.testdemo.utils.SPUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val ONE_DAY = 86400 * 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bootCount = SPUtils.getInt("BOOT_COUNT",0)

        val lastBootTime = SPUtils.getLong("BOOT_TIME",0)

        btn_submit.setOnClickListener {

          when{

              bootCount == 1 -> tv_show.setText("欢迎初次使用")

              (System.currentTimeMillis() - lastBootTime)  < ONE_DAY * 3 -> tv_show.setText("欢迎经常使用")

              (System.currentTimeMillis() - lastBootTime)  > ONE_DAY * 3 -> tv_show.setText("好久不见，欢迎再次使用")

          }

        }
    }
}
