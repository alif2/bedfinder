package com.bedfinder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TranslocationFileWriter {
	// Hide the default constructor
	private TranslocationFileWriter() {
	}

	public static void write(List<TranslocationPair> pairs, Path file) throws IOException {
		StringBuilder builder = new StringBuilder();

		for (var pair : pairs) {
			builder.append(pair.toString());
		}

		Files.writeString(file, builder.toString(), StandardCharsets.UTF_8);
	}
}
