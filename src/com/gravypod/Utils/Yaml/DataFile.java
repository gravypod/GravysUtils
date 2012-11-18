package com.gravypod.Utils.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import com.gravypod.Utils.Files.FileConversion;

/*
 * TODO: Add the 'yaml' style
 * ex:
 * 
 * test:
 *   testing:
 *     - test
 * 
 */

public class DataFile {
	
	private final DumperOptions yamlOptions = new DumperOptions();
	
	private final Representer yamlRepresenter = new Representer();
	
	final private Yaml yml;
	
	final private Map<String, Object> yamlData = new HashMap<String, Object>();
	
	final private File ymlFile;
	
	@SuppressWarnings("unchecked")
	public DataFile(File data) {
	
		String input = FileConversion.fileToString(data);
		
		yamlOptions.setIndent(2);
		
		yamlOptions.setDefaultFlowStyle(FlowStyle.AUTO);
		
		yamlRepresenter.setDefaultFlowStyle(FlowStyle.AUTO);
		
		yml = new Yaml(new Constructor(), yamlRepresenter, yamlOptions);
		
		Map<String, Object> temp = (Map<String, Object>) yml.load(input);
		
		yamlData.putAll(temp != null ? temp : new HashMap<String, Object>());
		ymlFile = data;
		
	}
	
	public Object get(String path) {
	
		return yamlData.get(path);
	}
	
	/**
	 * Set data into out memory map
	 * 
	 * @param path
	 * @param data
	 */
	public void set(String path, Object data) {
	
		if (yamlData.containsKey(path)) {
			
			yamlData.remove(data);
			
		}
		
		yamlData.put(path, data);
		
	}
	
	/**
	 * Set data with the option to save to the file.
	 * 
	 * @param path
	 * @param data
	 * @param save
	 * 
	 */
	public void set(String path, Object data, boolean save) {
	
		set(path, data);
		
		if (save)
			save();
		
	}
	
	public void save() {
	
		synchronized(yamlData) {
			
			String data = yml.dumpAs(new HashMap<String, Object>(yamlData), Tag.MAP, FlowStyle.BLOCK);
			
			try {
				
				FileWriter writer = new FileWriter(ymlFile);
				
				writer.write(data);
				
				writer.flush();
				
				writer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
