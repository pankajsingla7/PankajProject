package com.java.app.dao;

import org.springframework.data.annotation.Id;
public class Todo {

	static final int MAX_LENGTH_DESCRIPTION = 500;
    static final int MAX_LENGTH_TITLE = 100;
 
    @Id
    private String id;
 
    private boolean status;
 
    private String name;
 
    public Todo() {}
 
    private Todo(Builder builder) {
        this.setStatus(builder.status);
        this.setName(builder.name);
    }
 
    static Builder getBuilder() {
        return new Builder();
    }
 
    //Other getters are omitted
 
    public void update(boolean status, String name) {
        checkTitleAndDescription(status, name);
 
        this.setStatus(status);
        this.setName(name);
    }
 
    /**
     * We don't have to use the builder pattern here because the constructed 
     * class has only two String fields. However, I use the builder pattern 
     * in this example because it makes the code a bit easier to read.
     */
    static class Builder {
 
        private boolean status;
 
        private String name;
 
        private Builder() {}
 
        Builder name(String name) {
            this.name = name;
            return this;
        }
 
        Builder status(boolean status) {
            this.status = status;
            return this;
        }
 
        Todo build() {
            Todo build = new Todo(this);
 
            build.checkTitleAndDescription(build.getStatus(), build.getName());
 
            return build;
        }
    }
 
    private void checkTitleAndDescription(boolean status, String name) {
//        notNull( name, "Title cannot be null");
//        notEmpty(name, "Title cannot be empty");
//        isTrue(name.length() <= MAX_LENGTH_TITLE,
//                "Title cannot be longer than %d characters",
//                MAX_LENGTH_TITLE
//        );
 
        if (name != null) {
//            isTrue(name.length() <= MAX_LENGTH_DESCRIPTION,
//                    "Description cannot be longer than %d characters",
//                    MAX_LENGTH_DESCRIPTION
//            );
        }
    }

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return this.id;
	}
}
