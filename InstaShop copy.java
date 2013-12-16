import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// @author Stephen Grinich
// Written for cs257 Final Project

// An Image Editor presented as a GUI that allows of a user to load an image, apply an effect to the image, and then name and export the image. 
// Images are saved to same directory as InstaShop.java. 

public class InstaShop extends JFrame {
	
	// Initializes variables, buttons, JPanel, JFrame, and JLabel
	static String filename; 
	boolean sepia; 
    boolean blush;
    boolean bw; 
    boolean frost;
    boolean sol; 
    boolean random; 
    boolean midnight; 
    boolean morning; 
    static boolean isNewImage = false; 
    ImageIcon imageFinal;
	ImageIcon editedImage;
	BufferedImage bufferedImageOriginal;
	JPanel buttonPanel = new JPanel(); 
	JFrame window = new JFrame(); 
	JLabel label;
    JButton sepiaButton = new JButton("Sepia");
    JButton blushButton = new JButton("Blush");
    JButton bwButton = new JButton("Noir");
    JButton browseButton = new JButton("Browse Button");
    JButton exportButton = new JButton("Export Image");
    JButton frostButton = new JButton("Frost");
    JButton solButton = new JButton("Sol");
    JButton randomButton = new JButton("Random");
    JButton originalButton = new JButton("Original Image");
    JButton midnightButton = new JButton("Midnight");
    JButton morningButton = new JButton("Morning");
    JButton newImageButton = new JButton("Choose New Image");
    
    double[] rgbnumbers = {0,0,0,0,0,0,0,0,0};
    
	public InstaShop() {
		// Sets button text color
		originalButton.setForeground(Color.black);
		sepiaButton.setForeground(Color.decode("#8B4513"));
		blushButton.setForeground(Color.red);
		solButton.setForeground(Color.orange);
		bwButton.setForeground(Color.black);
		frostButton.setForeground(Color.decode("#4169E1"));
		randomButton.setForeground(Color.MAGENTA);
		morningButton.setForeground(Color.GRAY);
		
        // Gets the file directory for image chosen from FileDialog
        String fileLocation = getFileDirectory();
        
        // Get ImageIcon from file location
        final ImageIcon image = new ImageIcon(fileLocation);
        // Get BufferedImage from file location
        try {
			bufferedImageOriginal = ImageIO.read(new File(fileLocation));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
        // Draws initial image that's shown on startup, gets ImageIcon
        imageFinal = drawImage(image);
        
        // Add buttons to JFrame
        buttonPanel.add(originalButton);
        buttonPanel.add(newImageButton);
        buttonPanel.add(exportButton);
        buttonPanel.add(sepiaButton);
        buttonPanel.add(blushButton);
        buttonPanel.add(solButton);
        buttonPanel.add(bwButton);
        buttonPanel.add(frostButton);
        buttonPanel.add(midnightButton);
        buttonPanel.add(morningButton);
        buttonPanel.add(randomButton);
        
        // Set background color of buttonPanel
        buttonPanel.setBackground(Color.GRAY);
        
        // Add buttonPanel to JFrame window
        window.add(buttonPanel, BorderLayout.SOUTH);
        
		// Set up the frame window and its main content pane.
        window.setSize(1200, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setTitle("InstaShop");
        window.setResizable(false);
        window.getContentPane().setBackground(Color.DARK_GRAY);
                
        // Listener for button to choose new image
        newImageButton.addActionListener(new ActionListener() {     	 
            public void actionPerformed(ActionEvent e)
            {
            	isNewImage = true; 
            	String fileLocation = getFileDirectory();
                
                // Get ImageIcon from file location
                final ImageIcon image = new ImageIcon(fileLocation);
                // Get BufferedImage from file location
                try {
        			bufferedImageOriginal = ImageIO.read(new File(fileLocation));
        		} catch (IOException e1) {
        			e1.printStackTrace();
        		}
                
                // Draws initial image that's shown on startup, gets ImageIcon
                label.setIcon(null);
                imageFinal = drawImage(image);
                
            }
        });  
         
        // Listener for sepia button
        sepiaButton.addActionListener(new ActionListener() {     	 
            public void actionPerformed(ActionEvent e)
            {
            	sepia = true; 
            	label.setIcon(null);
            	drawImage(imageFinal);
            	sepia = false; 
            }
        });  
        
        // Listener for blush button
        blushButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	blush = true; 
            	label.setIcon(null);
            	drawImage(imageFinal);
            	blush = false; 
            }
        });  
        
        // Listener for sol button
        solButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	sol = true; 
            	label.setIcon(null);
            	drawImage(imageFinal);
            	sol = false; 
            }
        });  
        
        // Listener for morning button
        morningButton.addActionListener(new ActionListener() {       	 
            public void actionPerformed(ActionEvent e)
            {
            	morning = true; 
            	label.setIcon(null);
            	drawImage(imageFinal);
            	morning = false; 
            }
        }); 
        
        // Listener for black and white button
        bwButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	bw = true; 
            	label.setIcon(null);
            	drawImage(imageFinal);
            	bw = false; 
            }
        }); 
        
        // Listener for frost button
        frostButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	frost = true; 
            	label.setIcon(null);
            	drawImage(imageFinal);
            	frost = false; 
            }
        });
        
        // Listener for original button
        originalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	label.setIcon(null);
            	drawImage(imageFinal);
            }
        }); 
        
        // Listener for effect button
        midnightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {	
            	midnight = true; 
            	label.setIcon(null);
            	drawImage(imageFinal);
            	midnight = false; 
            }
        }); 
        
        // Listener for random button
        randomButton.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	random = true; 
            	label.setIcon(null);
            	drawImage(imageFinal);
            	random = false;

            }
        }); 
        
        // Listener for export button
        exportButton.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                if(editedImage == null) {	
                	exportImage(imageFinal);
                }
                
                else {
                	exportImage(editedImage);
                }
            }
        });  
        
	}
	
	// Draws image, returns ImageIcon of the final scaled down image
	public ImageIcon drawImage(ImageIcon image) {
		
		// Creates Image from ImageIcon 
        Image imageN = image.getImage();
        
        // Gets image width and height
        int scaledWidth = image.getIconWidth();
        int scaledHeight = image.getIconHeight();  
                
        // Resize image to fit in window if greater than certain values. Keeps ratio of width to height.  
        if ((image.getIconWidth() > 900) && (image.getIconWidth() > image.getIconHeight())) {
        	scaledWidth = 900; 
        	
        	// This scales an image's height to maintain the same aspect ratio when width is scaled down
        	float ratio = (float) 900/image.getIconWidth();
        	scaledHeight = (int) (image.getIconHeight() * ratio);
        }
        
        // Resize image to fit in window if greater than certain values. Keeps ratio of height to width.
        if ((image.getIconHeight() > 700) && (image.getIconHeight() > image.getIconWidth())) {
        	scaledHeight = 700; 
        	
        	// This scales an image's width to maintain the same aspect ratio when height is scaled down
        	float ratio = (float) 700/image.getIconHeight();
        	scaledWidth = (int) (image.getIconWidth() * ratio);
        }
        
        // Creates Image from scaled values
        Image newimage = imageN.getScaledInstance(scaledWidth,scaledHeight, java.awt.Image.SCALE_SMOOTH);
        // Creates ImageIcon from scaled Image just made
        ImageIcon imageFinal = new ImageIcon(newimage);
        
        // Creates a BufferedImage from input image. A BufferedImage is needed for many operations involving getting and setting pixel values
        BufferedImage bufferedImage = new BufferedImage(scaledWidth, scaledHeight, bufferedImageOriginal.getType());
        
        // Draw image onto this BufferedImage
     	Graphics2D graphic = bufferedImage.createGraphics();
     	graphic.drawImage(bufferedImageOriginal, 0, 0, scaledWidth, scaledHeight, null);
     	graphic.dispose();
     	
     	// Sets color values for applyEffect method
     	if(sepia){
     		double[] sepianumbers = {.393,.769,.189,.349,.686,.168,.272,.534,.131};
     		rgbnumbers = sepianumbers; 
	        applyEffect(bufferedImage);
     	}
     	
     	// Sets color values for applyEffect method
     	if(blush){
     		double[] blushnumbers = {.8,.669,.11,.349,.686,.168,.272,.534,.131};
     		rgbnumbers = blushnumbers; 
     		applyEffect(bufferedImage);;
     	}
     	
     	// Call black and white filter
     	if(bw){
     		applyBW(bufferedImage);
     	}
     	
     	// Sets color values for applyEffect method
     	if(frost){
     		double[] frostnumbers = {.21,.422,.52,.4,.45,.54,.4,.48,.58};
     		rgbnumbers = frostnumbers; 
     		applyEffect(bufferedImage);
     	}
     	
     	// Sets color values for applyEffect method
     	if(sol){
     		double[] solnumbers = {.693,.569,.389,.548,.386,.168,.272,.234,.131};
     		rgbnumbers = solnumbers;
     		applyEffect(bufferedImage);
     	}
     		
     	// Sets color values for applyEffect method
     	if(morning){
     		double[] morningnumbers = {.7229,.70207,.0378,.52844,.41259,.41008,.29911,.09905,.71516};
     		rgbnumbers = morningnumbers; 
     		applyEffect(bufferedImage);
     	}
     		
     	// Call random effect
     	if(random){
     		applyRandom(bufferedImage);
     	}
     	
     	// Sets color values for applyEffect method
     	if(midnight){
     		double[] midnightnumbers = {.73222,.277,.2405,.0427,.001629,.4267,.67199,.3997,.9828};
     		rgbnumbers = midnightnumbers; 
     		applyEffect(bufferedImage);
     	}
     	
     	// Sets edited image
     	imageFinal = new ImageIcon(bufferedImage);
 		editedImage = new ImageIcon(bufferedImage);
     	
     	// Creates JLabel of final, edited image
        label = new JLabel(imageFinal);
        
        // Adds this JLabel to JFrame
        window.add(label, BorderLayout.CENTER);
        
        // Return final image
        return imageFinal;
	}
	
	// Applies filter effect to image
	public void applyEffect(BufferedImage bufferedImage){
		for(int x = 0; x<bufferedImage.getWidth(); x++) {
        	for(int y = 0; y < bufferedImage.getHeight(); y++) {
        		
        		int rgb = bufferedImage.getRGB(x,y);
        		int redBefore = (rgb>>16)&0x0ff;
        		int greenBefore=(rgb>>8) &0x0ff;
        		int blueBefore= (rgb)    &0x0ff;
        		
        		int redAfter =  (int) ((redBefore * rgbnumbers[0]) + (greenBefore * rgbnumbers[1]) + (blueBefore * rgbnumbers[2]));
        		if(redAfter > 255) {
        			redAfter = 255; 
        		}
        		int greenAfter = (int) ((redBefore * rgbnumbers[3]) + (greenBefore * rgbnumbers[4]) + (blueBefore * rgbnumbers[5]));
        		if(greenAfter > 255) {
        			greenAfter = 255;
        		}
        		int blueAfter = (int) ((redBefore * rgbnumbers[6]) + (greenBefore * rgbnumbers[7]) + (blueBefore * rgbnumbers[8]));
        		if(blueAfter > 255){
        			blueAfter = 255; 
        		}
        		
        		int col = (redAfter << 16) | (greenAfter << 8) | blueAfter;
        		
        		bufferedImage.setRGB(x, y, col);
        	}
		}
	}

	// Changes pixel values for black and white filter
	public void applyBW(BufferedImage bufferedImage){
		for(int x = 0; x<bufferedImage.getWidth(); x++) {
        	for(int y = 0; y < bufferedImage.getHeight(); y++) {
        		
        		int rgb = bufferedImage.getRGB(x,y);
        		
        		int redBefore = (rgb>>16)&0x0ff;
        		int greenBefore=(rgb>>8) &0x0ff;
        		int blueBefore= (rgb)    &0x0ff;
        		
        		int redAfter =  (int) (redBefore + greenBefore + blueBefore)/3;
        		if(redAfter > 255) {
        			redAfter = 255; 
        		}
        		int greenAfter = (int) (redBefore + greenBefore + blueBefore)/3;
        		if(greenAfter > 255) {
        			greenAfter = 255;
        		}
        		int blueAfter = (int) (redBefore + greenBefore + blueBefore)/3;
        		if(blueAfter > 255){
        			blueAfter = 255; 
        		}
        		
        		int col = (redAfter << 16) | (greenAfter << 8) | blueAfter;
        		
        		bufferedImage.setRGB(x, y, col);
        	}
		}
	}
		
	// Changes pixels to random color filter
	public void applyRandom(BufferedImage bufferedImage){
		// Random numbers need to be set here so image doesn't just look like static
		double randomOne = Math.random();
		double randomTwo = Math.random();
		double randomThree = Math.random();
		double randomFour = Math.random();
		double randomFive = Math.random();
		double randomSix = Math.random();
		double randomSeven = Math.random();
		double randomEight = Math.random();
		double randomNine = Math.random();
		
		for(int x = 0; x<bufferedImage.getWidth(); x++) {
        	for(int y = 0; y < bufferedImage.getHeight(); y++) {
        		
        		int rgb = bufferedImage.getRGB(x,y);
        		
        		int redBefore = (rgb>>16)&0x0ff;
        		int greenBefore=(rgb>>8) &0x0ff;
        		int blueBefore= (rgb)    &0x0ff;
        		
        		int redAfter =  (int) ((redBefore * randomOne) + (greenBefore * randomTwo) + (blueBefore * randomThree));
        		if(redAfter > 255) {
        			redAfter = 255; 
        		}
        		int greenAfter = (int) ((redBefore * randomFour) + (greenBefore * randomFive) + (blueBefore * randomSix));
        		if(greenAfter > 255) {
        			greenAfter = 255;
        		}
        		int blueAfter = (int) ((redBefore * randomSeven) + (greenBefore * randomEight) + (blueBefore * randomNine));
        		if(blueAfter > 255){
        			blueAfter = 255; 
        		}
        		
        		int col = (redAfter << 16) | (greenAfter << 8) | blueAfter;
        		
        		bufferedImage.setRGB(x, y, col);
        	}
		}
	}	
	
	// Returns file dialog
	public static String getFileDirectory(){
		FileDialog fd = new FileDialog(new Frame(), "Choose an image to edit", FileDialog.LOAD);
        fd.setDirectory("C:\\");
        fd.setFile("*.jpg");
        fd.setVisible(true);
        filename = fd.getFile();
        String filedirectory = fd.getDirectory();
        
        // Quits program if 'cancel' selected, but not if user is selecting a new image to edit
        if ((filename == null) && (isNewImage==false)) {
          System.exit(0);
        }
        
        // Checks to see if file chosen is an image, an image being a file that ends with .jpg, .jpeg or .png
        // If not an image, prompt user to pick image again. 
        while((filename.toLowerCase().contains(".jpg") || filename.toLowerCase().contains(".jpeg") || filename.toLowerCase().contains(".png")) == false){
        	JOptionPane.showMessageDialog(null, "File chosen not an image. Please choose an image ending in '.jpg', '.png', or '.jpeg'. ");
        	fd = new FileDialog(new Frame(), "Choose an image to edit", FileDialog.LOAD);
            fd.setDirectory("C:\\");
            fd.setFile("*.jpg");
            fd.setVisible(true);
            filename = fd.getFile();
            filedirectory = fd.getDirectory();
            
            // Quits program if 'cancel' selected, but not if the user is selecting a new image to edit
            if ((filename == null) && (isNewImage==false)) {
              System.exit(0);
            }
        }
        
        // Gets the image chosen from FileDialog
        String fileLocation = filedirectory+filename;
        return fileLocation;
	}
	
	// Exports image as .jpg
	public void exportImage(ImageIcon image){
		Image img = image.getImage();
		
		// Created BufferedImage
		BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
		// Draw image onto this BufferedImage
		Graphics2D graphic = bufferedImage.createGraphics();
	    graphic.drawImage(img, 0, 0, null);
	    graphic.dispose();
	    
	    // Gets save file name
	    String imageName = JOptionPane.showInputDialog("Enter a name for your file: ");
	    
		File outputImage =  new File(imageName + ".jpg");
		try {
		ImageIO.write(bufferedImage, "jpg", outputImage);
		} catch (IOException e) {
			System.out.println("Error exporting image");
		}
		
	}

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Please select an image to edit");
        new InstaShop();
    }
}