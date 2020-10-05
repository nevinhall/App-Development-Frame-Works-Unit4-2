package ie.nevin.service;

import ie.nevin.dao.HeroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImplementation implements HeroService{
    @Autowired
    HeroDao heroDao;


    @Override
    public int countTheHeroes() {
        return heroDao.getHeroCount();
    }
}
