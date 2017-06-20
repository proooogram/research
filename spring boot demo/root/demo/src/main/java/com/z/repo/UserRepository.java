package com.z.repo;

import com.z.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by agui on 2017/6/20.
 */
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<User> findAll(){
        return jdbcTemplate.query("select id, username, password, email from user", new UserRowMapper());
//        return null;
    }

    @Transactional(readOnly=true)
    public User findById(Integer userId){
        return jdbcTemplate.queryForObject("select id,username,password,email from user where id=?",
                new Object[userId], new UserRowMapper());
    }

//    @Transactional()
}

class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"));
    }
}
