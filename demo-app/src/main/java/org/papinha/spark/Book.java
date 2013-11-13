/**
 * 
 */
package org.papinha.spark;

/**
 * Book class model
 *
 */
public class Book {
	
	private String author;
	
	private String title;

	public Book(String author, String title) {
		super();
		this.author = author;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
