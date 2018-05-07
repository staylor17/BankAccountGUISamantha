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

public class TransferAmt extends JPanel
{
	ArrayList<BankAccount> allAccounts;
	JPanel thisPanel = this;
	
	public TransferAmt(ArrayList<BankAccount> bankAccounts)
	{
		allAccounts = bankAccounts;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel lblWithdrawAcct = new JLabel("Account to Withdraw from: ");
		add(lblWithdrawAcct, gbc);
		gbc.gridy++;
		
		JLabel lblName1 = new JLabel("Name: ");
		add(lblName1, gbc);
		gbc.gridx++;
				
		JTextField txtName1 = new JTextField();
		txtName1.setPreferredSize(new Dimension(150,25));
		add(txtName1, gbc);
		gbc.gridx = 0 ;
		gbc.gridy++; 
				
		JLabel lblAcctNum1 = new JLabel("Account #: ");
		add(lblAcctNum1,gbc);
		gbc.gridx++;
		
		JTextField txtAcctNum1 = new JTextField();
		txtAcctNum1.setPreferredSize(new Dimension(150,25));
		add(txtAcctNum1, gbc);
		gbc.gridx=0;
		gbc.gridy++;
		
		JLabel lblDepositAcct= new JLabel("Account to Deposit to: ");
		add(lblDepositAcct, gbc);
		gbc.gridy++;
		
		JLabel lblName2 = new JLabel("Name: ");
		add(lblName2, gbc);
		gbc.gridx++;
				
		JTextField txtName2 = new JTextField();
		txtName2.setPreferredSize(new Dimension(150,25));
		add(txtName2, gbc);
		gbc.gridx = 0 ;
		gbc.gridy++; 
				
		JLabel lblAcctNum2 = new JLabel("Account #: ");
		add(lblAcctNum2,gbc);
		gbc.gridx++;
		
		JTextField txtAcctNum2 = new JTextField();
		txtAcctNum2.setPreferredSize(new Dimension(150,25));
		add(txtAcctNum2, gbc);
		gbc.gridx=0;
		gbc.gridy++;
		
		JLabel lblTransfer = new JLabel("Transfer Amount:");
		add(lblTransfer, gbc);
		gbc.gridy++;
		
		JLabel lblAmt = new JLabel("Amount: $");
		add(lblAmt, gbc);
		gbc.gridx++;
		
		JTextField txtAmt = new JTextField();
		txtAmt.setPreferredSize(new Dimension(150,25));
		add(txtAmt, gbc);
		gbc.gridx = 1;
		gbc.gridy++;
		
		JButton btnTransfer = new JButton("Transfer");
		add(btnTransfer, gbc);
		
		btnTransfer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String name1 = txtName1.getText();
				String name2 = txtName2.getText();
				
				for(int i = 0; i < allAccounts.size(); i++)
				{
					if (allAccounts.get(i).getName().equals(name1))
					{

						int acctNum1 = allAccounts.get(i).getAcctNum();
						String stringAcctNum = txtAcctNum1.getText();
						int enteredAcctNum1 = Integer.parseInt(stringAcctNum);
						
						String transferAmt = txtAmt.getText();
						double dubTransfer = Double.parseDouble(transferAmt);
						
						if (acctNum1 == enteredAcctNum1)
						{
							try
							{
								allAccounts.get(i).withdraw(dubTransfer);
							}
							catch(IllegalArgumentException a)
							{
								JOptionPane.showMessageDialog(thisPanel, "Unable to Transfer Amount");
							}
						}
						
					}
					
					if (allAccounts.get(i).getName().equals(name2))
					{

						int acctNum2 = allAccounts.get(i).getAcctNum();
						String stringAcctNum = txtAcctNum2.getText();
						int enteredAcctNum2 = Integer.parseInt(stringAcctNum);
						
						String transferAmt = txtAmt.getText();
						double dubTransfer = Double.parseDouble(transferAmt);
						
						if (acctNum2 == enteredAcctNum2)
						{
							try
						{
							allAccounts.get(i).deposit(dubTransfer);
						}
						catch(IllegalArgumentException a)
						{
							JOptionPane.showMessageDialog(thisPanel, "Unable to Transfer Amount");
						}
						}
					}
					
					
				}
				
			}
			
		});
		
	
	}
}
