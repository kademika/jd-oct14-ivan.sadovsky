package day9.observerpattern;

public class ConcreteObserver implements Observer{

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(this.toString() + " notified.");
	}

}
