package ie.nevin.dao;

import ie.nevin.classes.Hero;
import ie.nevin.dao.rowmappers.HeroRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    @Override
    public int deleteHeroId(int heroId) {
        final String SQL = "DELETE FROM hero WHERE hero.heroId = ?";
        return jdbcTemplate.update(SQL, new Object[]{heroId});
    }

    @Override
    public int changeHeroName(String heroName, String oldName) {
        final String SQL = "UPDATE hero set hero.heroName = ? WHERE hero.heroName = ?";
        int res = jdbcTemplate.update(SQL, new Object[]{heroName, oldName});

        if (res == 0) {
            System.out.println("Failed to change the hero name, perhaps the hero didn't exist ?");
        }
        return res;
    }

    @Override
    public boolean exists(String heroName) {
        return 1 == jdbcTemplate.queryForObject("SELECT COUNT(1) FROM hero WHERE hero.heroName = ?", new Object[]{heroName}, Integer.class);
    }

    @Override
    public int addHero(final String heroName) {
        final String INSERT_SQL = "INSERT INTO hero(heroName) VALUES (?)";
        KeyHolder KeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                new PreparedStatementCreator() {

                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException
                    {
                        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] {"heroId"});
                        ps.setString(1, heroName);
                        return ps;
                    }
                }, KeyHolder);

        return KeyHolder.getKey().intValue();
    }


}
