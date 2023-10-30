package dev.ifrs.service;

import java.util.Date;
import java.util.List;

import dev.ifrs.dto.UserDto;
import dev.ifrs.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class UserService {
    EntityManager em;
 
    public List<User> findAll() {
        return em.createQuery("select * from tab_usuario u", User.class).getResultList();
    }
 
    public Long create(UserDto userDto) {
        User user = new User();
        user.setNome(userDto.getNome());
        user.setSobrenome(userDto.getSobrenome());
        user.setData_nasc(userDto.getData_nasc());
        user.setEmail(userDto.getEmail());
        user.setSenha(userDto.getSenha());
        em.persist(user);
 
        return user.getId();
    }
 
}
