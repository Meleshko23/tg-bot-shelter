package pro.sky.telegrambot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pro.sky.telegrambot.controller.InfoController;
import pro.sky.telegrambot.model.Info;
import pro.sky.telegrambot.repositories.InfoRepository;
import pro.sky.telegrambot.service.InfoService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = InfoController.class)
public class InfoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InfoRepository infoRepository;

    @SpyBean
    private InfoService infoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void editInfoTest() throws Exception {
            final String name = "name";
            final String details = "details1";

            JSONObject infoObject = new JSONObject();
            infoObject.put("name", name);
            infoObject.put("details", details);

            Info info = new Info();
            info.setName(name);
            info.setDetails(details);

            when(infoRepository.save(any(Info.class))).thenReturn(info);
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/info")
                            .content(infoObject.toString())
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value(name))
                    .andExpect(jsonPath("$.details").value(details));
        }

    @Test
    public void getAllInfoTest() throws Exception {
        final String name = "name";
        final String details = "details";

        final String name1 = "name1";
        final String details1 = "details1";
        Info info = new Info(name, details);
        Info info1 = new Info(name1, details1);

        JSONObject infoObject = new JSONObject();
        infoObject.put("name", name);
        infoObject.put("details", details);

        when(infoRepository.findAll()).thenReturn(List.of(info, info1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/info/all_info")
                        .content(infoObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
