package net.jimender2.ignition.git.gateway;

import net.jimender2.ignition.git.common.AbstractScriptModule;
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

public class GatewayScriptModule extends AbstractScriptModule
{

}