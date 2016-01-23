import culebrastore.Product
import culebrastore.Role
import culebrastore.Tag
import culebrastore.User
import culebrastore.UserRole

class BootStrap {

    def init = { servletContext ->
        def tag1 = new Tag(name: 'GUI', description: 'GUI application').save()
        def tag2 = new Tag(name: 'CLI', description: 'CLI application').save()

        def product1 = new Product(name: 'Culebra GUI', description: 'Culebra GUI ', status: "Available")
        // TODO Figure out why this doesn't work
        // product1.addToTags(tag : tag1)
        product1.save()


        def product2 = new Product(name: 'Culebra Tester', description: 'Culebra Tester ', status: "Available")
        // product2.addToTags(tag : tag2)
        product2.save()

        def product3 = new Product(name: 'AndroidViewClient', description: 'AndroidViewClient', status: "Available")
        // product3.addToTags(tag : tag2)
        product3.save()

        // def order1 = new Order(orderNumber: 1, createdDate: new Date()).save()
        // def order2 = new Order(orderNumber: 2, createdDate: new Date()).save()
        // def order3 = new Order(orderNumber: 3, createdDate: new Date()).save()


        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)


        def user1 = User.findByUsername('guest') ?: new User(username: 'guest', enabled: true, password: 'password', firstName : 'Guest', lastName: 'User')
        user1.save(failOnError: true)
        if (!user1.authorities.contains(userRole)) {
            UserRole.create user1, userRole, true
        }

        def user2 = User.findByUsername('admin') ?: new User(username: 'admin', enabled: true, password: 'password', firstName : 'Admin', lastName: 'User')
        user2.save(failOnError: true)
        if (!user2.authorities.contains(userRole)) {
            UserRole.create user2, userRole, true
        }

        if (!user2.authorities.contains(adminRole)) {
            UserRole.create user2, adminRole, true
        }


        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 3

    }
    def destroy = {
    }
}





