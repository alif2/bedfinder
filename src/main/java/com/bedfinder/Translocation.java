package com.bedfinder;

public class Translocation {
	public static final long DEFAULT_ADJUSTMENT = 1000000;

	private String id;
	private String chromosome;
	private long startLocation;
	private long endLocation;

	public Translocation(String id, String chromosome, long startLocation, long endLocation) {
		this.id = id;
		this.chromosome = chromosome;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChromosome() {
		return chromosome;
	}

	public void setChromosome(String chromosome) {
		this.chromosome = chromosome;
	}

	public long getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(long startLocation) {
		if (startLocation < 0) {
			this.startLocation = 0;
			return;
		}

		this.startLocation = startLocation;
	}

	public void adjustStartLocation() {
		setStartLocation(this.startLocation - DEFAULT_ADJUSTMENT);
	}

	public void adjustStartLocation(long adjustment) {
		setStartLocation(this.startLocation - adjustment);
	}

	public long getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(long endLocation) {
		this.endLocation = endLocation;
	}

	public void adjustEndLocation() {
		if (this.endLocation > Long.MAX_VALUE - DEFAULT_ADJUSTMENT) {
			setEndLocation(Long.MAX_VALUE);
			return;
		}

		setEndLocation(this.endLocation + DEFAULT_ADJUSTMENT);
	}

	public void adjustEndLocation(long adjustment) {
		if (this.endLocation > Long.MAX_VALUE - adjustment) {
			setEndLocation(Long.MAX_VALUE);
			return;
		}

		setEndLocation(this.endLocation + adjustment);
	}

	@Override
	public String toString() {
		return this.id + ", " + this.chromosome + ", " + this.startLocation + ", " + this.endLocation;
	}
}
