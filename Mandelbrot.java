public class Mandelbrot {

	public static void main(String[] args) {
		MandelbrotGUI gui = new MandelbrotGUI();
		Generator generator = new Generator();
		boolean zooming = false;
		while(true){
			
			switch(gui.getCommand()){
				
				case MandelbrotGUI.RENDER:
					zooming = true;
					generator.render(gui);
					break;
				case MandelbrotGUI.RESET:
					zooming = false;
					gui.resetPlane();
					gui.clearPlane();
					break;
				case  MandelbrotGUI.QUIT:
					System.exit(0);
					break;
				case MandelbrotGUI.ZOOM:
			        if (zooming) generator.render(gui);
			        break;
			}
		}

	}

}
