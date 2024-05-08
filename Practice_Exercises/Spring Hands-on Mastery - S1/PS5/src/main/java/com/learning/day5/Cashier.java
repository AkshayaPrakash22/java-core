package com.learning.day5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Cashier {
	
	private String fileName;
    private String path;
    private BufferedWriter writer;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void openFile() throws IOException {
        File targetDir = new File(path);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        File checkoutFile = new File(path, fileName + ".txt");
        if (!checkoutFile.exists()) {
            checkoutFile.createNewFile();
        }
        writer = new BufferedWriter(new FileWriter(checkoutFile, true));
    }

    public void checkout(ShoppingCart cart) throws IOException {
        List<Product> items = cart.getItems();
        writer.write(new Date().toString() + "\t" + items.toString() + "\n");
        writer.flush();
    }

    public void closeFile() throws IOException {
        writer.close();
    }

}
