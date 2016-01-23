package culebrastore

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class PublicController {

    def index() { render('public')}
}
