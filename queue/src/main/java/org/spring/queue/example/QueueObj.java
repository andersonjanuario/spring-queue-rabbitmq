package org.spring.queue.example;

import java.io.Serializable;

/**
 * The Class QueueObj.
 */
public class QueueObj implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8512323476310451231L;

	/** The code. */
	private long code;

	/** The name. */
	private String name;

	/** The year. */
	private int year;

	/**
	 * Instantiates a new queue obj.
	 *
	 * @param code the code
	 * @param name the name
	 * @param year the year
	 */
	public QueueObj(long code, String name, int year) {
		super();
		this.code = code;
		this.name = name;
		this.year = year;
	}

	/**
	 * Instantiates a new queue obj.
	 */
	public QueueObj() {
		super();
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public long getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(long code) {
		this.code = code;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (code ^ (code >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QueueObj other = (QueueObj) obj;
		if (code != other.code)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueueObj [code=" + code + ", name=" + name + ", year=" + year + "]";
	}

}
