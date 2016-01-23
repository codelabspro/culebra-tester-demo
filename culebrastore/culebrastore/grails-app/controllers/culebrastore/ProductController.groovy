package culebrastore

import grails.plugin.springsecurity.annotation.Secured

class ProductController {

    static scaffold = true


    // @Secured(['ROLE_USER'])
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def list() {
        def products = Product.findAllByStatus("Available", [sort: "name", order : "asc"])

        def suborders = Suborder.list(sort: "suborderNumber", order: "asc")

        def tags = Tag.list(sort: "name", order : "asc")

        String hello = printHelloWorld()

        return [products : products, tags : tags, hello: hello, suborders: suborders]
    }

    public String printHelloWorld() {
        return "Hello";

    }
    @Secured(['ROLE_USER'])
    def listfiltered() {
        def filteredproducts = Product.findAllByName("Celery", [sort: "name", order: "asc"])

            return [filteredproducts : filteredproducts]

    }
    @Secured(['ROLE_USER'])
    def showdetail(int id) {
        if (id == null) {
            redirect(action: 'list')
        }

        def product = Product.findById(id)

        [product : product]
    }


    def ajaxdetail(int id) {
        if (id == null) {
            redirect(action: 'ajaxdetail')
        }

        def product = Product.findById(id)

        [product : product]
    }
}


