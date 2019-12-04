package com.example.dailyjournal

class EntryComponent {
    var entryDate: String? = null
    var eventList: List<String>? = null
    var entryReflect: String? = null

    constructor() : super () {}

    constructor(EntryDate: String, EntryReflect: String) : super() {
        this.entryDate = EntryDate
        this.entryReflect = EntryReflect
    }
}