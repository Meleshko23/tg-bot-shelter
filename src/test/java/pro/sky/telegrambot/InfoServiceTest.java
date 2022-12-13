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
import pro.sky.telegrambot.service.InfoService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class InfoServiceTest {

    @InjectMocks
    private InfoService infoService;

    @Mock
    private InfoRepository infoRepository;
    private Info info1;
    private Info info2;

    private List<Info> infos = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        infoService = new InfoService(infoRepository);
        info1 = new Info("name", "details");
        info2 = new Info("name1", "details1");
        infos.add(info1);
        infos.add(info2);
    }

    @Test
    public void editInfoTest(){
        info1 = new Info("name1", "details");
        Assertions.assertEquals(info1, infoService.editInfo(info1));
    }

    @Test
    public void getAllInfoTest(){
        Mockito.when(infoRepository.findAll()).thenReturn(infos);
        Assertions.assertEquals(infos, infoService.getAllInfo());
    }
}
