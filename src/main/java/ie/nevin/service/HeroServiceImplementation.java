package ie.nevin.service;

import ie.nevin.classes.Hero;
import ie.nevin.dao.HeroDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImplementation implements HeroService {
    @Autowired
    HeroDao heroDao;


    @Override
    public int countTheHeroes() {
        return heroDao.getHeroCount();
    }

    @Override
    public Hero findHero(int heroId) {
        Hero returnedHero = heroDao.findHeroByHeroId(heroId);
        if (returnedHero == null) {
           System.out.println("There is no Hero with ID " + heroId + " in the database");
        }
        return returnedHero;
    }
}

