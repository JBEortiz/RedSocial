package com.meetpix.backend.red.social;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class EventoTest {

	@Autowired
	MockMvc mock;

	@Test
	void postEvento() throws Exception {
		mock.perform(post("/api/eventos/eventos/create").contentType(MediaType.APPLICATION_JSON)
				.content("{\"descripcion\": \"madrid\",\"direccion\":madrid,\"nombre\":\"viaje a madrir\"}"))
				.andDo(print());
	}

	@Test
	void putEvento() throws Exception {
		mock.perform(put("/api/eventos/eventos/9").contentType(MediaType.APPLICATION_JSON)
				.content("{\"descripcion\": \"barcelona\",\"direccion\":barcelona,\"nombre\":\"viaje a madrir\"}"))
				.andDo(print());
	}

	@Test
	void deleteEvento() throws Exception {
		mock.perform(delete("/api/eventos/eventos/7")).andDo(print());
	}

	@Test
	void getEvento() throws Exception {
		mock.perform(get("/api/eventos")).andDo(print());
	}

	@Test
	void getEventoById() throws Exception {
		mock.perform(get("/api/eventos/9")).andDo(print());
	}

	@Test
	void getDtoEvento() throws Exception {
		mock.perform(get("/api/eventos/eventos")).andDo(print());
	}
}
