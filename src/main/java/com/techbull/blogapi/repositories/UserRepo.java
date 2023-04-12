package com.techbull.blogapi.repositories;

import com.techbull.blogapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    /*
        When we use the @Autowired annotation on a repository interface in our service layer, Spring will automatically generate an implementation of that
        interface and inject it into our service. This is possible because Spring Data JPA uses dynamic proxy classes to generate implementations of our
        repository interfaces at runtime.


        The implementation of the repository interface that Spring generates will include all the necessary logic to interact with the database.
        This includes generating SQL statements, executing queries, and mapping the results back to our entity objects.


        So when we @Autowire a repository interface in our service layer, we are actually getting an instance of a dynamically generated class that
        implements that interface. This class provides all the necessary functionality to interact with the database and perform CRUD operations on our entities.

    */
}
