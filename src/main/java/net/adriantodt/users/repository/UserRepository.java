package net.adriantodt.users.repository;

import net.adriantodt.users.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>, QuerydslPredicateExecutor<User> {
    User findByEmail(String email);
}
