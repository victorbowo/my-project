package com.javaee.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class FilesUtil {
	
	private File file;
	private String fileContentType;
	private String fileFileName;
	
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	
	
    public static void saveFile(File file, String fileName, String filesDirectory) throws IOException{
        FileInputStream in = null;
        FileOutputStream out = null;
         
        File dir = new File (filesDirectory);
        if ( !dir.exists() )
           dir.mkdirs();
         
        String targetPath =  dir.getPath() + File.separator + fileName;
        System.out.println("source file path ::"+file.getAbsolutePath());
        System.out.println("saving file to ::" + targetPath);
        File destinationFile = new File ( targetPath);
        try {
            in = new FileInputStream( file );
            out = new FileOutputStream( destinationFile );
            int c;
 
            while ((c = in.read()) != -1) {
                out.write(c);
            }
 
        }finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
         
    }
}