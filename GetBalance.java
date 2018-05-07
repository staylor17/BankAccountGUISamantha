import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetBalance extends JPanel
{
	ArrayList<BankAccount> allAccounts;
	
	public GetBalance(ArrayList<BankAccount> bankAccounts)
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
		gbc.gridx = 0;
		gbc.gridy++; 
		
		JLabel lblAcctNum = new JLabel("Account Number: ");
		add(lblAcctNum, gbc);
		gbc.gridx++;
		
		JTextField txtAcctNum = new JTextField();
		txtAcctNum.setPreferredSize(new Dimension(150,25));
		add(txtAcctNum, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		
		JLabel lblBalance = new JLabel("Balance");
		add(lblBalance, gbc);
		gbc.gridx++;
		
		JTextField txtBalance = new JTextField();
		txtBalance.setPreferredSize(new Dimension(150,25));
		txtBalance.setEditable(false);
		add(txtBalance, gbc);
		gbc.gridx = 1;
		gbc.gridy++;
		
		JButton btnGetBalance = new JButton("Get Balance");
		add(btnGetBalance,gbc);
		gbc.gridx++;
	
		JButton btnClear = new JButton("Clear");
		add(btnClear, gbc);
		

		btnGetBalance.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String name = txtName.getText();
												
				for(int i = 0; i < allAccounts.size(); i++)
				{
					
					if(allAccounts.get(i).getName().equals(name))
					{		
						int acctNum = allAccounts.get(i).getAcctNum();
						String stringAcctNum = txtAcctNum.getText();
						int enteredAcctNum = Integer.parseInt(stringAcctNum);
						
						if(acctNum == enteredAcctNum)
						{
							double balance = allAccounts.get(i).getBalance();
							txtBalance.setText("$" + balance);
						}
						else
						{
							txtBalance.setText("Unable to access balance.");
						}
					}
					else
					{
						txtBalance.setText("Unable to access balance.");
					}
										
				}
			
				System.out.print(allAccounts);
			}
			
			
			
		});
		
		btnClear.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						txtName.setText("");
						txtAcctNum.setText("");
						txtBalance.setText("");
	
					}
			
				});
			
	}
}
