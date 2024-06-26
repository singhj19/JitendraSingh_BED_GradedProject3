package com.g2b8.tta.g2b8_bed_gradedproject3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g2b8.tta.g2b8_bed_gradedproject3.model.Ticket;
import com.g2b8.tta.g2b8_bed_gradedproject3.repository.TicketRepository;
import com.g2b8.tta.g2b8_bed_gradedproject3.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	@Autowired
	public void setTicketRepository(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> list() {
		return ticketRepository.getTickets();
	}

	@Override
	public void save(Ticket ticket) {

		ticketRepository.saveTicket(ticket);
	}

	@Override
	public Ticket getById(long ticketId) {
		return ticketRepository.getTicket(ticketId);
	}

	@Override
	public void deleteById(long ticketId) {
		ticketRepository.deleteTicket(ticketId);
	}

	@Override
	public List<Ticket> searchByTitleOrDescription(String titleOrDescription) {
		List<Ticket> tickets = ticketRepository.findByTitleOrDescription(titleOrDescription);
		return tickets;
	}
}
