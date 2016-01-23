class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "500"(view:'/error')

        // "/"(view:"/index")
        "/" (controller:  'product', action: 'list')
        "/admin" (view: "/index")
	}
}
