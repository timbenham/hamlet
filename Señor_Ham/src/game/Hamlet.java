package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Hamlet extends JFrame
{
  static JFrame frame;
  static JPanel panel;
  static JLabel imageLabel;
  static JButton one;
  static JButton two;
  static ActionListener deathPane = new DeathOne();
  static ActionListener gravePane = new GraveOne();
  static ActionListener funeralPane = new Funeral();
  static ActionListener laertesPane = new Laertes();
  static ActionListener grapplePane = new Grapple();
  static ActionListener speechPane = new Speech();
  static ActionListener scenePane = new BeginSceneTwo();
  static ActionListener fencePane = new Fence();
  static ActionListener poisonPane = new Poison();
  static ActionListener endPane = new End();
  static DeathPane deadPane = new DeathPane();
  static JTextArea textBox = new JTextArea();

  static ImageIcon death = new ImageIcon("");

  public static void main(String[] args) { initRoot(); }

  public static void initRoot()
  {
    frame = new JFrame("Hamlet");
    textBox.setEditable(false);
    panel = new JPanel();
    frame.setBounds(200, 200, 500, 500);
    frame.setDefaultCloseOperation(3);
    imageLabel = new JLabel(new ImageIcon("images/Graveyard.jpg"));
    panel.add(imageLabel);
    one = new JButton("Put up with diggers");
    two = new JButton("Get mad, throw skull");
    textBox.setText("You and Horatio are walking towards a Graveyard. \nYou see two Gravediggers digging and whilsting with their work\nOne of the diggers is carelessly throwing up skulls. \nHorrified at his carelessness, you pick up one of the skulls and ponder.\nWhat do you do?");

    panel.add(textBox);
    one.addActionListener(gravePane);
    deadPane.setDeathText("You try to attack the diggeer, who team up on you and kill you");
    two.addActionListener(deadPane);
    panel.add(imageLabel);
    panel.add(one);
    panel.add(two);
    frame.add(panel);
    frame.setVisible(true);
  }

  private static class End
    implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Hamlet.panel.remove(Hamlet.imageLabel);
      Hamlet.imageLabel = new JLabel(new ImageIcon("images/dying Hamlet.jpg"));
      Hamlet.textBox.setText("You run up and stick Laertes' poisoned rapier\ninto the King.You then nick Laertes as well.\nGertrude, by this time has already died from the poisoned water.");

      Hamlet.panel.remove(Hamlet.one);
      Hamlet.panel.remove(Hamlet.two);
      Hamlet.panel.add(Hamlet.imageLabel);
      Hamlet.panel.add(Hamlet.one);
      Hamlet.one.setText("Done");
      Hamlet.two.setText("Have a change of heart");
      Hamlet.one.removeActionListener(Hamlet.poisonPane);
      Hamlet.one.addActionListener(Hamlet.deathPane);
      Hamlet.panel.repaint();
    }
  }

  private static class Poison
    implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Hamlet.panel.remove(Hamlet.imageLabel);
      Hamlet.imageLabel = new JLabel(new ImageIcon("images/poison.jpg"));
      Hamlet.textBox.setText("You agree to fight with Laertes and commence the duel\n You put up a good fight, but Laertes ends up landing a hit on you.\nYou instantly realize that the saber is poisoned.\nYou have to act quickly,\n\nwhat do you do with your final moments?");

      Hamlet.panel.remove(Hamlet.one);
      Hamlet.panel.remove(Hamlet.two);
      Hamlet.panel.add(Hamlet.imageLabel);
      Hamlet.panel.add(Hamlet.one);
      Hamlet.panel.add(Hamlet.two);
      Hamlet.one.setText("Kill the king!");
      Hamlet.two.setText("Have a change of heart");
      Hamlet.deadPane.setDeathText("The Poison takes its effect quickly. You are dead within a minute. You are slain");
      Hamlet.one.removeActionListener(Hamlet.poisonPane);
      Hamlet.one.addActionListener(Hamlet.endPane);
      Hamlet.panel.repaint();
    }
  }

  private static class Fence
    implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Hamlet.panel.remove(Hamlet.imageLabel);
      Hamlet.imageLabel = new JLabel(new ImageIcon("images/fencing.jpg"));
      Hamlet.textBox.setText("After telling Horatio all about the Kings plans,\nOsric enters and suggests that you settle your differences with Laertes");
      Hamlet.one.setText("Fight Laertes");
      Hamlet.two.setText("Kill Laertes");
      Hamlet.deadPane.setDeathText("You step quickly and gut Laertes.\nthe King sees this and uses it as an opportunity to slit your throat. You die");

      Hamlet.panel.remove(Hamlet.one);
      Hamlet.panel.remove(Hamlet.two);
      Hamlet.panel.add(Hamlet.imageLabel);
      Hamlet.panel.add(Hamlet.one);
      Hamlet.panel.add(Hamlet.two);
      Hamlet.two.removeActionListener(Hamlet.fencePane);
      Hamlet.two.addActionListener(Hamlet.deadPane);
      Hamlet.one.removeActionListener(Hamlet.deadPane);
      Hamlet.one.removeActionListener(Hamlet.scenePane);
      Hamlet.one.addActionListener(Hamlet.poisonPane);
      Hamlet.panel.repaint();
    }
  }

  private static class BeginSceneTwo
    implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Hamlet.panel.remove(Hamlet.imageLabel);
      Hamlet.imageLabel = new JLabel(new ImageIcon("images/hamlet horatio.jpg"));
      Hamlet.textBox.setText("You're standing in the castle with Horatio.\nYou think that it's time to tell Horatio what you know about the King and his plotting.\n\nWhat do you do?");

      Hamlet.two.setText("Inform Horatio");
      Hamlet.one.setText("Lie to Horatio");
      Hamlet.deadPane.setDeathText("You try to pull the wool over Horatio's eyes, but he doesn't buy it.\nHe stabs you for your insolence");

      Hamlet.panel.remove(Hamlet.one);
      Hamlet.panel.remove(Hamlet.two);
      Hamlet.panel.add(Hamlet.imageLabel);
      Hamlet.panel.add(Hamlet.one);
      Hamlet.panel.add(Hamlet.two);
      Hamlet.two.removeActionListener(Hamlet.deadPane);
      Hamlet.one.removeActionListener(Hamlet.scenePane);
      Hamlet.two.addActionListener(Hamlet.fencePane);
      Hamlet.one.addActionListener(Hamlet.deadPane);

      Hamlet.panel.repaint();
    }
  }

  private static class Speech
    implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Hamlet.panel.remove(Hamlet.imageLabel);
      Hamlet.imageLabel = new JLabel(new ImageIcon("images/speech.jpg"));
      Hamlet.textBox.setText("You turn around to see a dead Ophelia being lowered into the gound\nYou stand next to the grave, ovwrwhelmed by sadness.\n\nWhat do you do?");

      Hamlet.panel.add(Hamlet.imageLabel);
      Hamlet.panel.remove(Hamlet.one);
      Hamlet.panel.add(Hamlet.one);
      Hamlet.panel.add(Hamlet.two);
      Hamlet.two.setText("Start crying");
      Hamlet.deadPane.setDeathText("You start crying. Slowly at first, but increasingly heavily.\nYou start crying so hard that you fall into grave of Ophelia and break you neck.");

      Hamlet.one.setText("Say speech");
      Hamlet.one.removeActionListener(Hamlet.speechPane);
      Hamlet.one.addActionListener(Hamlet.scenePane);
      Hamlet.two.removeActionListener(Hamlet.grapplePane);
      Hamlet.two.addActionListener(Hamlet.deadPane);
      Hamlet.panel.repaint();
    }
  }

  private static class Grapple
    implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Hamlet.panel.remove(Hamlet.imageLabel);
      Hamlet.panel.remove(Hamlet.one);
      Hamlet.textBox.setText("After a short scuffle, you and Laertes are separated from each other.\nYou're both scratched up\nbut noting major");
      Hamlet.imageLabel = new JLabel(new ImageIcon("images/separated.png"));
      Hamlet.panel.add(Hamlet.imageLabel);
      Hamlet.panel.add(Hamlet.one);
      Hamlet.panel.remove(Hamlet.two);
      Hamlet.one.setText("OK");
      Hamlet.one.removeActionListener(Hamlet.grapplePane);
      Hamlet.one.addActionListener(Hamlet.speechPane);
      Hamlet.panel.repaint();
    }
  }

  private static class Laertes
    implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Hamlet.panel.remove(Hamlet.imageLabel);
      Hamlet.textBox.setText("Upon seeing you, Laertes flies into a fit of rage comes at you swinging\nYou two begin to fight.\n\nWhat do you do?");

      Hamlet.imageLabel = new JLabel(new ImageIcon("images/grappling.JPG"));
      Hamlet.panel.remove(Hamlet.one);
      Hamlet.panel.add(Hamlet.imageLabel);
      Hamlet.panel.add(Hamlet.one);
      Hamlet.panel.add(Hamlet.two);

      Hamlet.one.removeActionListener(Hamlet.laertesPane);
      Hamlet.two.removeActionListener(Hamlet.deadPane);
      Hamlet.one.addActionListener(Hamlet.grapplePane);
      Hamlet.two.addActionListener(Hamlet.grapplePane);
      Hamlet.two.setText("Fight clean");
      Hamlet.one.setText("Fight dirty");
      Hamlet.panel.repaint();
    }
  }

  private static class Funeral
    implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Hamlet.panel.remove(Hamlet.imageLabel);
      Hamlet.textBox.setText("Out of pure sorrow,\nLaertes jumps into the grave and starts cursing your name.\nYou then step out of the shadowsand surprise the crowd with your presence");

      Hamlet.imageLabel = new JLabel(new ImageIcon("images/laertes.jpg"));
      Hamlet.panel.add(Hamlet.imageLabel);
      Hamlet.one.setText("OK");
      Hamlet.panel.remove(Hamlet.two);
      Hamlet.panel.remove(Hamlet.one);
      Hamlet.panel.remove(Hamlet.two);
      Hamlet.panel.add(Hamlet.one);
      Hamlet.two.removeActionListener(Hamlet.deadPane);
      Hamlet.one.removeActionListener(Hamlet.funeralPane);
      Hamlet.one.addActionListener(Hamlet.laertesPane);
      Hamlet.panel.repaint();
    }
  }

  private static class GraveOne
    implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Hamlet.panel.remove(Hamlet.imageLabel);

      Hamlet.imageLabel = new JLabel(new ImageIcon("images/funeral.jpg"));
      Hamlet.panel.add(Hamlet.imageLabel);
      Hamlet.textBox.setText("After speaking with the GraveDiggers,\nyou find out that this grave is for your beloved Opherlia\n who drowned herself earlier that day.\nSuddenly you hear music and see a funeral procession.\nIt's The King, your Mother, and assorted company. What do you do?");

      Hamlet.one.setText("Play it cool");
      Hamlet.two.setText("Kill the king in rage");
      Hamlet.deadPane.setDeathText("You throw yourself at the King and start strangling him.\nLaertes sees this as a change and stabs you from behind. You are slain");

      Hamlet.panel.remove(Hamlet.one);
      Hamlet.panel.remove(Hamlet.two);
      Hamlet.panel.add(Hamlet.one);
      Hamlet.panel.add(Hamlet.two);
      Hamlet.one.removeActionListener(Hamlet.gravePane);
      Hamlet.one.addActionListener(Hamlet.funeralPane);
      Hamlet.panel.repaint();
    }
  }

  private static class DeathOne
    implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      Hamlet.frame.dispose();
    }
  }

  private static class DeathPane
    implements ActionListener
  {
    String str = "";

    public void setDeathText(String str) {
      this.str = str;
    }

    public void actionPerformed(ActionEvent e) {
      Hamlet.panel.remove(Hamlet.imageLabel);
      Hamlet.imageLabel = new JLabel(new ImageIcon("images/skull.jpg"));

      Hamlet.textBox.setText(this.str);
      Hamlet.panel.remove(Hamlet.two);
      Hamlet.one.setText("OK");
      Hamlet.panel.remove(Hamlet.one);
      Hamlet.panel.add(Hamlet.imageLabel);
      Hamlet.panel.add(Hamlet.one);
      Hamlet.one.removeActionListener(Hamlet.gravePane);
      Hamlet.one.addActionListener(Hamlet.deathPane);
      Hamlet.panel.repaint();
    }
  }
}