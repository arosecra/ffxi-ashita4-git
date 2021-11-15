package org.github.arosecra.ffxi.ashita4.git;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FfxiAshita4Git
{
	public static void main(String[] args) throws IOException {
		File base = new File("D:\\Software\\Ashita4\\gitrepos");
		
		for(File repo : base.listFiles()) {
			for(File repoFile : FileUtils.listFiles(repo, null, true)) {
				String relativeFilename = repoFile.getAbsolutePath().substring(repo.getAbsolutePath().length()+1);
				if(!relativeFilename.toLowerCase().contains(".git") && 
						!relativeFilename.toLowerCase().contains("readme") && 
						!relativeFilename.toLowerCase().contains("example")) {
					System.out.println(relativeFilename);
					FileUtils.copyFile(repoFile, new File("D:\\software\\Ashita4", relativeFilename));
				}
			}
		}
	}
}