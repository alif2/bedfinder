package com.bedfinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	private static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		if (args.length < 2) {
			logger.error("Please include the input and output file names as arguments.");
			return;
		}

		Path inputFile = Paths.get(args[0]);
		Path outputFile = Paths.get(args[1]);

		if (!Files.exists(inputFile)) {
			logger.error("The file {} does not exist.", args[0]);
			return;
		}

		if (Files.isDirectory(inputFile)) {
			logger.error("The file {} is a directory.", args[0]);
			return;
		}

		if (!Files.isReadable(inputFile)) {
			logger.error("The file {} exists, but could not be read. Check you have permissions to read it.", args[0]);
		}

		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(inputFile);
		} catch (IOException e) {
			logger.error("Unable to read the file due to an unknown error.", e);
		}

		var pairs = buildPairs(lines);

		try {
			TranslocationFileWriter.write(pairs, outputFile);
		} catch (IOException e) {
			logger.error("Unable to write the result to a file. Results will be written below.", e);
			logger.info(pairs.toString());
		}
	}

	private static ArrayList<TranslocationPair> buildPairs(List<String> lines) {
		var pairs = new ArrayList<TranslocationPair>(lines.size());
		for (var line : lines) {
			var pair = TranslocationPairBuilder.build(line);

			pair.adjustStartLocations();
			pair.adjustEndLocations();

			pairs.add(pair);
		}

		return pairs;
	}
}
