import java.awt.*;

public class TestFrame extends Frame
{
   private Button    add      = new Button("Add"),  
                     reset    = new Button("Reset"),
                     quit     = new Button("Quit");
   private TextField output   = new TextField(6),   
                     input    = new TextField(6);
   private Label     outLabel = new Label("Sum:"),  
                     inLabel  = new Label("Add:");
   private int       sum = 0;

   public TestFrame(String t)
   {
      super(t); setup();
      pack();   show();
   }

   public boolean action(Event e, Object o)
   {
      if (e.target == quit)
         System.exit(0);
      else if (e.target == add)
      {
         sum += Integer.parseInt(input.getText());
         output.setText(String.valueOf(sum));
      }
      else if (e.target == reset)
      {
         sum = 0;
         output.setText("");
      }     
      return false;
   }
  
   private void setup()
   {
      setLayout(new FlowLayout());
      add(inLabel);   
      add(input);
      add(outLabel);  
      add(output);
      add(add);       
      add(reset); 
      add(quit);
   }
}