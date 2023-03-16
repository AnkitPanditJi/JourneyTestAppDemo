package com.blavas.journeytestapp.models

class CommentDataItems {
    var postId: String? = null
        get() = field
        set(value) {
            field = value
        }
    var id: String? = null
        get() = field
        set(value) {
            field = value
        }
    var name: String? = null
        get() = field
        set(value) {
            field = value
        }

    var email: String? = null
        get() = field
        set(value) {
            field = value
        }

    var body: String? = null
        get() = field
        set(value) {
            field = value
        }


    constructor(postId : String, id: String, name: String, email: String, body: String){
        this.postId = postId
        this.id = id
        this.name = name
        this.email = email
        this.body = body
    }

}