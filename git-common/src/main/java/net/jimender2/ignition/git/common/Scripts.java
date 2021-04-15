package net.jimender2.ignition.git.common;

import java.util.List;

public interface Scripts
{
	int init(String path);
	int add(String path);
    int add(String path, String filter);
    int commit(String path);
    int commit(String path, String commitMsg);
	int clone(String path, String url);
    List listTags(String path);
    List listBranches(String path);
    List walkAllCommits(String path);
    List getConflictingFiles(String path);
    List getAddedFiles(String path);
}