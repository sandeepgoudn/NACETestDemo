package com.accenture.nace;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.accenture.nace.model.NaceOrder;
import com.accenture.nace.repository.NaceRepository;
import com.accenture.nace.service.NaceService;

@SpringBootTest
class NaceApplicationTests {

	@Autowired
	private NaceService service;
	
	@MockBean
	private NaceRepository repository;
	
	@Test
	public void getOrdersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new NaceOrder(321,"Druv","23.7","tiuu","jhlhja","jhdifhaoih","jhflial","lkal","jlj","jlkgol"), new NaceOrder(327, "23","23.7","tiuu99","jhlhja","jhdhaoih","jhfliahjl","lkfal","jlj","jlkjaol")).collect(Collectors.toList()));
		assertEquals(2, service.getAllOrders().size());
	}
	
	@Test
	public void getOrdersByIDTest() {
		Integer id = 321;
		when(repository.findById(id)).thenReturn(Optional.of(new NaceOrder(321,"Druv","23.7","tiuu","jhlhja","jhdifhaoih","jhflial","lkal","jlj","jlkgol")));
		Optional<NaceOrder> optID= Optional.ofNullable(service.getNaceOrderByID(id));
		assertTrue(optID.isPresent());
		NaceOrder order = optID.get();
		assertEquals(321,order.getOrderid());
		assertEquals("Druv",order.getLevel());
		assertEquals("23.7",order.getCode());
		assertEquals("tiuu",order.getParent());
		assertEquals("jhlhja",order.getDescription());
		assertEquals("jhdifhaoih",order.getThisitemincludes());
		assertEquals("jhflial",order.getThisitemsalsoincludes());
		assertEquals("lkal",order.getRulings());
		assertEquals("jlj",order.getExcludes());
		assertEquals("jlkgol",order.getRev4());
	}
	
	@Test
	public void bookOrderTest() {
		NaceOrder order = new NaceOrder(551, "Karma", "Vidhatha", "fasfas", "12.3", "rvsao", "grg", "oiahl", "pill", "CRUD");
		when(repository.save(order)).thenReturn(order);
		assertEquals(order, service.saveOrder(order));
	}
	
	@Test
	public void updateBookOrder() {
		NaceOrder order = new NaceOrder(557, "Karma", "Vidhatha", "fasfas", "12.3", "rvsao", "grg", "oiahl", "pill", "CRUD");
		NaceOrder newOrder = new NaceOrder(557, "1", "1.2", "2A", "Grains", "kkk", "ppp", "ddd", "lll", "fff");
		NaceOrder existingOrder = repository.findById(order.getOrderid()).orElse(null);
		when(repository.findById(any())).thenReturn(Optional.of(null));
		if(existingOrder!=null) {
		existingOrder.setCode(newOrder.getCode());
		existingOrder.setDescription(newOrder.getDescription());
		existingOrder.setLevel(newOrder.getLevel());
		existingOrder.setParent(newOrder.getParent());
		existingOrder.setThisitemincludes(newOrder.getThisitemincludes());
		existingOrder.setThisitemsalsoincludes(newOrder.getThisitemsalsoincludes());
		existingOrder.setExcludes(newOrder.getExcludes());
		existingOrder.setRev4(newOrder.getRev4());
		existingOrder.setRulings(newOrder.getRulings());
		when(repository.save(existingOrder)).thenReturn(newOrder);
		assertEquals(newOrder, existingOrder);
		}
		
	}


}
