package utils;
import javax.swing.JButton;
/**
 * 
 * 
 *
 */
public final class CreateButton {
    private CreateButton() {
    }
   /**
    * 
    * @param btnName
    * @return aaaaaaaaaaa
    */
   public static JButton createOpButton(final String btnName) {
       final JButton btn = new JButton(btnName);
       btn.setBackground(CCColors.OPERATION_BUTTON);
       return btn;
   }
}
