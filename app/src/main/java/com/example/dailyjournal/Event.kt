package com.example.dailyjournal

import java.io.Serializable
import java.util.*

class Event : Serializable {

    var title : String = ""
    var location : String = ""
    var date : String = ""
    var startTime : String = ""
    var endTime : String = ""

    fun Name(n : String) {
        this.title = n
    }

    fun Location(n : String) {
        this.location = n
    }

    fun Date(n : String) {
        this.date = n
    }

    fun StartTime(n : String) {
        this.startTime = n
    }

    fun EndTime(n : String) {
        this.endTime = n
    }
}