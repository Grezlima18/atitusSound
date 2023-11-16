package br.edu.atitus.pooavancado.atitusound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.atitusound.entities.PlaylistEntity;
import br.edu.atitus.pooavancado.atitusound.entities.dtos.PlaylistDTO;
import br.edu.atitus.pooavancado.atitusound.services.GenericService;
import br.edu.atitus.pooavancado.atitusound.services.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController extends GenericController<PlaylistEntity, PlaylistDTO>{

	private final PlaylistService service;
	
	public PlaylistController(PlaylistService service) {
		super();
		this.service = service;
	}

	@Override
	GenericService<PlaylistEntity> getService() {
		return service;
	}

	@Override
	PlaylistEntity convertDTO2Entity(PlaylistDTO dto) {
		PlaylistEntity playlist = new PlaylistEntity();
		playlist.setName(dto.getName());
		playlist.setPublic_share(dto.getPublic_share());
		return playlist;
	}

	
}
