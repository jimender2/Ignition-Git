package net.jimender2.ignition.git.common;

import com.inductiveautomation.ignition.common.BundleUtil;
import org.python.util.PythonInterpreter;
// import net.jimender2.scripting.license.ScriptingLicense;
import org.python.core.PyObject;
import org.apache.log4j.Logger;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


import org.eclipse.jgit.*;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;

public abstract class AbstractScriptModule implements Scripts
{
	private static final Logger log = Logger.getLogger("Jimender2");	

	@Override
	public int init(String path) {
		try {
			File dir = File.createTempFile(path, ".test");
			Git git = Git.init().setDirectory(dir).call();
			AbstractScriptModule.log.error((Object)"Success");
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

	// @Override
	// public int init(String path) {
	// 	Path repoPath = Paths.get(path);
	// 	try {
    //         Git git = Git.init().setDirectory(repoPath.toFile()).call();
	// 		AbstractScriptModule.log.error((Object)"Success");
    //         git.close();
	// 	} catch (Exception e) {
	// 		AbstractScriptModule.log.error((Object)"Error");
	// 		AbstractScriptModule.log.error((Object)e);
	// 	}
	// 	return 0;
	// }

	@Override
	public int add(String path) {
		Path repoPath = Paths.get(path);
		try {
            Git git = Git.open(repoPath.toFile());
			AbstractScriptModule.log.error((Object)"Success");
            git.add().addFilepattern(".").call();
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

	@Override
	public int add(String path, String filter) {
		Path repoPath = Paths.get(path);
		try {
            Git git = Git.open(repoPath.toFile());
			AbstractScriptModule.log.error((Object)"Success");
            git.add().addFilepattern(filter).call();
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

    @Override
	public int commit(String path) {
		Path repoPath = Paths.get(path);
		try {
            Git git = Git.open(repoPath.toFile());
			AbstractScriptModule.log.error((Object)"Success");
			git.commit().setMessage("Added testfile").call();
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

    @Override
	public int commit(String path, String commitMsg) {
		Path repoPath = Paths.get(path);
		try {
            Git git = Git.open(repoPath.toFile());
			AbstractScriptModule.log.error((Object)"Success");
			git.commit().setMessage(commitMsg).call();
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

    @Override
	public int clone(String path, String url) {
		try {
			AbstractScriptModule.log.error((Object)"Success");
			File localPath = File.createTempFile(path, "");
            Git git = Git.cloneRepository()
                .setURI(url)
                .setDirectory(localPath)
                .call();
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

    @Override
	public List listTags(String path) {
		Path repoPath = Paths.get(path);
		List<String> tagList = new ArrayList<String>();
		tagList.add("test");
		try {
			Git git = Git.open(repoPath.toFile());
			AbstractScriptModule.log.error((Object)"Success");
            List<Ref> call = git.tagList().call();
            for (Ref ref : call) {
                tagList.add(ref.getName().toString());
            }
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return tagList;
	}

    @Override
	public List listBranches(String path) {
		Path repoPath = Paths.get(path);
		List<String> tagList = new ArrayList<String>();
		try {
			Git git = Git.open(repoPath.toFile());
			AbstractScriptModule.log.error((Object)"Success");
			List<Ref> call = git.branchList().call();
            for (Ref ref : call) {
                tagList.add(ref.getName().toString());
            }
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return tagList;
	}

    // @Override
	// public List walkAllCommits(String path) {
	// 	Path repoPath = Paths.get(path);
	// 	List<String> tagList = new ArrayList<String>();
	// 	try {
	// 		Git git = Git.open(repoPath.toFile());
	// 		AbstractScriptModule.log.error((Object)"Success");
    //         Iterable<RevCommit> commits = git.log().all().call();
    //         for (RevCommit commit : commits) {
    //             tagList.add(commit.toString());
    //         }
    //         git.close();
	// 	} catch (Exception e) {
	// 		AbstractScriptModule.log.error((Object)"Error");
	// 		AbstractScriptModule.log.error((Object)e);
	// 	}
	// 	return tagList;
	// }

    // @Override
	// public List walkCommitsOnBranch(String path, String branch) {
	// 	Path repoPath = Paths.get(path);
	// 	List<String> tagList = new ArrayList<String>();
	// 	try {
	// 		Git git = Git.open(repoPath.toFile());
	// 		AbstractScriptModule.log.error((Object)"Success");
    //         ObjectId branchId = repository.resolve("HEAD");
    //         Iterable<RevCommit> commits = git.log().add(branchId).call();
    //         for (RevCommit commit : commits) {
    //             tagList.add(commit.toString());
    //         }
    //         git.close();
	// 	} catch (Exception e) {
	// 		AbstractScriptModule.log.error((Object)"Error");
	// 		AbstractScriptModule.log.error((Object)e);
	// 	}
	// 	return tagList;
	// }



}