package ie.nevin.service;

import ie.nevin.classes.Hero;

import java.util.List;

public interface HeroService {
    int countTheHeroes();

    Hero findHero(int heroId);

    List<Hero> findAllHeroes();

    int deleteHero(int heroId);

    int changeHeroName(String heroName, String OldHeroName);

    boolean exists(String heroName);




}
