package com.bedfinder;

public class TranslocationPair {
	private Translocation first;
	private Translocation second;

	public TranslocationPair(Translocation first, Translocation second) {
		this.first = first;
		this.second = second;
	}

	public Translocation getFirst() {
		return first;
	}

	public void setFirst(Translocation first) {
		this.first = first;
	}

	public Translocation getSecond() {
		return second;
	}

	public void setSecond(Translocation second) {
		this.second = second;
	}

	public void adjustStartLocations() {
		this.first.adjustStartLocation();
		this.second.adjustStartLocation();
	}

	public void adjustStartLocations(long adjustment) {
		this.first.adjustStartLocation(adjustment);
		this.second.adjustStartLocation(adjustment);
	}

	public void adjustEndLocations() {
		this.first.adjustEndLocation();
		this.second.adjustEndLocation();
	}

	public void adjustEndLocations(long adjustment) {
		this.first.adjustEndLocation(adjustment);
		this.second.adjustEndLocation(adjustment);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(first.getChromosome());
		builder.append("\t" + first.getStartLocation());
		builder.append("\t" + first.getEndLocation());
		builder.append("\t" + first.getId());
		builder.append(System.lineSeparator());

		builder.append(second.getChromosome());
		builder.append("\t" + second.getStartLocation());
		builder.append("\t" + second.getEndLocation());
		builder.append("\t" + second.getId());
		builder.append(System.lineSeparator());

		return builder.toString();
	}
}
