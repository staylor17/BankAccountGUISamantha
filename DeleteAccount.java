import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DeleteAccount extends JPanel 
{
	ArrayList<BankAccount> allAccounts;
	String[] accts = {" ", "Checking", "Savings"};
	JPanel thisPanel = this;
	
	public DeleteAccount(ArrayList<BankAccount> bankAccounts)
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
		txtName.setPreferredSize(new Dimension(150,25));
		add(txtName, gbc);
		gbc.gridx = 0 ;
		gbc.gridy++; 
				
		JLabel lblAcctNum = new JLabel("Enter Account Number: ");
		add(lblAcctNum,gbc);
		gbc.gridx++;
		
		JTextField txtAcctNum = new JTextField();
		txtAcctNum.setPreferredSize(new Dimension(150,25));
		add(txtAcctNum, gbc);
		gbc.gridx=1;
		gbc.gridy++;
		
		JButton btnDelete = new JButton("Delete Account");
		add(btnDelete,gbc);
		
		btnDelete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String name = txtName.getText();
				
				for(int i = 0; i < allAccounts.size(); i++)
				{
					if (allAccounts.get(i).getName().equals(name))
					{
							int acctNum = allAccounts.get(i).getAcctNum();
							String stringAcctNum = txtAcctNum.getText();
							int enteredAcctNum = Integer.parseInt(stringAcctNum);
						
							if (acctNum == enteredAcctNum)
							{
								try 
								{
									allAccounts.remove(i);
									JOptionPane.showMessageDialog(thisPanel, "Account Successfully Deleted");
								}
								catch(IllegalArgumentException a)
								{
									JOptionPane.showMessageDialog(thisPanel, "Unable to Delete Account");
								}
							}
					}
					
				}
				
				System.out.print(allAccounts);
			}
			
		});
		
	}
}

