package com.kuzudisli.domain.entities

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

open class User : RealmObject {
    @PrimaryKey var _id: ObjectId = ObjectId()
    var first_name: String = ""
    var last_name: String = ""
    var phone_number: String? = null
    var address: String? = null
    var email: String = ""
    var password: String = ""
}