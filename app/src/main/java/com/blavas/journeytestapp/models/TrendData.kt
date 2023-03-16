package com.blavas.journeytestapp.models

class TrendData {
    var userId: String? = null
        get() = field
        set(value) {
            field = value
        }
    var id: String? = null
        get() = field
        set(value) {
            field = value
        }
    var title: String? = null
        get() = field
        set(value) {
            field = value
        }

    var body: String? = null
        get() = field
        set(value) {
            field = value
        }

    constructor(userId : String , id: String, title: String, body: String){
        this.userId = userId
        this.id = id
        this.title = title
        this.body = body
    }

}