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
        System.out.println("Find Id = 3 " + heroService.findHero(3));

        System.out.println("Heros in Database are: " + heroService.findAllHeroes());

        System.out.println("Delte Id  " + heroService.deleteHero(1));
//        System.out.println("Find Id = 1 " + heroService.findHero(1));

        System.out.println("Nevin in Database " + heroService.exists("nevin"));

        System.out.println("Change domi to luke " + heroService.changeHeroName("luke","domi"));
        System.out.println("Change domi to luke " + heroService.changeHeroName("luke","domi"));
        System.out.println("Change luke to nevin " + heroService.changeHeroName("nevin","luke"));




    }


}
