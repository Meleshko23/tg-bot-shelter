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
import pro.sky.telegrambot.service.InfoShelterService;


@ExtendWith(MockitoExtension.class)
public class InfoShelterServiceTest {
    @InjectMocks
    private InfoShelterService infoShelterService;

    @Mock
    private InfoRepository infoRepository;
    private Info info1;
    private Info info2;
    private Info info3;


    @BeforeEach
    public void setUp(){
        infoShelterService = new InfoShelterService(infoRepository);
        info1 = new Info("name", "details");
        info2 = new Info("name1", "details1");
        info3 = new Info("name2", "details2");
    }

    @Test
    public void sendInfoShelterTest(){
        Mockito.when(infoRepository.findInfoByName(info1.getName())).thenReturn(info1);
        Assertions.assertEquals(info1.getDetails(), infoShelterService.sendInfoShelter(info1.getName()));
    }

    @Test
    public void sendWorkTimeAddressMapTest(){
        Mockito.when(infoRepository.findInfoByName(info2.getName())).thenReturn(info2);
        Assertions.assertEquals(info2.getDetails(), infoShelterService.sendWorkTimeAddressMap(info2.getName()));
    }

    @Test
    public void sendShelterRulesTest(){
        Mockito.when(infoRepository.findInfoByName(info3.getName())).thenReturn(info3);
        Assertions.assertEquals(info3.getDetails(), infoShelterService.sendShelterRules(info3.getName()));
    }

    @Test
    public void sendSecurityContactsTest(){
        Mockito.when(infoRepository.findInfoByName(info3.getName())).thenReturn(info3);
        Assertions.assertEquals(info3.getDetails(), infoShelterService.sendSecurityContacts(info3.getName()));
    }

    @Test
    public void sendSafetyPrecautionsTest(){
        Mockito.when(infoRepository.findInfoByName(info2.getName())).thenReturn(info2);
        Assertions.assertEquals(info2.getDetails(), infoShelterService.sendSafetyPrecautions(info2.getName()));
    }
}
