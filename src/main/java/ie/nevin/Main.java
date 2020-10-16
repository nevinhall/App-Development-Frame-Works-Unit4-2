package ie.nevin;

import ie.nevin.service.HeroService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HeroService heroService = (HeroService) context.getBean("heroServiceImplementation");
        System.out.println("There are " + heroService.countTheHeroes() + " in the database");

        System.out.println("Find Id = 1 " + heroService.findHero(1));
        System.out.println("Find Id = 1 " + heroService.findHero(3));

        System.out.println("Heros in Database are: " + heroService.findAllHeroes());

        
    }


}
