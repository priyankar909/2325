package com.zynetic2325.backend.modal;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	@NotBlank(message = "Title required hai")
    private String title;

    @NotBlank(message = "Author required hai")
    private String author;

    @NotBlank(message = "Category required hai")
    private String category;

    @Positive(message = "Price positive hona chahiye")
    private double price;

    @Min(value = 1, message = "Rating kam se kam 1 hona chahiye")
    @Max(value = 5, message = "Rating zyada se zyada 5 ho sakta hai")
    private int rating;

    @PastOrPresent(message = "Published date aaj ya pehle ki honi chahiye")
    private LocalDate publishedDate;
}

