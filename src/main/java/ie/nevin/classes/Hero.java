package ie.nevin.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {
    public String HeroName;
    public int HeroId;

//    public void setHeroId(int heroId) {
//        HeroId = heroId;
//    }
//
//    public void setHeroName(String heroName) {
//        HeroName = heroName;
//    }
}
