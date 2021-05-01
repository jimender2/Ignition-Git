package net.jimender2.ignition.git.gateway;

import net.jimender2.ignition.git.common.AbstractScriptModule;
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

// import com.inductiveautomation.ignition.common.licensing.LicenseMode;
// import com.inductiveautomation.ignition.gateway.clientcomm.ClientReqSession;
// import com.inductiveautomation.ignition.common.script.ScriptManager;
// import com.inductiveautomation.ignition.common.script.hints.ScriptFunctionDocProvider;
// import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider;
// import com.inductiveautomation.ignition.common.script.ScriptManager;
// import com.inductiveautomation.ignition.common.licensing.LicenseState;
// import com.inductiveautomation.ignition.gateway.model.GatewayContext;
// import org.apache.log4j.Logger;
// import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook;
// import com.inductiveautomation.ignition.gateway.datasource.SRConnection;

// // public class GatewayScriptModule extends AbstractScriptModule{
// public class GatewayScriptModule extends AbstractGatewayModuleHook {

// 	private final GatewayScriptModule scriptModule;
// 	private GatewayContext context;
// 	private final Logger log;

// 	public GatewayScriptModule() {
// 	 	this.scriptModule = new GatewayScriptModule();
// 	 	this.log = Logger.getLogger((Class)this.getClass());
// 	}

// 	@Override
// 	public void initializeScriptManager(final ScriptManager manager){
// 		super.initializeScriptManager(manager);
// 		manager.addScriptModule("system.jimender2.git", (Object)this.scriptModule, (ScriptFunctionDocProvider)new PropertiesFileDocProvider());
// 	}

// 	@Override
// 	public void setup(final GatewayContext gatewayContext) {
// 		this.context = gatewayContext;
// 	}

// 	@Override
// 	public void startup(final LicenseState licenseState) {
	
// 	}

// 	@Override
// 	public void shutdown(){

// 	}

// 	@Override
// 	public Object getRPCHandler(final ClientReqSession session, final String projectName) {
// 		return this.scriptModule;
// 	}
// }

public abstract class GatewayScriptModule extends AbstractScriptModule
{
    private static final Logger log = Logger.getLogger("Jimender2");	

	// @Override
	// protected int addrpc(String path) {
	// 	// Path repoPath = Paths.get(path);
	// 	// try {
    //     //     Git git = Git.open(repoPath.toFile());
	// 	// 	GatewayScriptModule.log.error((Object)"Success");
    //     //     git.add().addFilepattern(".").call();
    //     //     git.close();
	// 	// } catch (Exception e) {
	// 	// 	GatewayScriptModule.log.error((Object)"Error");
	// 	// 	GatewayScriptModule.log.error((Object)e);
	// 	// }
	// 	// return 0;
    //     return rpc.add(path);
	// }
}