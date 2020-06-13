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
public class MensajePerfilTest {

	@Autowired
	MockMvc mock;

	@Test
	void getMensajePerfil() throws Exception {
		mock.perform(get("/api/miperfil/mensajes")).andDo(print());
	}

	@Test
	void postMensajePerfil() throws Exception {
		mock.perform(post("/api/miperfil/mensaje").contentType(MediaType.APPLICATION_JSON)
				.content("{\"cuerpo\": \"barcelona\",\"nombre\":barcelona\"}")).andDo(print());
	}

	@Test
	void putAcociarMensajePerfil() throws Exception {
		mock.perform(put("/api/miperfil/mensajeCreate/3/22")).andDo(print());
	}

	@Test
	void putDeleteMensajePerfil() throws Exception {
		mock.perform(put("/api/miperfil/mensajeDelete/3/17")).andDo(print());
	}

	@Test
	void deleteMensajePerfil() throws Exception {
		mock.perform(delete("/api/miperfil/18")).andDo(print());
	}

}
