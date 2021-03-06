package ie.nevin.service;

import ie.nevin.classes.Hero;
import ie.nevin.dao.HeroDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Hero> findAllHeroes() {
        return heroDao.findAllHeros();
    }

    @Override
    public int deleteHero(int heroId) {
        int res = heroDao.deleteHeroId(heroId);
        if(res == 0){
            System.out.println("There is no Hero with ID " + heroId + " in the database");
        }

        return res;
    }

    @Override
    public int changeHeroName(String heroName, String OldHeroName) {
        if(! heroDao.exists(OldHeroName)){
            System.out.println("There is no Hero with the Name " + OldHeroName + " in the database");
            return 0;
        }else if(heroDao.exists(heroName)){
            System.out.println("There is already a Hero with the Name " + heroName + " in the database");
            return 0;
        }else{
            return heroDao.changeHeroName(heroName, OldHeroName);
        }


    }

    @Override
    public boolean exists(String heroName) {
        return heroDao.exists(heroName);
    }

    @Override
    public Hero addHero(String heroName) {
        if (!exists(heroName)) {
            return heroDao.findHeroByHeroId(heroDao.addHero(heroName));
        }
        System.out.println("There is already a Hero with the Name " + heroName + " in the database");
        return null;
    }
}

