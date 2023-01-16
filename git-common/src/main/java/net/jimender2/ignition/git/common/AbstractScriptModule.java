package net.jimender2.ignition.git.common;

import com.inductiveautomation.ignition.common.BundleUtil;
import com.inductiveautomation.ignition.common.BasicDataset;
import com.inductiveautomation.ignition.common.Dataset;
import com.inductiveautomation.ignition.common.util.DatasetBuilder;
import org.python.util.PythonInterpreter;
// import net.jimender2.scripting.license.ScriptingLicense;
import org.python.core.PyObject;
import org.apache.log4j.Logger;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.eclipse.jgit.*;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public abstract class AbstractScriptModule implements Scripts
{
	private static final Logger log = Logger.getLogger("Jimender2");	

	@Override
	public int init(String path) {
		try {
			File localPath = File.createTempFile(path, "");
			Files.delete(localPath.toPath());
			Git git = Git.init().setDirectory(localPath).call();
			File myFile = new File(git.getRepository().getDirectory().getParent(), "testfile");
            if (!myFile.createNewFile()) {
                throw new IOException("Could not create file " + myFile);
            }

            // run the add-call
            git.add().addFilepattern("testfile").call();

            git.commit().setMessage("Initial commit").call();
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
	public int commit(String path, String commitMsg, String author, String email) {
		Path repoPath = Paths.get(path);
		try {
            Git git = Git.open(repoPath.toFile());
			AbstractScriptModule.log.error((Object)"Success");
			git.commit().setMessage(commitMsg).setAuthor(author, email).call();
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

    @Override
	public List walkAllCommits(String path) {
		Path repoPath = Paths.get(path);
		List<String> tagList = new ArrayList<String>();
		try {
			Git git = Git.open(repoPath.toFile());
			AbstractScriptModule.log.error((Object)"Success");
            Iterable<RevCommit> commits = git.log().all().call();
            for (RevCommit commit : commits) {
                tagList.add(commit.toString());
            }
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return tagList;
	}

	@Override
	public Dataset getAllCommitsInfo(String path) {
		Dataset ds = null;
		Path repoPath = Paths.get(path);
		List<String> colNames = new ArrayList<String>();
		colNames.add("shortMsg");
		colNames.add("commitTime");
		colNames.add("fullMsg");
		colNames.add("authorName");
		colNames.add("authorEmail");
		colNames.add("committerName");
		colNames.add("committerEmail");
		colNames.add("commitName");
		colNames.add("treeID");

		Class[] types = new Class[colNames.size()];
        for (int i = 0; i < types.length; i++) {
            types[i] = String.class;
        }
        
		DatasetBuilder builder = new DatasetBuilder();
		builder.colNames(colNames.toArray(new String[0]));
		builder.colTypes(types);

		try {
			Git git = Git.open(repoPath.toFile());
			AbstractScriptModule.log.error((Object)"Success");
            Iterable<RevCommit> commits = git.log().all().call();
            for (RevCommit commit : commits) {
				String[] rowData = new String[colNames.size()];
				rowData[0] = commit.getShortMessage().toString();
				rowData[1] = commit.getCommitTime()+"";
				rowData[2] = commit.getFullMessage().toString();
				rowData[3] = commit.getAuthorIdent().getName().toString();
				rowData[4] = commit.getAuthorIdent().getEmailAddress().toString();
				rowData[5] = commit.getCommitterIdent().getName().toString();
				rowData[6] = commit.getCommitterIdent().getEmailAddress().toString();
				rowData[7] = commit.getName().toString();
				rowData[8] = commit.getTree().getId().toString();

				builder.addRow(rowData);
            }
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		ds = builder.build();
		return ds != null ? ds : new BasicDataset();
	}

	@Override
	public Dataset getUncommitedChanges(String path) {
		Dataset ds = null;
		Path repoPath = Paths.get(path);
		List<String> colNames = new ArrayList<String>();
		colNames.add("type");
		colNames.add("msg");

		Class[] types = new Class[colNames.size()];
        for (int i = 0; i < types.length; i++) {
            types[i] = String.class;
        }
        
		DatasetBuilder builder = new DatasetBuilder();
		builder.colNames(colNames.toArray(new String[0]));
		builder.colTypes(types);

		try {
			Git git = Git.open(repoPath.toFile());
			Status status = git.status().call();
			AbstractScriptModule.log.error((Object)"Success");
			Set<String> conflicting = status.getConflicting();
			for(String conflict : conflicting) {
				String[] rowData = new String[colNames.size()];
				rowData[0] = "Conflicting";
				rowData[1] = conflict.toString();
				
				builder.addRow(rowData);
            }
			Set<String> added = status.getAdded();
			for(String add : added) {
				String[] rowData = new String[colNames.size()];
				rowData[0] = "Added";
				rowData[1] = add.toString();
				
				builder.addRow(rowData);
            }
			Set<String> changed = status.getChanged();
			for(String change : changed) {
				String[] rowData = new String[colNames.size()];
				rowData[0] = "Changed";
				rowData[1] = change.toString();
				
				builder.addRow(rowData);
            }
			Set<String> missing = status.getMissing();
			for(String miss : missing) {
				String[] rowData = new String[colNames.size()];
				rowData[0] = "Missing";
				rowData[1] = miss.toString();
				
				builder.addRow(rowData);
            }
			
			Set<String> modified = status.getModified();
			for(String modify : modified) {
				String[] rowData = new String[colNames.size()];
				rowData[0] = "Modification";
				rowData[1] = modify.toString();
				
				builder.addRow(rowData);
			}

			Set<String> removed = status.getRemoved();
			for(String remove : removed) {
				String[] rowData = new String[colNames.size()];
				rowData[0] = "Remove";
				rowData[1] = remove.toString();
				
				builder.addRow(rowData);
			}

			Set<String> uncommittedChanges = status.getUncommittedChanges();
			for(String uncommitted : uncommittedChanges) {
				String[] rowData = new String[colNames.size()];
				rowData[0] = "Uncommitted";
				rowData[1] = uncommitted.toString();
				
				builder.addRow(rowData);
			}

			Set<String> untracked = status.getUntracked();
			for(String untrack : untracked) {
				String[] rowData = new String[colNames.size()];
				rowData[0] = "Untracked File";
				rowData[1] = untrack.toString();
				
				builder.addRow(rowData);
			}

			Set<String> untrackedFolders = status.getUntrackedFolders();
			for(String untrack : untrackedFolders) {
				String[] rowData = new String[colNames.size()];
				rowData[0] = "Untracked Folder";
				rowData[1] = untrack.toString();
				
				builder.addRow(rowData);
			}

            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		ds = builder.build();
		return ds != null ? ds : new BasicDataset();
	}


	@Override
	public List getConflictingFiles(String path) {
		Path repoPath = Paths.get(path);
		List<String> fileList = new ArrayList<String>();
		try {
			Git git = Git.open(repoPath.toFile());
			Status status = git.status().call();
            Set<String> conflicting = status.getConflicting();
            for(String conflict : conflicting) {
            	fileList.add(conflict.toString());
            }
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return fileList;
	}

	@Override
	public List getAddedFiles(String path) {
		Path repoPath = Paths.get(path);
		List<String> fileList = new ArrayList<String>();
		try {
			Git git = Git.open(repoPath.toFile());
			Status status = git.status().call();
            Set<String> added = status.getAdded();
            for(String add : added) {
            	fileList.add(add.toString());
            }
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return fileList;
	}

	@Override
	public String listCurrentBranch(String path) {
		Path repoPath = Paths.get(path);
		List<String> fileList = new ArrayList<String>();
		String currentBranch = "";
		try {
			Git git = Git.open(repoPath.toFile());
			currentBranch = git.getRepository().getFullBranch();
            git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return currentBranch;
	}


	@Override
	public int pull(String path) {
		Path repoPath = Paths.get(path);
		try {
			Git git = Git.open(repoPath.toFile());
			git.pull().call();
			git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

	@Override
	public int pull(String path, String username, String password) {
		Path repoPath = Paths.get(path);
		try {
			Git git = Git.open(repoPath.toFile());
			CredentialsProvider cp = new UsernamePasswordCredentialsProvider(username, password);
			git.pull().setCredentialsProvider(cp).call();
			git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

	@Override
	public int push(String path, String username, String password) {
		Path repoPath = Paths.get(path);
		try {
			Git git = Git.open(repoPath.toFile());
			CredentialsProvider cp = new UsernamePasswordCredentialsProvider(username, password);
			git.push().setCredentialsProvider(cp).call();
			git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

	@Override
	public int createBranch(String path, String branchName) {
		Path repoPath = Paths.get(path);
		try {
			Git git = Git.open(repoPath.toFile());
			git.checkout().setName(branchName).setCreateBranch(true).call();
			git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

	@Override
	public int checkoutBranch(String path, String oldBranchName, String newBranchName) {
		Path repoPath = Paths.get(path);
		try {
			Git git = Git.open(repoPath.toFile());
			git.branchRename().setOldName(oldBranchName).setNewName(newBranchName).call();
			git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

	@Override
	public int checkoutBranch(String path, String newBranchName) {
		Path repoPath = Paths.get(path);
		try {
			Git git = Git.open(repoPath.toFile());
			String currentBranch = git.getRepository().getFullBranch();
			git.branchRename().setOldName(currentBranch).setNewName(newBranchName).call();
			git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

	@Override
	public int fetch(String path) {
		Path repoPath = Paths.get(path);
		try {
			Git git = Git.open(repoPath.toFile());
			git.fetch().call();
			git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object)"Error");
			AbstractScriptModule.log.error((Object)e);
		}
		return 0;
	}

	@Override
	public int reset(String path) {
		Path repoPath = Paths.get(path);
		try {
			Git git = Git.open(repoPath.toFile());
			git.reset().call();
			git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object) "Error");
			AbstractScriptModule.log.error((Object) e);
		}
		return 0;
	}

	@Override
	public int reset(String path, String file) {
		Path repoPath = Paths.get(path);
		try {
			Git git = Git.open(repoPath.toFile());
			AbstractScriptModule.log.error((Object) "Success");
			git.reset().addPath(file).call();
			git.close();
		} catch (Exception e) {
			AbstractScriptModule.log.error((Object) "Error");
			AbstractScriptModule.log.error((Object) e);
		}
		return 0;
	}

}