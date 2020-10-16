package ie.nevin.dao;

import ie.nevin.classes.Hero;

import java.util.List;

public interface HeroDao {
    int getHeroCount();

    Hero findHeroByHeroId(int heroId);

    List<Hero> findAllHeros();


}
