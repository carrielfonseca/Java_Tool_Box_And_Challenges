package toolbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


/* to load from the classpath, see https://www.mkyong.com/java/java-read-a-file-from-resources-folder/
 * Main Articles regarding classpath:
 *  https://en.wikipedia.org/wiki/Classpath_(Java)
 *  https://docs.oracle.com/javase/tutorial/essential/environment/paths.html
 *  https://docs.oracle.com/javase/7/docs/technotes/tools/windows/classpath.html
 * 
 * 
 * Key Points:
 * 1-) ClassPath is not ONE path, but actually an array of paths
 * 2-) The path before takes precedence over subsequent ones, so order matters
 * 3-) Classes are specified until the root directory, with package name folders not being included
 * 4-) package names are part of the class. This class, for instance, is actually class toolbox.TextFileReadFromClassPath
 * 5-) On windows command line, classpath entries are separated by semi colons (this changes on different operating sytems)
 * 6-) Para incluir um jar pelo commando no classpath, precisa colocar o path ateh o jar, incluindo o arquivo com a extensao .jar 
 * 
 * Teste para testar que a ordem do classpth importa:
 * 
 *  Rode primeiro no eclipse a classe para que seja compilada e o arquico temp.txt seja incluido na pasta bin
 *  Pelo command line, rode 
    java -cp C:\Users\Fabio\workspace\ToolBoxAndChallenges;C:\Users\Fabio\workspace\ToolBoxAndChallenges\bin toolbox.TextFileReadFromClassPath
    e depois
    java -cp C:\Users\Fabio\workspace\ToolBoxAndChallenges\bin;C:\Users\Fabio\workspace\ToolBoxAndChallenges; toolbox.TextFileReadFromClassPath
 */

public class TextFileReadFromClassPath {
	 
	public static void main(String[] args) throws IOException {
		TextFileReadFromClassPath main = new TextFileReadFromClassPath();
        File file = main.getFileFromResources("temp.txt");   
        printFile(file); 
	} 
	     
	// get file from classpath, resources folder
    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!"); 
        } else {
            return new File(resource.getFile());
        }

    }

    private static void printFile(File file) throws IOException {

        if (file == null) return;

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }


}
