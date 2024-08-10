package org.example.demo1.repository;

import org.example.demo1.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository implements BaseRepo<User>{


    private NamedParameterJdbcTemplate template;
    private PasswordEncoder passwordEncoder;
    private RowMapper<User> rowMapper =  (rs, rowNum) ->{
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String role = rs.getString("role");
        return User.builder().id(id).name(name).username(username).password(password).roles(role).build();
    };
    private BeanPropertyRowMapper<User> autoMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserRepository(NamedParameterJdbcTemplate template, PasswordEncoder passwordEncoder) {
        this.template = template;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUsername(String username) {
        String query =  "select * from users where username = :username limit 1";
        try {
            User user = template.queryForObject(query, Map.of("username", username), rowMapper);
            return Optional.ofNullable(user);
        }catch (Exception e){
            return Optional.empty();
        }
    }


    @Override
    public Integer save(User user) {
        String query =  "insert into users(name,username) values(:name,:username) returning id,name";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource source = new MapSqlParameterSource()
                .addValue("name",user.getName())
                .addValue("username",user.getUsername());

        template.update(query,source, keyHolder,new String[]{"id","name"});
        return  (Integer)(keyHolder.getKeys().get("id"));
    }

    @Override
    public User get(Integer id) {
        String query =  "select * from users where id = :id limit 1";
        User user = template.queryForObject(query,Map.of("id",id), autoMapper);
        return user;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
