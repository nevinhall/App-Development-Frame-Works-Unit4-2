package ie.nevin.service;

import ie.nevin.classes.Hero;

public interface HeroService {
    int countTheHeroes();
    Hero findHero(int heroId);

}
