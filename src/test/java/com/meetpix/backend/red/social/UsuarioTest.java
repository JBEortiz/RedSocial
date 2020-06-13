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
public class UsuarioTest {

	@Autowired
	MockMvc mock;

	@Test
	void getAllUsuario() throws Exception {
		mock.perform(get("/api/miperfil")).andDo(print());
	}

	@Test
	void getAllUsuarioNombre() throws Exception {
		mock.perform(get("/api/miperfil//miperfil/ordernombre")).andDo(print());
	}

	@Test
	void getAllUsuarioEdad() throws Exception {
		mock.perform(get("/api/miperfil/miperfil/orderedad")).andDo(print());
	}

	@Test
	void getUsuarioById() throws Exception {
		mock.perform(get("/api/miperfil/11")).andDo(print());
	}

	@Test
	void getUsuarioAllDTO() throws Exception {
		mock.perform(get("/api/miperfil/redcontactos")).andDo(print());
	}

	@Test
	void postUsuario() throws Exception {
		mock.perform(post("/api/miperfil/home").contentType(MediaType.APPLICATION_JSON).content(
				"{\"apellido\": \"barcelona\",\"ciudad\":barcelona,\"descripcion\": \"me gusta programar,\"edad\":\"40,\"apellido\": \"manolo,\"nombre\":pepe,\"trabajo\": \"circo\"avatar\":photo\"}"))
				.andDo(print());
	}

	@Test
	void putUsuario() throws Exception {
		mock.perform(put("/api/miperfil/miperfil/12").contentType(MediaType.APPLICATION_JSON)
				.content("{\"ciudad\":barcelona,\"descripcion\": \"me gusta programar,\"trabajo\": \"circo\"}"))
				.andDo(print());
	}

	@Test
	void deleteUsuario() throws Exception {
		mock.perform(delete("/api/miperfil/miperfil/7")).andDo(print());
	}
}
