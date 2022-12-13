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
import pro.sky.telegrambot.controller.VolunteerController;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.repositories.VolunteerRepository;
import pro.sky.telegrambot.service.VolunteerService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = VolunteerController.class)
public class VolunteerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VolunteerRepository volunteerRepository;

    @SpyBean
    private VolunteerService volunteerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void addVolunteerTest() throws Exception {
        final String name = "newName";
        final long chatId = 24435242;
        final long id = 1;

        JSONObject volunteerObject = new JSONObject();
        volunteerObject.put("id", id);
        volunteerObject.put("name", name);
        volunteerObject.put("chatId", chatId);

        Volunteer volunteer = new Volunteer();
        volunteer.setChatId(chatId);
        volunteer.setName(name);
        volunteer.setId(id);

        when(volunteerRepository.save(any(Volunteer.class))).thenReturn(volunteer);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/volunteer")
                        .content(volunteerObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.chatId").value(chatId));
    }

    @Test
    public void getAllVolunteer() throws Exception {
        final String name = "newName";
        final long chatId = 24435242;
        final long id = 1;

        final String name1 = "name";
        final long chatId1 = 3543542;
        final long id1 = 2;

        Volunteer volunteer = new Volunteer(id, chatId, name);
        Volunteer volunteer1 = new Volunteer(id1, chatId1, name1);

        JSONObject volunteerObject = new JSONObject();
        volunteerObject.put("id", id);
        volunteerObject.put("name", name);
        volunteerObject.put("chatId", chatId);

        when(volunteerRepository.findAll()).thenReturn(List.of(volunteer, volunteer1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/volunteer/all_volunteer")
                        .content(volunteerObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(id))
                .andExpect(jsonPath("$[0].name").value(name))
                .andExpect(jsonPath("$[0].chatId").value(chatId))
                .andExpect(jsonPath("$[1].id").value(id1))
                .andExpect(jsonPath("$[1].name").value(name1))
                .andExpect(jsonPath("$[1].chatId").value(chatId1));
    }
}
