package jlm.core.model;

import jlm.core.model.lesson.Exercise;

import javax.swing.*;
import java.io.*;

public class LocalFileSpy implements ProgressSpyListener {

    private String username;
    private String filePath;
    
    public LocalFileSpy() {
        username = System.getenv("USER");
        if (username == null)
            username = System.getenv("USERNAME");
        if (username == null)
            username = "John Doe";
        
        // init path of the logfile
        String jlmDirPath = getJLMPropertiesDir();
        if(jlmDirPath != null)
            filePath = jlmDirPath + "/progress.spy";
    }

    @Override
    public void executed(Exercise exo) {
        if(exo.isSuccessfullyPassed()) {
            String log = username+" solved "+exo.getName()+" in "+exo.lastResult.language+"!";
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
                bw.write(log);
                bw.newLine();
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public String getJLMPropertiesDir() {
        String jlmPropertiesDir = null;

        String value = Game.getProperty("jlm.configuration.file.path");
			if (value != null) {
				String paths[] = value.split(",");

				for (String localPath : paths) {
					localPath = localPath.replace("$HOME$", System.getProperty("user.home"));
					File localPropertiesFileParentDirectory = new File(localPath);
					File localPropertiesFileDirectory = new File(localPath, Game.getLocalPropertiesSubdirectory());

					if (!localPropertiesFileParentDirectory.exists()) {
						continue;
					} else if (localPropertiesFileDirectory.exists() || localPropertiesFileDirectory.mkdir()) {
						jlmPropertiesDir = localPropertiesFileParentDirectory.getPath();
						break;
					} else {
						Logger.log("Game:storeProperties", "cannot create local properties store directory ("
								+ localPropertiesFileDirectory + ")");
					}

				}
			} else {
				JOptionPane.showConfirmDialog(null,
                        "No path provided in the property file (or property file not found)\n" +
                                "You may want to export your session with the menu 'Session/Export session'\n" +
                                "to save your work manually.\n\n" +
                                "Quit without saving?",
                        "Cannot save your changes. Quit without saving?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
				return null;
			}
        return jlmPropertiesDir;
    }
}
