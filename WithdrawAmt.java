import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WithdrawAmt extends JPanel 
{
	private ArrayList<BankAccount> allAccounts;
	private JPanel thisPanel = this;
	
	public WithdrawAmt(ArrayList<BankAccount> bankAccounts)
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
		
		JLabel lblWithdraw = new JLabel("Amount to Withdraw: ");
		add(lblWithdraw, gbc);
		gbc.gridx++	;
		
		JTextField txtWithdraw = new JTextField();
		txtWithdraw.setPreferredSize(new Dimension(150,25));
		add(txtWithdraw, gbc);
		gbc.gridx=1;
		gbc.gridy++;
		
		JButton btnWithdraw = new JButton("Withdraw");
		add(btnWithdraw,gbc);
		
		btnWithdraw.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String name = txtName.getText();
				String withdraw = txtWithdraw.getText();
				double dubWithdraw = Double.parseDouble(withdraw);
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
								allAccounts.get(i).withdraw(dubWithdraw);
								JOptionPane.showMessageDialog(thisPanel, "Transaction Completed");
							}
							
							catch(IllegalArgumentException a)
							{
								JOptionPane.showMessageDialog(thisPanel, "Unable to Complete Transaction");
								
							}
						}
					}
				}
			
				System.out.print(allAccounts);
			}
			
			
			
		});
		
	}

}
