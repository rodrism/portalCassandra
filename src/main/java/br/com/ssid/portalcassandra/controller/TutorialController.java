package br.com.ssid.portalcassandra.controller;

import br.com.ssid.portalcassandra.model.Tutorial;
import br.com.ssid.portalcassandra.dao.TutorialRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TutorialController {

	@Autowired
	TutorialRepository tutorialRepository;

	/*
@GetMapping("/tutorials")
public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
  try {
    List<Tutorial> tutorials = new ArrayList<Tutorial>();

    if (title == null)
      tutorialRepository.findAll().forEach(tutorials::add);
    else
      tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

    if (tutorials.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(tutorials, HttpStatus.OK);
  } catch (Exception e) {
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
	 */

	@GetMapping("/tutorialsro")
	public ArrayList<Tutorial> getAllTutorial(@RequestParam(required = false) String title){
		ArrayList<Tutorial> _lista;
		_lista = (ArrayList<Tutorial>)tutorialRepository.findByTitleContaining(title);
		return _lista;
	}


	@PostMapping("/tutorialssite")
	public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
		try {
			Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getId(), tutorial.getTitle(), tutorial.getDescription(), false));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}


	@PostMapping("/tutorialsro")
	public ResponseEntity<Tutorial> createTutorial2(Tutorial tutorial){

		try {
			Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getId(), tutorial.getTitle(), tutorial.getDescription(), false));
			return ResponseEntity.ok(_tutorial);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();

		}


	}


}
