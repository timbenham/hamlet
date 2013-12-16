import javax.swing.JOptionPane;

public class HamletMain {
	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Welcome to Hamlet", "Hamlet Game",
				-1);

		Object[] characters = { "Hamlet", "Horatio", "Claudius" };
		int firstChoice = JOptionPane.showOptionDialog(null,
				"Who would you like to play as?", "Character Option Screen",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, characters, characters[2]);
		
		if(firstChoice == 0)
		{
			
		}
		else if(firstChoice == 1)
		{
			
		}
		else if(firstChoice == 2)
	}
}