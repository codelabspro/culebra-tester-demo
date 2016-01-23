package culebrastore


class Tag {
    String name
    String description
    // a tag can have many products
    static hasMany = [products : Product]
    static belongsTo = Product
    // add static constraints property
    static constraints = {
        name blank: false, unique: true
    }
    String toString() { return name }
}