package ie.nevin.dao;

import ie.nevin.classes.Hero;
import ie.nevin.dao.rowmappers.HeroRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroDaoImolementation implements HeroDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int getHeroCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hero", Integer.class);
    }

    @Override
    public Hero findHeroByHeroId(int heroId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM hero WHERE hero.heroId = ?", new Object[]{heroId}, new HeroRowMapper());
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Hero> findAllHeros() {
        try {
            return jdbcTemplate.query("SELECT * FROM hero ", new HeroRowMapper());
        } catch (Exception e) {
            return null;
        }
    }


}
