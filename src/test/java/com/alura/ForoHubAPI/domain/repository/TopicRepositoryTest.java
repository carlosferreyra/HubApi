package com.alura.ForoHubAPI.domain.repository;

import com.alura.ForoHubAPI.domain.model.*;
import com.alura.ForoHubAPI.dto.user.RegisterUserDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class TopicRepositoryTest {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("should fail if user or course doesn't exist")
    void testTopicValidToSave() {

        var userDto = new RegisterUserDTO("juan", "juan.perez@gmail.com", "contrasena123", ProfileType.STUDENT);
        var user = new User(userDto);
        em.persist(user);


        var course = new Course(null, "Desarrollo Web", Category.FRONT_END);
        em.persist(course);

        // Crear un tópico referenciando al curso y usuario válidos
        Topic validTopic = new Topic();
        validTopic.setTitle("Introducción a HTML");
        validTopic.setMessage("¿Cómo crear una estructura básica en HTML?");
        validTopic.setUser(user);
        validTopic.setCourse(course);

        Topic invalidTopic = new Topic();
        invalidTopic.setTitle("Pregunta inválida");
        invalidTopic.setMessage("Mensaje sin contenido");
        invalidTopic.setUser(null); // Usuario inexistente
        invalidTopic.setCourse(course);

        // Guardar el tópico válido
        Topic validResult = topicRepository.save(validTopic);
        assertNotNull(validResult.getTopicId());

        // Guardar el tópico inválido (debería lanzar una excepción)
        assertThrows(DataIntegrityViolationException.class, () -> {
            topicRepository.save(invalidTopic);
        });
    }
}
