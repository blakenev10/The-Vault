package viewsAndControllers;

public class Driver {

	public static void main(String[] args) {
		
		MainViewController vc 	= new MainViewController();
		MainView v				= new MainView(vc);
		vc.setView(v);
	}

}
