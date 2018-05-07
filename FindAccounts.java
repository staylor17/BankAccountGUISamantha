import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class FindAccounts extends JPanel
{
	ArrayList<BankAccount> allAccounts;
	
	public FindAccounts(ArrayList<BankAccount> bankAccounts)
	{
		allAccounts = bankAccounts;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel lblName = new JLabel("Name of Account Holder: ");
		add(lblName, gbc);
		gbc.gridx++;
				
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(200,25));
		add(txtName, gbc);
		gbc.gridx = 0;
		gbc.gridy++; 
		
		JLabel lblAccts = new JLabel("Accounts Under This Name: ");
		add(lblAccts, gbc);
		gbc.gridx++;
		
				
		JTextPane paneAccts = new JTextPane();
		paneAccts.setPreferredSize(new Dimension(200,100));
		add(paneAccts, gbc);
		gbc.gridy++;
				
		JScrollPane scrollAccts = new JScrollPane(paneAccts);
		scrollAccts.setPreferredSize(new Dimension(200, 100));
		add(scrollAccts, gbc);
		gbc.gridx = 1;
		gbc.gridy++;
		
		JButton btnFindAccts = new JButton("Find Accounts");
		add(btnFindAccts,gbc);
		
		
		btnFindAccts.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String name = txtName.getText();
				String newAccount = "";
				String foundAccounts = "";
								
				for(int i = 0; i < allAccounts.size(); i++)
				{					
					if(allAccounts.get(i).getName().equals(name))
					{	
						newAccount = allAccounts.get(i).toString();
						foundAccounts = foundAccounts + newAccount + "\n";
					}
					
					else
					{
						foundAccounts = "There are no accounts under this name.";
					}
			}
				
			paneAccts.setText(foundAccounts);
				
			}
		
		}); 
			
	}
}
