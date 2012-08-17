package com.example.parser;

import java.io.Serializable;

public class Item implements Serializable {

    private String title;
    private String description;
    private String link;

    public Item() {
        setTitle(null);
        setDescription(null);
        setLink(null);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

    // same as above.

}