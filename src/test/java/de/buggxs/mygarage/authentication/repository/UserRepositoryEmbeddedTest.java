package de.buggxs.mygarage.authentication.repository;

import de.buggxs.mygarage.authentication.user.User;
import de.buggxs.mygarage.authentication.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryEmbeddedTest {

    @Autowired
    private UserRepository underRepository;

    @BeforeEach
    void setUp() {
        underRepository.save(new User("admin", "admin@test.mail", "123456"));
    }

    @Test
    public void shouldFindUserByUsername() {
        Optional<User> test = underRepository.findByUsername("admin");
        assertThat(test).isNotEmpty();
    }

}
