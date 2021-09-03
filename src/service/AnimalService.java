package service;

import javax.ejb.Stateless;

import model.Animal;

@Stateless
public class AnimalService extends GenericService<Animal> {
	public AnimalService() {
		super(Animal.class);
	}
}
