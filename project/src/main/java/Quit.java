import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;



public class Quit implements NativeKeyListener {
    private volatile int quitFlag;
    

    public int getQuitFlag()
    {
        return quitFlag;
    }
    
   @Override
   public void nativeKeyTyped(NativeKeyEvent e)
   {
    if (e.getKeyChar() == 'y' ){
        quitFlag = 0;
        
    }
    else if (e.getKeyChar() == 'n') {
        quitFlag = 1;

    }
    else{
        System.out.println("Please enter either y/n");
    }
    }

        
}
   