package ie.nevin.dao;

import ie.nevin.classes.Hero;

import java.util.List;

public interface HeroDao {
    int getHeroCount();

    Hero findHeroByHeroId(int heroId);

    List<Hero> findAllHeros();

     int deleteHeroId(int heroId);

    int changeHeroName(String heroName, String oldName);

    boolean exists(String heroName);

    int addHero(final String heroName);


}
