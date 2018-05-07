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

public class DepositAmt extends JPanel 
{
	ArrayList<BankAccount> allAccounts;
	JPanel thisPanel = this;
	
	public DepositAmt(ArrayList<BankAccount> bankAccounts)
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
		
		JLabel lblAcctNum = new JLabel("Account Number: ");
		add(lblAcctNum, gbc);
		gbc.gridx++;
		
		JTextField txtAcctNum = new JTextField();
		txtAcctNum.setPreferredSize(new Dimension(150,25));
		add(txtAcctNum, gbc);
		gbc.gridx=0;
		gbc.gridy++;
		
		JLabel lblDeposit = new JLabel("Amount to Deposit: ");
		add(lblDeposit, gbc);
		gbc.gridx++	;
		
		JTextField txtDeposit = new JTextField();
		txtDeposit.setPreferredSize(new Dimension(150,25));
		add(txtDeposit, gbc);
		gbc.gridx=1;
		gbc.gridy++;
		
		JButton btnDeposit = new JButton("Deposit");
		add(btnDeposit,gbc);
		
		btnDeposit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String name = txtName.getText();
				String deposit = txtDeposit.getText();
				double dubDeposit = Double.parseDouble(deposit);
				String stringAcctNum = txtAcctNum.getText();
				int enteredAcctNum = Integer.parseInt(stringAcctNum);
										
				for(int i = 0; i < allAccounts.size(); i++)
				{
					if(allAccounts.get(i).getName().equals(name))
					{
						if(allAccounts.get(i).getAcctNum() == enteredAcctNum)
						{
							try
							{
								allAccounts.get(i).deposit(dubDeposit);
								 JOptionPane.showMessageDialog(thisPanel, "Amount Successfully Deposited");
							}
							catch(IllegalArgumentException a)
							{
								 JOptionPane.showMessageDialog(thisPanel, "Unable to Deposit Amount");
						
							}
						}
					}
				}
			
			}	
		});
		
	}

}
