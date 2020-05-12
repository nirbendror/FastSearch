package com.hit.dm;

import java.awt.Image;

public class searchItem {
    private String tag;
    private String description;
    private String link;

    public searchItem(String tag, String description, String link) {
        this.tag = tag;
        this.description = description;
        this.link = link;
    }

    public searchItem() {

    }


    public boolean isValid()
    {
        if(this.tag.isEmpty()||this.link.isEmpty())
        {
            return false;
        }
        return true;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof searchItem)) {
            return false;
        }

        searchItem c = (searchItem) o;

        return tag.equals(c.tag)
                && description.equals(c.description);
    }
}
