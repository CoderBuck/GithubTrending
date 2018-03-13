package io.buck.githubtrending.data.model;

import java.util.List;

import pl.droidsonroids.jspoon.annotation.Selector;

/**
 * Created by buck on 2018/3/13
 */

public class TrendingPage {

    @Selector(".repo-list > li")
    public List<Repo> mRepos;
}
