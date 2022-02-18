package lv.kalashnikov.insurance.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.kalashnikov.insurance.core.domain.Entity;
import lv.kalashnikov.insurance.core.domain.Item;
import lv.kalashnikov.insurance.core.domain.Policy;
import lv.kalashnikov.insurance.core.domain.RiskType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CalculatorController.class)
@ContextConfiguration(classes = {SpringWebConfig.class})
public class CalculatorControllerTest {

    @Autowired private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void postRequestIsSuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/calculator/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getCorrectPolicy()))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2.28")));
    }

    @Test
    public void postRequestIsFailed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/calculator/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getErroneousPolicy()))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    private static Policy getCorrectPolicy() {
        Item item1 = new Item("Item1", 100, RiskType.FIRE);
        Item item2 = new Item("Item2", 8, RiskType.THEFT);
        List<Item> list1 = List.of(item1, item2);
        Entity entity1 = new Entity("Home1", list1);
        List<Entity> entities = List.of(entity1);
        return new Policy("1", true, entities);
    }

    private static Policy getErroneousPolicy() {
        Item item1 = new Item("Item1", -100, RiskType.FIRE);
        Item item2 = new Item("Item2", 8, RiskType.THEFT);
        List<Item> list1 = List.of(item1, item2);
        Entity entity1 = new Entity("Home1", list1);
        List<Entity> entities = List.of(entity1);
        return new Policy("1", true, entities);
    }

}