package com.bedfinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TranslocationPairBuilder {
	private static Logger logger = LoggerFactory.getLogger(TranslocationPairBuilder.class);

	// Hide the default constructor
	private TranslocationPairBuilder() {
	}

	public static TranslocationPair build(String line) {
		String regex = "[+-]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);

		if (!matcher.find()) {
			logger.error("Unable to parse line: {}", line);
		}

		String first = line.substring(0, matcher.start() + 1);
		String second = line.substring(matcher.start() + 2);

		return buildPair(first, second);
	}

	private static TranslocationPair buildPair(String first, String second) {
		var leftSplitItems = first.split("\t");
		var rightSplitItems = second.split("\t");

		String id = leftSplitItems[0];

		var left = buildLeft(leftSplitItems, id);
		var right = buildRight(rightSplitItems, id);

		return new TranslocationPair(left, right);
	}

	private static Translocation buildLeft(String[] leftItems, String id) {
		String leftChromosome = leftItems[1];
		long leftStart = Long.parseLong(leftItems[2]);
		long leftEnd = Long.parseLong(leftItems[3]);
		return new Translocation(id, leftChromosome, leftStart, leftEnd);
	}

	private static Translocation buildRight(String[] rightItems, String id) {
		String rightChromosome = rightItems[0];
		long rightStart = Long.parseLong(rightItems[1]);
		long rightEnd = Long.parseLong(rightItems[2]);
		return new Translocation(id, rightChromosome, rightStart, rightEnd);
	}
}
