class PrettyDateGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.1 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def author = "Seymour Cakes"
    def authorEmail = ""
    def title = "Make date object print out human-readable relative timestamp"
    def description = '''\\
    Make Date object support print out of relative timestamp in human readable format, similar to Rails' distance_of_time_in_words.
    Usage: def d = new Date()
           d.prettyDate()
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/PrettyDate+Plugin"

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional)
    }

    def doWithDynamicMethods = { ctx ->

        Date.metaClass.prettyDate = {
             def p = new com.ocpsoft.pretty.time.PrettyTime()   
             return p.format(delegate)
        }
        assert "moments ago" == (new Date()).prettyDate()
    
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
