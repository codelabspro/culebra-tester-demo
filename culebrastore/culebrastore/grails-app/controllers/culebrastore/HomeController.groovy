package culebrastore

import grails.plugin.springsecurity.annotation.Secured

// Annotation to ensure that it is a protected resource
@Secured(['ROLE_USER'])
class HomeController {

    def index() {render 'home'}


    @Secured(['ROLE_ADMIN'])
    def adminOnly() { render 'admin'}
}
