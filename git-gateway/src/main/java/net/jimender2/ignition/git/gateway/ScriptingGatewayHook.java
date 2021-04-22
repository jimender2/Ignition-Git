package net.jimender2.ignition.git.gateway;

import com.inductiveautomation.ignition.common.licensing.LicenseMode;
import com.inductiveautomation.ignition.gateway.clientcomm.ClientReqSession;
import com.inductiveautomation.ignition.common.script.hints.ScriptFunctionDocProvider;
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.gateway.model.GatewayContext;
import org.apache.log4j.Logger;
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook;
import com.inductiveautomation.ignition.gateway.datasource.SRConnection;


public class ScriptingGatewayHook extends AbstractGatewayModuleHook
{
	private final GatewayScriptModule scriptModule;
	private final Logger log;
	private GatewayContext context;


	public ScriptingGatewayHook() {
		this.scriptModule = new GatewayScriptModule();
		this.log = Logger.getLogger((Class)this.getClass());
	}
	
	@Override
	public void setup(final GatewayContext gatewayContext) {
		this.context = gatewayContext;
	}
	
	@Override
	public void startup(final LicenseState licenseState) {

	}
	
	@Override
	public void shutdown() {
	}
	
	@Override
	public boolean isFreeModule() {
		return false;
	}
	
	public boolean isTrialExpired() {
		return false;
	}
	
	@Override
	public void notifyLicenseStateChanged(final LicenseState licenseState) {
		super.notifyLicenseStateChanged(licenseState);
	}
	
	@Override
	public void initializeScriptManager(final ScriptManager manager) {
		super.initializeScriptManager(manager);
		manager.addScriptModule("system.jimender2.git", (Object)this.scriptModule, (ScriptFunctionDocProvider)new PropertiesFileDocProvider());
	}
	
	@Override
	public Object getRPCHandler(final ClientReqSession session, final String projectName) {
		return this.scriptModule;
	}
}
