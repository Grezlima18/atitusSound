package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.atitusound.entities.PlaylistEntity;
import br.edu.atitus.pooavancado.atitusound.entities.UserEntity;
import br.edu.atitus.pooavancado.atitusound.repositories.GenericRepository;
import br.edu.atitus.pooavancado.atitusound.repositories.PlaylistRepository;
import br.edu.atitus.pooavancado.atitusound.services.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	private final PlaylistRepository repository;
	
	public PlaylistServiceImpl(PlaylistRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public GenericRepository<PlaylistEntity> getRepository() {
		return repository;
	}

	@Override
	public void validate(PlaylistEntity entidade) throws Exception {
		PlaylistService.super.validate(entidade);
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		entidade.setUser(user);
	}

	@Override
	public Page<List<PlaylistEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name) throws Exception {
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return repository.findByNameContainsIgnoreCaseAndUserOrPublicshare(pageable, null, true, name);
	}
	
}
