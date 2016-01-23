package culebrastore

class CustomerOrder {

    Integer number

    static hasMany = [suborders : Suborder]

    static constraints = {
    }
}
