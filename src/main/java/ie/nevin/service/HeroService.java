package ie.nevin.service;

import ie.nevin.classes.Hero;

import java.util.List;

public interface HeroService {
    int countTheHeroes();
    Hero findHero(int heroId);
    List<Hero> findAllHeroes();

}
