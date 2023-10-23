import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
* La classe <b><code>RecupFichier</code></b> recupere le fichier selectionn\u00e9
*  
* @version 1.1
* @author Kévin METRI et Bastien LEBLET
*/

public class RecupFichier {


    /**
    * Methode recupere le fichier selectionn\u00e9.
    *
    *@return le chemin du fichier selectionn\u00e9
    */
    public String recuperation() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        String chemin="";

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            chemin=selectedFile.getPath();
        }
        return chemin;
    }
}