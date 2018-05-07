import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WelcomePage extends JPanel
{  
	public WelcomePage()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 0;
		gbc.gridy = 0;
	
		
		BufferedImage bankjpg = null;
		
		try
		{
			bankjpg = ImageIO.read(new File("wells fargo2.jpg"));
			
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		JLabel lblHome = new JLabel(new ImageIcon(bankjpg));
		add(lblHome);
	}
	
}
