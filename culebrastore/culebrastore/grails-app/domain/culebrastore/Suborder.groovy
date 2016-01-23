package culebrastore

class Suborder {

    Integer suborderNumber
    Integer quantity
    // static hasOne = [product : Product]
    static belongsTo = CustomerOrder
    static constraints = {
        suborderNumber blank : false, unique: true
    }
}
