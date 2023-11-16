package br.edu.atitus.pooavancado.atitusound.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.edu.atitus.pooavancado.atitusound.entities.PlaylistEntity;
import br.edu.atitus.pooavancado.atitusound.entities.UserEntity;

@Repository
public interface PlaylistRepository extends GenericRepository<PlaylistEntity>{

	Page<List<PlaylistEntity>> findByNameContainsIgnoreCaseAndUserOrPublicshare(Pageable pageable, UserEntity user, boolean publicshare, String name);
	
}
