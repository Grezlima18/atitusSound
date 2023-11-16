package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.atitusound.entities.MusicEntity;
import br.edu.atitus.pooavancado.atitusound.repositories.GenericRepository;
import br.edu.atitus.pooavancado.atitusound.repositories.MusicRepository;
import br.edu.atitus.pooavancado.atitusound.services.MusicService;

@Service
public class MusicServiceImpl implements MusicService{

	private final MusicRepository repository;
		
	public MusicServiceImpl(MusicRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public GenericRepository<MusicEntity> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
