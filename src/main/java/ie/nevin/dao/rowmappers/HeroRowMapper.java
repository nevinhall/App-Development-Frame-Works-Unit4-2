package ie.nevin.dao.rowmappers;

import ie.nevin.classes.Hero;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HeroRowMapper implements RowMapper<Hero> {
    @Override
    public Hero mapRow(ResultSet resultSet, int i) throws SQLException {
        Hero hero = new Hero();
        hero.setHeroId(resultSet.getInt("heroId"));
        hero.setHeroName((resultSet.getString("heroName")));
        return hero;
    }
}
