package stockmanager.task.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author ali
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StockManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSymbolPath() {

        try {
            this.mockMvc.perform(get("/stock/GOOG"))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.symbol").value("GOOG"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUserIdPath() throws Exception {

        this.mockMvc.perform(get("/stock/user/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));
    }
}
