package com.example.dailyjournal

class EntryInfo {
    var entryWriter: String? = null
    var entryList: List<EntryComponent>? = null

    constructor() : super () {}

    constructor(EntryWriter:String, EntryList: List<EntryComponent>) : super() {
        this.entryWriter = EntryWriter
        this.entryList = EntryList
    }
}