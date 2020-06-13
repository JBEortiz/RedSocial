package com.meetpix.backend.red.social;

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
public class MensajeEventoTest {
	@Autowired
	MockMvc mock;

	@Test
	void getMensajeEvento() throws Exception {
		mock.perform(get("/api/eventos/mensajeEvent")).andDo(print());
	}

	@Test
	void postMensajeEvento() throws Exception {
		mock.perform(post("/api/eventos//mensajeEvent").contentType(MediaType.APPLICATION_JSON)
				.content("{\"cuerpo\": \"barcelona\",\"nombre\":barcelona\"}")).andDo(print());
	}

	@Test
	void putAcociarMensajeEvento() throws Exception {
		mock.perform(put("/api/eventos/asociarMensajeEvento/9/27")).andDo(print());
	}

	@Test
	void putDeleteMensajeEvento() throws Exception {
		mock.perform(put("/api/eventos/deleteMensajeEvento/9/28")).andDo(print());
	}

}
