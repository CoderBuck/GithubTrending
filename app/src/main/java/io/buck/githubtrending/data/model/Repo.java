package io.buck.githubtrending.data.model;

import java.util.List;

import pl.droidsonroids.jspoon.annotation.Selector;

/**
 * Created by buck on 2018/3/13
 */



public class Repo {

    @Selector("div > h3 > a")
    public String href;

    @Selector("div.py-1 > p")
    public String description;

    //span itemprop="programmingLanguage"
    @Selector("span[itemprop=programmingLanguage]")
    public String lan;

    @Selector("a[href$=stargazers]")
    public String starsToday;

    @Selector("a[href$=network]")
    public String Forks;

    @Selector("span.float-sm-right")
    public String starsTotal;

//    List<User> builters;


    @Override
    public String toString() {
        return "{" +
                "href='" + href + '\'' +
                ", description='" + description + '\'' +
                ", lan='" + lan + '\'' +
                ", starsToday='" + starsToday + '\'' +
                ", Forks='" + Forks + '\'' +
                ", starsTotal='" + starsTotal + '\'' +
                '}';
    }


}
