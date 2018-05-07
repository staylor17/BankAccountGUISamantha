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

public class AddAccount extends JPanel 
{	
	ArrayList<BankAccount> allAccounts;
	String[] accts = {" ", "Checking", "Savings"};
	JPanel thisPanel = this;
	
	public AddAccount(ArrayList<BankAccount> bankAccounts)
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
		
		JLabel lblInitBal = new JLabel("Starting Balance: ");
		add(lblInitBal, gbc);
		gbc.gridx++	;
		
		JTextField txtInitBal = new JTextField();
		txtInitBal.setPreferredSize(new Dimension(150,25));
		add(txtInitBal, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		
		JLabel lblType = new JLabel("Select Account Type: ");
		add(lblType,gbc);
		gbc.gridx++;
		
		JList lstAccts = new JList(accts);
		
		JScrollPane scrollAccts = new JScrollPane(lstAccts);
		scrollAccts.setPreferredSize(new Dimension(150, 25));
		add(scrollAccts, gbc);
		gbc.gridx = 1;
		gbc.gridy++;
		
		JButton btnAdd = new JButton("Add Account");
		add(btnAdd,gbc);
		
		btnAdd.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				  String name = txtName.getText();
				  String stringInitBal = txtInitBal.getText();
				  double dubAmt = Double.parseDouble(stringInitBal);
				  double intRate = 0.001;
				  double minBal = 100.00;
				  double minBalFee = 10.00;
				  double overFee = 10.00;
				  double transFee = 5.00;
				  int freeTrans = 5;
				  
				  
				  if (lstAccts.getSelectedValue().equals("Savings"))
					{
					  try
					  {
					    	bankAccounts.add(new SavingsAccount(name, dubAmt, intRate, minBal, minBalFee));
					    	JOptionPane.showMessageDialog(thisPanel, "Account Successfully Created");
					  }
					  catch(IllegalArgumentException a)
					  {
						  JOptionPane.showMessageDialog(thisPanel, "Unable to Create Account");
					  }
					  
					 }
				  
				  else if (lstAccts.getSelectedValue().equals("Checking"))
				  {
					  try
					  {
						  bankAccounts.add(new CheckingAccount(name, dubAmt, overFee, transFee, freeTrans));
						  JOptionPane.showMessageDialog(thisPanel, "Account Successfully Created");
					  }
					  catch(IllegalArgumentException a)
					  {
						  JOptionPane.showMessageDialog(thisPanel, "Unable to Create Account");
					  }
				  }	 
  
				  txtName.setText("");
				  txtInitBal.setText("");
				  				
			}
			
		});
		
	}
}
	

