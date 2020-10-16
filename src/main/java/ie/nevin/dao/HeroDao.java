package ie.nevin.dao;

import ie.nevin.classes.Hero;

public interface HeroDao {
    int getHeroCount();

    Hero findHeroByHeroId(int heroId);


}
