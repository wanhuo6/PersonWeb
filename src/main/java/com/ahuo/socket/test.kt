package com.ahuo.socket

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by ahuo on 17-5-16.
 */
object test {
    @JvmStatic fun main(args: Array<String>) {
        println("==" + System.currentTimeMillis())

        val formatter = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        val now = 1494925616347L
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = now
        println(now.toString() + " = " + formatter.format(calendar.time))
        var a=aaa
        a.hi("hihihi")
    }
}
