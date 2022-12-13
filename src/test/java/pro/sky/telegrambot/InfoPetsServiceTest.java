package pro.sky.telegrambot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.telegrambot.model.Info;
import pro.sky.telegrambot.repositories.InfoRepository;
import pro.sky.telegrambot.service.InfoPetsService;

@ExtendWith(MockitoExtension.class)
public class InfoPetsServiceTest {

    @InjectMocks
    private InfoPetsService infoPetsService;

    @Mock
    private InfoRepository infoRepository;
    private Info info1;
    private Info info2;
    private Info info3;


    @BeforeEach
    public void setUp(){
        infoPetsService = new InfoPetsService(infoRepository);
        info1 = new Info("name", "details");
        info2 = new Info("name1", "details1");
        info3 = new Info("name2", "details2");
    }

    @Test
    public void datingRulesTest(){
        Mockito.when(infoRepository.findInfoByName(info1.getName())).thenReturn(info1);
        Assertions.assertEquals(info1.getDetails(), infoPetsService.datingRules(info1.getName()));
    }

    @Test
    public void documentsListTest(){
        Mockito.when(infoRepository.findInfoByName(info1.getName())).thenReturn(info1);
        Assertions.assertEquals(info1.getDetails(), infoPetsService.documentsList(info1.getName()));
    }

    @Test
    public void transportRecommendationTest(){
        Mockito.when(infoRepository.findInfoByName(info1.getName())).thenReturn(info1);
        Assertions.assertEquals(info1.getDetails(), infoPetsService.transportRecommendation(info1.getName()));
    }

    @Test
    public void homeImprovementPuppyOrKittenTest(){
        Mockito.when(infoRepository.findInfoByName(info1.getName())).thenReturn(info1);
        Assertions.assertEquals(info1.getDetails(), infoPetsService.homeImprovementPuppyOrKitten(info1.getName()));
    }

    @Test
    public void homeImprovementDogOrCatTest(){
        Mockito.when(infoRepository.findInfoByName(info1.getName())).thenReturn(info1);
        Assertions.assertEquals(info1.getDetails(), infoPetsService.homeImprovementDogOrCat(info1.getName()));
    }

    @Test
    public void homeImprovementDisabledDogTest(){
        Mockito.when(infoRepository.findInfoByName(info1.getName())).thenReturn(info1);
        Assertions.assertEquals(info1.getDetails(), infoPetsService.homeImprovementDisabledDog(info1.getName()));
    }

    @Test
    public void cynolistTipsTest(){
        Mockito.when(infoRepository.findInfoByName(info1.getName())).thenReturn(info1);
        Assertions.assertEquals(info1.getDetails(), infoPetsService.cynolistTips(info1.getName()));
    }

    @Test
    public void cynolistListTest(){
        Mockito.when(infoRepository.findInfoByName(info1.getName())).thenReturn(info1);
        Assertions.assertEquals(info1.getDetails(), infoPetsService.cynolistList(info1.getName()));
    }

    @Test
    public void bounceListTest(){
        Mockito.when(infoRepository.findInfoByName(info1.getName())).thenReturn(info1);
        Assertions.assertEquals(info1.getDetails(), infoPetsService.bounceList(info1.getName()));
    }
}
