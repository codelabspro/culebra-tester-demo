package culebrastore

class Product {
    String name
    String description
    Float price
    String status

    // add a static hasMany property
    // a Product can have many tags of type Tag
    static hasMany = [tags : Tag]
    // static hasOne = [suborder : Suborder]
    static belongsTo = Suborder
    // add static constraints property to specify constraints
    static constraints = {
        // name of the property, constraint name, value for the constraint
        // types including class names start with capital letter, rest camel-case
        // properties start with lower, rest camel-case
        // properties that you want to persist must have an explicit type
        name blank :  false, unique: true
        description  blank: false,  maxSize: 1000
        price nullable: true
        status inList: ["Available", "Unavailable"]


    }
    String toString() { return name }



}



