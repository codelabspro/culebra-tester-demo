package com.logicmpls

class BreadcrumbTagLib {

    static namespace = "crumbs"

    def trail = { attrs, body ->
        def model = [:]
        model.selector = attrs.selector ?: grailsApplication.config.breadcrumbs.selector
        model.selectors = attrs.selectors ?: grailsApplication.config.breadcrumbs.selectors
        model.js = attrs.js ? Boolean.valueOf(attrs.js) : true
        out << render(template: '/breadcrumbs/trail', model: model, plugin: 'breadcrumbs')
    }

    def resources = { attrs, body ->
        out << render(template: '/breadcrumbs/resources', plugin: 'breadcrumbs')
    }

    def crumbscript = { attrs, body ->
        def model = [:]
        model.selector = attrs.selector ?: grailsApplication.config.breadcrumbs.selector
        model.selectors = attrs.selectors ?: grailsApplication.config.breadcrumbs.selectors
        out << render(template: '/breadcrumbs/crumbscript', model: model, plugin: 'breadcrumbs')
    }

}
