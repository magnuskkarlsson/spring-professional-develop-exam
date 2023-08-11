package se.mkk.springprofessionaldevelopexam.section4testing.springboot;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import se.mkk.springprofessionaldevelopexam.section4testing.Person;
import se.mkk.springprofessionaldevelopexam.section4testing.PersonController;
import se.mkk.springprofessionaldevelopexam.section4testing.PersonService;

@WebMvcTest(PersonController.class) // only create beans relevant to PersonController.class
public class PersonControllerWebMvcTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonService personService;

    @Test
    public void findById() throws Exception {
        given(personService.findById(0)) //
                .willReturn(new Person().setId(0).setName("John"));

        String url = "/api/persons";
        mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON)) //
                .andDo(print()) //
                .andExpect(status().isOk()) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("id").value("0")) //
                .andExpect(jsonPath("name").value("John"));

        verify(personService.findById(0));
    }
}
