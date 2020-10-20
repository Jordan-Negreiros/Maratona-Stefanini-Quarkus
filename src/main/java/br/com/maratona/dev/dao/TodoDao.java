package br.com.maratona.dev.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import br.com.maratona.dev.dto.TaskDTO;
import br.com.maratona.dev.model.Task;

@RequestScoped
public class TodoDao {

	public List<?> listAll() {
		List<?> tasks = Task.listAll();
		return tasks;
	}
	
	public Optional<Task> getById(Long id) {
		Optional<Task> taskOp = Task.findByIdOptional(id);
		if (taskOp.isEmpty()) {
			throw new NotFoundException();
		}
		
		return taskOp;
	}
	
	@Transactional
	public void insert(TaskDTO dto) {
		try {
			Task.persist(dto);
			
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
	}
	
	@Transactional
	public void update(TaskDTO dto) {
		try {
			Task.update("description", dto.description);
			
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
	}
	
	@Transactional
	public void delete(Long id) {
		Optional<Task> taskOp = Task.findByIdOptional(id);
		taskOp.ifPresentOrElse(Task::delete, () -> {
			throw new NotFoundException();
		});
	}
}
