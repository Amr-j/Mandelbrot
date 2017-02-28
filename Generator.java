import java.awt.Color;
public class Generator {
	private Color[] colors;
	
	public Generator(){
		colors = new Color[200];
		for (int j = 0; j < 200; j++){
			if (j < 20) colors[j] = Color.red;
			if (j >= 20 && j < 40) colors[j] = Color.orange;
			if (j >= 40 && j < 60) colors[j] = Color.magenta;
			if (j >= 60 && j < 80) colors[j] = Color.blue;
			if (j >= 80 && j < 100) colors[j] = Color.cyan;
			if (j >= 100 && j < 120) colors[j] = Color.green;
			if (j >= 120 && j < 140) colors[j] = Color.gray;
			if (j >= 140 && j < 160) colors[j] = Color.darkGray;
			if (j >= 160 && j < 180) colors[j] = Color.lightGray;
			if (j >= 180 && j < 200) colors[j] = Color.yellow;
		}
	}
	
	public void render(MandelbrotGUI gui){
		gui.disableInput();
		Complex[][] complex = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
								   gui.getMinimumImag(), gui.getMaximumImag(),
								   gui.getWidth(), gui.getHeight());
		int res = 1;
		switch(gui.getResolution()){
		case MandelbrotGUI.RESOLUTION_HIGH:
			res = 3;
		    break;
		case MandelbrotGUI.RESOLUTION_MEDIUM:
		    res = 5;
		    break;
		case MandelbrotGUI.RESOLUTION_LOW:
		    res = 7;
		    break;
		 case MandelbrotGUI.RESOLUTION_VERY_LOW:
		    res = 9;
		    break;
		}
		Color[][] picture = new Color[gui.getHeight()/res][gui.getWidth()/res];
		
		for (int i = 0; i < gui.getHeight()/res; i++) {
			for (int j = 0; j < gui.getWidth()/res; j++) {
				Complex c = complex[i*res+(res/2)][j*res+(res/2)];
				Complex z = new Complex(0,0);
				int iterations = 0;
				while (iterations < 200 && z.getAbs2() <= 4 ){
					iterations++;
					z.mul(z);
					z.add(c);					
				}
				
				switch(gui.getMode()){
				case MandelbrotGUI.MODE_BW:
					if (iterations < 200){
						picture[i][j] = Color.WHITE;
					} else { 
						picture[i][j] = Color.BLACK;
					}
					break;
				case MandelbrotGUI.MODE_COLOR:
					if (iterations < 200){
						picture[i][j] = colors[iterations];
					} else { 
						picture[i][j] = Color.BLACK;
					}
					break;
				
				}
				
				
			}
		}
		gui.putData(picture, res, res);
		gui.enableInput();
	}
	
	
	
	private Complex[][] mesh(double minRe, double maxRe,
			                 double minIm, double maxIm,
		                     int width, int height){
		
		Complex[][] temp = new Complex[height][width];
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++){
				double recoord = minRe + (-minRe + maxRe) / (width - 1) * j;
				double imcoord = maxIm - (-minIm + maxIm) / (height - 1) * i;
				temp[i][j] = new Complex(recoord, imcoord);
			}
		}
		return temp;
	}

}
