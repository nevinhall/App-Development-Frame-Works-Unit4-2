package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HeroDaoImolementation implements HeroDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int getHeroCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hero", Integer.class);
    }
}
